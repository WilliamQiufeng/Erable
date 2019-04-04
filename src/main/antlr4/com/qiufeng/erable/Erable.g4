grammar Erable;
@header{
  import java.util.*;
  import com.qiufeng.erable.*;
  import com.qiufeng.erable.ast.*;
}
@members{
    
}
prog
  : (ops SPLIT)* EOF?
  ;

decls
  returns [Object obj,int id]
  : fd=funcdecl
  | v=var
  ;
condexprs
  returns [Object obj,int id]
  : ic=ifcond
  | wc=whilecond
  ;
field_and_types
  returns [Object obj,int id]
  : tps=types
  | val=field
  ;
types
  returns [Object obj,int id]
  : arr=array
  | str=string
  | ato=num
  | objv=object
  ;
field
  returns [Object obj,int id]
  : fc=funccall
  | val=name
  ;
var
  returns [Object obj,int id,short mod]
  : modifiers+=VAR_ID+ declarations+=kvs
  ;
kvs
  :  (key=NAME (EQU val=ops)?)+
  ;
string
  returns [Object obj,int id]
  : ANYMATCH
  ;
ops
  returns [Object obj,int id,String type]
  : //l=ops DOT (funccall|NAME)                    {$type="dot";}
    l=ops ALPA pdo=ops ARPA                      {$type="element";}
  | <assoc=right> l=ops operation=POW r=ops                {$type="pow";}
  | l=ops operation=(EQU|ADDEQ|SUBEQ|MULEQ|DIVEQ|MODEQ) r=ops                              {$type="change";}
  | l=ops operation=(MOD|DIV|MUL|SUB|ADD|BINOPS) r=ops                 {$type="binop";}
  | operation=(UNARYOPS|ADD|SUB) r=ops           {$type="unary";}
  | LPA p=ops RPA                                {$type="bracket";}
  | field_and_types                              {$type="instance";}
  | decls                                        {$type="decls";}
  | condexprs                                    {$type="conds";}
  | codeblock                                    {$type="block";}
  ;
sblock
  : codeblock
  ;
sops
  : ops
  ;
oops
  returns [int id]
  : ops
  ;
array
  returns [Object obj,int id,List<Integer> arr]
  : ALPA elements+=ops* ARPA
  ;
num
  returns [Object obj,int id]
  : '0x' HEX
  | '0b' BIN
  | '0o' OCT
  | INT (DOT INT)?
  ;
object
  returns [Object obj, int id]
  : COLON pairs COLON
  ;
pairs
  : pair*
  ;
pair
  : key=oops EQU val=oops
  ;
funccall
  returns [Object obj,int id]
  : funcname=name LPA arguments+=ops*? RPA
  ;
args
  returns [ArrayList<FPADCode> arguments]
  : COLON LPA argss+=NAME* RPA
  ;

codeblock
  returns [Object obj,int id]
  : LCB block=prog RCB
  ;
funcdecl
  returns [Object obj,int id]
  : FUNC funcname=NAME arguments=args block=codeblock
  ;
ifcond
  returns [Object obj,int id]
  : IF LPA cond=ops RPA ido=sops
    elses+=elsecond*
  ;
elsecond
  : ELSE edo=ops
  ;
whilecond
  returns [Object obj,int id]
  : WHILE LPA cond=ops RPA pdo=sblock
  ;
name
  returns [Object obj,int id]
  : NAME
  ;



ANYMATCH : '"' (ESC|.)*? '"'            ;
UNARYOPS : REF|GREF|BNOT|RETURN|BREAK               ;
//BINOPS
BINOPS   : BAND|BOR|BXOR|NEQ|EQ|SWITCH|ULS|URS|LTE|GTE|LS|RS|LT|GT   ;

POW               : '**'                   ;


//Less/Greater than(or Equal to), (unsigned) Left/Right Shift
fragment ULS      : '<<<'                           ;
fragment URS      : '>>>'                           ;
fragment SWITCH   : '<=>'                           ;
fragment LTE      : '<='                            ;
fragment GTE      : '>='                            ;
fragment LS       : '<<'                            ;
fragment RS       : '>>'                            ;
ADDEQ    : '+='                            ;
SUBEQ    : '-='                            ;
MULEQ    : '*='                            ;
DIVEQ    : '/='                            ;
MODEQ    : '%='                            ;
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
EQU               : '='                             ;


//Bit Operation
fragment BAND     : '&'                             ;
fragment BOR      : '|'                             ;
fragment BXOR     : '^'                             ;
BNOT              : '!'                             ;

//Variable Operation
fragment REF      : '@'                             ;
fragment GREF     : '#'                             ;


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
