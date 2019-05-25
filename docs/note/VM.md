# VM

```flow

e=>end: End
in=>inputoutput: Input Compiled Program
inb=>operation: Input one byte
cps=>condition: Constant Pool?
in_cpele=>inputoutput: Read ContantPool
scopes=>condition: Scope?
func=>condition: Function Declare?
skip=>operation: set skip

in->inb
inb->cps
cps(yes)->in_cpele
cps(no,left)->scopes
scopes(yes)->inb
scopes(no,right)->func
func(yes)->skip
skip->inb
func(no,left)->inb

```



