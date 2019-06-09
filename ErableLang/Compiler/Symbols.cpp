#include <utility>

#include <utility>

//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Symbols.hpp"

using namespace Erable::Compiler::Symbols;

std::string RuleSymbol::getType() {
    return "RuleSymbol";
}

RuleSymbol::RuleSymbol(std::string ruleName) : ruleName(std::move(ruleName)) {}

std::string RuleSymbol::toString() {
    return "<" + this->ruleName + ">";
}

std::string RuleSymbol::getName() {
    return ruleName;
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


SymbolPtr operator ""_RuleSymbol(const char *name, std::size_t) {
    return std::make_unique<RuleSymbol>(std::string(name));
}

SymbolPtr operator ""_TokenSymbol(const char *name, std::size_t) {
    return std::make_unique<TokenSymbol>(std::string(name));
}

RulePtr operator ""_Rule(const char *name, std::size_t) {
    return std::make_unique<Rule>(std::string(name));
}

SymbolPtr operator|(SymbolPtr &&self, SymbolPtr &&other) {
    return std::make_unique<HandlerSymbol>(std::move(self), std::move(other));
}

SymbolPtr operator+(SymbolPtr &&self, SymbolPtr &&other) {
    return std::make_unique<ComplexSymbol>(std::move(self), std::move(other));
}

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::RulePtr &&rule, Erable::Compiler::Symbols::SymbolPtr &&symbol) {
    rule->rule = std::move(symbol);
    return std::move(rule);
}

Erable::Compiler::Symbols::SymbolPtr operator!(Erable::Compiler::Symbols::RulePtr &&) {
    return Erable::Compiler::Symbols::SymbolPtr();
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

TokenSymbol::TokenSymbol(std::string ruleName) : ruleName(std::move(ruleName)) {}

std::string TokenSymbol::getType() {
    return "TokenSymbol";
}

std::string TokenSymbol::toString() {
    return "[" + this->ruleName + "]";
}

std::string TokenSymbol::getName() {
    return ruleName;
}

Rule::Rule(std::string ruleName, SymbolPtr rule) : ruleName(std::move(ruleName)), rule(std::move(rule)) {}

std::string Rule::getType() {
    return "Rule";
}

std::string Rule::toString() {
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

std::string Symbol::toString() {
    return "Symbol";
}

std::string Symbol::getName() {
    return "__mixed__";
}
