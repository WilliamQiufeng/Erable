//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_SYNTAX_HPP
#define ERABLELANG_SYNTAX_HPP

#include "Headers.hpp"

namespace Erable::Compiler::Syntax {
	inline Symbols::SymbolList syntaxList;

	std::string $syntaxListToString();

	Symbols::SymbolList $find(std::string tag);

	void initSyntax();
}

#endif //ERABLELANG_SYNTAX_HPP
