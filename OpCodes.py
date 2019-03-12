# Every Usage starts with the opcode(index of it in array 'opcodes'),so we ignore them and just write usage after opcode.

# CPEI:constant pool element id				(4 bytes)
# uid:uniqe id during runtime 				(4 bytes)
# bid:buffer id								(4 bytes)
# WAU:will add a uid
# WAB:will add a bid

opcodes=[
#   Name     Description                            Usage                           Action
	"exit" , # byte 0 is to exit																	
	"conpl", # constant pool tag																	
	"reg"  , # register a variable					bid								WAU				
	"name" , # set name								bid												
	#_____________________________________________________________________________________
	#												var | buffer
	#_____________________________________________________________________________________
	
	"set"  , # set a variable's value				uid + bid
	"loadu", # load a variable's value to buffer	uid + bid
	"let"  , # make var see-able in current scope	uid
	"const", # make variable constant				uid
	"ref"  , # make variable be a reference			uid
	"class", # make buffer a class					bid								WAU
	"goto" , # goto an id as a scope				uid
	"func" , # make buffer a function				uid								WAU
	"args" , # declare numbers of arguments			2 bytes
	"len"  , # declare length of next buffer value	8 bytes
	#_____________________________________________________________________________________
	#												Conpl| targ buffer id
	#_____________________________________________________________________________________
	
	"buf"  , # store a value to buffer				CPEI + bid						WAB
	
	#_____________________________________________________________________________________
	#												a   | b   | targ buffer id
	#_____________________________________________________________________________________
	
	"add"  , # add two values						bid + bid + bid					WAB
	"sub"  , # substract two values					bid + bid + bid					WAB
	"mul"  , # multiply two values					bid + bid + bid					WAB
	"div"  , # divide two values					bid + bid + bid					WAB
	"mod"  , # mod two values						bid + bid + bid					WAB
	"dot"  , # dot field							bid + bid + bid					WAB
	"new"  , # new									bid + bid						WAB
	"delu" , # delete unique values					uid
	"delb" , # delete buffer values					bid
]
tags=[
	"num"  , # number
	"str"  , # string
]
def getOp(key):
	return opcodes.index(key)
def getTag(key):
	return tags.index(key)
