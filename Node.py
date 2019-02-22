from __future__ import print_function,division,absolute_import

import copy
import Exceptions
nddata={
	"isValid":"isValid",
	"isList" :"isList",
	"isBlock":"isBlock",
	"length" :"length",
	"restStr":"restStr"
}


var_identifiers=["let","const","var","ref","obj","changable"]
nums=list("0123456789abcdef")
global line
line=1
global column
column=0

class Code:
	source="None"
	tokens=[]
	cls=None
	@classmethod
	def proc(*args):
		pass
	@classmethod
	def getValue(*args):
		pass

class StringCode(Code):
	def __init__(self,string):
		self.source='"%s"'(string)
		self.tokens=['"',string,'"']

class NodeData:
	value=None
	err=None
	type="null"
	cls="null"
	data={}
	arr=[]
	def __init__(self,
				value=None,
				type="null",
				cls="null",
				err=None,
				length=0,
				*args,
				**kwargs):
		self.value=value
		self.type=type
		self.cls=cls
		self.err=err
		self.data=kwargs
		self.arr=list(args)
		if self.data.get("isValid") == None:
			self.data["isValid"]=True
	def get(self,key):
		return data[key]
	def __str__(self):
		return str(vars(self))
class Node:
	@classmethod
	def __init__(self):
		pass
	@classmethod
	def valid(self,s):
		return True
	@classmethod
	def process(self,s):
		nd= NodeData('',restStr=s)
		return nd
	@classmethod
	def bind(self,node):
		# bind the parent node
		self.parent=node
class WhitespaceNode(Node):
	def valid(self,s):
		return len(s)>0 and s[0].isspace()
	def process(self,s):
		for c in copy.deepcopy(s):
			if c.isspace():
				s.remove(s[0])
			else:
				break
		return NodeData(None,restStr=s)
class SplitNode(Node):
	def valid(self,s):
		if len(s)>0:
			return s[0]==';'
		return False
	def process(self,s):
		if len(s)>0:
			for c in s:
				if c==';':
					s.remove(s[0])
				else:
					break
			self.parent.coden+=1
			self.parent.codebuf.append([])
		return NodeData(restStr=s)
class CommaNode(Node):
	def valid(self,s):
		if len(s)>0:
			return s[0]==','
		return False
	def process(self,s):
		if len(s)>0:
			for c in s:
				if c==',':
					s.remove(s[0])
				else:
					break
		return NodeData(restStr=s)
class NameNode(Node):
	def valid(self,s):
		isValid=True
		if len(s)>0 :
			if s[0].isdigit() or (not s[0].isalpha()) and not s[0] in list("_$"):
				isValid=False
				return False
		else:
			isValid=False
		return isValid
	def process(self,s):
		res=''
		if len(s)>0:
			if s[0].isdigit():
				return NodeData(None,length=0,isValid=False,restStr=s)
		for c in copy.deepcopy(s):
			if not c.isalpha() and not c in list("_$") and not c.isdigit():
				break
			res+=c
			s.remove(s[0])
		
		return NodeData(res,length=len(res),isValid=True,restStr=s)

class NumNode(Node):
	def valid(self,s):
		if len(s)>0:
			if s[0].isdigit():
				return True
		return False
	def process(self,s):
		orig=copy.deepcopy(s)
		res=0
		radix=10
		if len(s)>0:
			for c in copy.deepcopy(s):
				if c=='x':
					radix=16
				elif c=='o':
					radix=8
				elif c=='t':
					radix=2
				elif c=='p':
					radix=10
				else:
					if c in nums:
						print("found %s in nums"%(c))
						if nums.index(c)<radix:
							res*=radix
							res+=nums.index(c)
						else:
							err=Exceptions.exception(message="Number '%d' is not in radix '%d'"%(nums.index(c),radix),stack=[Exceptions.stack(self.
							parent.line,self.parent.column,orig)])
							raise err
					else:
						break
				s.remove(s[0])
		return NodeData(res,type="instance",cls="integer",restStr=s)
class StringNode(Node):
	def valid(self,s):
		if len(s)<=0:
			return False
		if s[0] is not '"':
			return False
		started=False
		for c in s:
			if c=='"':
				started=not started
				# one round detecting string is over.
				if not started:
					return True
		return False
	def process(self,s):
		started=False
		ret=''
		for c in copy.deepcopy(s):
			if c is '"':
				started=not started
				if not started:
					s.remove(s[0])
					return NodeData(ret,type="instance",cls="string",restStr=s)
			else:
				ret+=c
			s.remove(s[0])
		raise Exceptions.exception(message="Error:Unterminated String Literal")
class VarNode(Node):
	def valid(self,s):
		isOk=False
		word=''
		for c in s:
			word+=c
			if word in var_identifiers:
				return True
		return False
	def process(self,s):
		ids=[]
		globn=NameNode()
		wn=WhitespaceNode()
		while globn.valid(s):
			globnd=globn.process(s)
			s=globnd.data["restStr"]
			s=wn.process(s).data["restStr"]
			ids.append(globnd.value)
		changable= "const" in ids
		glob= "var" in ids
		glob= not ("let" in ids)
		isref="ref" in ids
		finalIdentifiers=[]
		if changable:
			finalIdentifiers.append("const")
		else:
			finalIdentifiers.append("changable")
		if glob:
			finalIdentifiers.append("var")
		else:
			finalIdentifiers.append("let")
		if isref:
			finalIdentifiers.append("ref")
		else:
			finalIdentifiers.append("obj")
		fnd=NodeData(None,identifiers=finalIdentifiers)
		varname='unknown_variable'
		if len(ids)>0:
			if ids[len(ids)-1] in var_identifiers:
				err=Exceptions.exception(name="SyntaxError",message="Expected Variable Name but got Identifiers.")
				raise err
				# return NodeData(None,err=err,isValid=False)
			else:
				varname=ids[len(ids)-1]
		else:
			raise Exceptions.exception(message="How did you do it...")
		if len(s)>0:
			if s[0] == '=':
				s.remove(s[0])
				en=ExprNode()
				if en.valid(s):
					end=en.process(s)
					s=end.data["restStr"]
					if end.err is not None:
						raise end.err
					if end.data["isValid"]:
						fnd.value=end
						fnd.type="expr"
						fnd.cls="var"
					else:
						raise Exceptions.exception(message="Syntax error:expression not valid")
				else:
					raise Exceptions.exception("Syntax error:expression not valid")
		fnd.data["key"]=varname
		fnd.data["restStr"]=s
		return fnd
