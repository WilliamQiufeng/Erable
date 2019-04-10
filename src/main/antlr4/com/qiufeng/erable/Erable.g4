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
  | te=try_expr
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
  | thi=this_expression
  | par=parent_expression
  ;
field
  returns [Object obj,int id]
  : val=name
  ;
exprs
  : imp_module
  | load_native
  | native_funcdecl
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
  | funcname=ops LPA arguments=sep_ops RPA     {$type="funccall";}
  | LPA p=ops RPA                                {$type="bracket";}
  | modacc                                       {$type="modacc";}                    
  | field_and_types                              {$type="instance";}
  | decls                                        {$type="decls";}
  | condexprs                                    {$type="conds";}
  | codeblock                                    {$type="block";}
  | exprs                                        {$type="exprs";}
  | dynload                                      {$type="dynload";}
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
modacc
  returns [Object obj, int id]
  : mod=NAME MOD_ACC tar=NAME
  ;

array
  returns [Object obj,int id,List<Integer> arr]
  : ALPA elements=sep_ops ARPA
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
  | funcdecl
  | native_funcdecl
  ;
this_expression
  returns [Object obj,int id]
  : THIS
  ;
parent_expression
  returns [Object obj,int id]
  : PARENT
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
dynload
  : DYN_LOAD dyn=string WITH table=string AS mod=NAME
  ;
/*
   Load a native lib (.jar or .dex) for native functions
*/
load_native
  : LOAD lib=string
  ;
//Load a function from native library(.jar or .dex)
//for example:
//  native function println(obj) using "java.lang.System#out#println" in std/ios 
native_funcdecl
  returns [Object obj, int id]
  : NATIVE FUNC funcname=NAME arguments=args USING method=string
  ;
try_expr
  returns [Object obj,int id]
  : TRY tdo=ops catch_expr (FINALLY fin=ops)?
  ;
catch_expr
  : CATCH cn=NAME cdo=ops
  ;
imp_module
  returns [Object obj,int id]
  : USE mod=string
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
  : WHILE LPA cond=ops RPA pdo=sops
  ;
name
  returns [Object obj,int id]
  : NAME
  ;
sep_ops
  : ops? (COMMA ops)*
  ;

ANYMATCH : '"' (ESC|.)*? '"'            ;
UNARYOPS : REF|GREF|BNOT|RETURN|BREAK|THROW               ;
//BINOPS
BINOPS   : BAND|BOR|BXOR|NEQ|EQ|SWITCH|ULS|URS|LTE|GTE|LS|RS|LT|GT   ;

POW               : '**'                   ;
LINE_COMMENT      : '//' .*? '\n' -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

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
MOD_ACC  : '->'                            ;
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
TRY      : 'try'                           ;
CATCH    : 'catch'                         ;
FINALLY  : 'finally'                       ;
THROW    : 'throw'                         ;
NATIVE   : 'native'                        ;
USE      : 'use'                           ;
USING    : 'using'                         ;
LOAD     : 'load'                          ;
DYN_LOAD : 'dynload'                       ;
AS       : 'as'                            ;
WITH     : 'with'                          ;
THIS     : 'this'                          ;
PARENT   : 'parent'                        ;

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
