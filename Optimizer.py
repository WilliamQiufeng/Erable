import Node
class Optimizer:
	@classmethod
	def optimise(self,out):
		return out
def test():
	import time
	milli = lambda: int(time.time() * 1000)
	print("LeafLang Optimizer Testing")
	inp=input('>')
	global proc
	proc=Node.Processor()
	while inp != 'quit()':
		ms=milli()
		res=proc.process(list(inp))
		ma=milli()
		# print(ma)
		md=ma-ms
		print("Syntax Parsed")
		print("used %d ms"%(md))
		ms=milli()
		opt=Optimizer()
		res=opt.optimise(res)
		ma=milli()
		md=ma-ms
		print(res)
		print("optimised code in %d ms"%(md))
		
		inp=input('>')
if __name__=="__main__":
	test()
