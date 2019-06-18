# Erable Parser Specification

>  **Erable** Parser Specification shows how the parser (under `Erable::Compiler::`) works.

```flow

```

## Syntax

The syntax is under file `Syntax.cpp` which is very clear to see.



### Example

```
<op>:
	<int>
	<op> + <op>
	<op> - <op>
	<op> * <op>
	<op> / <op>
<int>:
	[0-9]+
```



**Input:**: `[<int 7> * <int 6> + <int 5> / <int 4>]`

1. > **Input**: `<int>`
   >
   > Matches `<op<int>>`
   >
   > push to rule list's back
   >
   > **Rule List**: `[<op<int>]`
   >
   > *Finished*
   >
   > > Detect if the forward token matches
   > >
   > > **None** -> **Really finished**
   >
   > **Now available**: `[<op[1-4]>]`

2. > **Input**: `*`
   >
   > Matches `<op[3]>`
   >
   > push
   >
   > **Rule List**: `[<op<int>>, <*>]`
   >
   > **Now available**: `[<op[3]>]`

3. > **Input**: `<int>`
   >
   > Matches `<op<int>>``
   >
   > push to rule list's back
   >
   > **Rule List**: `[<op<int>>, <*>,<op<int>]`
   >
   > *Finished*
   >
   > > Detect if the forward token matches
   > >
   > > **None** -> **Really Finished**
   >
   > **Rule List**: `<op[3]>`
   >
   > **Now available**: `[<op[1-4]>]`

4. > **Input**: `+`
   >
   > Matches `<op[1]>`
   >
   > push
   >
   > **Rule List**: `[<op[3]>, <+>]`
   >
   > **Now available**: `[<op[1]>]`