from __future__ import print_function,division,absolute_import

import copy
import Exceptions


def arrToStr(arr):
	''' an tool function which turns list-ified string back to the string '''
	string=""
	for c in arr:
		string+=c
	return string
def matchStart(arr,s):
	'''match string at start'''
	if len(s)>0:
		for b in arr:
			# print("COMPARING %s WITH %s"%(arrToStr(s),b))
			if arrToStr(s).startswith(b):
				return True
	return False
def findInBasicOp(s):
	'''
	check if operation is in basic oprations list.
	if do,return the operation
	else ,return False.
	'''
	stringified=arrToStr(s)
	for it in basic_operations:
		itmo=it[:-1] # IT Minus One
		if stringified.startswith(itmo):
			return itmo
	return False
def cleanWhiteSpaces(s):
	'''
	a tool function to help clean whitespaces.
	it helps with time
	'''
	wsn = WhitespaceNode()
	wsnd= wsn.process(s)
	return wsnd.restStr
nddata={
	"isValid":"isValid",
	"isList" :"isList",
	"isBlock":"isBlock",
	"length" :"length",
	"restStr":"restStr"
}

'''Identifiers used for variable declaration'''
var_identifiers=["let","const","var","ref","obj","changable"]
'''Identifiers in if statement but not need to be connected'''
no_need_if_identifiers=["if","with","while","signal","protect"]
'''Identifiers used for if statement'''
if_identifiers=[*no_need_if_identifiers,"elif","else"]

'''Left Bracket'''
left_bracket=["(","{"]
'''Right Bracket'''
right_bracket=[")","}"]

'''
basic operations
'''
basic_operations=[
	"return ",
	"delete ",
	"emit "  ,
	"import ",
	"async " ,
	"await " 
]
'''
zero operations
'''
zero_operations=[
	"break",
	"continue"
]

'''
Unary  Operations
'return': return value
'!'     : not gate
'@'     : gets the value by the reference
'#'     : gets the reference by the value
'''
unary_operations=[
	*basic_operations,
	"!",
	"@","#"
]

'''
Binary Operations
"a<<<b": unsigned a<<b
"a>>>b": unsigned a>>b
"a<=>b": swap a and b (value type must be same)
"a==b" : decides if a equals b
"a!=b" : decides if a does not equal to b
"a<=b" : decides if a is less than or equal to b
"a>=b" : decides if a is greater or equal to b
"a>>b" : move b binary digit right of a
"a<<b" : move b binary digit left of a
"a&&b" : boolean a and b
"a||b" : boolean a or b
"a.b"  : gets the field b of a
"a+b,a-b,a*b,a/b,a%b": do calculation
"a&b"  : binary a and b
"a|b"  : binary a or b
"a^b"  : binary a xor b
"a=b"  : change the value of a to b
"a>b,a<b" : decides if a is greater than/less than b
":"    : TODO
"?"    : TODO
'''
binary_operations=[
	"<<<",">>>","<=>",
	"==","!=","<=",">=","<<",">>","&&","||",
	".","+","-","*","/","%","&","|","^","=",">","<",":","?"
]
evaluation_operations=["+","-","*","/","%"]

'''digits'''
nums=list("0123456789abcdefghijklmnopqrstuvwxyz")

class Code:
	'''I dont know what this is for'''
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
	'''neither this'''
	def __init__(self,string):
		self.source='"%s"'(string)
		self.tokens=['"',string,'"']

class NodeData:
	'''Stores the data returned from the syntax parser(Node)'''
	def __init__(self,
				value=None,
				type="null",
				cls="null",
				err=None,
				length=0,
				restStr="",
				needsAdd=True,
				*args,
				**kwargs):
		self.value=value
		self.type=type
		self.cls=cls
		self.err=err
		self.restStr=restStr
		self.needsAdd=needsAdd
		self.data=kwargs
		self.arr=list(args)
		if self.data.get("isValid") == None:
			self.data["isValid"]=True
	def __str__(self):
		return str(vars(self))

