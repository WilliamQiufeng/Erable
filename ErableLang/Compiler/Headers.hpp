//
// Created by Qiufeng54321 on 2019-06-23.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_HEADERS_HPP
#define ERABLELANG_HEADERS_HPP

#include <string>
#include <memory>
#include <unordered_set>
/*
namespace Erable::Compiler::Symbols {
	class Symbol;

	typedef std::shared_ptr<Symbol> SymbolPtr;

	class TokenSymbol;

	typedef std::shared_ptr<TokenSymbol> TokenSymbolPtr;

	class RuleSymbol;

	typedef std::shared_ptr<RuleSymbol> RuleSymbolPtr;

	class Rule;

	typedef std::shared_ptr<Rule> RulePtr;

	class HandlerSymbol;

	typedef std::shared_ptr<HandlerSymbol> HandlerSymbolPtr;

	class ComplexSymbol;

	typedef std::shared_ptr<ComplexSymbol> ComplexSymbolPtr;


	typedef std::vector<Erable::Compiler::Symbols::SymbolPtr> SyntaxList;
}

Erable::Compiler::Symbols::SymbolPtr operator "" _RuleSymbol(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr operator "" _TokenSymbol(const char *, std::size_t);

Erable::Compiler::Symbols::RulePtr operator "" _Rule(const char *, std::size_t);

//Erable::Compiler::Symbols::SymbolPtr operator "" _RuleRef(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr
operator|(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolPtr);

Erable::Compiler::Symbols::SymbolPtr
operator+(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolPtr);

Erable::Compiler::Symbols::SymbolPtr operator<<(Erable::Compiler::Symbols::SymbolPtr, std::string tag);

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::RulePtr, Erable::Compiler::Symbols::SymbolPtr);

Erable::Compiler::Symbols::SymbolPtr operator>=(Erable::Compiler::Symbols::SymbolPtr, std::string name);

Erable::Compiler::Symbols::SymbolPtr operator!(Erable::Compiler::Symbols::RulePtr);*/
namespace Erable::Compiler::Symbols {
	enum class SymbolType;
	struct Symbol;
	struct CombineSymbol;
	typedef std::shared_ptr<Symbol> SymbolPtr;
	typedef std::shared_ptr<CombineSymbol> CombineSymbolPtr;
	typedef std::vector<SymbolPtr> SymbolList;
	typedef std::vector<SymbolPtr> TokenSymbolList;
	typedef std::unordered_set<SymbolPtr> SymbolSet;
	typedef std::unordered_set<SymbolPtr> LookaheadSet;
}

Erable::Compiler::Symbols::SymbolPtr operator "" _rule(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr operator "" _token(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr
operator+(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolPtr);

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolList);

#include <vector>
#include <deque>

namespace Erable::Compiler::Data {
	struct ProcessedData;

	typedef std::vector<ProcessedData> DataList;

	typedef std::deque<ProcessedData> DataDeque;
}
/*namespace Erable::Compiler {
	class Old_Parser;
}*/
namespace Erable::Compiler {
	struct Token {
		std::string name, data;

		const std::string &getName() const;

		void setName(const std::string &name);

		const std::string &getData() const;

		void setData(const std::string &data);

		friend std::ostream &operator<<(std::ostream &os, const Token &token);

	};

	class TokenElement;

	class PlainTokenElement;

	class Tokens;

	typedef std::vector<Token> TokenList;
}

namespace Erable::Compiler::Parser {
	enum class ActionType;

	struct Action;

	struct IterationNode;

	class RuleIteration;

	class ParseTable;

	typedef std::unordered_set<IterationNode *> IterationNodeSet;
}
#endif //ERABLELANG_HEADERS_HPP
