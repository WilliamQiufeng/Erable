//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_PARSER_HPP
#define ERABLECOMPILER_PARSER_HPP

#include <vector>
#include <string>
#include "Syntax.hpp"

namespace Erable::Compiler {
    class Parser {
    public:
        Parser();

        Syntax::SyntaxList available;


    };
}

#endif //ERABLECOMPILER_PARSER_HPP
