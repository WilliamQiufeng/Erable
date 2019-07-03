#include <utility>
#include <Syntax.hpp>
#include <iostream>
#include <sstream>
#include <iomanip>

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
	}

	void RuleIteration::recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol) {
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

	ParseTable::ParseTable(const RuleIteration &iteration, int stateAmount) : iteration(iteration) {
		setStateAmount(stateAmount);
	}

	int ParseTable::getStateAmount() const {
		return stateAmount;
	}

	void ParseTable::setStateAmount(int amount) {
		ParseTable::stateAmount = amount;
		parseTable.clear();
		for (int i = 0; i < amount; i++) {
			parseTable.push_back(ActionLine());
		}
	}

	void ParseTable::generateTable() {
		IterationNodeSet duplicateBuffer;
		_generateTable(duplicateBuffer);
	}

	void ParseTable::_generateTable(IterationNodeSet &duplicateBuffer) {
		_generateTable(duplicateBuffer, this->iteration.rootNode);
	}

	void ParseTable::_generateTable(IterationNodeSet &duplicateBuffer, IterationNode *node) {
		for (auto &item : node->symbols) {
			Symbols::CombineSymbolPtr ptr = std::static_pointer_cast<Symbols::CombineSymbol>(item);
			if (ptr->dotPosition >= ptr->list.size()) {
				//If the rule is the root rule
				if (ptr->ruleId == 0) {
					_place(node->iterationIndex, ptr->lookahead, {ActionType::ACCEPT});
				} else {
					_place(node->iterationIndex, ptr->lookahead, {ActionType::REDUCE, ptr->ruleId});
				}
			} else {
				Symbols::SymbolPtr currentSymbol = ptr->list[ptr->dotPosition];
				IterationNode *changedToNode = ptr->connectedTo;
				_place(node->iterationIndex, currentSymbol->getTag(),
					   {ActionType::STATE, changedToNode->iterationIndex});
				if (duplicateBuffer.find(changedToNode) == duplicateBuffer.end()) {
					duplicateBuffer.insert(changedToNode);
					_generateTable(duplicateBuffer, changedToNode);
				}
			}
		}
	}

	void ParseTable::_place(int line, std::string key, Action action) {
		auto &tl = parseTable[line];
		auto found = tl.find(key);
		if (found == tl.end()) {
			tl[key] = action;
		} else {
			std::cerr << "Conflict in state " << line << " symbol " << key << " with action " << (*found).second
					  << " and " << action << std::endl;
		}
	}

	void ParseTable::_place(int line, std::vector<std::string> keys, Action action) {
		for (auto item : keys) {
			_place(line, item, action);
		}
	}

	void ParseTable::_place(int line, Symbols::SymbolList symbols, Action action) {
		for (auto item : symbols) {
			_place(line, item->getTag(), action);
		}
	}

	void ParseTable::_place(int line, Symbols::SymbolSet symbols, Action action) {
		for (auto item : symbols) {
			_place(line, item->getTag(), action);
		}
	}

	std::ostream &operator<<(std::ostream &os, const ParseTable &table) {
		int stateWidth = 6;
		int width = 10;
		int tokensWidth = (Syntax::tokenList.size() + 1) * width;
		os << std::setw(stateWidth) << std::left << "state" << "|";
		for (auto tkn : Syntax::tokenList) {
			os << std::setw(width) << tkn->getTag() << "|";
		}
		os << std::setw(width) << Symbols::EOT->getTag() << "|";
		/*for (auto tkn : Syntax::ruleList) {
			os << std::setw(width) << tkn->getTag() << "|";
		}*/
		os << std::endl;
		for (int i = 0; i < table.getStateAmount(); i++) {
			ParseTable::ActionLine line = table.parseTable[i];
			os << std::setw(stateWidth) << std::left << i << "|";
			for (auto tkn : Syntax::tokenList) {
				auto tag = tkn->getTag();
				auto found = line.find(tag);
				if (found != line.end()) {
					Action action = (*found).second;
					std::stringstream ss;
					ss << action;
					os << std::setw(width) << ss.str() << "|";
				} else {
					os << std::setw(width) << " " << "|";
				}
			}
			auto found = line.find(Symbols::EOT->getTag());
			if (found != line.end()) {
				Action action = (*found).second;
				std::stringstream ss;
				ss << action;
				os << std::setw(width) << ss.str() << "|";
			} else {
				os << std::setw(width) << " " << "|";
			}
			/*for (auto tkn : Syntax::ruleList) {
				auto tag = tkn->getTag();
				auto found = line.find(tag);
				if (found != line.end()) {
					Action action = (*found).second;
					std::stringstream ss;
					ss << action;
					os << std::setw(width) << ss.str() << "|";
				} else {
					os << std::setw(width) << " " << "|";
				}
			}*/
			os << "\n";
		}
		return os;
	}

	ParseTable::ParseTable(const RuleIteration &iteration) : ParseTable(iteration, iteration.currentIndex) {}

	std::ostream &operator<<(std::ostream &os, const Action &action) {
		switch (action.type) {

			case ActionType::STATE:
				os << "s" << action.i;
				break;
			case ActionType::REDUCE:
				os << "r" << action.i;
				break;
			case ActionType::ACCEPT:
				os << "acc";
				break;
		}
		return os;
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
	return os;
}
