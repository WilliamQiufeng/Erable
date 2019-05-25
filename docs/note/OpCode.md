# 指令

​        每条Erable源文件中的代码都会被转换成指令码。

​        指令码遵循以下格式：

```
[OpCode 1B] [ARG]*
```

​        指令码开头必须写入一字节自己字节码编号（`OpCode#ordinal`)，然后写入n个参数（参数数量已经被定义在`OpCode.java`当中。）。

​        `LOADC`指令特殊，`LOADC`指令的第一个参数为常量池id，长度有可能与其他id长度不同（详解见<a href="ID.md">ID.md</a>）

