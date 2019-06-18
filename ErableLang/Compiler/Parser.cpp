//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Parser.hpp"

namespace Erable::Compiler {
    Parser::Parser(TokenList inputTokens) : inputTokens(inputTokens) {}

    Parser::Parser(Parser *parent, TokenList inputTokens)
            : parent(parent), inputTokens(inputTokens) {}

    Data::ProcessedData Parser::read() {
        if (this->forwardData.isNull) {
            auto tkn(this->inputTokens.front());
            this->inputTokens.erase(inputTokens.begin());
            return Data::ProcessedData(tkn);
        } else {
            auto forward(this->forwardData);
            this->forwardData = Data::ProcessedData();
            return forward;
        }
    }

    Data::ProcessedData Parser::forward() {
        return this->forwardData = read();
    }

    bool Parser::isSubparser() {
        return parent != nullptr;
    }

    /*
     *
     */
    Data::ProcessedData Parser::parseRule() {
        Data::DataList available;
        return Data::ProcessedData();
    }
}
