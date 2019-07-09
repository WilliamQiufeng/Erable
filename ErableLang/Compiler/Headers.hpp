//
// Created by Qiufeng54321 on 2019-06-23.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_HEADERS_HPP
#define ERABLELANG_HEADERS_HPP

#include <string>
#include <memory>
#include <unordered_set>
#include <unordered_map>
#include <set>
#include <vector>
#include <deque>
#include <fstream>

namespace Erable {
	namespace Compiler {
		namespace Symbols {
			enum class SymbolType;
			struct Symbol;
			struct CombineSymbol;
			typedef std::shared_ptr<Symbol> SymbolPtr;
			typedef std::shared_ptr<CombineSymbol> CombineSymbolPtr;
			typedef std::vector<SymbolPtr> SymbolList;
			typedef std::vector<SymbolPtr> TokenSymbolList;
			typedef std::unordered_set<SymbolPtr> SymbolSet;
			typedef SymbolSet LookaheadSet;
		}
		namespace Data {
			struct ProcessedData;

			typedef std::vector<ProcessedData> DataList;

			typedef std::deque<ProcessedData> DataDeque;
		}
		namespace Parser {
			enum class ActionType;

			struct Action;

			struct IterationNode;

			class RuleIteration;

			class ParseTable;

			typedef std::unordered_set<IterationNode *> IterationNodeSet;
		}
		namespace Syntax {
			namespace IO {
				struct Symbol {
					bool isRule;
					std::string name;
				};
				struct MetaData {
					int major, minor;
				};
				struct Action;
			}
		}
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
	inline int UNKNOWN = -1;
}

Erable::Compiler::Symbols::SymbolPtr operator "" _rule(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr operator "" _token(const char *, std::size_t);

Erable::Compiler::Symbols::SymbolPtr
operator+(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolPtr);

Erable::Compiler::Symbols::SymbolPtr
operator-(Erable::Compiler::Symbols::SymbolPtr, Erable::Compiler::Symbols::SymbolList);



#endif //ERABLELANG_HEADERS_HPP
