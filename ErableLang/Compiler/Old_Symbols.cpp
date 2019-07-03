#include <utility>
#include <iostream>

//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Old_Symbols.hpp"
#include "ProcessedData.hpp"

using namespace Erable::Compiler::Symbols;

int Symbol::precedenceCount = 0;

std::string RuleSymbol::getType() {
	return "RuleSymbol";
}

RuleSymbol::RuleSymbol(std::string ruleName) : ruleName(std::move(ruleName)) {
	tag = this->ruleName;
}

std::string RuleSymbol::toString() {
	return "<symbol - " + this->ruleName + ">";
}

std::string RuleSymbol::getName() {
	return ruleName;
}

bool RuleSymbol::find(std::string string) {
	return this->ruleName == string;
}

bool RuleSymbol::matchesStart(Erable::Compiler::Data::DataDeque list) {
	return false;
}

bool RuleSymbol::matchesAll(Erable::Compiler::Data::DataDeque list) {
	return false;
}


std::string HandlerSymbol::getType() {
	return "HandlerSymbol";
}

HandlerSymbol::HandlerSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol) : firstSymbol(std::move(firstSymbol)),
																				  secondSymbol(
																						  std::move(secondSymbol)) {}

std::string HandlerSymbol::toString() {
	return "(" + this->firstSymbol->toString() + " | " + this->secondSymbol->toString() + ")";
}

bool HandlerSymbol::find(std::string string) {
	return firstSymbol->find(string) or secondSymbol->find(string);
}


SymbolPtr operator ""_RuleSymbol(const char *name, std::size_t) {
	return std::make_shared<RuleSymbol>(std::string(name));
}

SymbolPtr operator ""_TokenSymbol(const char *name, std::size_t) {
	return std::make_shared<TokenSymbol>(std::string(name));
}

RulePtr operator ""_Rule(const char *name, std::size_t) {
	auto &&ret = std::make_shared<Rule>(std::string(name));
	return std::move(ret);
}

/*Erable::Compiler::Symbols::SymbolPtr operator ""_RuleRef(const char *name, std::size_t size) {
	return operator ""_Rule(name, size);
}*/

SymbolPtr operator|(SymbolPtr self, SymbolPtr other) {
	return std::make_shared<HandlerSymbol>(std::move(self), std::move(other));
}

SymbolPtr operator+(SymbolPtr self, SymbolPtr other) {
	return std::make_shared<ComplexSymbol>(std::move(self), std::move(other));
}

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::RulePtr rule, Erable::Compiler::Symbols::SymbolPtr symbol) {
	rule->rule = std::move(symbol);
	return rule;
}

Erable::Compiler::Symbols::SymbolPtr operator!(Erable::Compiler::Symbols::RulePtr) {
	return Erable::Compiler::Symbols::SymbolPtr();
}

Erable::Compiler::Symbols::SymbolPtr operator>=(Erable::Compiler::Symbols::SymbolPtr ptr, std::string name) {
	//std::cout<<ptr->toString() << ": " << ptr->tag << " == " << name <<std::endl;
	if (ptr->tag == name) return ptr;
	auto type = ptr->getType();
	if (type == "TokenSymbol" or type == "RuleSymbol") {
		goto name_assert;
	} else if (type == "Rule") {
		auto *real = (Rule *) ptr.get();
		if (real->isRef()) {
			goto name_assert;
		} else {
			return real->rule >= name;
		}
	} else if (type == "ComplexSymbol") {
		auto *real = (ComplexSymbol *) ptr.get();
		auto lptr = real->firstSymbol >= name, rptr = real->secondSymbol >= name;
		if ((lptr) != nullptr) return lptr;
		else if ((rptr) != nullptr) return rptr;
		return nullptr;
	} else if (type == "HandlerSymbol") {
		auto *real = (HandlerSymbol *) ptr.get();
		auto lptr = real->firstSymbol >= name, rptr = real->secondSymbol >= name;
		if ((lptr) != nullptr) return lptr;
		else if ((rptr) != nullptr) return rptr;
		return nullptr;
	}
	name_assert:
	{
		return (ptr->getName() == name ? ptr : nullptr);
	}
}

Erable::Compiler::Symbols::SymbolPtr operator<<(Erable::Compiler::Symbols::SymbolPtr ptr, std::string tag) {
	ptr->tag = std::move(tag);
	return ptr;
}


std::string ComplexSymbol::getType() {
	return "ComplexSymbol";
}

ComplexSymbol::ComplexSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol) : firstSymbol(std::move(firstSymbol)),
																				  secondSymbol(
																						  std::move(secondSymbol)) {}

std::string ComplexSymbol::toString() {
	return this->firstSymbol->toString() + " " + this->secondSymbol->toString();
}

bool ComplexSymbol::find(std::string) {
	return false;
}

std::string TokenSymbol::getName() {
	return ruleName;
}

bool TokenSymbol::find(std::string string) {
	return this->ruleName == string;
}

bool TokenSymbol::isValidToken(Erable::Compiler::Data::ProcessedData data) {
	return (not data.isNull) and (not data.isRule()) and
		   (data.getToken().name == this->ruleName);
}

bool TokenSymbol::matchesStart(Erable::Compiler::Data::DataDeque list) {
	return (not list.empty()) and isValidToken(list[0]);
}

bool TokenSymbol::matchesAll(Erable::Compiler::Data::DataDeque list) {
	return list.size() == 1 and matchesStart(list);
}

Rule::Rule(std::string ruleName) : ruleName(std::move(ruleName)) {
	tag = this->ruleName;
}


std::string Rule::getType() {
	return "Rule";
}

std::string Rule::toString() {
	if (this->rule == nullptr)
		return "<ref - " + this->ruleName + ">";
	else
		return this->ruleName + ": " + this->rule->toString();
}

std::string Rule::getName() {
	return ruleName;
}

bool Rule::isRef() {
	return rule == nullptr;
}

bool Rule::isReal() {
	return !isRef();
}

bool Rule::find(std::string string) {
	if (this->isRef()) {
		return false;
	} else {
		return this->ruleName == string or this->rule->find(string);
	}
}

std::string Symbol::toString() {
	return "Symbol";
}

std::string Symbol::getName() {
	return "__mixed__";
}

bool Symbol::matchesStart(Erable::Compiler::Data::DataDeque) {
	return false;
}

bool Symbol::matchesAll(Erable::Compiler::Data::DataDeque) {
	return false;
}