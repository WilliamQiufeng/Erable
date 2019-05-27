//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_LEXER_HPP
#define ERABLELANG_LEXER_HPP

namespace Erable::Compiler {
    class Lexer;
}

#include <IO.hpp>
#include "Tokens.hpp"

namespace Erable::Compiler{
    class Lexer{
        int line, column;
        std::vector<TokenElement*> available;
        std::vector<Token> tokens;
        std::vector<char> forwards;
        IO::InputStream in;
    public:
        Lexer(IO::InputStream);
        char read();
        char forward();
        void readToken();
        void reset();
    };
}

#endif //ERABLELANG_LEXER_HPP