class InstanceNodeData(NodeData):
	'''
		Base Class for instance types
	'''
	def __init__(self,value=None,cls="null",restStr="",*args,**kwargs):
		NodeData.__init__(self,value=value,type="instance",cls=cls,restStr=restStr,*args,**kwargs)

class StringNodeData(InstanceNodeData):
	'''
		NodeData for string
	'''
	def __init__(self,string,restStr):
		InstanceNodeData.__init__(self,string,cls="string",restStr=restStr)

class NumNodeData(InstanceNodeData):
	'''
		NodeData for numbers
	'''
	def __init__(self,num,restStr):
		InstanceNodeData.__init__(self,num,cls="number",restStr=restStr)

class ArrayNodeData(InstanceNodeData):
	def __init__(self,arr=[],restStr=''):
		InstanceNodeData.__init__(self,arr,cls="arr",restStr=restStr)
class ZeroOperation(NodeData):
	'''
	NodeData class to store zero operation
	'''
	def __init__(self,operation="null",restStr=""):
		NodeData.__init__(self,None,type="operation",cls=operation,restStr=restStr)
class UnaryOperation(NodeData):
	'''
		NodeData class to store unary operations
	'''
	def __init__(self,operation,target,restStr):
		NodeData.__init__(self,None,type="operation",cls=operation,restStr=restStr)
		self.data["target"]=target

class BinaryOperation(NodeData):
	'''
		NodeData class to store binary operations
	'''
	def __init__(self,operation,target,field,restStr):
		NodeData.__init__(self,None,type="operation",cls=operation,restStr=restStr,needsAdd=False)
		self.data['target']=target
		self.data['field']=field

class ExprNodeData(NodeData):
	'''
		expr Node data
	'''
	def __init__(self,
				value=None,
				cls="null",
				err=None,
				length=0,
				restStr="",
				*args,
				**kwargs):
		NodeData.__init__(self,value,type="expr",cls=cls,err=err,length=length,restStr=restStr,*args,**kwargs)
		

class IfNodeData(ExprNodeData):
	def __init__(self,cls="null",cond=None,do=None,restStr=""):
		ExprNodeData.__init__(self,None,cls=cls,restStr=restStr)
		self.cond=cond
		self.do=do
		self.elses=[]
		self.elifs=[]
class ArgsDeclNodeData(ExprNodeData):
	def __init__(self,args=[],restStr=""):
		ExprNodeData.__init__(self,value=args,cls="args",restStr=restStr)
class ForEachNodeData(ExprNodeData):
	def __init__(self,var=[],iterator=[],do=None,restStr=""):
		ExprNodeData.__init__(self,None,cls="foreach",restStr=restStr)
		self.var=var
		self.iterator=iterator
		self.do=do
anonymous_lable_id=0
class LabelNodeData(ExprNodeData):
	def __init__(self,name=None,do=None,restStr=""):
		global anonymous_label_id
		ExprNodeData.__init__(self,value=do,cls="label",restStr=restStr)
		if name==None:
			name="anonymous_label%d"%(anonymous_label_id)
			anonymous_label_id+=1
		self.name=name

anonymous_func_id=0
class FuncDeclNodeData(ExprNodeData):
	def __init__(self,name=None,args=[],do=None,restStr=""):
		global anonymous_func_id
		ExprNodeData.__init__(self,value=do,cls="function",restStr=restStr)
		if name==None:
			name="anonymous_func%d"%(anonymous_func_id)
			anonymous_func_id+=1
		self.args=args
		self.name=name
anonymous_class_id=0
class ClassDeclNodeData(ExprNodeData):
	def __init__(self,name=None,extends=[],do=None,restStr=""):
		global anonymous_class_id
		ExprNodeData.__init__(self,value=do,cls="class",restStr=restStr)
		if name==None:
			name="anonymous_class%d"%(anonymous_class_id)
			anonymous_class_id+=1
		self.extends=extends
		self.name=name
