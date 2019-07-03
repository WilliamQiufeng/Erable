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
		auto SS = "S'"_rule;
		auto S = "S"_rule;
		/*auto Op = "Op"_rule;
		auto Add = "Add"_rule;
		auto Mul = "Mul"_rule;
		auto num = "NUMBER"_token;
		auto plus = "ADD"_token;
		auto minus = "SUB"_token;
		auto mul = "MUL"_token;
		auto div = "DIV"_token;
		S - Symbols::SymbolList{Op};
		Op - Symbols::SymbolList{
			Add,
			Mul
		};
		Add - Symbols::SymbolList{
			Add + plus + Mul,
			Add + minus + Mul,
			Mul
		};
		Mul - Symbols::SymbolList {
			Mul + mul + num,
			Mul + div + num,
			num
		};*/
		auto A = "A"_token;
		auto B = "B"_token;
		auto C = "C"_token;
		auto D = "D"_token;
		SS - Symbols::SymbolList{S};
		S - Symbols::SymbolList{
				A + B + C,
				A + B + D
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