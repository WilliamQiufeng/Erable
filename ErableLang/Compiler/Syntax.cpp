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
            "DEC"_TokenSymbol
            | "HEX"_TokenSymbol
            | "BIN"_TokenSymbol
            | "OCT"_TokenSymbol
            | "DOUBLE"_TokenSymbol
    );
    auto &&string = "string"_Rule - (
            "STRING"_TokenSymbol
    );
    auto &&list = "list"_Rule - (
            "op"_RuleSymbol
            | ("list"_RuleSymbol + "COMMA"_TokenSymbol + "op"_RuleRef)
    );
    auto &&array = "array"_Rule - (
            ("LEFT_ARR"_TokenSymbol + "RIGHT_ARR"_TokenSymbol)
            | ("LEFT_ARR"_TokenSymbol + std::move(list) + "RIGHT_ARR"_TokenSymbol)
    );
    auto &&literals = "literals"_Rule - (
            std::move(typeName)
            | std::move(atomic)
            | std::move(string)
            | std::move(array)
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
    auto &&bracket = "bracket"_Rule - (
            "LEFT_PAREN"_TokenSymbol + "op"_RuleRef + "RIGHT_PAREN"_TokenSymbol
    );

    auto &&operations = "operations"_Rule - (
            std::move(binaryOp)
            | std::move(unaryOp)
            | std::move(bracket)
    );
    auto &&ifstmt = "ifstmt"_Rule - (
            ("IF"_TokenSymbol + "LEFT_PAREN"_TokenSymbol + "op"_RuleRef + "RIGHT_PAREN"_TokenSymbol + "op"_RuleRef)
            | "ifstmt"_RuleSymbol + "ELSE"_TokenSymbol + "op"_RuleRef
    );
    auto &&whilestmt = "whilestmt"_Rule - (
            ("WHILE"_TokenSymbol + "LEFT_PAREN"_TokenSymbol + "op"_RuleRef + "RIGHT_PAREN"_TokenSymbol + "op"_RuleRef)
    );
    auto &&statements = "statements"_Rule - (
            std::move(ifstmt)
            | std::move(whilestmt)
            | std::move(var)
    );

    auto &&op = "op"_Rule - (
            std::move(operations)
            | std::move(statements)
            | std::move(literals)
    );
    syntaxTree = std::move(op);
}
