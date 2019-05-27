//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_LEXER_HPP
#define ERABLELANG_LEXER_HPP

#include <IO.hpp>

namespace Erable::Compiler{
    class Lexer{
        int line, column;
    public:
        Lexer(IO::InputStream);
        char read();
    };
}

#endif //ERABLELANG_LEXER_HPP
