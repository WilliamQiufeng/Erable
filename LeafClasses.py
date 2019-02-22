defined_classes=[]
class Method:
	name="anonymus"
	codes=[] # list of codes
	args={} # args (classes) like:{"arg1":"cls"}
	def __init__(self,name,args,codes):
		self.name  =  name
		self.args  =  args
		self.codes =  codes
	def invoke(*args):
		
class Class :
	constructor=[]
	methods=[]
	fields={}
	def __init__(self,type):
		self.type=type
	def addConstructor(self,n):
		self.constructor.append(n)
	def addField(self,f):
		self.fields.append(f)
	def addMethod(self,m):
		self.methods.append(m)
	def getConstructor(self,name):
		for c in self.constructor:
			if c.name==name:
				return c
		return None
