//
// Created by Qiufeng54321 on 2019-07-12.
//

#ifndef ERABLELANG_PARSER_HPP
#define ERABLELANG_PARSER_HPP

#include <Lexer/Symbols.hpp>
#include "MultiStack.hpp"
#include "ParseTable.hpp"

namespace Erable::Compiler::Parser {
	struct NodeData {
		std::variant<Symbols::SymbolPtr, Token> type;
		std::vector<NodeData> subData;
		int state;

		explicit NodeData(const std::variant<Symbols::SymbolPtr, Token> &type = Symbols::EMPTY_PLACEHOLDER,
						  const std::vector<NodeData> &subData = {}, int state = 0);

		bool operator==(const NodeData &rhs) const;

		bool operator!=(const NodeData &rhs) const;
	};

	typedef NodeData MultiStackIntegralType;
	typedef Utils::MultiStack<MultiStackIntegralType> MultiStackType;
	//This is a GLR(1) Parser
	class Parser {
		typedef std::vector<Utils::MultiStackPath> IndexesType;
		MultiStackType multiStack;
		ParseTable parseTable;
		IndexesType indexes;

		void parse(TokenList tokenList);

		bool allError();

		void parseNext(Token token);

		bool isParsable(Token token);

		bool next(Utils::MultiStackPath path, Action action);
	};
}

#endif //ERABLELANG_PARSER_HPP
