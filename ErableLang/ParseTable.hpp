//
// Created by Qiufeng54321 on 2019-07-02.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_PARSETABLE_HPP
#define ERABLELANG_PARSETABLE_HPP

#include <ostream>
#include "Headers.hpp"

namespace Erable::Compiler::Parser {
	inline int INcount = 0;

	struct IterationNode {
		int iterationIndex;
		std::vector<Symbols::SymbolPtr> symbols;

		friend std::ostream &operator<<(std::ostream &os, const IterationNode &node);
	};

	class RuleIteration {
	public:
		int currentIndex = 0;
		IterationNode *rootNode;

		void shiftDot(IterationNode *);

		Symbols::SymbolPtr find(Symbols::SymbolPtr);

		Symbols::SymbolPtr findMatch(Symbols::SymbolPtr);

		void generate();

		void generateOneRound(IterationNode *);

		void generateFirstRound();

		void recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol);

	protected:
		Symbols::SymbolPtr _find(IterationNode *node, Symbols::SymbolPtr symbolPtr, bool matchDotAndLookahead);

		void _generate(IterationNode *);

		void _expandRule(IterationNode *node, Symbols::RuleSymbolPtr &symbol);

		void _expandContainer(IterationNode *node, Symbols::RuleContainerPtr &symbol);
	};
}

#endif //ERABLELANG_PARSETABLE_HPP
