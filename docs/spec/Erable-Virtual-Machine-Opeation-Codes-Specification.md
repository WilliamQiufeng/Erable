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

------

## Definitions

+ ***ID***s are for referencing values
+ IDs which is from other modules are called ***Module ID*** below
+ ***AID***s are **ID**s which are either ***ID***s, ***CID***s, or ***Module ID***s

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

The suffix can be added if:

| type                              | suffix  |
| :-------------------------------- | ------- |
| The id/cid is from another module | -module |

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

### Byte form of ID

Every ID will be output by the following form:

```
[type:2 bytes] [id:unknown bytes]
```

The types are:

| type       | type bits | id length                                                    |
| ---------- | --------- | ------------------------------------------------------------ |
| ID         | 0b00      | 1, 2, or 4(determined by the total number of IDs)            |
| CID        | 0b01      | 1, 2, or 4(determined by the total number of IDs)            |
| Module ID  | 0b10      | 8 (with 4 bytes showing the module ID and 4 bytes showing the value ID) |
| Module CID | 0b11      | 8 (with 4 bytes showing the module ID and 4 bytes showing the value CID) |



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

Binary Operations always follow the rules:

+ Always have 3 parameters and the result ID index is always 2.
+ The first two arguments are the two operands and the last one is the id the output redirects.
+ Always do operations to the two operands and outputs to the ID.

The following operators are very clear to understand and the formats are the same.

| OpCode | Description |
| --- | --- |
| `ADD` | Basic mathematical operation |
| `SUB` | Basic mathematical operation |
| `MUL` | Basic mathematical operation |
| `DIV` | Basic mathematical operation |
| `MOD` | Basic mathematical operation |
| `ELEMENT` | Accesses an element from an object |
| `LS` | Left shifts an object |
| `RS` | Right shifts an object |
| `URS` | Right shifts an object but keeps the sign not moving |
| `LT` | Checks if the left operand is less than the right one |
| `EQ` | Checks if the two operands are the same |
| `EQU` | Sets the left operand's value to the right operand's value |
| `SWITCH` | Switches two operand's value |
| `BOR` | Does bit operation `or` |
| `BAND` | Does bit operation `and` |
| `BXOR` | Does bit operation `xor` |

```
OpCode [left : AID] [right : AID] [output : AID]
```



------



| OpCode | Parameters | Result ID Index |
| --- | --- | --- |
| `COND` | 2 | 1 |


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

