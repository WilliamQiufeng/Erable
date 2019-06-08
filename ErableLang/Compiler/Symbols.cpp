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


std::string HandlerSymbol::getType() {
    return "HandlerSymbol";
}

HandlerSymbol::HandlerSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol) : firstSymbol(std::move(firstSymbol)),
                                                                                  secondSymbol(
                                                                                          std::move(secondSymbol)) {}


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
    return std::make_unique<HandlerSymbol>(self, other);
}

SymbolPtr operator+(SymbolPtr &&self, SymbolPtr &&other) {
    return std::make_unique<ComplexSymbol>(self, other);
}

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::RulePtr &&rule, Erable::Compiler::Symbols::SymbolPtr &&symbol) {
    rule->rule = std::move(symbol);
    return std::move(rule);
}


std::string ComplexSymbol::getType() {
    return "ComplexSymbol";
}

ComplexSymbol::ComplexSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol) : firstSymbol(std::move(firstSymbol)),
                                                                                  secondSymbol(
                                                                                          std::move(secondSymbol)) {}

TokenSymbol::TokenSymbol(std::string ruleName) : ruleName(std::move(ruleName)) {}

std::string TokenSymbol::getType() {
    return "TokenSymbol";
}

Rule::Rule(std::string ruleName) : ruleName(std::move(ruleName)) {}

std::string Rule::getType() {
    return "Rule";
}