class Node:		
	'''Basic Node Class'''
	@classmethod
	def __init__(self):
		pass
	@classmethod
	def valid(self,s):
		'''Used to check if the syntax is valid.'''
		return True
	@classmethod
	def process(self,s):
		''' 
			usally called when the syntax is valid.
			processes the code and give the result as a NodeData
		'''
		nd= NodeData('',restStr=s)
		return nd
	@classmethod
	def bind(self,node):
		'''Binds the parent'''
		# bind the parent node
		self.parent=node
class WhitespaceNode(Node):
	'''Used to Ignore Whitespaces'''
	def valid(self,s):
		return len(s)>0 and s[0].isspace()
	def process(self,s):
		for c in copy.deepcopy(s):
			if c.isspace():
				s.remove(s[0])
			else:
				break
		return ExprNodeData(None,restStr=s,cls="whitespace",needsAdd=False)

class SplitNode(Node):		
	'''Used to process split.'''
	def valid(self,s):
		if len(s)>0:
			return s[0]==';'
		return False
	def process(self,s):
		if len(s)>0:
			for c in copy.deepcopy(s):
				if c==';':
					s.remove(s[0])
				else:
					break
			'''
				start a new line of code
			'''
			self.parent.coden+=1
			self.parent.codebuf.append([])
			self.parent.current=None
		return ExprNodeData(restStr=s,cls="split")

class CommaNode(Node):		
	'''Used to ignore commas or used in argument parsing'''
	def valid(self,s):
		if len(s)>0:
			return s[0]==','
		return False
	def process(self,s):
		if len(s)>0:
			for c in copy.deepcopy(s):
				if c==',':
					s.remove(s[0])
				else:
					break
		return ExprNodeData(restStr=s,cls="comma")

class NameNode(Node):
	'''Basic Name Structure.regex:  [a-zA-Z_$][a-zA-Z0-9_$]*'''
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
				Exceptions.exception(message="name cannot be started with a digit").throw()
		for c in copy.deepcopy(s):
			if not c.isalpha() and not c in list("_$") and not c.isdigit():
				break
			res+=c
			s.remove(s[0])
		
		return ExprNodeData(res,cls="name",length=len(res),isValid=True,restStr=s)


class NumNode(Node):
	'''
		Processes Numbers
		radix changed when using:
			number + 'r'
			like:16rabcd
	'''
	def valid(self,s):
		if len(s)>0:
			return s[0].isdigit()
		return False
	def process(self,s):
		orig=""
		res=0
		currentDigit=1
		radix=10
		isFloat=False
		floatP=0
		if len(s)>0:
			for c in copy.deepcopy(s):
				orig+=c
				if c=='r':
					if isFloat:
						radix=floatP*currentDigit
						currentDigit=1
						floatP=0
					else:
						radix=res
						res=0
					printf("radix changed to:%d"%(radix))
				elif c==".":
					isFloat=not isFloat
				else:
					if c in nums:
						printf("found %s in nums"%(c))
						if nums.index(c)<radix:
							if isFloat:
								currentDigit*=radix
								floatP+=nums.index(c)/currentDigit
							else:
								res*=radix
								res+=nums.index(c)
						else:
							Exceptions.exception(message="Number '%s' is not in radix '%d'"%(c,radix),stack=[Exceptions.stack(self.
							parent.line,self.parent.column,orig)]).throw()
					else:
						break
				s.remove(s[0])
		return NumNodeData(res+floatP,restStr=s)

class StringNode(Node):		
	'''Processes Strings'''
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
					return StringNodeData(ret,restStr=s)
			else:
				ret+=c
			s.remove(s[0])
		Exceptions.exception(message="Error:Unterminated String Literal").throw()


