//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//
#pragma once
#ifndef ERABLECOMPILER_SYMBOLS_HPP
#define ERABLECOMPILER_SYMBOLS_HPP

#include "Headers.hpp"
#include <string>
#include <vector>


namespace Erable::Compiler::Symbols {
	//Symbol: the base class for other symbol types
	class Symbol {
	public:
		static int precedenceCount;
		int precedence = precedenceCount++;
		std::string tag;

		virtual std::string getType() = 0;

		virtual std::string getName();

		virtual std::string toString();

		virtual bool find(std::string) = 0;

		virtual bool matchesStart(Data::DataDeque);

		virtual bool matchesAll(Data::DataDeque);

		virtual bool next
	};


	//TokenSymbol stores a token name
	class TokenSymbol : public Symbol {
	public:
		std::string ruleName;

		explicit TokenSymbol(std::string ruleName);

		std::string getType() override;

		std::string getName() override;

		std::string toString() override;

		bool find(std::string string) override;

		bool isValidToken(Data::ProcessedData);

		bool matchesStart(Data::DataDeque list) override;

		bool matchesAll(Data::DataDeque list) override;
	};


	//RuleSymbol stores a rule name
	class RuleSymbol : public Symbol {
	public:
		std::string ruleName;

		explicit RuleSymbol(std::string ruleName);

		std::string getType() override;

		std::string getName() override;

		std::string toString() override;

		bool find(std::string string) override;

		bool matchesStart(Data::DataDeque list) override;

		bool matchesAll(Data::DataDeque list) override;
	};


	//HandlerSymbol stores branches of tokens to be processed.
	class HandlerSymbol : public Symbol {
	public:
		SymbolPtr firstSymbol, secondSymbol;

		HandlerSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol);

		std::string getType() override;

		std::string toString() override;

		bool find(std::string string) override;
	};


	//ComplexSymbol stores list of symbols
	class ComplexSymbol : public Symbol {
	public:
		SymbolPtr firstSymbol, secondSymbol;

		ComplexSymbol(SymbolPtr &&firstSymbol, SymbolPtr &&secondSymbol);

		std::string getType() override;

		std::string toString() override;

		bool find(std::string string) override;
	};


	//A Rule defines a grammar
	class Rule : public Symbol {
	public:
		SymbolPtr rule;
		std::string ruleName;
		bool forbidLowerPrecedence;

		explicit Rule(std::string ruleName);

		std::string getType() override;

		std::string getName() override;

		std::string toString() override;

		bool isRef();

		bool isReal();

		bool find(std::string string) override;
	};

}


#endif //ERABLECOMPILER_SYMBOLS_HPP
