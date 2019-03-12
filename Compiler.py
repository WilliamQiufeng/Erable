import OpCodes,math,Node,Exceptions
Exceptions.state="Compilation"
constant_pool_id=0
uid=0
bid=0
uid_length=2
bid_length=2
constant_pool_id_length=2
num_length=4
opcode_length=2
def tobyte(b,l):
	return b.to_bytes(l,"big")
def bufferC(id):
	global bid
	reg=tobyte(OpCodes.getOp("buf"),opcode_length)
	reg+=tobyte(id,constant_pool_id_length)
	reg+=tobyte(bid,bid_length)
	regd=BasicNodeOutData(reg,bid,"bid")
	kv_bids[bid]={
		"type":"cid",
		"id"  :id
	}
	printf("buf   c%d b%d"%(id,bid))
	bid+=1
	return regd

def checkExistsUB(id):
	for u in kv_uids:
		# printf(kv_uids[u]["name"],"and",kv_bids[id]["id"])
		if kv_uids[u]["name"]==kv_bids[id]["id"]:
			return True
	return False
def findUidB(id):
	# printf(id)
	for u in kv_uids:
		# printf(kv_uids[u]["name"],"and",kv_bids[id]["id"])
		if kv_uids[u]["name"]==kv_bids[id]["id"]:
			return u
	return 65535

def findUidC(id):
	idb=65535
	for u in kv_bids:
		# printf(kv_uids[u])
		if kv_bids[u]["id"]==id:
			idb=u
			break
	return findUidB(idb)
class NodeOutData:
	def __init__(self,*data,**kwargs):
		self.datas=data
		self.obj=kwargs
class BasicNodeOutData(NodeOutData):
	def __init__(self,bts,id,idType="id",**kwargs):
		self.bts=bts
		self.id=id
		self.idType=idType
		self.kwargs=kwargs
class Processor:
	def __init__(self):
		self.conpl=ConstantPool()
		self.bts=[]
	def processE(self,n):
		# print(n.cls)
		no=kv_vc.get(n.cls)
		noi=no(n)
		noi.bind(self)
		return noi.write()
	def process(self,ns):
		for na in ns:
			for n in na:
				bts=self.processE(n)
				self.bts.append(bts)
				#print(vars(bts))
		return self.bts
class NodeOut:
	code=0
	def bind(self,parent):
		self.parent=parent
	def add_id(self):
		global constant_pool_id
		self.cid=constant_pool_id
		constant_pool_id+=1
	def add_uid(self):
		global uid
		self.uid=uid
		uid+=1
	def add_bid(self):
		global bid
		self.bid=bid
		bid+=1
	def __init__(self,data=None):
		self.cid=constant_pool_id
		self.uid=uid
		self.bid=bid
		self.data=data
	@classmethod
	def write(self):
		return tobyte(self.code,opcode_length)

class ConstantPool(NodeOut):
	code=OpCodes.getOp("conpl")
	def __init__(self,pool=[]):
		self.pool=[]
	def add(self,this,element):
		for e in self.pool:
			if e.bts==element.bts:
				element.id=e.id
				return element.id
		self.pool.append(element)
		printf("conpl c%s"%(vars(element)))
		this.add_id()
		kv_cids[element.id]=element
		return element.id
	def write(self):
		op=tobyte(self.code,opcode_length)
		ret=op
		length=len(self.pool)
		ret+=tobyte(length,num_length)
		#print("op wrote")
		#print(ret)
		for d in self.data:
			ret+=d.bts
		return BasicNodeOutData(ret,-1)
class NumPoolElement(NodeOut):
	code=OpCodes.getTag("num")
	def __init__(self,num):
		NodeOut.__init__(self)
		self.num=num
	def write(self):
		op=tobyte(self.code,opcode_length)
		ret=op
		fi=math.modf(self.num.value)
		# print(fi)
		intp=tobyte(int(fi[1]),num_length)
		#print("---INT---")
		#print(intp)
		ret+=intp
		retd=BasicNodeOutData(ret,self.cid,"cid")
		self.cid=self.parent.conpl.add(self,retd)
		b=bufferC(self.cid)
		return b
class StringPoolElement(NodeOut):
	code=OpCodes.getTag("str")
	def __init__(self,string):
		NodeOut.__init__(self)
		self.string=string
	def write(self):
		ret=tobyte(self.code,opcode_length)
		length=tobyte(len(self.string.value),num_length)
		ret+=length
		ret+=bytearray(self.string.value.encode("utf-8"))
		retd=BasicNodeOutData(ret,self.cid,"cid")
		self.cid=self.parent.conpl.add(self,retd)
		b=bufferC(self.cid)
		return b
class Emulate:
	pass
