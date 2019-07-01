//
// Created by Qiufeng54321 on 2019-06-09.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_SYNTAX_HPP
#define ERABLECOMPILER_SYNTAX_HPP

#include <vector>

#include "Headers.hpp"
#include "Old_Symbols.hpp"

namespace Erable::Compiler::Syntax {
	inline Symbols::SymbolPtr syntaxTree;

	void initSyntaxes();
}

#endif //ERABLECOMPILER_SYNTAX_HPP
