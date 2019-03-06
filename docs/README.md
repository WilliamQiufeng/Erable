---
layout: post
title: "LeafLang"
date: 2019-03-01
excerpt: "A Programming Language created by myself"
tags: [project,language]
comments: true
---

# LeafLang

I have been working on this since two weaks ago.  

This is still under development, so it might be unstable.Please report bugs or request new features to me!  

## How to use

### Requirements

+ Python 3 or later

run this in your terminal:  

```bash
cd LeafLang-compiler
python3 Node.py
```

You will get something like this:  

```
LeafLang Testing
>
```

Thats it! For now it will just parse the code and prints the serialized **Code Data**.I will keep developing this!

## Syntax

### Basic Types

#### String

```
"string literal"
```

#### Integer

`0-9` and `a-f`  is used for digits.  

`t,o,p,x` is used to change radix.

```
0xat1
```

##### Steps

+ input 0,and changed to radix 16.  

+ 0*16+10(a)=10
+ input is `t` ,change to radix 2
+ 10*2+1=21
+ returns the result 21

#### Array

```
[expr1,expr2,exr3,...]
```

returns a list of exprs.

### Variable Declaration

| Identifiers | Usage                                                 |
| ----------- | ----------------------------------------------------- |
| var         | make this variable global                             |
| let         | make this variable declared only in the current scope |
| changeable  | this variable can be changed                          |
| const       | cannot change the value of the variable               |
| obj         | this variable stores a value                          |
| ref         | this variable stores a reference to another value     |

```
[Identifiers]+ Name [= Expr]
```

### Function Call

calls a function.

```
func(expr1,expr2,expr3,...)
```

### Function Declaration

declare a function.

```
function [Name function_name] : (arg1,arg2,arg3,...) [CodeBlock do]
function [Name function_name] [CodeBlock do]
function : (arg1,arg2,arg3,...) [CodeBlock do]
function : (arg1,arg2,arg3,...)
function [CodeBlock do]
```

If `function name` is not declared,the name will be instead of `anonymous_func0`,`anonymous_func1`,etc.

### Binary Operations

| Operator     | Usage                         |
| ------------ | ----------------------------- |
| \.           | access the field              |
| \+,\-,\*,/,% | plus, minus,times,devide,mod  |
| <<,\>\>      | binary shifting               |
| <<<,>>>      | unsigned binary shifting      |
| <=>          | swap two values               |
| ==,!=,\>=,<= | conditions                    |
| =            | set the value of the variable |
| &,\|,^       | bit and,bit or,bit xor        |

```
[Expr] [Identifer] [Expr2]
```

### Unary Operations

| Operator | Usage                       |
| :------- | --------------------------- |
| !        | bit not                     |
| @        | gets the value by reference |
| #        | gets the reference by value |
| return   | return a value              |
| emit     | emit a signal               |
| delete   | delete a value              |

```
[Identifiers] [Expr]
```

### CodeBlocks

A group of codes.

```
{
    [Expr]*
}
(
	[Expr]*
)
```

If no return value is specified,the last expression will be evaluated and be set to the return value.



### If Expressions

```
(if|elif) [CodeBlock condition] [CodeBlock do]
else [CodeBlock do]
```

### Emit and Signals

Signals will be activated when it is emitted.   
It can be declared like this:  

```
signal(exprtag) [CodeBlock do]
```

Where expr tag is the key which emit can activate.  

Emit Expression:

```
emit exprtag
```

It activates the signal which is declared with the same exprtag.

### Loop Expressions

You can use `while` and `foreach` for looping.  

```
while [CodeBlock condition] [CodeBlock do]
```

`while` is activated until the condition returns false.

```
foreach [CodeBlock iterator] [CodeBlock do]
```

`foreach`iterates the iterator.

### With Expression

```
with [CodeBlock protect] [CodeBlock do]
```

`[CodeBlock protect]` must return a reference to variable.(Usage of reference of variable:`#variable_name`  )

```
with(a){
    do(a)
}
```

#### What It Does

+ It will first store the a's value to anonymous variable(in here we call it *backup*)
+ do things inside **[CodeBlock do]**
+ If exceptions happen,the protected value will be set back to *backup*.