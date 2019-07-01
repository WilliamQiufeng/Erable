#include <utility>

//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Symbols.hpp"
#include <sstream>
#include "Utils.h"

std::string Erable::Compiler::Symbols::Symbol::getTag() {
	return this->tag;
}

Erable::Compiler::Symbols::Symbol::Symbol(std::string tag) : tag(std::move(tag)) {}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::RuleSymbol::getType() {
	return SymbolType::RULE;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::RuleSymbol::fullClone() {
	RuleSymbolPtr rule = std::make_shared<Erable::Compiler::Symbols::RuleSymbol>(this->tag);
	rule->ruleIndex = this->ruleIndex;
	SymbolList copy;
	for (auto &ref : rules) {
		copy.push_back(ref->fullClone());
	}
	rule->rules = copy;
	return rule;
}

Erable::Compiler::Symbols::RuleSymbol::RuleSymbol(const std::string &tag,
												  Erable::Compiler::Symbols::SymbolList combination) : Symbol(
		tag), rules(std::move(combination)) {}

Erable::Compiler::Symbols::RuleSymbol::RuleSymbol(const std::string &tag) : Symbol(tag) {}

int Erable::Compiler::Symbols::RuleSymbol::currentIndex = 0;

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::Symbol::getFront(int dotInd) {
	SymbolList symbolList;
	return getFront(symbolList, dotInd);
}

Erable::Compiler::Symbols::SymbolPtr
Erable::Compiler::Symbols::RuleSymbol::getFront(SymbolList &symbolList, int dotInd) {
	if (this->rules.size() > dotInd + 2) return nullptr;
	auto &first = rules[dotInd + 1];
	return Symbol::getFront(symbolList, dotInd, first);
}

std::string Erable::Compiler::Symbols::RuleSymbol::toString() {
	std::stringstream ss;
	ss << getTag() << ": ";
	for (auto &item : rules) {
		ss << "| " << item->toString();
	}
	return ss.str();
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::CombineSymbol::getType() {
	return SymbolType::COMBINATION;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::CombineSymbol::fullClone() {
	SymbolList symbolList;
	for (auto &ref : list) {
		symbolList.push_back(ref->fullClone());
	}
	CombineSymbolPtr combination = std::make_shared<CombineSymbol>(symbolList);
	return combination;
}


Erable::Compiler::Symbols::CombineSymbol::CombineSymbol(Erable::Compiler::Symbols::SymbolList list) : Symbol(
		"_combination"), list(std::move(
		list)) {}

Erable::Compiler::Symbols::SymbolPtr
Erable::Compiler::Symbols::CombineSymbol::getFront(Erable::Compiler::Symbols::SymbolList &symbolList, int dotInd) {
	if (this->list.size() > dotInd + 2) return nullptr;
	auto &first = list[dotInd + 1];
	return Symbol::getFront(symbolList, dotInd, first);
}

std::string Erable::Compiler::Symbols::CombineSymbol::toString() {
	std::stringstream ss;
	for (auto &item : list) {
		ss << item->toString() << " ";
	}
	return ss.str();
}

Erable::Compiler::Symbols::SymbolPtr
Erable::Compiler::Symbols::Symbol::getFront(Erable::Compiler::Symbols::SymbolList &symbolList, int dotInd,
											Erable::Compiler::Symbols::SymbolPtr exp) {
	switch (exp->getType()) {
		case SymbolType::TOKEN:
			return exp;
		case SymbolType::RULE:
		case SymbolType::COMBINATION:
			if (Utils::ArrayUtils::indexOf(symbolList, exp) == -1) {
				symbolList.push_back(exp);
				return exp->getFront(symbolList, dotInd);
			}
			//Else fall to default
		default:
			return nullptr;
	}
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::TokenSymbol::getType() {
	return SymbolType::TOKEN;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::TokenSymbol::fullClone() {
	return std::make_shared<TokenSymbol>(this->getTag());
}

Erable::Compiler::Symbols::TokenSymbol::TokenSymbol(std::string tag) : Symbol(std::move(tag)) {}

Erable::Compiler::Symbols::SymbolPtr
Erable::Compiler::Symbols::TokenSymbol::getFront(Erable::Compiler::Symbols::SymbolList &list, int i) {
	return nullptr;
}

std::string Erable::Compiler::Symbols::TokenSymbol::toString() {
	return getTag();
}

Erable::Compiler::Symbols::SymbolPtr operator "" _rule(const char *name, std::size_t) {
	auto rule = std::make_shared<Erable::Compiler::Symbols::RuleSymbol>(name);
	rule->ruleIndex = Erable::Compiler::Symbols::RuleSymbol::currentIndex++;
	return rule;
};

Erable::Compiler::Symbols::SymbolPtr operator "" _token(const char *name, std::size_t) {
	return std::make_shared<Erable::Compiler::Symbols::TokenSymbol>(name);
};

Erable::Compiler::Symbols::SymbolPtr
operator+(Erable::Compiler::Symbols::SymbolPtr lhs, Erable::Compiler::Symbols::SymbolPtr rhs) {
	using namespace Erable::Compiler::Symbols;
	if (lhs->getType() == SymbolType::COMBINATION) {
		CombineSymbolPtr combineSymbolPtr = std::static_pointer_cast<CombineSymbol>(lhs);
		combineSymbolPtr->list.push_back(rhs);
		return lhs;
	} else {
		return std::make_shared<CombineSymbol>(SymbolList{lhs, rhs});
	}
}

Erable::Compiler::Symbols::SymbolPtr
operator|(Erable::Compiler::Symbols::SymbolPtr lhs, Erable::Compiler::Symbols::SymbolPtr rhs) {
	using namespace Erable::Compiler::Symbols;
	if (lhs->getType() == SymbolType::RULE) {
		RuleSymbolPtr ruleSymbolPtr = std::static_pointer_cast<RuleSymbol>(lhs);
		if (rhs->getType() == SymbolType::RULE) {
			ruleSymbolPtr->rules.push_back(rhs);
			return ruleSymbolPtr;
		}
		std::stringstream ss;
		ss << lhs->getTag() << ruleSymbolPtr->rules.size();
		auto str = ss.str();
		SymbolPtr newRule = operator ""_rule(str.c_str(), str.size());
		std::static_pointer_cast<RuleSymbol>(newRule)->rules.push_back(rhs);
		ruleSymbolPtr->rules.push_back(newRule);
		return ruleSymbolPtr;
	} else {
		return std::make_shared<RuleSymbol>("_anonymous_rule", SymbolList{lhs, rhs});
	}
}