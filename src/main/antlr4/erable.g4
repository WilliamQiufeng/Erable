grammar erable;
prog
  : (progo SPLIT)* EOF
  ;
progo
  : ops
  | var
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
  : (modifiers+=(VAR_SC|VAR_CG|VAR_TP))+? (var_name=NAME (EQU val=progo)?)+?
  ;

funccall
  : NAME LPA args+=progo*? RPA
  ;

name
  : NAME
  ;
ADD      : '+'                             ;
SUB      : '-'                             ;
MUL      : '*'                             ;
DIV      : '/'                             ;
POW      : '**'                            ;
EQU      : '='                             ;
SPLIT    : ';'                             ;
DOT      : '.'                             ;
COMMA    : ','                             ;
LPA      : '('                             ;
RPA      : ')'                             ;
INT      : [0-9]+                          ;
BIN      : [01]+                           ;
OCT      : [0-8]+                          ;
HEX      : [0-9a-fA-F]+                    ;
VAR_SC   : 'var'|'let'                     ;
VAR_CG   : 'const'|'changeable'            ;
VAR_TP   : 'obj'|'ref'                     ;
VAR_IDS  : (VAR_SC|VAR_CG|VAR_TP)+         ;
LETT     : [a-zA-Z_$]                      ;
NAME     : LETT (LETT|INT)*                ;
STRING   : '"' (ESC|.)*? '"'               ;
fragment ESC : '\\' ([\\bfnrt"]|UNICODE)   ;
UNICODE  : [uU] HEX HEX HEX HEX            ;
WS       : [ \t\n\r]+ -> skip              ;
