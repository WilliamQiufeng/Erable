//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Syntax.hpp"
#include "Lexer/Symbols.hpp"
#include <iostream>
#include <sstream>

namespace Erable::Compiler::Syntax {


	void initAddMulOpSyntax() {
		auto S = "S"_rule;
		auto Op = "Op"_rule;
		auto Add = "Add"_rule;
		auto Mul = "Mul"_rule;
		auto Pow = "Pow"_rule;
		auto num = "NUMBER"_token;
		auto plus = "ADD"_token;
		auto minus = "SUB"_token;
		auto mul = "MUL"_token;
		auto div = "DIV"_token;
		auto pow = "POW"_token;
		S - Symbols::SymbolList{Op};
		Op - Symbols::SymbolList{
				Add/*,
			Mul*/
		};
		Add - Symbols::SymbolList{
				Add + plus + Mul,
				Add + minus + Mul,
				Mul
		};
		Mul - Symbols::SymbolList{
				Mul + mul + Pow,
				Mul + div + Pow,
				Pow
		};
		Pow - Symbols::SymbolList{
				num + pow + Pow,
				num
		};
	}

	void initAmbiguousSyntax() {
		auto SS = "S'"_rule;
		auto S = "S"_rule;
		auto A = "A"_token;
		SS - Symbols::SymbolList{S};
		S - Symbols::SymbolList{
				S + S,
				A
		};
	}

	void initSimpleSyntax() {
		auto SS = "S'"_rule;
		auto S = "S"_rule;
		auto A = "A"_rule;
		auto a = "a"_token;
		auto b = "b"_token;
		SS - Symbols::SymbolList{S};
		S - Symbols::SymbolList{
				A + A
		};
		A - Symbols::SymbolList{
				a + A,
				b
		};

	}

	void initWikipediaSyntax() {
		auto SS = "S'"_rule;
		auto S = "S"_rule;
		auto E = "E"_rule;
		auto T = "T"_rule;
		auto LP = "("_token;
		auto RP = ")"_token;
		auto PL = "+"_token;
		auto n = "n"_token;
		SS - Symbols::SymbolList{S};
		S - Symbols::SymbolList{E};
		E - Symbols::SymbolList{
				T,
				LP + E + RP
		};
		T - Symbols::SymbolList{
				n,
				PL + T,
				T + n
		};
	}

	void initTomitaGLRSyntax1() {
		auto SS = "S'"_rule;
		auto S = "S"_rule;
		auto T = "T"_rule;
		auto D = "D"_rule;
		auto a = "a"_token;
		auto b = "b"_token;

		SS - Symbols::SymbolList{S};
		S - Symbols::SymbolList{T + b};
		T - Symbols::SymbolList{
				T + b,
				D + T,
				a + b,
				a,
				b
		};
		D - Symbols::SymbolList{a, b};
	}

	void initSyntax() {
//		initSimpleSyntax();
//		initAmbiguousSyntax();
//		initAddMulOpSyntax();
		initWikipediaSyntax();
//		initTomitaGLRSyntax1();
	}

	std::string $syntaxListToString() {
		std::stringstream ss;
		for (auto &item : syntaxList) {
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