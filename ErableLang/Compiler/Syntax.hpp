//
// Created by Qiufeng54321 on 2019-06-09.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_SYNTAX_HPP
#define ERABLECOMPILER_SYNTAX_HPP

#include <vector>
#include "Symbols.hpp"

namespace Erable::Compiler::Syntax {
    typedef std::vector<Erable::Compiler::Symbols::SymbolPtr> SyntaxList;
    inline Symbols::SymbolPtr syntaxTree;

    void initSyntaxes();
}

#endif //ERABLECOMPILER_SYNTAX_HPP
