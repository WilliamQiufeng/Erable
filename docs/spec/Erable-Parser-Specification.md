# Erable Parser Specification

>  **Erable** Parser Specification shows how the parser (under `Erable::Compiler::`) works.


## Syntax

There are two classes which define *Symbols*: `Erable::Compiler::Symbols::Symbol` and 
`Erable::Compiler::Symbols::CombineSymbol` (Only use the class name for short below).  
  
`Symbol` is the base class of `CombineSymbol` where `Symbol` ***declares***  **rules** or **tokens** and 
`CombineSymbol` ***defines*** the **rules**.  
  
When declaring a `Symbol`, ***DO NOT*** just construct it! It has its own constructing method using 
[user defined literal operator](https://en.cppreference.com/w/cpp/language/user_literal) `_token` and `_rule`, which
 both returns  `Erable::Compiler::Symbols::SymbolPtr (aka std::shared_ptr<Erable::Compiler::Symbols::Symbol>)`.  
  
  
`Erable::Compiler::Symbols::SymbolList (aka std::vector<Erable::Compiler::Symbols::SymbolPtr>)` can be used as 
Declaring multiple or single productions in one rule.  
Every symbols in the declaring term will be expanded and be added in `syntaxList` independently.  
In this example we will define rules like in [BNF](https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_form) :
```bnf
<root> ::= <paren> <paren> | <paren>
<paren> ::= "(" <root> ")" | "(" ")"
```  
**And** the corresponding syntax declaration code *can* be like this:  
```cpp
using namespace Erable::Compiler::Symbols;
SymbolPtr LPAREN = "("_token; // Declares a token named '('
auto RPAREN = ")"_token; //It is recommended to use 'auto'
auto rootRule = "root"_rule; // Declares a rule named 'root'
auto paren = "paren"_rule; // Declares a rule named 'paren'
rootRule - SymbolList {
    paren + paren, //Use '+' operator to combine the symbols to CombineSymbol
    paren //Every symbols in the list is one unique production but with the same identity as the rule
};
paren - SymbolList {
    LPAREN + rootRule + RPAREN,
    LPAREN + RPAREN
};
```
  
**Note** that all symbols in the list which is used to define a rule will be implicitly turned into 
`CombineSymbol`s.  
**Note** that rules that is ***defined*** first becomes the **root rule**.  
Here we defined rules properly and thus it can accept inputs like `(()())(((())()))` ~It's just like Lisp~.