class CodeBlockNode(Node):
	'''
		Processes the code blocks
		{
			[codes]
		}
		(
			[codes]
		)
	'''
	def __init__(self):
		# Node.__init__(self)
		self.nodes=exprs
	def valid(self,s):
		if len(s)>0:
			if s[0] in ["{","("]:
				return True
		return False
	def setExprs(self,nodes):
		self.nodes=nodes
	def process(self,s):
		if len(s)>0:
			# codes inside the code block
			cbk=""
			# level of the scope
			which=0
			for c in copy.deepcopy(s):
				s.remove(s[0])
				if c in left_bracket:
					which+=1
					if which!=1:
						cbk+=c
					continue
				elif c in right_bracket:
					which-=1
					if which==0:
						break
					else:
						cbk+=c
					continue
				cbk+=c
			printf("---CODE BLOCK---")
			printf(cbk)
			printf("---END CODE BLOCK---")
			blk=[[]]
			pcs=Processor()
			pcs.setExprs(self.nodes)
			blk=pcs.process(cbk)
			return ExprNodeData(value=blk,cls="codeblock",restStr=s)

class VarNode(Node):			
	'''
		Processes Variable Declaration
		(var|let|const|changable|obj|ref)+ NameNode [= ExprNode]
			var      : global
			let      : only in current scope or deeper
			const    : not changable
			changable: changanle
			obj      : it specifies that the value is an object
			ref      : it specifies that the value points to an object
		NOTE : reference can also be stored as a value,but it comes out as a number.
	'''
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
			s=globnd.restStr
			s=cleanWhiteSpaces(s)
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
		fnd=ExprNodeData(None,cls="var",identifiers=finalIdentifiers)
		fnd.value=None
		varname='unknown_variable'
		if len(ids)>0:
			if ids[len(ids)-1] in var_identifiers:
				Exceptions.exception(name="SyntaxError",message="Expected Variable Name but got Identifiers.").throw()
			else:
				varname=ids[len(ids)-1]
		else:
			Exceptions.exception(message="How did you do it...").throw()
		if len(s)>0:
			if s[0] == '=':
				s.remove(s[0])
				en=ExprNode()
				en.bind(self.parent)
				if en.valid(s):
					end=en.process(s)
					s=end.restStr
					if end.err is not None:
						raise end.err
					if end.data["isValid"]:
						fnd.value=end
					else:
						Exceptions.exception(message="Syntax error:expression not valid").throw()
				else:
					Exceptions.exception("Syntax error:expression not valid").throw()
		fnd.data["key"]=ExprNodeData(varname,cls="name",length=len(varname),isValid=True,restStr=s)
		fnd.restStr=s
		return fnd

class FuncCallNode(Node):		
	'''
		Processes a function calling
		[NameNode] ([ExprNode[,ExprNode[,...]]])
	'''
	def valid(self,s):
		for c in s:
			if c=='(':
				return True
			if c.isspace() or not c.isalpha() and not c.isdigit() and not c=='(':
				return False
		return False
	def process(self,s):
		cct=''
		if len(s)>0:
			args=''
			funcName=''
			isInArgs=0
			isInStr=False
			nn=NameNode()
			nn.bind(self.parent)
			nnd=nn.process(s)
			funcName=nnd.value
			s=nnd.restStr
			aargs=[]
			rargs=[]
			if s[0] in left_bracket:
				isInArgs+=1
				s.remove(s[0])
				for c in copy.deepcopy(s):
					cct+=c
					s.remove(s[0])
					if c in left_bracket:
						if not isInStr:
							isInArgs+=1
					if c in right_bracket:
						if not isInStr:
							isInArgs-=1
							if isInArgs==0:
								if args!="":
									aargs.append(args)
									args=""
								break
					if c=='"':
						isInStr=not isInStr
					if isInArgs>0:
						args+=c
					if isInArgs==1 and c==',':
						aargs.append(args)
						args=""
				for arg in aargs:
					pcs=Processor()
					cbf=pcs.process(arg)[0]
					rargs.append(cbf)
				return ExprNodeData(value=funcName,cls="funccall",restStr=s,arguments=rargs)
			else:
				return 	ExprNodeData(value=funcName,cls="funccall",restStr=s,arguments=[])
			if isInArgs:
				Exceptions.exception(message="Unterminated argument value passing.",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=cct)]).throw()
			printf("FINAL ARGS:",args)
					
		return NodeData(value=None,type="expr",cls="funccall",restStr=s,arguments=aargs,funcName=funcName)
		

