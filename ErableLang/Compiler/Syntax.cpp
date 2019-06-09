//
// Created by Qiufeng54321 on 2019-06-09.
// Copyright (c) Qiufeng54321 All rights reserved.
//

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
            + "op"_RuleSymbol
    );
    auto &&binaryOp = "binaryOp"_Rule - (
            "op"_RuleSymbol + ("ADD"_TokenSymbol | "SUB"_TokenSymbol) + "op"_Rule
    );
    syntaxTree.push_back(std::move(atomic));
    syntaxTree.push_back(std::move(var));
}
