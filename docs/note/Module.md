# 模块 Module

​        模块分为静态和动态两种。静态模块将模块的代码编译后直接放入需要使用模块的代码中。动态模块使用`.dynec`文件进行导入。

​        Modules are either `static` or `dynamic`. When importing `Static Modules`, the compiler compiles the module and put it in the consumer directly. `Dynamic Modules` need to be imported by a `.dynec` file.

## 动态模块

​        如果要编译一个`.erable`文件为动态模块，需要在编译时加入**`-dyn`**选项。此选项会生成一个`.dynec`文件，格式为**Java Properties**。其中包含了此模块中定义的变量和函数（我称它为名称id表）：

​        If you want to compile an `.erable` file, you need to add a  **`-dyn`**  option to the command line. This option makes the compiler generate a `.dynec` file in **Java Properties** format including the variables and functions declared in the module.

```erable
var a=0;//text in .dynec: "a=[ID of a]"
function b:(){//text in .dynec: "b=[ID of b]"
    var c="hi~";//WIll not be included in .dynec
};
```

​        此`.dynec`文件中还包含了一个名叫**`@maxid`**的属性，此属性是在早期实现时产生的，现已停用。

​        The `.dynec` file also contains a property named **`@maxid`**, which was added when the dynamic module was first introduced. Now this property is **DEPRECATED**.

​        要引入动态模块，加入以下代码：

​        To import a dynamic module:

```erable
dynload "xx.ec" with "xx.dynec" as xx;
```

​        其中，`"xx.ec"`代表了要引入的模块，`"xx.dynec"`为加载的名称id表，`xx`为模块名。

​        In this case, `"xx.ec"` represents the modules which needs to be imported, `"xx.dynec"` represents the name table, and `"xx"` represents the module name.

​        使用`动态模块`的函数实例：

​        Example of using `Dynamic Modules`:

```erable
dynload "stdlib/java.ec" with "stdlib/java.dynec" as java;//Load Dynamic module 'java'
java->java_new("java.lang.String",["abc"]);//call java_new in module 'java' with args
```

