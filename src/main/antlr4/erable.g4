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
  returns [int retid]
  : (progo SPLIT)*
  {
    if(root==current){
      root.printTree();
      $retid=-1;
    }
  } 
  ;
progo
  returns [int retid]
  : decls
  {
    $retid=$decls.retid;
  }

  | condexprs
  {
    $retid=$condexprs.retid;
  }

  | ops
  {
    $retid=$ops.retid;
  }

  | codeblock
  {
    $retid=$codeblock.retid;
  }

  ;
exprs
  returns [int retid]
  : fat=field_and_types
    {
      $retid=$fat.retid;
    }
  ;
decls
  returns [int retid]
  : fd=funcdecl
    {
      $retid=$fd.retid;
    }
  | v=var
    {
      $retid=$v.retid;
    }
  ;
condexprs
  returns [int retid]
  : ic=ifcond
    {
      $retid=$ic.retid;
    }
  | whilecond
  ;
field_and_types
  returns [int retid]
  : val=field
  {
    $retid=$val.retid;
  }
  | tps=types
  {
    $retid=$tps.retid;
  }
  ;
types
  returns [int retid]
  : arr=array
  {
    $retid=$arr.retid;
  }
  | str=string
  {
    $retid=$str.retid;
  }
  | ato=atom
  {
    $retid=$ato.retid;
  }
  ;
field
  returns [int retid]
  : fc=funccall
  {
    $retid=$fc.retid;
  }
  | val=name
  {
    $retid=$val.retid;
  }
  ;
ops
  returns [int retid]
  : uo=unary_op
    {
      $retid=$uo.retid;
    }
  | bo=binary_op
    {
      $retid=$bo.retid;
    }
  ;
var
  returns [int retid]
  : modifiers=var_ids declarations=var_kv
    {
      $retid=-1;
    }
  ;
var_kv
  : var_pair+
  ;
var_pair
  @init {boolean hasVal=true;}
  : key=name (EQU val=progo {hasVal=true;})? {if(!hasVal)$val.retid=-1;}
  {
    current.declareVariable($key.retid,$val.retid);
    System.out.println("------variable declared:"+$key.text);
  }
  ;
unary_op
  returns [int retid]
  : operation=UNARYOPS pdo=progo?
    {
      UnaryOpCode uoc=new UnaryOpCode($operation.text,$pdo.retid);
      current.addCode(uoc);
      $retid=uoc.id;
    }
  ;
binary_op
  returns [int retid]
  : l=binary_op DOT f=field
    {
      DotCode dc=new DotCode($l.retid,$f.retid);
      $retid=dc.id;
      current.addCode(dc);
    }
  | l=binary_op ALPA pdo=progo ARPA
    {
      ArrayElementCode aec=new ArrayElementCode($l.retid,$pdo.retid);
      $retid=aec.id;
      current.addCode(aec);
    }
  | <assoc=right> l=binary_op POW r=binary_op
    {
      BinaryOpCode boc=new BinaryOpCode($operation.text,$l.retid,$r.retid);
      current.addCode(boc);
      $retid=boc.id;
    }
  | l=binary_op operation=(BINOPS|EQU) r=binary_op
    {
      BinaryOpCode boc=new BinaryOpCode($operation.text,$l.retid,$r.retid);
      current.addCode(boc);
      $retid=boc.id;
    }
  | value=field_and_types
    {
      $retid=$value.retid;
    }
  ;

atom
  returns [int retid]
  : LPA p=progo RPA
    {
      $retid=$p.retid;
    }
  | num=unsigned_num
  {
     int idr=-1;
     String text=$num.text;
     double number=Double.parseDouble(text);
     idr=current.addObject(number);
     $retid=current.temp(idr);
     System.out.println("------ID for number'"+number+"' is:"+idr+"------");
  }

  ;
string
  returns [int retid]
  : '"' str=anymatch '"'
    {
      int idr=-1;
      idr=current.addObject($str.text);
      $retid=current.temp(idr);
      System.out.println("------ID for name'"+$str.text+"' is:"+idr+"------");
    }
  ;
anymatch
  : (ESC|.)*?
  ;
array
  returns [int retid]
  : ALPA elements+=progo* ARPA
    {
      int[] retids={};
      for(ProgoContext tk : $elements){
        retids=ArrayUtils.push(retids,tk.retid);
      }
      ArrayCode ac=new ArrayCode(retids);
      current.addCode(ac);
      $retid=ac.id;
    }
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
  returns [int retid]
  : funcname=name LPA arguments+=progo*? RPA
  {
    int[] retids={};
    for(ProgoContext tk : $arguments){
      retids=ArrayUtils.push(retids,tk.retid);
    }
    FuncCallCode fc=new FuncCallCode($funcname.retid,retids);
    current.addCode(fc);
    $retid=fc.id;
  }
  ;
args
  returns [int[] argids]
  : COLON LPA argss+=name* RPA
    {
      int[] retids={};
      for(NameContext tk : $argss){
        retids=ArrayUtils.push(retids,tk.retid);
      }
      $argids=retids;
    }
  ;
codeblock
  returns [int retid]
  : LCB {current=current.createChild(Scope.Type.CODEBLOCK);} block=prog RCB
  {
    BlockCode bc=new BlockCode(current);
    $retid=bc.id;
    current.getParent().addCode(bc);
    current=current.getParent();
  }
  ;
funcdecl
  returns [int retid]
  : FUNC funcname=name arguments=args {
      current=current.createChild(Scope.Type.FUNCTION);
      int nul=current.temp(current.findId("null"));
      for(int ids : $arguments.argids){
	current.declareVariable(ids,nul,true);
      }
    } block=progo
  {
    $retid=current.getParent().declareFunction(
      $funcname.retid,
      $arguments.argids,
      current);
    current=current.getParent();
    System.out.println("------function declared:"+$funcname.text);
  }
  ;
ifcond
  returns [int retid]
  @init {
    Scope sif;
    Scope[] elses={};
  }
  : IF LPA cond=progo RPA {current=current.createChild(Scope.Type.IF);} ido=progo {
      sif=current;current=current.getParent();
    }
    (ELSE {current=current.createChild(Scope.Type.IF);} edo=progo {
      elses=ArrayUtils.push(elses,current);
      current=current.getParent();
    })*
    {
      IfCode ic=new IfCode($cond.retid,sif,elses);
      current.addCode(ic);
      $retid=ic.id;
    } 
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
     $retid=current.temp(idr);
     System.out.println("------ID for name'"+$NAME.text+"' is:"+idr+"------");
  }

  ;



EQU               : '='                             ;
UNARYOPS : BNOT|RETURN|BREAK|ADD|SUB                ;
//BINOPS
BINOPS   : DOT|POW|MOD|DIV|MUL|SUB|ADD|AND|OR|XOR|BAND|BOR|BXOR|ADDEQ|SUBEQ|MULEQ|DIVEQ|MODEQ|NEQ|EQ|SWITCH|ULS|URS|LTE|GTE|LS|RS|LT|GT   ;

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
fragment MUL      : '*'                             ;
fragment DIV      : '/'                             ;
fragment MOD      : '%'                             ;


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
ESC      : '\\' ([\\bfnrt"]|UNICODE)       ;
UNICODE  : [uU] HEX HEX HEX HEX            ;
WS       : [ \t\n\r]+ -> skip              ;
