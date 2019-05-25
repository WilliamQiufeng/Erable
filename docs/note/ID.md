# ID

​        *ID*分为两种：`ID`与`CID`。ID指向运行时的缓存，CID指向常量池元素。

​        ID与CID是绝对且独立的。为每条语句会分一个ID，为每个常量池元素会分配一个CID。

​        为了节省编译后文件的大小，ID与CID的长度取决于最大ID值。

| Max ID(<=n)         | Length |
| ------------------- | ------ |
| `Byte.MAX_VALUE`    | 1      |
| `Short.MAX_VALUE`   | 2      |
| `Integer.MAX_VALUE` | 4      |

​        当ID/CID超出了`Integer.MAX_VALUE`，将无法编译成功。

