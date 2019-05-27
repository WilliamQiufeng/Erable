# Erable Virtual Machine Operation Codes Specification

---

> Erable Programming Language & Erable Virtual Machine &copy; Qiufeng 2019. All rights reserved.
>
> Specification Documentaion &copy; Tanpero 2019. All rights reserved.
>
> This specification document and its derivatives are Erable project.
>
> This specification document is a draft,
>
> ​    in its early development status,
>
> ​    may be based on the discussion to larger changes in the future.
>
> Version 1.0

---

### Format

The **OpCode Usage Format** is formed based on the following rules:

**指令码** 的形式需要遵循一下形式：

+ A tag of the OpCode 指令码标签名称
+ Following arguments 

The argument is formed:

```
[name:type]
```

The type has the following:

> id
>
> cid

If the type is custom (or has different byte lengths):

> [name:4 bytes] //'4 bytes' is replaceable

When showing a group of OpCodes, use:

```
...(description)
```

So it is formed like:

```
OpCodeName [arg1:id] [arg2:cid]
```

## Standard OpCode Document

### Constant Pool Related

| OpCode          | Parameters | Result ID Index |
| --------------- | ---------- | --------------- |
| `CONSTANT_POOL` | 0          | -1              |


> Description

To show the start of a constant pool.

> Usage

```
CONSTANT_POOL [length:cid] ...(List of elements)
```



---

| OpCode   | Parameters | Result ID Index |
| -------- | ---------- | --------------- |
| `CP_NUM` | 0          | -1              |

#### NOTE

This is special because it contains the real literal data, which means the parameter number is not just 0 but with 8 bytes after.


> Description

Declare a double value in a constant pool.

> Usage

```
CP_NUM [double:8 bytes]
```



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `CP_INT` | 0 | -1 |

#### NOTE

This is special because it contains the real literal data, which means the parameter number is not just 0 but with 4 bytes after.


> Description

Declare an integer value in a constant pool.

> Usage

```
CP_INT [int:4 bytes]
```



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `CP_STR` | 0 | -1 |

#### NOTE

This is special because it contains the real literal data, which means the parameter number is not just 0.


> Description

Declare a string value in a constant pool.

Adds a `\0` character after the string is recorded.

> Usage

```
CP_INT [length:4 bytes] ...(${length} bytes string)
```

--------

### Binary Operations

Binary Operations always follow the rules: The first two arguments are the two operands and the last one is the id the output redirects. The following operators are very clear to understand and the formats are the same.

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `ADD` | 3 | 2 |

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `SUB` | 3 | 2 |

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `MUL` | 3 | 2 |

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `DIV` | 3 | 2 |

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `MOD` | 3 | 2 |

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `POW` | 3 | 2 |

------



| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `COND` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `ELEMENT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `LS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `RS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `URS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `LT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `GT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `LTE` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `GTE` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `EQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `NEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `EQU` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `SWITCH` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BNOT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BAND` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BOR` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BXOR` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `ADDEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `SUBEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `MULEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `DIVEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `MODEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `PUSH_SCOPE` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `POP_SCOPE` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `REF` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `GREF` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `RETURN` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BREAK` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `COPY` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `LOADC` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `FUNCTION` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `ARRAY` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `PUSH_ELEMENT` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `CALL` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `IF` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `ELSE` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `WHILE` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `END` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `BREAKIF` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `JUMPIF` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `OBJECT` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `PAIR` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `TRY` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `NATIVE_FUNCDECL` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `LOAD_LIB` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `DYN_LOAD` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `DYNCALL` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `EXIT` | 0 | -1 |

> Description



> Usage



---

