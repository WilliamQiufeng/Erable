grammar simperr;
var
  : VAR_IDS NAME EQU NAME SPLIT
  ;
VAR_IDS : ('var'|'let')+;
LETTER : [a-zA-Z$_];
NUM : [0-9];
NAME : LETTER (LETTER|NUM)*;
EQU : '=';
SPLIT : ';';
WS : [ \t\n\r]+ -> skip;
