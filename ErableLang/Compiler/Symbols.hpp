//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_SYMBOLS_HPP
#define ERABLELANG_SYMBOLS_HPP

#include "Headers.hpp"

namespace Erable::Compiler::Symbols {
	enum class SymbolType {
		RULE,
		TOKEN,
		COMBINATION
	};

	struct Symbol {
		std::string tag;
		Parser::IterationNode *connectedTo;
		int dotPosition = 0;
		//It doesn't show the list of lookaheads, but shows all  possible lookaheads that will call reduce.
		std::vector<TokenSymbolPtr> lookahead;

		explicit Symbol(std::string tag);

		virtual std::string getTag();

		virtual SymbolType getType() = 0;

		virtual SymbolPtr fullClone() = 0;

		SymbolPtr getFront(int);

		virtual SymbolPtr getFront(SymbolList &, int) = 0;

		virtual std::string toString() = 0;

		static SymbolPtr getFront(SymbolList &, int, SymbolPtr exp);
	};

	struct RuleSymbol : public Symbol {
		static int currentIndex;
		SymbolList rules;
		int ruleIndex = -1;

		RuleSymbol(const std::string &tag, SymbolList combination);

		RuleSymbol(const std::string &tag);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		SymbolPtr getFront(SymbolList &, int) override;

		[[deprecated]] std::string toString() override;
	};

	struct CombineSymbol : public Symbol {
		SymbolList list;

		CombineSymbol(SymbolList list);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		SymbolPtr getFront(SymbolList &list, int i) override;

		std::string toString() override;
	};

	struct TokenSymbol : public Symbol {

		explicit TokenSymbol(std::string tag);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		SymbolPtr getFront(SymbolList &list, int i) override;

		std::string toString() override;
	};
}


#endif //ERABLELANG_SYMBOLS_HPP
