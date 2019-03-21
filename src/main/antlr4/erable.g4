grammar erable;
prog
  : (progo SPLIT)* 
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
  : string
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
  : minus_plus ((AND|OR|XOR|BAND|BOR|BXOR||NEQ|EQ|LTE|RTE||ULS|URS|LS|RS|LT|GT) minus_plus)*
  ;
minus_plus
  : mul_div ((ADD|SUB) mul_div)*
  ;
mul_div
  : change ((MUL|DIV) change)*
  ;
change
  : dot (EQU dot)*
  ;
dot
  : field_and_types (DOT field)*
  ;
atom
  : LPA progo? RPA
  | (ADD|SUB)? unsigned_num
  ;
string
  : STRING
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
  : (BNOT|RETURN) progo
  ;

var
  : modifiers=var_ids declarations=var_kv
  ;
var_kv
  : var_pair+
  ;
var_pair
  : key=NAME (EQU val=progo)?
  ;
var_ids
  : VAR_ID+
  ;
funccall
  : funcname=NAME LPA arguments+=progo*? RPA
  ;
args
  : COLON LPA NAME* RPA
  ;
codeblock
  : LCB block=prog? RCB
  ;
funcdecl
  : FUNC funcname=NAME arguments=args block=progo
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
  : NAME
  ;
ADD      : '+'                             ;
SUB      : '-'                             ;
MUL      : '*'                             ;
DIV      : '/'                             ;
//not used:POW
POW      : '**'                            ;
EQ       : '=='                            ;
NEQ      : '!='                            ;
EQU      : '='                             ;
//Less/Greater than(or Equal to), (unsigned) Left/Right Shift
ULS      : '<<<'                           ;
URS      : '>>>'                           ;
LTE      : '<='                            ;
GTE      : '>='                            ;
LS       : '<<'                            ;
RS       : '>>'                            ;
AND      : '&&'                            ;
OR       : '||'                            ;
XOR      : '^^'                            ;
LT       : '<'                             ;
GT       : '>'                             ;
COLON    : ':'                             ;
SPLIT    : ';'                             ;
DOT      : '.'                             ;
COMMA    : ','                             ;
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
