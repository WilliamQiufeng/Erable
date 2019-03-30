grammar Erable;
@header{
  import java.util.*;
  //import com.qiufeng.erable.*;
  //import com.qiufeng.erable.ast.*;
}
@members{
    
}
prog
  : (progo SPLIT)* EOF?
  ;
progo
  : decls
  | condexprs
  | ops
  | codeblock
  ;
exprs
  : fat=field_and_types
  ;
decls
  : fd=funcdecl
  | v=var
  ;
condexprs
  : ic=ifcond
  | wc=whilecond
  ;
field_and_types
  : val=field
  | tps=types
  ;
types
  : arr=array
  | str=string
  | ato=atom
  ;
field
  : fc=funccall
  | val=name
  ;
var
  : modifiers=var_ids declarations=var_kv
  ;
var_kv
  : var_pair+
  ;
var_pair
  : key=name (EQU val=progo)?
  ;

ops
  : l=ops DOT f=field
  | l=ops ALPA pdo=progo ARPA
  | <assoc=right> l=ops POW r=ops
  | l=ops EQU r=ops
  | l=ops MOD r=ops
  | l=ops DIV r=ops
  | l=ops MUL r=ops
  | l=ops SUB r=ops
  | l=ops ADD r=ops
  | l=ops operation=BINOPS r=ops
  | operation=(UNARYOPS|ADD|SUB) r=ops
  | field_and_types
  ;
atom
  : LPA p=progo RPA
  | num=unsigned_num
  ;
string
  : '"' str=anymatch '"'
  ;
anymatch
  : (ESC|.)*?
  ;
array
  : ALPA elements+=progo* ARPA
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


var_ids
  : VAR_ID+
  ;
funccall
  : funcname=name LPA arguments+=progo*? RPA
  ;
args
  : COLON LPA argss+=name* RPA
  ;
codeblock
  : LCB block=prog RCB
  ;
funcdecl
  : FUNC funcname=name arguments=args block=codeblock
  ;
ifcond
  : IF LPA cond=progo RPA ido=progo
    (ELSE edo=progo)*
  ;
whilecond
  : WHILE LPA cond=progo RPA pdo=progo
  ;
name
  : NAME
  ;



EQU               : '='                             ;
UNARYOPS : BNOT|RETURN|BREAK                        ;
//BINOPS
BINOPS   : OR|XOR|BAND|BOR|BXOR|ADDEQ|SUBEQ|MULEQ|DIVEQ|MODEQ|NEQ|EQ|SWITCH|ULS|URS|LTE|GTE|LS|RS|LT|GT   ;

POW               : '**'                   ;

//Less/Greater than(or Equal to), (unsigned) Left/Right Shift
fragment ULS      : '<<<'                           ;
fragment URS      : '>>>'                           ;
fragment SWITCH   : '<=>'                           ;
fragment LTE      : '<='                            ;
fragment GTE      : '>='                            ;
fragment LS       : '<<'                            ;
fragment RS       : '>>'                            ;
fragment AND      : '&&'                            ;
fragment OR       : '||'                            ;
fragment XOR      : '^^'                            ;
fragment ADDEQ    : '+='                            ;
fragment SUBEQ    : '-='                            ;
fragment MULEQ    : '*='                            ;
fragment DIVEQ    : '/='                            ;
fragment MODEQ    : '%='                            ;
fragment EQ       : '=='                            ;
fragment NEQ      : '!='                            ;
fragment LT       : '<'                             ;
fragment GT       : '>'                             ;
COLON             : ':'                             ;
SPLIT             : ';'                             ;
DOT               : '.'                             ;
COMMA             : ','                             ;
ADD               : '+'                             ;
SUB               : '-'                             ;
MUL               : '*'                             ;
DIV               : '/'                             ;
MOD               : '%'                             ;


//Bit Operation
fragment BAND     : '&'                             ;
fragment BOR      : '|'                             ;
fragment BXOR     : '^'                             ;
BNOT              : '!'                             ;




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
fragment DIGITS   : [0-9]                  ;

//integers behind to prevent conflict
INT      : [0-9]+                          ;
BIN      : [01]+                           ;
OCT      : [0-8]+                          ;
HEX      : [0-9a-fA-F]+                    ;
HEXD     : [0-9a-fA-F]                    ;
ESC      : '\\' ([\\bfnrt"]|UNICODE)       ;
UNICODE  : [uU] HEXD HEXD HEXD HEXD            ;
WS       : [ \t\n\r]+ -> skip              ;
