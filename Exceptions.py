exception_list=[]
class stack:
	def __init__(self,line=-1,column=-1,code="Unknown Code"):
		self.line   = line
		self.column = column
		self.code   = code
	def __str__(self):
		s='\tat #%d column %d:\''%(self.line,self.column)
		for c in self.code:
			s+=c
		s+='\''
		return s
class exception(Exception):
	@classmethod
	def __init__(self,
				name="Exception",
				message="",
				file="Unknown Source File",
				stack=[]):
		
		self.name   =name
		self.message=message
		self.file   =file
		self.stack  =stack
		
	@classmethod
	def throw(self):
		exception_list.append(self)
	@classmethod
	def tostring(self):
		err='%s:%s(in %s)\n'%(self.name,self.message,self.file)
		for s in self.stack:
			err+=s.__str__()
			err+="\n"
		return err
	@classmethod
	def __str__(self):
		print(self.tostring())
		return self.tostring()
		

def throw_all():
	for err in exception_list:
		print(err.tostring())
	raise "Terminated due to runtime error"