class FuncCallNode(Node):
	def valid(self,s):
		for c in s:
			if c=='(':
				# print("found.valid")
				return True
			if c.isspace() or not c.isalpha() and not c.isdigit() and not c=='(':
				# print("invalid char")
				return False
		#print("found all but not valid")
		return False
	def process(self,s):
		cct=''
		if len(s)>0:
			args=''
			funcName=''
			isInArgs=False
			isInStr=False
			for c in copy.deepcopy(s):
				cct+=c
				s.remove(s[0])
				if c=='(':
					if not isInStr:
						isInArgs=True
						continue
				if c==')':
					if not isInStr:
						isInArgs=False
						break
				if c=='"':
					isInStr=not isInStr
				if isInArgs:
					args+=c
				else:
					funcName+=c
			if isInArgs:
				raise Exceptions.exception(message="Unterminated argument value passing.",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=cct)])
			cn=CommaNode()
			en=ExprNode()
			wn=WhitespaceNode()
			en.bind(self.parent)
			args=list(args)
			oriargs=args
			aargs=[]
			while len(args)>0:
				if wn.valid(args):
					args=wn.process(args).data["restStr"]
				try:
					end=en.process(args)
					args=end.data["restStr"]
					aargs.append(end)
				except Exceptions.exception as e:
					raise Exceptions.exception(name="SyntaxError",message="Invalid Syntax passing argument value.",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=oriargs)]+e.stack)
				if cn.valid(args):
					args=cn.process(args).data["restStr"]
		return NodeData(value=None,type="expr",cls="funccall",restStr=s,arguments=aargs,funcName=funcName)
class NewNode(Node):
	def valid(self,s):
		if len(s)>=3:
			return s[0:3]==list("new")
	def process(self,s):
		cct='' # string read and concated.
		if len(s)>0:
			s=s[4:]
			fcn=FuncCallNode()
			fcn.bind(self.parent)
			fcnd=fcn.process(s)
			s=fcnd.data["restStr"]
			return NodeData(value=None,type="expr",cls="new",funcName=fcnd.data["funcName"],restStr=s,arguments=fcnd.data["arguments"])
		raise Exceptions.exception(message="got unexpected EOF")
class DotNode(Node):
	def valid(self,s):
		if len(s)>0:
			return s[0]=='.'
		return False
	def process(self,s):
		currentab=self.parent.codebuf[self.parent.coden]
		if len(currentab)<1:
			raise Exceptions.exception(name="SyntaxError",message="using dot expr before nothing",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)])
		currenta=currentab[len(currentab)-1]
		current=None
		types=[]
		en=ExprNode(dot_exprs)
		s=s[1:]
		if currenta.cls=="var":
			current=currenta.value
		else:
			current=currenta
		cpy=copy.deepcopy(current)
		current.value=None
		current.type="expr"
		current.cls="dot"
		end=en.process(s)
		s=end.data["restStr"]
		current.data["field"]=end
		return NodeData(None,type="expr",cls="dot",restStr=s)
	
exprs=[
	VarNode,
	StringNode,
	NumNode,
	NewNode,
	DotNode,
	FuncCallNode,
	WhitespaceNode,
	SplitNode
]
dot_exprs=[
	FuncCallNode,
	NameNode
]	
class ExprNode(Node):
	nodes=exprs
	
	def __init__(self,nodes=exprs):
		self.nodes=nodes
	
	def valid(self,s):
		for n in self.nodes:
			if n().valid(s):
				print("%s is valid with %s"%(n,str(s)))
				return True
		return False
	def process(self,s):
		for n in self.nodes:
			ins=n()
			if ins.valid(s):
				ins.bind(self.parent)
				nr=ins.process(s)
				return nr
			
		raise Exceptions.exception(message="Unknown Syntax",stack=[Exceptions.stack(self.parent.line,self.parent.column,s)])

class Processor:
	codebuf=[[]]
	en=ExprNode()
	line=1
	column=1
	coden=0
	def __init__(self):
		self.en.bind(self)
	def process(self,inp):
		length=len(inp)
		while len(inp)>0:
			self.en.valid(inp)
			end=self.en.process(list(inp))
			inp=end.data["restStr"]
			self.column+=length-len(inp)
			length=len(inp)
			if end.cls=="dot":
				printf(self.codebuf[self.coden][len(self.codebuf[self.coden])-1])
				continue
			self.codebuf[self.coden].append(end)
			printf(end)
			print("one code ended")
		self.line+=1
		self.column=1
		return self.codebuf
		
		
		
def printf(s):
	if isinstance(s,list) or isinstance(s,dict) or isinstance(s,tuple):
		for k in s:
			printf(s)
	else:
		print(s)
print("LeafLang Testing")
inp=input('>')
proc=Processor()
while inp is not 'quit()':
	res=proc.process(list(inp))
	for i in res:
		print('[')
		for j in i:
			print('      ',j.__str__())
		print(']')
	inp=input('>')
