#include <utility>

#include <utility>

#include <utility>


//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Symbols.hpp"
#include "Syntax.hpp"
#include "ParseTable.hpp"
#include <sstream>
#include "Utils.h"

int Erable::Compiler::Symbols::Symbol::currentUid = 0;

std::string Erable::Compiler::Symbols::Symbol::getTag() {
	return this->tag;
}

Erable::Compiler::Symbols::Symbol::Symbol(std::string tag) : tag(std::move(tag)) {}

void Erable::Compiler::Symbols::Symbol::shiftDot() {
	dotPosition++;
}

std::string Erable::Compiler::Symbols::Symbol::toString() {
	if (this->getType() == SymbolType::RULE) {
		return "<" + getTag() + ">";
	} else {
		return "[" + getTag() + "]";
	}
}

Erable::Compiler::Symbols::LookaheadSet Erable::Compiler::Symbols::Symbol::getFront() {
	SymbolList symbolList{};
	return getFirst(symbolList);
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::Symbol::getType() {
	return type;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::Symbol::fullClone() {
	auto ret = std::make_shared<Symbol>(getTag());
	ret->ruleId = ruleId;
	ret->type = type;
	return ret;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::Symbol::fullCloneWithNeg1Dot() {
	auto cloned = this->fullClone();
	cloned->dotPosition = UNKNOWN;
	return cloned;
}

Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::Symbol::getFirst(Erable::Compiler::Symbols::SymbolList &symbolList) {
	return {EOT};
}

bool Erable::Compiler::Symbols::Symbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	return getTag() == that->getTag() and getType() == that->getType();
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::CombineSymbol::getType() {
	return SymbolType::COMBINATION;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::CombineSymbol::fullClone() {
	CombineSymbolPtr combination = std::make_shared<CombineSymbol>(getTag(), list);
	combination->ruleId = ruleId;
	return combination;
}


Erable::Compiler::Symbols::CombineSymbol::CombineSymbol(Erable::Compiler::Symbols::SymbolList list) : CombineSymbol(
		ANONYMOUS, std::move(list)) {}

Erable::Compiler::Symbols::CombineSymbol::CombineSymbol(std::string tag, Erable::Compiler::Symbols::SymbolList list)
		: Symbol(
		std::move(tag)), list(std::move(
		list)) {}

Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::CombineSymbol::getFirst(SymbolList &symbolList) {
	/*if (this->list.size() <= dotPosition) return {EOT};
	auto &first = list[dotPosition];
	return {Symbol::getFirst(symbolList, first)};*/
	if (this->list.empty()) return {};
	auto &sym = this->list[0];
	LookaheadSet lookaheadSet = Symbol::getFront(symbolList, sym);
	lookaheadSet.insert(lookahead.begin(), lookahead.end());
	return lookaheadSet;
}

std::string Erable::Compiler::Symbols::CombineSymbol::toString() {
	std::stringstream ss;
	ss << this->getTag() << " -> { ";
	int dot = 0;
	for (auto &item : list) {
		if (dot == dotPosition)
			ss << ".";
		ss << item->toString() << " ";
		dot++;
	}
	if (dot == dotPosition)
		ss << ".";
	ss << "}";
	ss << ", (";
	for (auto &tkn : lookahead) {
		ss << "'" << tkn->getTag() << "' ";
	}
	ss << ")";
	return ss.str();
}

bool Erable::Compiler::Symbols::CombineSymbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	/*if (that->getType() == SymbolType::COMBINATION) {
		if (this->getTag() != that->getTag())return false;
		CombineSymbolPtr ptr = std::static_pointer_cast<CombineSymbol>(that);
		if (this->list.size() != ptr->list.size()) return false;
		auto start = ptr->list.begin();
		for (auto &rule : this->list) {
			auto now = *start;
			start++;
			if (rule->is(now)) continue;
			return false;
		}
		return true;
	}
	return false;*/
	return this->ruleId == that->ruleId;
}

/*Erable::Compiler::Symbols::LookaheadSet Erable::Compiler::Symbols::CombineSymbol::getFront() {
	SymbolList buffer;
	if (this->getTag() == ANONYMOUS) return Symbol::getFront();
	if (this->list.size() <= dotPosition + 1) {
		if (this->lookahead.empty()) {
			return {EOT};
		} else {
			return this->lookahead;
		}
	};
	auto &first = list[dotPosition + 1];
	return {Symbol::getFront(buffer, first)};
}*/


Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::Symbol::getFront(SymbolList &symbolList, SymbolPtr exp) {
	switch (exp->getType()) {
		case SymbolType::TOKEN:
			return {exp};
		case SymbolType::RULE:
			if (Parser::RuleIteration::notDuplicate(symbolList, exp)) {
				symbolList.push_back(exp);
				LookaheadSet ret;
				SymbolList found = Syntax::$find(exp->getTag());
				for (auto &item : found) {
					LookaheadSet lookaheadSet = item->getFirst(symbolList);
					ret.insert(lookaheadSet.begin(), lookaheadSet.end());
				}
//				return ret.empty() ? LookaheadSet{EOT} : ret;
				return ret;
			}
			break;
		case SymbolType::COMBINATION:
			if (Parser::RuleIteration::notDuplicate(symbolList, exp)) {
				symbolList.push_back(exp);
				auto front = exp->getFirst(symbolList);
//				return front.empty() ? LookaheadSet{EOT} : front;
				return front;
			}
			//Else fall to default
		default:
			return {};
	}
	return {};
}

Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::Symbol::getLookahead(Erable::Compiler::Symbols::SymbolList &duplicateSymbol,
												Erable::Compiler::Symbols::SymbolPtr exp, SymbolList symbolList,
												int startOffset) {
	std::cout << "New Lookahead called for " << exp->toString() << "---------------------" << std::endl;
	if ((not Syntax::syntaxList.empty()) and Syntax::syntaxList[0]->getTag() == exp->getTag()) return {EOT};
	LookaheadSet lookaheadSet;
	for (int i = startOffset; i < symbolList.size(); i++) {
		auto &item = symbolList[i];
		std::cout << "\t" << item->toString() << std::endl;
		if (!Parser::RuleIteration::isExactlyDuplicate(duplicateSymbol, item)) {
			if (item->getType() != SymbolType::COMBINATION)
				throw std::runtime_error("Internal Error: item should be combination.");
			auto comb = std::static_pointer_cast<CombineSymbol>(item);
			bool shouldAddFirst = false;
			//for S->aAb
			for (int ladp = comb->dotPosition; ladp < comb->list.size(); ladp++) {
				auto &sym = comb->list[ladp];
				//The next symbol of exp
				if (shouldAddFirst) {
					std::cout << "\t\t" << sym->toString() << " is the next symbol after  " << exp->toString() << " in "
							  << comb->toString() << std::endl;
					shouldAddFirst = false;
					SymbolList buff;
					//get FIRST(sym)
					auto first = Symbol::getFront(buff, sym);
					std::cout << "\t\tthe first gotten of " << sym->toString() << " in rule " << comb->toString()
							  << " is: (";
					for (auto &tk : first) {
						std::cout << "'" << tk->toString() << "' ";
					}
					std::cout << ")" << std::endl;
					//remove epsilons
					for (auto startF = first.begin(); startF != first.end();) {
						if ((*startF)->getTag() == EPSILON->getTag()) {
							startF = first.erase(startF);
							continue;
						}
						startF++;
					}
					//add FIRST(sym) to FOLLOW(exp)
					lookaheadSet.insert(first.begin(), first.end());
					continue;
				}
				//If matches the exp's tag then set shouldAddFirst to true( which means the next symbol will be selected)
				if (sym->getTag() == exp->getTag()) {
					std::cout << "\t\tThere is a tag named " << sym->getTag() << " which is the same as "
							  << exp->getTag()
							  << " in " << comb->toString() << std::endl;
					shouldAddFirst = true;
				}
			}
			//If S->aB
			if (shouldAddFirst) {
				std::cout << "\t\t" << item->toString() << " matches S->aB with " << exp->getTag() << std::endl;
				//calculate FOLLOW(S)
				SymbolList dupl{item->fullCloneWithNeg1Dot()};
				LookaheadSet follow = getLookahead(dupl, item, symbolList, startOffset);
				std::cout << "They are: (";
				for (auto &tk : follow) {
					std::cout << "'" << tk->toString() << "' ";
				}
				std::cout << ")" << std::endl;
				//Add FOLLOW(S) -> FOLLOW(B)
				lookaheadSet.insert(follow.begin(), follow.end());
			}
			duplicateSymbol.push_back(item);
		} else {
			std::cout << "\t\tThe symbol is duplicate: " << item->toString() << " and " << exp->toString() << std::endl;
		}
	}
	std::cout << "End lookahead calling for " << exp->toString() << std::endl;
	return lookaheadSet.empty() ? exp->lookahead : lookaheadSet;
//	return lookaheadSet;
}

Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::Symbol::getLookahead(Erable::Compiler::Symbols::SymbolPtr exp, SymbolList symbolList,
												int startOffset) {
	SymbolList buffer;
	return getLookahead(buffer, std::move(exp), std::move(symbolList), startOffset);
}

/*
Erable::Compiler::Symbols::LookaheadSet
Erable::Compiler::Symbols::Symbol::_getLookAhead(Erable::Compiler::Symbols::SymbolList &duplicateSymbol,
												 Erable::Compiler::Symbols::SymbolPtr exp) {
	switch (exp->getType()) {

		case SymbolType::TOKEN:return {exp};
		case SymbolType::RULE:break;
		case SymbolType::COMBINATION:break;
	}
}*/

Erable::Compiler::Symbols::SymbolPtr operator "" _rule(const char *name, std::size_t size) {
	auto tkn = operator ""_token(name, size);
	tkn->type = Erable::Compiler::Symbols::SymbolType::RULE;
//	Erable::Compiler::Syntax::ruleList.insert(tkn);
	return tkn;
}

Erable::Compiler::Symbols::SymbolPtr operator "" _token(const char *name, std::size_t) {
	auto ret = std::make_shared<Erable::Compiler::Symbols::Symbol>(name);
	Erable::Compiler::Syntax::tokenList.insert(ret);
	return ret;
};

Erable::Compiler::Symbols::SymbolPtr
operator+(Erable::Compiler::Symbols::SymbolPtr lhs, Erable::Compiler::Symbols::SymbolPtr rhs) {
	using namespace Erable::Compiler::Symbols;
	if (lhs->getType() == SymbolType::COMBINATION) {
		CombineSymbolPtr combineSymbolPtr = std::static_pointer_cast<CombineSymbol>(lhs);
		combineSymbolPtr->list.push_back(rhs);
		return lhs;
	} else {
		return std::make_shared<CombineSymbol>(ANONYMOUS, SymbolList{lhs, rhs});
	}
}

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::SymbolPtr symbolPtr, Erable::Compiler::Symbols::SymbolList list) {
	for (auto &item : list) {
		Erable::Compiler::Symbols::SymbolPtr ptr;
		if (item->getType() != Erable::Compiler::Symbols::SymbolType::COMBINATION) {
			ptr = std::make_shared<Erable::Compiler::Symbols::CombineSymbol>(symbolPtr->getTag(),
																			 Erable::Compiler::Symbols::SymbolList{
																					 item});
		} else {
			item->tag = symbolPtr->getTag();
			ptr = item;
		}
		ptr->ruleId = Erable::Compiler::Syntax::syntaxList.size();
		Erable::Compiler::Syntax::syntaxList.push_back(ptr);
	}
	return symbolPtr;
}

