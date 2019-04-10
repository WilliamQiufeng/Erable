# Hello World!

**Congratulations**! You have installed *Erable*!

The first thing of learning ***Erable*** is to **Print 'Hello World'**!

The file is already in the current folder(`Chapter 1/`), so:

Compile and run:

```bash
cd erable #replace erable to the repository cloned
# -s        : print the code serialised but human-readable
# -d        : debug information output
# -f [FILE] : input file to be compiled
# -q        : quiet. No outputs
./erable.sh -d output.log -s -f "tutorial/Chapter 1/HelloWorld.erable"
```

Now open `output.log`, you will see this:

```
Parsed file tutorial/Chapter 1/HelloWorld.erable
Parsed file stdlib/ios.erable
File stdlib/ios.erable finished.Total time:14 ms.
File tutorial/Chapter 1/HelloWorld.erable finished.Total time:399 ms.
ConstantPoolElement{id=0, obj=0.0}
ConstantPoolElement{id=1, obj=1.0}
ConstantPoolElement{id=2, obj=stdlib/ios}
ConstantPoolElement{id=3, obj=java.lang.System#out#println}
ConstantPoolElement{id=4, obj=com.qiufeng.erable.stdlib.InputScanner#input}
ConstantPoolElement{id=5, obj=Hello World!}
>#0 :
-->@1  buffer 1 to @1

-->%true : variable `0` true = @1 ->2

-->@3  buffer 0 to @3

-->%false : variable `0` false = @3 ->4

-->@5  buffer 2 to @5

-->@7  buffer 3 to @7

-->%println : function println[id=6 name=object] ->8 : native 7

-->@9  buffer 4 to @9

-->%input : function input[] ->10 : native 9

-->@11  buffer 5 to @11

-->@12  println@8[11] ->12


Starting Compiler...
__TEMP @1  buffer 1 to @1____
[38, 0, 0, 0, 1, 0, 0, 0, 1]
[37, 0, 0, 0, 1, 0, 0, 0, 2]
__TEMP @3  buffer 0 to @3____
[38, 0, 0, 0, 0, 0, 0, 0, 3]
[37, 0, 0, 0, 3, 0, 0, 0, 4]
__TEMP @5  buffer 2 to @5____
[38, 0, 0, 0, 2, 0, 0, 0, 5]
__TEMP @7  buffer 3 to @7____
[38, 0, 0, 0, 3, 0, 0, 0, 7]
___NATIVE_FUNCDECL___%println : function println[id=6 name=object] ->8 : native 7
[69, 0, 0, 0, 8, 0, 0, 0, 7]
___ARG_PUSH___id=6 name=object
[40, 0, 0, 0, 6]
___END %println : function println[id=6 name=object] ->8 : native 7 ___
__TEMP @9  buffer 4 to @9____
[38, 0, 0, 0, 4, 0, 0, 0, 9]
___NATIVE_FUNCDECL___%input : function input[] ->10 : native 9
[69, 0, 0, 0, 10, 0, 0, 0, 9]
___END %input : function input[] ->10 : native 9 ___
__TEMP @11  buffer 5 to @11____
[38, 0, 0, 0, 5, 0, 0, 0, 11]
__CALL_PREPARE @12  println@8[11] ->12__
____PUSH_ARG 11____
[47, 0, 0, 0, 11]
__CALL @12  println@8[11] ->12__
[48, 0, 0, 0, 8, 0, 0, 0, 12]

```

These are the debug informations, to show what happened during compilation.

>  Well, I haven't created a vm yet…… so, currently, you can't run an erable executable yet.

