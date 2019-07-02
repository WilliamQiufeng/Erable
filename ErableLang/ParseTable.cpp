#include <utility>
#include <Syntax.hpp>
#include <iostream>

//
// Created by Qiufeng54321 on 2019-07-02.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "ParseTable.hpp"
#include "Symbols.hpp"

namespace Erable::Compiler::Parser {
	void RuleIteration::shiftDot(IterationNode *iterationNode) {
		for (auto &item : iterationNode->symbols) {
			item->dotPosition++;
		}
	}

	Symbols::SymbolPtr RuleIteration::find(Symbols::SymbolPtr symbolPtr) {
		return _find(rootNode, std::move(symbolPtr), false);
	}

	Symbols::SymbolPtr RuleIteration::findMatch(Symbols::SymbolPtr symbolPtr) {
		return _find(rootNode, std::move(symbolPtr), true);
	}

	Symbols::SymbolPtr
	RuleIteration::_find(IterationNode *node, Symbols::SymbolPtr symbolPtr, bool matchDotAndLookahead) {
		for (auto &item : node->symbols) {
			if (item->is(symbolPtr)) {
				if (matchDotAndLookahead) {
					if (item->dotPosition != symbolPtr->dotPosition and
						item->lookahead != symbolPtr->lookahead)
						continue;
				}
				return item;
			}
			if (item->connectedTo) return _find(item->connectedTo, symbolPtr, matchDotAndLookahead);
		}
		return nullptr;
	}

	void RuleIteration::generate() {
		generateFirstRound();
		_generate(rootNode);
	}

	void RuleIteration::_generate(IterationNode *node) {
		generateOneRound(node);
		for (auto &item : node->symbols) {
			if (item->connectedTo) {
				generateOneRound(item->connectedTo);
			}
		}
	}

	void RuleIteration::generateFirstRound() {
		//Clone the root rule
		auto clone = Syntax::root->fullClone();
		//set lookahead
		//auto dulplicateBuffer = Symbols::SymbolList{};
		clone->lookahead = clone->getFront();
		//Initialize the root node
		rootNode = new IterationNode{this->currentIndex++, {clone}};
		//Recursively expand the node/rule
		recursiveExpandRule(rootNode, clone);
		rootNode->symbols.erase(rootNode->symbols.begin());
	}

	void RuleIteration::generateOneRound(IterationNode *node) {
		//For each symbol in the parent node
		for (auto &item : node->symbols) {

			if (item->getType() == Symbols::SymbolType::CONTAINER) {
				//cast the symbol to a rule container
				Symbols::RuleContainerPtr ruleContainer = std::static_pointer_cast<Symbols::RuleContainer>(item);
				//If the rule container's dot position reached its end
				if (ruleContainer->container.size() <= item->dotPosition) {
					continue;
				}
			} else if (item->getType() == Symbols::SymbolType::RULE) {
				//cast the symbol to a rule
				Symbols::RuleSymbolPtr ruleContainer = std::static_pointer_cast<Symbols::RuleSymbol>(item);
				//If the rule container's dot position reached its end
				if (ruleContainer->combination->list.size() <= item->dotPosition) {
					continue;
				}
			} else {
				throw std::runtime_error(
						"CLR(1) Parse Table Error: the symbol must be a rule container or a rule in an iteration node");
			}
			//Create a clone for the symbol
			auto clone = item->fullClone();
			//Set the dot position to the parent's dot position
			clone->dotPosition = item->dotPosition;
			//Increase the dot position
			clone->shiftDot();
			//Lookahead doesn't change!!
			clone->lookahead = item->lookahead;
			//If there is a duplicate symbol
			auto found = findMatch(clone);
			if (found) {
				//Connect them
				clone->connectedToSymbol = found;
			} else {
				//Create a child node
				auto *newNode = new IterationNode{this->currentIndex++, {clone}};
				if (newNode->iterationIndex == 2) {

				}
				recursiveExpandRule(newNode, clone);
				//Connect the node
				item->connectedTo = newNode;
			}
		}
	}

	void RuleIteration::recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol) {
		if (symbol->getType() == Symbols::SymbolType::CONTAINER) {
			//cast the symbol to a rule container
			Symbols::RuleContainerPtr ruleContainer = std::static_pointer_cast<Symbols::RuleContainer>(symbol);
			_expandContainer(node, ruleContainer);
		} else if (symbol->getType() == Symbols::SymbolType::RULE) {
			//cast the symbol to a rule container
			Symbols::RuleSymbolPtr ruleContainer = std::static_pointer_cast<Symbols::RuleSymbol>(symbol);
			_expandRule(node, ruleContainer);
		}
	}

	void RuleIteration::_expandRule(IterationNode *node, Symbols::RuleSymbolPtr &symbol) {
		if (symbol->combination->list.size() > symbol->dotPosition) {
			//Set current symbol
			auto &currentSymbol = symbol->combination->list[symbol->dotPosition];
			if (node->iterationIndex == 2) {

			}
			if (currentSymbol->getType() != Symbols::SymbolType::RULE and
				currentSymbol->getType() != Symbols::SymbolType::CONTAINER)
				return;
			//Clone the whole container
			auto clone = currentSymbol->fullClone();
			//set lookahead
			auto duplicateBuffer = Symbols::SymbolList{};
			bool buf = true;
			clone->lookahead = symbol->getFront(duplicateBuffer, buf);
			/*//push the container to the back of the node
			node->symbols.push_back(clone);*/
			//Expand it recursively
			recursiveExpandRule(node, clone);
		}
	}

	void RuleIteration::_expandContainer(IterationNode *node, Symbols::RuleContainerPtr &symbol) {
		if (node->iterationIndex == 2) {

		}
		//For each rule in the container
		for (auto &item : symbol->container) {
			auto clone = item->fullClone();
			//set lookahead
			auto duplicateBuffer = Symbols::SymbolList{};
			bool buf = true;
			clone->lookahead = symbol->getFront(duplicateBuffer, buf);
			node->symbols.push_back(clone);
			_expandRule(node, item);
		}
	}

	std::ostream &operator<<(std::ostream &os, const IterationNode &node) {
		os << "I" << node.iterationIndex << ": ";
		for (auto &item : node.symbols) {
			os << "[" << item->getTag() << " -> ";
			if (item->connectedTo)os << "I" << item->connectedTo->iterationIndex;
			else if (item->connectedToSymbol)os << "R" << item->connectedToSymbol->getTag();
			else os << "None";
			/*INcount--;
			os << "\n";
			for(int i = 0; i<INcount-1; i++) {
				os << "\t";
			}*/
			os << ", (";
			for (auto &tkn : item->lookahead) {
				os << tkn->getTag() << " ";
			}
			os << ")]";
		}
		os << "\n";
		for (auto &item : node.symbols) {
			if (item->connectedTo)os << (*item->connectedTo) << std::endl;
		}
		return os;
	}
}
