# Erable<sup>TM</sup> Virtual Machine Operation Codes Specification

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



| OpCode          | Parameters | Result ID |
| --------------- | ---------- | --------- |
| `CONSTANT_POOL` | 0          | -1        |


> Description



> Usage



---

| OpCode   | Parameters | Result ID |
| -------- | ---------- | --------- |
| `CP_NUM` | 0          | -1        |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `CP_INT` | 0 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `CP_STR` | 0 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `ADD` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `SUB` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `MUL` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `DIV` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `MOD` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `POW` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `COND` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `ELEMENT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `LS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `RS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `URS` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `LT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `GT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `LTE` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `GTE` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `EQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `NEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `EQU` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `SWITCH` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BNOT` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BAND` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BOR` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BXOR` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `ADDEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `SUBEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `MULEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `DIVEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `MODEQ` | 3 | 2 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `PUSH_SCOPE` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `POP_SCOPE` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `REF` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `GREF` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `RETURN` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BREAK` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `COPY` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `LOADC` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `FUNCTION` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `ARRAY` | 1 | 0 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `PUSH_ELEMENT` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `CALL` | 2 | 1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `IF` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `ELSE` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `WHILE` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `END` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `BREAKIF` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `JUMPIF` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `OBJECT` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `PAIR` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `TRY` | 2 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `NATIVE_FUNCDECL` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `LOAD_LIB` | 1 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `DYN_LOAD` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `DYNCALL` | 3 | -1 |


> Description



> Usage



---

| OpCode | Parameters | Result ID |
| --- | --- | --- |
| `EXIT` | 0 | -1 |

> Description



> Usage



---

