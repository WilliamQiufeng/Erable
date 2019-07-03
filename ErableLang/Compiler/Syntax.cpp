//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Syntax.hpp"
#include "Symbols.hpp"
#include <iostream>
#include <sstream>

namespace Erable::Compiler::Syntax {

	void initSyntax() {
		auto A = "A"_rule;
		auto S = "S"_rule;
		auto SS = "S'"_rule;
		SS - Symbols::SymbolList{
				S
		};
		S - Symbols::SymbolList{
				A + A
		};
		A - Symbols::SymbolList{
				"a"_token + A,
				"b"_token
		};
	}

	std::string $syntaxListToString() {
		std::stringstream ss;
		for (auto &item : syntaxList) {
			ss << item->getTag() << " -> ";
			Symbols::CombineSymbolPtr combineSymbolPtr = std::static_pointer_cast<Symbols::CombineSymbol>(item);
			ss << combineSymbolPtr->toString() << "\n";
		}
		return ss.str();
	}

	Symbols::SymbolList $find(std::string tag) {
		Symbols::SymbolList symbolList;
		for (auto &item : syntaxList) {
			if (item->getTag() == tag) {
				symbolList.push_back(item);
			}
		}
		return symbolList;
	}
}