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
		Symbols::SymbolPtr symbolPtr;
		Token token;
		std::vector<NodeData> subData;
		int state;

		explicit NodeData(Symbols::SymbolPtr type = Symbols::EMPTY_PLACEHOLDER,
						  std::vector<NodeData> subData = {}, int state = 0);

		explicit NodeData(Token type = Symbols::EOT_TOKEN,
						  std::vector<NodeData> subData = {}, int state = 0);

		std::string getTag();

		bool operator==(const NodeData &rhs) const;

		bool operator!=(const NodeData &rhs) const;
	};

	typedef NodeData MultiStackIntegralType;
	typedef Utils::MultiStack MultiStackType;
	//This is a GLR(1) Parser
	class Parser {
		typedef std::vector<Utils::MultiStackPath> IndexesType;
		MultiStackType multiStack;
		ParseTable parseTable;
		IndexesType indexes;

	public:
		explicit Parser(ParseTable parseTable);

		bool parse(TokenList tokenList);

		bool allError();

		IndexesType parseNext(Token token);

		bool isParsable(Token token);

		IndexesType next(Utils::MultiStackPath path, Action action, Token token);

		IndexesType doState(Utils::MultiStackPath &path, MultiStackType::NodeList &list, Token token, int state);

		IndexesType doReduce(Utils::MultiStackPath &path, MultiStackType::NodeList &list, int reduce);

		Utils::MultiStackPath findDuplicate(const NodeData &nodeData, Utils::MultiStackPath indexBuff = {0});
	};
}

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::NodeData nodeData);

std::ostream &operator<<(std::ostream &os, Erable::Compiler::Parser::MultiStackType multiStack);

#endif //ERABLELANG_PARSER_HPP
