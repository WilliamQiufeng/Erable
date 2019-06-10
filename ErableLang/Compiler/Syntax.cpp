//
// Created by Qiufeng54321 on 2019-06-09.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include <iostream>
#include "Syntax.hpp"

void Erable::Compiler::Syntax::initSyntaxes() {
    auto &&atomic = "atomic"_Rule - (
            "INT"_TokenSymbol
            | "HEX"_TokenSymbol
            | "BIN"_TokenSymbol
            | "OCT"_TokenSymbol
            | "DOUBLE"_TokenSymbol
    );
    auto &&var = "var"_Rule - (
            ("VAR"_TokenSymbol | "CONST"_TokenSymbol)
            + "NAME"_TokenSymbol
            + "SET"_TokenSymbol
            + "op"_RuleRef
    );
    auto &&binaryOp = "binaryOp"_Rule - (
            ("op"_RuleSymbol + ("ADD"_TokenSymbol | "SUB"_TokenSymbol) + "op"_RuleRef)
            | ("op"_RuleSymbol + ("MUL"_TokenSymbol | "DIV"_TokenSymbol | "MOD"_TokenSymbol) + "op"_RuleRef)
            | ("op"_RuleSymbol +
               ("LEFT_SHIFT"_TokenSymbol | "RIGHT_SHIFT"_TokenSymbol | "UNSIGNED_RIGHT_SHIFT"_TokenSymbol) +
               "op"_RuleRef)
            | ("op"_RuleSymbol + ("BIT_AND"_TokenSymbol | "BIT_OR"_TokenSymbol) + "op"_RuleRef)
            | ("op"_RuleSymbol + ("AND"_TokenSymbol | "OR"_TokenSymbol) + "op"_RuleRef)
    );
    syntaxTree.push_back(std::move(atomic));
    syntaxTree.push_back(std::move(var));
    syntaxTree.push_back(std::move(binaryOp));
}
