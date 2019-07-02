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
		COMBINATION,
		RULEREF,
		CONTAINER
	};

	struct Symbol {
	public:
		std::string tag;
		Parser::IterationNode *connectedTo = nullptr;
		SymbolPtr connectedToSymbol = nullptr;
		int dotPosition = 0;
		//It doesn't show the list of lookaheads, but shows all  possible lookaheads that will call reduce.
		TokenSymbolList lookahead;

		explicit Symbol(std::string tag);

		virtual std::string getTag();

		virtual SymbolType getType() = 0;

		virtual SymbolPtr fullClone() = 0;

		virtual void shiftDot();

		TokenSymbolList getFront();

		virtual TokenSymbolList getFront(SymbolList &, bool &incDot) = 0;

		virtual std::string toString() = 0;

		virtual bool is(SymbolPtr that) = 0;

		static TokenSymbolList getFront(SymbolList &, SymbolPtr exp, bool &incDot);
	};

	struct RuleSymbol : public Symbol {
		static int currentIndex;
		CombineSymbolPtr combination;
		int ruleIndex = -1;

		RuleSymbol(const std::string &tag, CombineSymbolPtr combination);

		RuleSymbol(const std::string &tag);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		TokenSymbolList getFront(SymbolList &, bool &incDot) override;

		std::string toString() override;

		void shiftDot() override;

		bool is(SymbolPtr that) override;
	};

	struct RuleRefSymbol : public Symbol {
		SymbolPtr rule;

		RuleRefSymbol(const std::string &tag, SymbolPtr rule);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		TokenSymbolList getFront(SymbolList &list, bool &incDot) override;

		std::string toString() override;

		bool is(SymbolPtr that) override;
	};

	struct RuleContainer : public Symbol {
		typedef std::vector<RuleSymbolPtr> Container;
		Container container;

		RuleContainer(const std::string &tag, const Container &container);

		void shiftDot() override;

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		TokenSymbolList getFront(SymbolList &list, bool &incDot) override;

		std::string toString() override;

		bool is(SymbolPtr that) override;
	};

	struct CombineSymbol : public Symbol {
		SymbolList list;

		CombineSymbol(SymbolList list);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		TokenSymbolList getFront(SymbolList &list, bool &incDot) override;

		std::string toString() override;

		bool is(SymbolPtr that) override;
	};

	struct TokenSymbol : public Symbol {

		explicit TokenSymbol(std::string tag);

		SymbolType getType() override;

		SymbolPtr fullClone() override;

		TokenSymbolList getFront(SymbolList &list, bool &incDot) override;

		std::string toString() override;

		bool is(SymbolPtr that) override;
	};

	inline TokenSymbolPtr EOT = std::make_shared<TokenSymbol>("$EOT");
}


#endif //ERABLELANG_SYMBOLS_HPP
