//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_TOKENS_HPP
#define ERABLELANG_TOKENS_HPP


#include <Utils.h>
#include "Lexer.hpp"

namespace Erable::Compiler {
    class TokenElement{
        Lexer* lexer;
    public:
        virtual bool consume(char);
        virtual void clear();
    };
    class Tokens {
        Utils::Enum<TokenElement*> vals;
    public:
        void setLexer(Lexer* lexer);
    };
}


#endif //ERABLELANG_TOKENS_HPP