class NewNode(Node):
	'''
		processes an initialisation.
		Usage:
			new [FuncCallNode]
		NOTE : you can also use 'new cls' instead of 'new cls()'
	'''
	def valid(self,s):
		if len(s)>=3:
			return s[0:3]==list("new")
	def process(self,s):
		cct='' # string read and concated.
		if len(s)>0:
			s=s[4:]
			retn=ExprNodeData(value=None,cls="new")
			
			fcn=FuncCallNode()
			fcn.bind(self.parent)
			fcnd=fcn.process(s)
			printf(fcnd)
			s=fcnd.restStr
			retn.value=fcnd.value
			retn.restStr=s
			retn.data['arguments']=fcnd.data["arguments"]
			return retn
		Exceptions.EOFException().throw()


class BinaryOpNode(Node):
	'''
		processes binary opreations
		[ExprNode] [bin_op] (FuncCallNode|NameNode)
	'''
	def valid(self,s):
		return matchStart(binary_operations,s)
	def process(self,s):
		# currentab=self.parent.codebuf[self.parent.coden]
		currenta=self.parent.current
		if currenta==None:
			Exceptions.exception(name="SyntaxError",message="using binary operation after nothing",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)]).throw()
		printf("---BINARY OPCODE CURRENT---")
		printf(currenta)
		printf("---END BINARY OPCODE CURRENT---")
		current=None
		types=[]
		en=ExprNode()
		en.bind(self.parent)
		op="null"
		stringified=arrToStr(s)
		for it in binary_operations:
			if stringified.startswith(it):
				op=it
				break
		s=s[len(op):]
		if currenta.cls=="var":
			current=currenta.value
		else:
			current=currenta
		ccp=current
		if op in ["*","/","%"] and current.type=="operation":
			printf("CHANGING ORDER OF OPERATION...Class=%s"%(current.cls))
			if current.cls in binary_operations:
				current=current.data['field']
			elif current.cls in unary_operations or findInBasicOp(current.cls):
				current=current.data["target"]
			#else:
			#	Exceptions.exception(name="OperationNotFoundError",message="unknown operation for matching.",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)]).throw()
		cpy=copy.deepcopy(current)
		current.value=None
		current.type="operation"
		current.cls=op
		printf("---processing field after binary operator '%s'....---"%(op))
		end=en.process(s)
		printf("---DOT EXPR PROCESSED---\n")
		s=end.restStr
		ccp.restStr=s
		current.data["field"]=end
		current.data["target"]=cpy
		current=ccp
		current.needsAdd=False
		return current
	
class UnaryOpNode(Node):
	'''
		processes unary opreations
		[ExprNode] [unary_op] (FuncCallNode|NameNode)
	'''
	def valid(self,s):
		return matchStart(unary_operations,s) and not matchStart(binary_operations,s)
	def process(self,s):
		types=[]
		en=ExprNode()
		en.bind(self.parent)
		op="null"
		stringified=arrToStr(s)
		for it in unary_operations:
			if stringified.startswith(it):
				op=it
				break
		s=s[len(op):]
		if op in basic_operations:
			op=op[:-1]
		printf("---processing field after unary operator '%s'....---"%(op))
		end=en.process(s)
		printf("---DOT EXPR PROCESSED---\n")
		s=end.restStr
		current=UnaryOperation(op,end,s)
		return current

