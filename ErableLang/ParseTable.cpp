#include <utility>
#include <Syntax.hpp>
#include <iostream>
#include <sstream>

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

	IterationNode *RuleIteration::findMatch(Symbols::SymbolPtr symbolPtr) {
		std::unordered_set<IterationNode *> buffer;
		return _find(buffer, rootNode, std::move(symbolPtr));
	}

	IterationNode *RuleIteration::_find(std::unordered_set<IterationNode *> &searched, IterationNode *node,
										Symbols::SymbolPtr symbolPtr) {
		for (auto &item : node->symbols) {
			if (item->is(symbolPtr)) {
				if (item->dotPosition == symbolPtr->dotPosition) {
					if (item->lookahead.size() != symbolPtr->lookahead.size())continue;
					auto beg = item->lookahead.begin();
					bool brk = false;
					for (auto &i : item->lookahead) {
						if (i->getTag() != (*beg)->getTag()) {
							brk = true;
							break;
						}
						beg++;
					}
					if (brk)continue;
					if (symbolPtr->uid != item->uid) {
						std::cout << item->toString() << " is " << symbolPtr->toString() << std::endl;
						return node;
					}
				}
			}
		}
		searched.insert(node);
		for (auto &item1 : node->symbols) {
			if (item1->connectedTo) {
				if (searched.find(item1->connectedTo) == searched.end()) {
					auto res = _find(searched, item1->connectedTo, symbolPtr);
					if (res)return res;
				}
			};
		}
		return nullptr;
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
				if (symbolPtr->uid != item->uid)
					return item;
			}
			if (item->connectedTo) return _find(item->connectedTo, symbolPtr, matchDotAndLookahead);
		}
		return nullptr;
	}

	void RuleIteration::generate() {
		generateFirstRound();
		std::unordered_set<IterationNode *> duplicateBuffer;
		_generate(duplicateBuffer, rootNode);
	}

	//TODO: 修改生成方式
	void RuleIteration::_generate(std::unordered_set<IterationNode *> &duplicateBuffer, IterationNode *node) {
		generateOneRound(node);
		for (auto &item : node->symbols) {
			if (item->connectedTo) {
				if (duplicateBuffer.find(item->connectedTo) == duplicateBuffer.end()) {
					duplicateBuffer.insert(item->connectedTo);
					_generate(duplicateBuffer, item->connectedTo);
				}
			}
		}
	}

	bool RuleIteration::isFinished(IterationNode *node) {
		return false;
	}

	void RuleIteration::generateFirstRound() {
		/*//Clone the root rule
		auto clone = Syntax::root->fullClone();
		//set lookahead
		//auto dulplicateBuffer = Symbols::SymbolList{};
		clone->lookahead = clone->getFront();
		//Initialize the root node
		rootNode = new IterationNode{this->currentIndex++, {clone}};
		//Recursively expand the node/rule
		recursiveExpandRule(rootNode, clone);
		rootNode->symbols.erase(rootNode->symbols.begin());*/
		if (Syntax::syntaxList.empty()) throw std::runtime_error("No input syntax given!!");
		//Always, the first syntax declared is the root
		auto &rootSyntax = Syntax::syntaxList[0];
		auto clone = rootSyntax->fullClone();
		//Set lookahead(always $EOT at start but whatever :P)
		clone->lookahead = clone->getFront();
		//Initialize the root node
		rootNode = new IterationNode{this->currentIndex++, {clone}};
		//Recursively expand the rule
		recursiveExpandRule(rootNode, clone);
	}

	void RuleIteration::generateOneRound(IterationNode *node) {

		//For each symbol in the parent node
		for (auto &item : node->symbols) {
			if (item->connectedTo) return;
			if (item->getType() == Symbols::SymbolType::COMBINATION) {
				auto casted = std::static_pointer_cast<Symbols::CombineSymbol>(item);
				if (casted->dotPosition >= casted->list.size()) continue;
				auto cloned = casted->fullClone();
				cloned->lookahead = casted->lookahead;
				cloned->dotPosition = casted->dotPosition;
				cloned->shiftDot();
				auto found = findMatch(cloned);
				if (found) {
					item->connectedTo = found;
					continue;
				}
				IterationNode *newNode = new IterationNode{this->currentIndex++, {cloned}};
				if (newNode->iterationIndex == 8) {

				}
				recursiveExpandRule(newNode, cloned);
				item->connectedTo = newNode;
			} else {
				throw std::runtime_error(
						"Iteration Error: unknown operation which caused non-combination in iteration");
			}
		}
//		std::cout << rootNode << std::endl;
//		std::cout << "------------------------------------------" << std::endl;
		/*//For each symbol in the parent node
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
		}*/
	}

	void RuleIteration::recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol) {
		/*if (symbol->getType() == Symbols::SymbolType::CONTAINER) {
			//cast the symbol to a rule container
			Symbols::RuleContainerPtr ruleContainer = std::static_pointer_cast<Symbols::RuleContainer>(symbol);
			_expandContainer(node, ruleContainer);
		} else if (symbol->getType() == Symbols::SymbolType::RULE) {
			//cast the symbol to a rule container
			Symbols::RuleSymbolPtr ruleContainer = std::static_pointer_cast<Symbols::RuleSymbol>(symbol);
			_expandRule(node, ruleContainer);
		}*/
		if (symbol->getType() == Symbols::SymbolType::COMBINATION) {
			//Cast the symbol
			auto combination = std::static_pointer_cast<Symbols::CombineSymbol>(symbol);
			//Check if the current symbol is not none
			if (combination->list.size() > combination->dotPosition) {
				//Check if the current symbol is a rule
				auto &get = combination->list[combination->dotPosition];
				if (get->getType() == Symbols::SymbolType::COMBINATION or get->getType() == Symbols::SymbolType::RULE) {
					auto found = Syntax::$find(get->getTag());
					Symbols::SymbolList cloneFound;
					for (auto &item : found) {
						auto cloned = item->fullClone();
						cloned->lookahead = combination->getFront();
						cloneFound.push_back(cloned);
					}
					node->symbols.insert(node->symbols.end(), cloneFound.begin(), cloneFound.end());
					for (auto &element : cloneFound) {
						recursiveExpandRule(node, element);
					}
				}
			}
		}
	}

}

std::string Erable::Compiler::Parser::IterationNode::toString() {
	std::stringstream ss;
	ss << this;
	return ss.str();
}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::IterationNode *node) {
	os << "I" << node->iterationIndex << ": ";
	for (auto &item : node->symbols) {
		os << "[" << item->getTag() << " -> " << item->toString() << " => ";
		if (item->connectedTo)os << "I" << item->connectedTo->iterationIndex;
		else if (item->connectedToSymbol)os << item->connectedToSymbol->toString();
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
		os << ")]\n\t";
	}
	Erable::Compiler::Parser::INDuplicateBuffer.insert(node);
	os << "\n";
	for (auto &item : node->symbols) {
		if (Erable::Compiler::Parser::INDuplicateBuffer.find(item->connectedTo) ==
			Erable::Compiler::Parser::INDuplicateBuffer.end())
			if (item->connectedTo)os << item->connectedTo << std::endl;
	}
	//Erable::Compiler::Parser::INDuplicateBuffer.clear();
	return os;
}
