//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_PARSER_HPP
#define ERABLECOMPILER_PARSER_HPP

#include <vector>
#include <string>
#include "Syntax.hpp"
#include "ProcessedData.hpp"

namespace Erable::Compiler {
    class Parser {
        Parser *parent = nullptr;
    public:
        explicit Parser(Erable::Compiler::TokenList inputTokens);

        Parser(Erable::Compiler::Parser *parent, Erable::Compiler::TokenList inputTokens);


        TokenList inputTokens;

        Data::DataList dataList;

        Data::ProcessedData forwardData;

        Data::ProcessedData read();

        Data::ProcessedData forward();

        Data::ProcessedData parseRule();

        bool isSubparser();
    };
}

#endif //ERABLECOMPILER_PARSER_HPP
