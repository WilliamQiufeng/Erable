grammar erable;
@header{
  import java.util.*;
  import com.qiufeng.erable.*;
  import com.qiufeng.erable.ast.*;
}
@members{
  Scope root=new Scope(null,Scope.Type.CODEBLOCK);
  Scope current=root;
}
prog
  : (progo SPLIT)*
  {
    root.printTree();
  } 
  ;
progo
  : decls
  | condexprs
  | ops
  | codeblock
  ;
exprs
  : field_and_types
  ;
decls
  : funcdecl
  | var
  ;
condexprs
  : ifcond
  | whilecond
  ;
field_and_types
  : field
  | types
  ;
types
  : array
  | string
  | atom
  ;
field
  : funccall
  | name
  ;
ops
  : binary_op
  | unary_op
  ;
binary_op
  : binary_op DOT field
  | binary_op ALPA progo ARPA
  | binary_op EQU binary_op
  | <assoc=right> binary_op POW binary_op
  | binary_op MOD binary_op
  | binary_op DIV binary_op
  | binary_op MUL binary_op
  | binary_op SUB binary_op
  | binary_op ADD binary_op
  | binary_op 
	operation=(AND|OR|XOR|BAND|BOR|BXOR|ADDEQ|SUBEQ|MULEQ|DIVEQ|MODEQ|NEQ|EQ|SWITCH|ULS|URS|LTE|GTE|LS|RS|LT|GT) binary_op
  | field_and_types
  ;

atom
  returns [int retid]
  : LPA progo? RPA
  | num=pos_neg_num
  {
     int idr=-1;
     String text=$num.text;
     double number=Double.parseDouble(text);
     idr=current.addObject(number);
     $retid=idr;
     System.out.println("------ID for number'"+number+"' is:"+idr+"------");
  }

  ;
pos_neg_num
  : (ADD|SUB)? unsigned_num
  ;
string
  : STRING
  ;
array
  : ALPA progo* ARPA
  ;
unsigned_num
  : unsigned_int 
  | unsigned_float
  
  ;
unsigned_int
  : '0x' HEX
  | '0b' BIN
  | '0o' OCT
  | INT
  ;
unsigned_float
  : INT DOT INT
  ;
unary_op
  : operation=(BNOT|RETURN) progo
  ;

var
  : modifiers=var_ids declarations=var_kv
  ;
var_kv
  : var_pair+
  ;
var_pair
  : key=name {current=current.createChild(Scope.Type.VARIABLE);} (EQU val=progo)?
  {
    current.getParent().declareVariable($key.retid,current);
    current=current.getParent();
    System.out.println("------variable declared:"+$key.text);
  }
  ;
var_ids
  : VAR_ID+
  ;
funccall
  : funcname=name LPA arguments+=progo*? RPA
  ;
args
  : COLON LPA name* RPA
  ;
codeblock
  : LCB block=prog RCB
  ;
funcdecl
  : FUNC funcname=name arguments=args {current=current.createChild(Scope.Type.FUNCTION);} block=progo
  {
    current.getParent().declareFunction($funcname.retid,current);
    current=current.getParent();
    System.out.println("------function declared:"+$funcname.text);
  }
  ;
ifcond
  : IF LPA progo? RPA progo
    (ELIF LPA progo? RPA progo)*
    (ELSE progo)?
  ;
whilecond
  : WHILE LPA progo? RPA progo
  ;
name
  returns [int retid]
  : NAME
  {
     int idr=-1;
     idr=current.addObject($NAME.text);
     $retid=idr;
     System.out.println("------ID for name'"+$NAME.text+"' is:"+idr+"------");
  }

  ;

//not used:POW
POW      : '**'                            ;

//Less/Greater than(or Equal to), (unsigned) Left/Right Shift
ULS      : '<<<'                           ;
URS      : '>>>'                           ;
SWITCH   : '<=>'                           ;
LTE      : '<='                            ;
GTE      : '>='                            ;
LS       : '<<'                            ;
RS       : '>>'                            ;
AND      : '&&'                            ;
OR       : '||'                            ;
XOR      : '^^'                            ;
ADDEQ    : '+='                            ;
SUBEQ    : '-='                            ;
MULEQ    : '*='                            ;
DIVEQ    : '/='                            ;
MODEQ    : '%='                            ;
EQ       : '=='                            ;
NEQ      : '!='                            ;
EQU      : '='                             ;
LT       : '<'                             ;
GT       : '>'                             ;
COLON    : ':'                             ;
SPLIT    : ';'                             ;
DOT      : '.'                             ;
COMMA    : ','                             ;
ADD      : '+'                             ;
SUB      : '-'                             ;
MUL      : '*'                             ;
DIV      : '/'                             ;
MOD      : '%'                             ;

//Bit Operation
BAND     : '&'                             ;
BOR      : '|'                             ;
BXOR     : '^'                             ;
BNOT     : '!'                             ;

//Parenthesis
LPA      : '('                             ;
RPA      : ')'                             ;

//CodeBlock tokens
LCB      : '{'                             ;
RCB      : '}'                             ;

//Array Parenthesis
ALPA     : '['                             ;
ARPA     : ']'                             ;

//Variable Identifiers
fragment VAR_SC   : 'var'|'let'            ;
fragment VAR_CG   : 'const'|'changeable'   ;
fragment VAR_TP   : 'obj'|'ref'            ;
VAR_ID   : VAR_SC|VAR_CG|VAR_TP            ;

//identifiers first
FUNC     : 'function'                      ;
WHILE    : 'while'                         ;
IF       : 'if'                            ;
ELIF     : 'elif'                          ;
ELSE     : 'else'                          ;
RETURN   : 'return'                        ;
BREAK    : 'break'                         ;

//name then
NAME     : LETT (LETT|DIGITS)*             ;
fragment LETT     : [a-zA-Z_$]             ;
STRING   : '"' (ESC|.)*? '"'               ;
fragment DIGITS   : [0-9]                  ;

//integers behind to prevent conflict
INT      : [0-9]+                          ;
BIN      : [01]+                           ;
OCT      : [0-8]+                          ;
HEX      : [0-9a-fA-F]+                    ;
fragment ESC : '\\' ([\\bfnrt"]|UNICODE)   ;
UNICODE  : [uU] HEX HEX HEX HEX            ;
WS       : [ \t\n\r]+ -> skip              ;