class ZeroOpNode(Node):
	def valid(self,s):
		cct=""
		for c in s:
			if c.isdigit() or c.isalpha():
				cct+=c
			else:
				break
		return cct in zero_operations
	def process(self,s):
		cct=""
		for c in copy.copy(s):
			if c.isalpha() or c.isdigit():
				cct+=c
				s=s[1:]
			else:
				break
		if cct in zero_operations:
			op=cct
			return ZeroOperation(op,s)
		Exceptions.exception(message="Invalid Zero Operation",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=cct)]).throw()

class ArrayNode(Node):
	def valid(self,s):
		if len(s)>0:
			return s[0]=="["
		return False
	def process(self,s):
		s=s[1:]
		en=ExprNode()
		en.bind(self.parent)
		elements=[]
		while len(s)>0:
			if s[0]=="]":
				s=s[1:]
				break
			vld=en.valid(s)
			if vld.__name__==CommaNode.__name__:
				s=s[1:]
				self.parent.current=None
				continue
			if not vld:
				Exceptions.exception(message="Invalid Statement Array Element",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)]).throw()
			end=en.process(s)
			s=end.restStr
			if end.needsAdd:
				elements.append(end)
			printf("---ARR CURRENT---")
			printf(self.parent.current)
			printf("---END ARR CURRENT---")
		return ArrayNodeData(elements,restStr=s)
class IfNode(Node):
	'''TODO:all stuff related to if statement'''
	def valid(self,s):
		cct=""
		for c in s:
			if not c.isalpha():
				return cct in if_identifiers
			cct+=c
		return False
		# for i in if_identifiers:
		# 	if arrToStr(s).startswith(i+"(") or arrToStr(s).startswith(i+"{"):
		# 		return True
		# return False
	def process(self,s):
		cls="null"
		for i in if_identifiers:
			if arrToStr(s).startswith(i):
				cls=i
		if cls=="null":
			Exceptions.exception(message="Not a valid if statement",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)]).throw()
		printf("IF STATE MENT '%s' FOUND"%(cls))
		s   =  s[len(cls):]
		s   =  cleanWhiteSpaces(s)
		cbn =  CodeBlockNode()
		# cbn.bind(self.parent)
		cond=None
		if cls!="else":
			cond=cbn.process(s)
			s=cond.restStr
		dosth=cbn.process(s)
		s=dosth.restStr
		ifnd=IfNodeData(cls=cls,cond=cond,do=dosth,restStr=s)
		if cls in no_need_if_identifiers:
			return ifnd
		else:
			current=self.parent.current
			if current.cls in if_identifiers and cls!="if":
				ifnd.needsAdd=False
				if cls=="else":
					current.elses.append(ifnd)
				elif cls=="elif":
					current.elifs.append(ifnd)
				else:
					Exceptions.exception(message="undefined class of if statement").throw()
				return ifnd
			else:
				Exceptions.exception(message="Undefined Behavior").throw()
		Exceptions.exception(message="unknown").throw()

class ForEachNode(Node):
	def valid(self,s):
		cct=""
		for c in s:
			if not c.isalpha():
				return cct=="foreach"
			if c not in "foreach":
				break
			cct+=c
		return False
	def process(self,s):
		cct=""
		s=s[7:] # length of 'foreach' is 7, so substr [7:]
		s=cleanWhiteSpaces(s)
		adn=ArgsDeclNode()
		adn.bind(self.parent)
		cbn=CodeBlockNode()
		cbn.bind(self.parent)
		var=[]
		iterator=[]
		if adn.valid(s):
			adnd=adn.process(s)
			s=adnd.restStr
			var=adnd.value
		s=cleanWhiteSpaces(s)
		if adn.valid(s):
			adnd=adn.process(s)
			s=adnd.restStr
			iterator=adnd.value
		s=cleanWhiteSpaces(s)
		if cbn.valid(s):
			cbnd=cbn.process(s)
			s=cbnd.restStr
			do=cbnd.value
		return ForEachNodeData(var=var,iterator=iterator,do=do,restStr=s)
