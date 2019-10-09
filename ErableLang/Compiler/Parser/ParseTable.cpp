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
#include "Lexer/Symbols.hpp"

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
		//This is DSF
//		generateOneRound(node);
//		for (auto &item : node->symbols) {
//			if (item->connectedTo) {
//				if (duplicateBuffer.find(item->connectedTo) == duplicateBuffer.end()) {
//					duplicateBuffer.insert(item->connectedTo);
//					_generate(duplicateBuffer, item->connectedTo);
//				}
//			}
//		}
		std::unordered_set<IterationNode *> round{node}, next_round;
		while (true) {
			for (auto &rNode : round) {
				generateOneRound(rNode);
				for (auto &item : rNode->symbols) {
					if (item->connectedTo) {
						if (duplicateBuffer.find(item->connectedTo) == duplicateBuffer.end()) {
							duplicateBuffer.insert(item->connectedTo);
							next_round.insert(item->connectedTo);
						}
					}
				}
			}
			if (next_round.empty()) break;
			round = next_round;
			next_round = std::unordered_set<IterationNode *>();
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
		clone->lookahead = {Symbols::EOT};
		//Initialize the root node
		rootNode = new IterationNode{this->currentIndex++, {clone}};
		//Recursively expand the rule
		recursiveExpandRule(rootNode, clone);
		for (auto &sym : rootNode->symbols) {
			sym->lookahead = Symbols::Symbol::getLookahead(sym, rootNode->symbols, 0);
		}
	}

	void RuleIteration::generateOneRound(IterationNode *node) {
		std::unordered_map<std::string, IterationNode *> mappingCurrentDot;
		//For each symbol in the parent node
		for (auto &item : node->symbols) {
			if (item->connectedTo) continue;
			if (item->getType() == Symbols::SymbolType::COMBINATION) {
				auto casted = std::static_pointer_cast<Symbols::CombineSymbol>(item);
				if (casted->dotPosition >= casted->list.size()) continue;
				auto &currentSymbol = casted->list[casted->dotPosition];
				auto clone = casted->fullClone();
				clone->dotPosition = casted->dotPosition;
				clone->lookahead = casted->lookahead;
				clone->shiftDot();
				auto found = findMatch(clone);
				if (found) {
					casted->connectedTo = found;
					continue;
				}
				if (mappingCurrentDot.find(currentSymbol->getTag()) == mappingCurrentDot.end()) {
					mappingCurrentDot[currentSymbol->getTag()] = new IterationNode(this->currentIndex++,
																				   Symbols::SymbolList{});
				}
				mappingCurrentDot[currentSymbol->getTag()]->symbols.push_back(clone);
				casted->connectedTo = mappingCurrentDot[currentSymbol->getTag()];
			}
		}
		for (auto &pair : mappingCurrentDot) {
			IterationNode *iterationNode = pair.second;
			std::cout << "Iteration " << iterationNode->iterationIndex << "-----" << std::endl;
			Symbols::SymbolList cloneCurrentSymbols = iterationNode->symbols;
			Symbols::SymbolList cloneDuplicateSymbols = iterationNode->symbols;
			int cloneDuplicateSymbolsSize = cloneDuplicateSymbols.size();
			for (auto &item : cloneCurrentSymbols) {
				recursiveExpandRule(cloneDuplicateSymbols, iterationNode, item);
			}

			for (int i = cloneDuplicateSymbolsSize; i < iterationNode->symbols.size(); i++) {
				auto sym = iterationNode->symbols[i];
				sym->lookahead = Symbols::Symbol::getLookahead(sym, iterationNode->symbols, 0);
			}
		}
	}

	void RuleIteration::recursiveExpandRule(IterationNode *node, Symbols::SymbolPtr &symbol) {
		Symbols::SymbolList duplicateBuffer;
		recursiveExpandRule(duplicateBuffer, node, symbol);
		/*if(node->iterationIndex == 6) {

		}
		for (auto sym : node->symbols) {
			sym->lookahead = Symbols::Symbol::getLookahead(sym, node->symbols);
		}*/
	}

	void RuleIteration::recursiveExpandRule(Symbols::SymbolList &duplicateBuffer, IterationNode *node,
											Symbols::SymbolPtr &symbol) {
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
						Symbols::SymbolList dup;

//						cloned->lookahead = cloned->getFirst(dup);
						auto duplicateDuplicateBuffer = duplicateBuffer;
						if (!isExactlyDuplicate(duplicateDuplicateBuffer, cloned)) {
							duplicateBuffer.push_back(cloned);
							cloneFound.push_back(cloned);
						}
					}
					node->symbols.insert(node->symbols.end(), cloneFound.begin(), cloneFound.end());
					for (auto &element : cloneFound) {
						recursiveExpandRule(duplicateBuffer, node, element);
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

	bool RuleIteration::notDuplicate(Symbols::SymbolSet &duplicateBuffer, Symbols::SymbolPtr sym) {
		for (auto &elem : duplicateBuffer) {
			if (sym->is(elem)) {
				return false;
			}
		}
		return true;
	}

	bool RuleIteration::notDuplicate(Symbols::SymbolList &duplicateBuffer, Symbols::SymbolPtr sym) {
		for (auto &elem : duplicateBuffer) {
			if (sym->is(elem)) {
				return false;
			}
		}
		return true;
	}

	bool RuleIteration::isExactlyDuplicate(Symbols::SymbolList &duplicateBuffer, Symbols::SymbolPtr sym) {
		for (auto &elem : duplicateBuffer) {
			if (sym->is(elem) and (sym->dotPosition == elem->dotPosition or elem->dotPosition == -1)) {
				return true;
			}
		}
		return false;
	}

	bool RuleIteration::exactlyDuplicateWithLookahead(Symbols::SymbolList &duplicateBuffer, Symbols::SymbolPtr sym) {
		for (auto &elem : duplicateBuffer) {
			if (sym->is(elem) and sym->dotPosition == elem->dotPosition and sym->lookahead == elem->lookahead) {
				return true;
			}
		}
		return false;
	}

	void ParseTable::_place(int line, std::string key, Action action) {
		ActionLine &tl = parseTable[line];
		ParseTable::ActionLine::iterator it;
		for (it = tl.equal_range(key).first; it != tl.equal_range(key).second; ++it) {
			Action act = it->second;
			if (act == action) return;
		}
		tl.insert(std::make_pair(key, action));
		int amount = tl.count(key);
		int width = amount * 3;
		if (width > maxWidth) maxWidth = width;
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
		int width = table.maxWidth;
		os << std::setw(stateWidth) << std::left << "state" << "|";
		for (auto tkn : Syntax::tokenList) {
			os << std::setw(width) << tkn->getTag() << "|";
		}
		os << std::setw(width) << Symbols::EOT->getTag() << "|";
		/*for (auto tkn : Syntax::ruleList) {
			os << std::setw(width) << tkn->getTag() << "|";
		}*/
		os << std::endl;
		//For each line in the table
		for (int i = 0; i < table.getStateAmount(); i++) {
			ParseTable::ActionLine line = table.parseTable[i];
			//Write state number
			os << std::setw(stateWidth) << std::left << i << "|";
			for (auto tkn : Syntax::tokenList) {
				auto tag = tkn->getTag();
//				auto found = line.find(tag);
//				auto cloneFound = found;
//				if (found != line.end()) {
				std::stringstream ss;
				ParseTable::ActionLine::iterator it;
				for (it = line.equal_range(tag).first; it != line.equal_range(tag).second; ++it) {
					Action action = it->second;
					if (it != line.equal_range(tag).first) {
						ss << "/";
					}
					ss << action;
				}
				os << std::setw(width) << ss.str();
				/*} else {
					os << std::setw(width) << " ";
				}*/
				os << "|";
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

	const ParseTable::ActionTable &ParseTable::getParseTable() const {
		return parseTable;
	}

	void ParseTable::setParseTable(const ParseTable::ActionTable &parseTable) {
		ParseTable::parseTable = parseTable;
	}

	ParseTable::ParseTable(int stateAmount) : stateAmount(stateAmount) {}

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

	bool Action::operator==(const Action &rhs) const {
		return type == rhs.type &&
			   i == rhs.i;
	}
}

std::string Erable::Compiler::Parser::IterationNode::toString() {
	std::stringstream os;
	os << "I" << this->iterationIndex << ": ";
	for (auto &item : this->symbols) {
		os << "[" << item->toString() << " => ";
		if (item->connectedTo)os << "I" << item->connectedTo->iterationIndex;
		else if (item->connectedToSymbol)os << item->connectedToSymbol->toString();
		else os << "None";
		os << "]\n\t";
	}
	Erable::Compiler::Parser::INDuplicateBuffer.insert(this);
	os << "\n";
	for (auto &item : this->symbols) {
		if (Erable::Compiler::Parser::INDuplicateBuffer.find(item->connectedTo) ==
			Erable::Compiler::Parser::INDuplicateBuffer.end())
			if (item->connectedTo)os << item->connectedTo->toString() << std::endl;
	}
	return os.str();
}

Erable::Compiler::Parser::IterationNode::IterationNode(int iterationIndex,
													   const Erable::Compiler::Symbols::SymbolList &symbols)
		: iterationIndex(iterationIndex), symbols(symbols) {}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::IterationNode *node) {
	os << node->toString();
	return os;
}
