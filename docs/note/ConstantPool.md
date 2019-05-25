# 常量池

## 继承关系

> ConstantPool
>
> > Code



> ConstantPoolString & ConstantPoolNumber
>
> > ConstantPoolElement
> >
> > > Code

## 详解

&emsp;&emsp;常量池存储着源文件中显式定义的数值和字符串。每个常量池元素都有一个自己的id。此id与`Code`类的`currentId`字段不冲突。

&emsp;&emsp;例如：

```erable
var a=1+2;
var b="a"+"ab";
```

​        在此例中，常量`1`, `2`, `"a"`, `"ab"`将会被储存。当调用一个元素时，将会使用`OpCode.LOADC`指令加载：

```asm
LOADC 0 1
```

​        此命令将会把元素0加载到`Temp 1`中。