//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_LEXER_HPP
#define ERABLELANG_LEXER_HPP

namespace Erable::Compiler {
    class Lexer;
}

#include "Tokens.hpp"
#include <fstream>

namespace Erable::Compiler{
    class Lexer{
        int line, column;
        std::vector<TokenElement*> available;
        std::vector<Token> tokens;
        std::vector<char> forwards;
        std::ifstream in;
    public:
        Lexer(std::string);
        char read();
        char forward();
        void readToken();
        void reset();

        void clearWS();

        void lex();

        int getLine() const;

        void setLine(int line);

        int getColumn() const;

        void setColumn(int column);

        const std::vector<TokenElement *> &getAvailable() const;

        void setAvailable(const std::vector<TokenElement *> &available);

        const std::vector<Token> &getTokens() const;

        void setTokens(const std::vector<Token> &tokens);

        const std::vector<char> &getForwards() const;

        void setForwards(const std::vector<char> &forwards);
    };
}

#endif //ERABLELANG_LEXER_HPP