class NameNodeOut(NodeOut):
	code=OpCodes.getOp("loadu")
	def __init__(self,nd):
		self.data=nd
	def write(self):
		spe=StringPoolElement(self.data)
		spe.bind(self.parent)
		cd=spe.write()
		exists=checkExistsUB(cd.id)
		if not exists:
			Exceptions.exception(name="NoDefinitionError",message="Cannot set a value to an undefined variable '%s'"%(self.data.value)).throw()
		uidb=findUidB(cd.id)
		ret=cd.bts+tobyte(self.code,opcode_length)+tobyte(uidb,uid_length)
		global bid
		ret+=tobyte(bid,bid_length)
		printf("loadu u%d b%d"%(uidb,bid))
		bnod=BasicNodeOutData(ret,bid,uid=uidb)
		kv_bids[bid]={
			"type":"uid",
			"id"  :uidb
		}
		bid+=1
		return bnod
class VarChangeNodeOut(NodeOut):
	code=OpCodes.getOp("set")
	def __init__(self,nd):
		self.data=nd
	def write(self):
		global bid
		targ=self.data.data["target"]
		fiel=self.data.data["field"]
		ret=b''
		targo=self.parent.processE(targ)
		
		fielo=self.parent.processE(fiel)
		ret=targo.bts+fielo.bts
		ret+=tobyte(self.code,opcode_length)
		# printf("targo id:",targo.id)
		nid=targo.kwargs["uid"]
		ret+=tobyte(nid,uid_length)+tobyte(fielo.id,bid_length)
		printf("set   u%d b%d"%(nid,fielo.id))
		return BasicNodeOutData(ret,-1)
class VarNodeOut(NodeOut):
	code=OpCodes.getOp("reg")
	def __init__(self,nd):
		self.data=nd
	def write(self):
		
		name_spe=StringPoolElement(self.data.data["key"])
		name_spe.bind(self.parent)
		nsw=name_spe.write()
		check=checkExistsUB(nsw.id)
		if check:
			Exceptions.exception(name="RedefinitionError",message="cannot define variable '%s' twice"%(self.data.data["key"].value)).throw()
		self.add_uid()
		ret=tobyte(self.code,opcode_length)
		printf("reg   u%d"%(self.uid))
		ncd=tobyte(OpCodes.getOp("name"),opcode_length)+tobyte(self.uid,uid_length)+tobyte(nsw.id,num_length)
		printf("name  u%d b%d"%(self.uid,nsw.id))
		bncd=nsw.bts
		if self.data.value!=None:
			val=self.parent.processE(self.data.value)
			vid=val.id
			bncd+=val.bts
			# print(vars(val))
			ret+=tobyte(OpCodes.getOp("set"),opcode_length)+tobyte(self.uid,uid_length)+tobyte(vid,uid_length)
			printf("set   u%d b%d"%(self.uid,vid))
			
		if "const" in self.data.data["identifiers"]:
			code=tobyte(self.uid,uid_length)
			ret+=tobyte(OpCodes.getOp("const"),opcode_length)+code
			printf("const u%d"%(self.uid))
		if "ref" in self.data.data["identifiers"]:
			code=tobyte(self.uid,uid_length)
			ret+=tobyte(OpCodes.getOp("ref"),opcode_length)+code
			printf("ref   u%d"%(self.uid))
		if "let" in self.data.data["identifiers"]:
			code=tobyte(self.uid,uid_length)
			ret+=tobyte(OpCodes.getOp("let"),opcode_length)+code
			printf("let   u%d"%(self.uid))
		ret=bncd+ret+ncd
		kv_uids[self.uid]={
			"uid"  :self.uid,
			"name" :nsw.id,
			"codes":ret
		}
		return BasicNodeOutData(ret,self.uid,"uid",name=nsw.id)

class NewNodeOut(NodeOut):
	code=OpCodes.getOp("new")
	
def printf(*args):
	print(*args)
kv_vc={
	"string":StringPoolElement,
	"name"	:NameNodeOut,
	"number":NumPoolElement,
	"var"   :VarNodeOut,
	"="		:VarChangeNodeOut
}
kv_uids={}
kv_bids={}
kv_cids={}
#def testconpl():
#	num=NumPoolElement(1024)
#	string=StringPoolElement("hello")
#	conpl=ConstantPool([num,string])
#	print(conpl.write())
def test():
	import time,Optimizer
	milli = lambda: int(time.time() * 1000)
	print("LeafLang Compiler Testing")
	inp=input('>')
	global proc
	proc=Node.Processor()
	global compiler
	compiler=Processor()
	while inp != 'quit()':
		proc.clearbuf()
		ms=milli()
		res=proc.process(list(inp))
		ma=milli()
		# print(ma)
		md=ma-ms
		print("Syntax Parsed")
		print("used %d ms"%(md))
		ms=milli()
		opt=Optimizer.Optimizer()
		res=opt.optimise(res)
		ma=milli()
		md=ma-ms
		print(res)
		print("optimised code in %d ms"%(md))
		
		rb=compiler.process(res)
		print(rb)
		inp=input('>')
if __name__=='__main__':
	test()
	
