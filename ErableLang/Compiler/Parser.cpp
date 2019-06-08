//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Parser.hpp"

Erable::Compiler::Parser::Parser() {
    symbols = {
            "atomic"_Rule - "INT"_TokenSymbol
            | "HEX"_TokenSymbol
            | "BIN"_TokenSymbol
            | "OCT"_TokenSymbol
            | "DOUBLE"_TokenSymbol
    };
}