class ArgsDeclNode(Node):
	'''
	this node is used by Class Declaration and Function Declaration.
	'''
	def valid(self,s):
		if len(s)>0:
			return s[0]==":"
		return False
	def process(self,s):
		args=[]
		if len(s)>0:
			if s[0]==":":
				s=s[2:]
				en  = NameNode()
				en  . bind(self.parent)
				while True:
					# clean whitespaces
					s=cleanWhiteSpaces(s)
					printf("---WS CLEANED---")
					printf(s)
					printf("---END WS CLEANED---")
					if len(s)<=0:
						Exceptions.EOFException().throw()
					char=s[0]
					if char in right_bracket:
						s=s[1:]
						break
					if char==",":
						s=s[1:]
						continue
					vld=en.valid(s)
					if not vld:
							Exceptions.exception(message="Invalid Args Declaration Element",stack=[Exceptions.stack(line=self.parent.line,column=self.parent.column,code=s)]).throw()
					end=en.process(s)
					s=end.restStr
					args.append(end.value)
		printf("restStr=",s)
		return ArgsDeclNodeData(args,s)
		
class LabelNode(Node):
	def valid(self,s):
		cct=""
		for c in s:
			if not c.isalpha():
				return cct=="label"
			if c not in ["l","a","b","e"]:
				return False
			cct+=c
	def process(self,s):
		s=s[5:] # length of 'label' is 5
		s=cleanWhiteSpaces(s)
		nn=NameNode()
		name=None
		if nn.valid(s):
			nnd=nn.process(s)
			s=nnd.restStr
			name=nnd.value
		s=cleanWhiteSpaces(s)
		en=ExprNode()
		en.bind(self.parent)
		do=None
		if en.valid(s):
			end=en.process(s)
			s=end.restStr
			do=end
		return LabelNodeData(name=name,do=do,restStr=s)
class FuncDeclNode(Node):
	'''
	Usage:
		function name:(arg1,arg2,arg3,...){do sth}
	'''
	def valid(self,s):
		cct=""
		for c in s:
			if not c.isalpha():
				return cct=="function"
			if c not in ["f","u","n","c","t","i","o"]:
				return False
			cct+=c
	def process(self,s):
		s=s[8:]# length of 'function' is 8
		# first,clean whitespaces
		s   = cleanWhiteSpaces(s)
		# second,read the function name
		nn  = NameNode()
		nn  . bind(self.parent)
		name= None
		# function name will be anonymous if not valid
		if nn.valid(s):
			nnd=nn.process(s)
			s=nnd.restStr
			name=nnd.value
		# clean whitespaces again
		s   = cleanWhiteSpaces(s)
		# now read argument declaration
		adn=ArgsDeclNode()
		adn.bind(self.parent)
		argsd=adn.process(s)
		args=argsd.value
		s=argsd.restStr
		s=cleanWhiteSpaces(s)
		# process the 'do' part
		do=None
		don = CodeBlockNode()
		don.bind(self.parent)
		# if not valid just skip
		if don.valid(s):
			dod=don.process(s)
			s=dod.restStr
			do=dod
			
		return FuncDeclNodeData(name=name,args=args,do=do)
class ClassDeclNode(Node):
	'''
	Class Declaration Usage:
		class [Name classname] [Args extends] [CodeBlock do]
	'''
	def valid(self,s):
		cct=""
		for c in s:
			if not c.isalpha():
				return  cct=="class"
			if c not in ["c","l","a","s"]:
				return False
			cct+=c
			
	def process(self,s):
		s=s[5:]# length of 'function' is 8
		# first,clean whitespaces
		s   = cleanWhiteSpaces(s)
		# second,read the function name
		nn  = NameNode()
		nn  . bind(self.parent)
		name= None
		# class name will be anonymous if not valid
		if nn.valid(s):
			nnd=nn.process(s)
			s=nnd.restStr
			name=nnd.value
		# clean whitespaces again
		s   = cleanWhiteSpaces(s)
		# now read extends declaration
		adn=ArgsDeclNode()
		adn.bind(self.parent)
		argsd=adn.process(s)
		extends=argsd.value
		s=argsd.restStr
		s=cleanWhiteSpaces(s)
		# process the 'do' part
		do=None
		don = CodeBlockNode()
		don.setExprs(class_do_exprs)
		don.bind(self.parent)
		# if not valid just skip
		if don.valid(s):
			dod=don.process(s)
			s=dod.restStr
			do=dod
			
		return ClassDeclNodeData(name=name,extends=extends,do=do)
