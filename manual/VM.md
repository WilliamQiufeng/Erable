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
cps(no)->scopes
scopes(yes,right)->inb
scopes(no)->func
func(yes)->skip
skip->inb
```



