grammar erable;
prog
  : (progo SPLIT)* 
  ;
progo
  : funcdecl
  | ops
  | var
  | codeblock
  ;
exprs
  : field_and_types
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
  : minus_plus
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
var
  : modifiers=var_ids decls=var_kv
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
  : NAME LPA arguments+=progo*? RPA
  ;
args
  : COLON LPA NAME* RPA
  ;
codeblock
  : LCB prog? RCB
  ;
funcdecl
  : FUNC NAME args codeblock
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
EQU      : '='                             ;
COLON    : ':'                             ;
SPLIT    : ';'                             ;
DOT      : '.'                             ;
COMMA    : ','                             ;
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
//function first
FUNC     : 'function'                      ;
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
