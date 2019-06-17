//
// Created by Qiufeng54321 on 2019-06-09.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include <iostream>
#include "Syntax.hpp"

void Erable::Compiler::Syntax::initSyntaxes() {
    auto &&typeName = "typeName"_Rule - (
            ("NAME"_TokenSymbol + ("DOT"_TokenSymbol | "ACCESS"_TokenSymbol) + "typeName"_RuleRef)
            | "NAME"_TokenSymbol
    );
    auto &&atomic = "atomic"_Rule - (
            "INT"_TokenSymbol
            | "HEX"_TokenSymbol
            | "BIN"_TokenSymbol
            | "OCT"_TokenSymbol
            | "DOUBLE"_TokenSymbol
    );
    auto &&var = "var"_Rule - (
            (("VAR"_TokenSymbol | "CONST"_TokenSymbol) << "identifier")
            + ("NAME"_TokenSymbol << "name")
            + "COLON"_TokenSymbol + ("typeName"_RuleRef << "type")
            + "SET"_TokenSymbol
            + ("op"_RuleRef << "value")
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
    auto &&unaryOp = "unaryOp"_Rule - (
            ("RETURN"_TokenSymbol | "BIT_NOT"_TokenSymbol | "NOT"_TokenSymbol | "REF"_TokenSymbol |
             "GET_REF"_TokenSymbol) + "op"_RuleSymbol
    );


    auto &&op = "op"_Rule - (
            std::move(binaryOp)
            | std::move(unaryOp)
            | std::move(atomic)
            | std::move(var)
            | std::move(typeName)
    );
    syntaxTree = std::move(op);
}
