//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Parser.hpp"

Erable::Compiler::Parser::Parser(Erable::Compiler::TokenList &inputTokens) : inputTokens(inputTokens) {}

Erable::Compiler::Parser::Parser(Erable::Compiler::Parser *parent, Erable::Compiler::TokenList &inputTokens)
        : parent(parent), inputTokens(inputTokens) {}

Erable::Compiler::Data::ProcessedData Erable::Compiler::Parser::read() {
    if (this->forwardData.isNull) {
        auto tkn(this->inputTokens.front());
        this->inputTokens.erase(inputTokens.begin());
        return Erable::Compiler::Data::ProcessedData(tkn);
    } else {
        auto forward(this->forwardData);
        this->forwardData = Erable::Compiler::Data::ProcessedData();
        return forward;
    }
}

Erable::Compiler::Data::ProcessedData Erable::Compiler::Parser::forward() {
    return this->forwardData = read();
}

bool Erable::Compiler::Parser::isSubparser() {
    return parent != nullptr;
}
