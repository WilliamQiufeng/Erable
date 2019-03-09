# Every Usage starts with the opcode(index of it in array 'opcodes'),so we ignore them and just write usage after opcode.

# CPEI:constant pool element id				(4 bytes)
# uid:uniqe id during runtime 				(4 bytes)
# bid:buffer id								(4 bytes)
# WAU:will add a uid
# WAB:will add a bid

opcodes=[
#   Name     Description                            Usage                           Action
	"exit" , # byte 0 is to exit
	"reg"  , # register a variable													WAU
	"set"  , # set a variable's value				uid + bid
	"const", # make variable constant				uid
	"ref"  , # make variable be a reference			uid
	"var"  , # make variable variable (...what)		uid
	"class", # make buffer a class					bid								WAU
	"goto" , # goto an id as a scope				uid
	"func" , # make buffer a function				uid								WAU
	"args" , # declare numbers of arguments			2 bytes
	"len"  , # declare length of next buffer value	8 bytes
	"buf"  , # store a value to buffer				CPEI							WAB
	"add"  , # add two values						uid + uid						WAB
	"sub"  , # substract two values					uid + uid						WAB
	"mul"  , # multiply two values					uid + uid						WAB
	"div"  , # divide two values					usage: uid + uid				WAB
	"mod"  , # mod two values						usage: uid + uid				WAB
	"del"  , # delete values						usage: uid
]
