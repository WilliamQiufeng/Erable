//
// Created by Qiufeng54321 on 2019-07-02.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_PARSETABLE_HPP
#define ERABLELANG_PARSETABLE_HPP

#include <ostream>
#include "Headers.hpp"

namespace Erable::Compiler::Parser {
	inline std::unordered_set<IterationNode *> INDuplicateBuffer;
	struct IterationNode {
		int iterationIndex;
		std::vector<Symbols::SymbolPtr> symbols;


		std::string toString();
	};

	class RuleIteration {
	public:
		int currentIndex = -1;
		IterationNode *rootNode;

		/**
		 * Calls shiftDot on every symbol in the node
		 */
		void shiftDot(IterationNode *);

		/**
		 * Find the symbol which is equal to the other.
		 * @return Symbol found or $EOT
		 */
		Symbols::SymbolPtr find(Symbols::SymbolPtr);

		/**
		 * Find the symbol which is totally equal to the other.
		 * @return Symbol found or $EOT
		 */
		IterationNode *findMatch(Symbols::SymbolPtr);

		/**
		 * Entry function for generating the whole iteration.
		 * Will first call generateFirstRound and then calls _generate
		 */
		void generate();

		/**
		 * Only generate one round
		 */
		void generateOneRound(IterationNode *);

		/**
		 * Generate the first round for the Iteration(I0).
		 */
		void generateFirstRound();

		/**
		 * If the symbol followed by the dot is a rule, expand the rule and keep doing this.
		 * @param node
		 * @param symbol
		 */
		static void recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol);

		bool isFinished(IterationNode *node);

	protected:
		Symbols::SymbolPtr _find(IterationNode *node, Symbols::SymbolPtr symbolPtr, bool matchDotAndLookahead);

		IterationNode *_find(std::unordered_set<IterationNode *> &searched, IterationNode *node,
							 Symbols::SymbolPtr symbolPtr);

		void _generate(std::unordered_set<IterationNode *> &duplicateBuffer, IterationNode *);

	};
}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::IterationNode *node);

#endif //ERABLELANG_PARSETABLE_HPP
