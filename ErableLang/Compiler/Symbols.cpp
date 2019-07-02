#include <utility>

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

void Erable::Compiler::Symbols::Symbol::shiftDot() {
	dotPosition++;
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::RuleSymbol::getType() {
	return SymbolType::RULE;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::RuleSymbol::fullClone() {
	RuleSymbolPtr rule = std::make_shared<Erable::Compiler::Symbols::RuleSymbol>(this->tag,
																				 std::static_pointer_cast<CombineSymbol>(
																						 this->combination->fullClone()));
	return rule;
}

Erable::Compiler::Symbols::RuleSymbol::RuleSymbol(const std::string &tag,
												  Erable::Compiler::Symbols::CombineSymbolPtr combination) : Symbol(
		tag), combination(std::move(combination)) {}

Erable::Compiler::Symbols::RuleSymbol::RuleSymbol(const std::string &tag) : Symbol(tag) {}

int Erable::Compiler::Symbols::RuleSymbol::currentIndex = 0;

Erable::Compiler::Symbols::TokenSymbolList Erable::Compiler::Symbols::Symbol::getFront() {
	SymbolList symbolList{};
	bool incDot = true;
	return getFront(symbolList, incDot);
}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::RuleSymbol::getFront(SymbolList &symbolList, bool &incDot) {
	return {combination->getFront(symbolList, incDot)};
}

std::string Erable::Compiler::Symbols::RuleSymbol::toString() {
	return combination->toString();
}

bool Erable::Compiler::Symbols::RuleSymbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	if (that->getType() == SymbolType::RULE)
		return combination->is(std::static_pointer_cast<RuleSymbol>(that)->combination) and getTag() == that->getTag();
	return false;
}

void Erable::Compiler::Symbols::RuleSymbol::shiftDot() {
	Symbol::shiftDot();
	combination->shiftDot();
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::CombineSymbol::getType() {
	return SymbolType::COMBINATION;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::CombineSymbol::fullClone() {
	CombineSymbolPtr combination = std::make_shared<CombineSymbol>(list);
	return combination;
}


Erable::Compiler::Symbols::CombineSymbol::CombineSymbol(Erable::Compiler::Symbols::SymbolList list) : Symbol(
		"_combination"), list(std::move(
		list)) {}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::CombineSymbol::getFront(SymbolList &symbolList, bool &incDot) {
	if (this->list.size() <= dotPosition + incDot) return {EOT};
	auto &first = list[dotPosition + incDot];
	incDot = false;
	return {Symbol::getFront(symbolList, first, incDot)};
}

std::string Erable::Compiler::Symbols::CombineSymbol::toString() {
	std::stringstream ss;
	for (auto &item : list) {
		ss << item->toString() << " ";
	}
	return ss.str();
}

bool Erable::Compiler::Symbols::CombineSymbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	if (that->getType() == SymbolType::COMBINATION) {
		if (this->getTag() != that->getTag())return false;
		CombineSymbolPtr ptr = std::static_pointer_cast<CombineSymbol>(that);
		if (this->list.size() != ptr->list.size()) return false;
		auto start = ptr->list.begin();
		for (auto &rule : this->list) {
			if (rule->getTag() == (*start++)->getTag()) continue;
			return false;
		}
	}
	return false;
}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::Symbol::getFront(SymbolList &symbolList, SymbolPtr exp, bool &incDot) {
	switch (exp->getType()) {
		case SymbolType::TOKEN:
			return {std::static_pointer_cast<TokenSymbol>(exp)};
		case SymbolType::RULE:
		case SymbolType::COMBINATION:
			if (Utils::ArrayUtils::indexOf(symbolList, exp) == -1) {
				symbolList.push_back(exp);
				auto front = exp->getFront(symbolList, incDot);
				return front.empty() ? TokenSymbolList{EOT} : front;
			}
			//Else fall to default
		default:
			return {EOT};
	}
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::TokenSymbol::getType() {
	return SymbolType::TOKEN;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::TokenSymbol::fullClone() {
	return std::make_shared<TokenSymbol>(this->getTag());
}

Erable::Compiler::Symbols::TokenSymbol::TokenSymbol(std::string tag) : Symbol(std::move(tag)) {}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::TokenSymbol::getFront(SymbolList &list, bool &incDot) {
	return {EOT};
}

std::string Erable::Compiler::Symbols::TokenSymbol::toString() {
	return getTag();
}

bool Erable::Compiler::Symbols::TokenSymbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	return getTag() == that->getTag() and that->getType() == SymbolType::TOKEN;
}

Erable::Compiler::Symbols::SymbolPtr operator "" _rule(const char *name, std::size_t) {
	auto rule = std::make_shared<Erable::Compiler::Symbols::RuleSymbol>(name);
	rule->ruleIndex = Erable::Compiler::Symbols::RuleSymbol::currentIndex++;
	return rule;
};

Erable::Compiler::Symbols::SymbolPtr operator "" _token(const char *name, std::size_t) {
	return std::make_shared<Erable::Compiler::Symbols::TokenSymbol>(name);
};

Erable::Compiler::Symbols::SymbolPtr operator "" _container(const char *name, std::size_t) {
	return std::make_shared<Erable::Compiler::Symbols::RuleContainer>(name,
																	  Erable::Compiler::Symbols::RuleContainer::Container{});
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
	RuleSymbolPtr lhsPtr, rhsPtr;
	if (rhs->getType() == SymbolType::RULE) {
		//如果是rule就直接类型转换
		rhsPtr = std::static_pointer_cast<RuleSymbol>(rhs);
	} else {
		//否则做一个新的rule
		RuleSymbolPtr newRule = std::static_pointer_cast<RuleSymbol>(
				operator ""_rule(lhs->getTag().c_str(), lhs->getTag().size()));
		if (rhs->getType() == SymbolType::COMBINATION) {
			CombineSymbolPtr combineSymbolPtr = std::static_pointer_cast<CombineSymbol>(rhs);
			newRule->combination = combineSymbolPtr;
		} else {
			newRule->combination = std::make_shared<CombineSymbol>(SymbolList{rhs});
		}
		rhsPtr = newRule;
	}
	if (lhs->getType() == SymbolType::CONTAINER) {
		//如果lhs是rule容器就把rhsPtr加进去
		RuleContainerPtr ruleSymbolPtr = std::static_pointer_cast<RuleContainer>(lhs);
		ruleSymbolPtr->container.push_back(rhsPtr);
		return ruleSymbolPtr;
	} else {
		//否则定义匿名容器
		lhsPtr = std::make_shared<RuleSymbol>("_anonymous_rule", std::make_shared<CombineSymbol>(SymbolList{lhs}));
		return std::make_shared<RuleContainer>("_anonymous_container", RuleContainer::Container{lhsPtr, rhsPtr});
	}
}

Erable::Compiler::Symbols::SymbolPtr operator-(Erable::Compiler::Symbols::SymbolPtr symbolPtr) {
	return symbolPtr->getType() == Erable::Compiler::Symbols::SymbolType::RULE
		   ? std::make_shared<Erable::Compiler::Symbols::RuleRefSymbol>(symbolPtr->getTag(), symbolPtr) : symbolPtr;
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::RuleRefSymbol::getType() {
	return SymbolType::RULEREF;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::RuleRefSymbol::fullClone() {
	return std::make_shared<RuleRefSymbol>(tag, rule);
}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::RuleRefSymbol::getFront(SymbolList &list, bool &incDot) {
	return this->rule->getFront(list, incDot);
}

std::string Erable::Compiler::Symbols::RuleRefSymbol::toString() {
	return this->rule->getTag();
}

Erable::Compiler::Symbols::RuleRefSymbol::RuleRefSymbol(const std::string &tag,
														Erable::Compiler::Symbols::SymbolPtr rule) : Symbol(tag),
																									 rule(std::move(
																											 rule)) {}

bool Erable::Compiler::Symbols::RuleRefSymbol::is(Erable::Compiler::Symbols::SymbolPtr that) {
	if (that->getType() == SymbolType::RULEREF)
		return rule->is(std::static_pointer_cast<RuleRefSymbol>(that)->rule) and getTag() == that->getTag();
	return false;
}

Erable::Compiler::Symbols::SymbolType Erable::Compiler::Symbols::RuleContainer::getType() {
	return SymbolType::CONTAINER;
}

Erable::Compiler::Symbols::SymbolPtr Erable::Compiler::Symbols::RuleContainer::fullClone() {
	Container copy;
	for (auto &item : container) {
		copy.push_back(std::static_pointer_cast<RuleSymbol>(item->fullClone()));
	}
	return std::make_shared<RuleContainer>(getTag(), copy);
}

Erable::Compiler::Symbols::TokenSymbolList
Erable::Compiler::Symbols::RuleContainer::getFront(SymbolList &list, bool &incDot) {
	TokenSymbolList ret;
	for (auto &rule : this->container) {
		auto ruleFront = Symbol::getFront(list, rule, incDot);
		ret.insert(ret.end(), ruleFront.begin(), ruleFront.end());
	}
	return ret;
}

std::string Erable::Compiler::Symbols::RuleContainer::toString() {
	std::stringstream ss;
	for (auto &rule : container) {
		ss << rule->toString() << "\n";
	}
	return ss.str();
}

Erable::Compiler::Symbols::RuleContainer::RuleContainer(const std::string &tag,
														const Container &container)
		: Symbol(tag), container(container) {}

void Erable::Compiler::Symbols::RuleContainer::shiftDot() {
	Symbol::shiftDot();
	for (auto &item : container) {
		item->shiftDot();
	}
}

bool Erable::Compiler::Symbols::RuleContainer::is(Erable::Compiler::Symbols::SymbolPtr that) {
	if (that->getType() == SymbolType::CONTAINER) {
		if (this->getTag() != that->getTag()) return false;
		RuleContainerPtr ruleContainer = std::static_pointer_cast<RuleContainer>(that);
		if (ruleContainer->container.size() != this->container.size())return false;
		auto start = ruleContainer->container.begin();
		RuleContainer::Container::const_iterator end;
		for (auto &rule : this->container) {
			if (rule->is(*start++)) continue;
			return false;
		}
		return true;
	}
	return false;
}