exprs=[
	FuncDeclNode,
	ClassDeclNode,
	ForEachNode,
	LabelNode,
	ArrayNode,
	BinaryOpNode,
	UnaryOpNode,
	ZeroOpNode,
	CodeBlockNode,
	VarNode,
	IfNode,
	StringNode,
	NumNode,
	NewNode,
	FuncCallNode,
	NameNode,
	WhitespaceNode,
	SplitNode,
	CommaNode
]
dot_exprs=[
	FuncCallNode,
	NameNode
]
class_do_exprs=[
	ClassDeclNode,
	FuncDeclNode,
	VarNode,
	SplitNode,
	CodeBlockNode,
	WhitespaceNode
]
class ExprNode(Node):
	nodes=exprs
	
	def __init__(self,nodes=exprs):
		self.nodes=nodes
		
	
	def valid(self,s):
		for n in self.nodes:
			if n().valid(s):
				printf("%s is valid with %s"%(n,str(s)))
				return n
		return False
	def process(self,s):
		s=cleanWhiteSpaces(s)
		for n in self.nodes:
			ins=n()
			if ins.valid(s):
				ins.bind(self.parent)
				nr=ins.process(s)
				if nr.needsAdd:
					self.parent.current=nr
					printf("---CURRENT :",hex(id(self.parent.current)),"---")
					printf(self.parent.current)
					printf('---END CURRENT---')
				s=cleanWhiteSpaces(s)
				return nr
			
		Exceptions.exception(message="Unknown Syntax",stack=[Exceptions.stack(self.parent.line,self.parent.column,s)]).throw()

class Processor:
	
	def __init__(self):
		self.clearbuf()
	def setExprs(self,exprs):
		self.en.nodes=exprs
	def process(self,inp):
		length=len(inp)
		while len(inp)>0:
			vld=self.en.valid(inp)
			if vld:
				printf("VALID:",vld.__name__)
			else:
				printf("NO VALID EXPR!")
			end=self.en.process(list(inp))
			printf("---NEW CURRENT---")
			printf(self.current)
			printf("---END NEW CURRENT---")
			inp=end.restStr
			self.column+=length-len(inp)
			length=len(inp)
			if not end.needsAdd:
				printf(end.cls,": ")
				printf(self.current)
				printf("")
				continue
			elif end.cls in ["split","comma","whitespace"]:
				printf(end.cls,"MET")
				continue
			self.codebuf[self.coden].append(end)
			
			printf(end)
			printf("one code ended")
		self.line+=1
		self.column=1
		return self.codebuf
	def clearbuf(self):
		self.codebuf=[[]]
		self.isInArgs=False
		self.current=None
		self.en=ExprNode()
		self.line=1
		self.column=1
		self.coden=0
		self.en.parent=self
		
		
def printf(*args):
	return False
	print(*args)
	
def test():
	import time
	milli = lambda: int(time.time() * 1000)
	print("LeafLang Syntax Parser Testing")
	inp=input('>')
	global proc
	proc=Processor()
	while inp != 'quit()':
		ms=milli()
		res=proc.process(list(inp))
		ma=milli()
		# print(ma)
		md=ma-ms
		for i in res:
			print('[')
			for j in i:
				print('      ',j.__str__())
			print(']')
		print("used %d ms"%(md))
		inp=input('>')

if __name__=="__main__":
	test()
