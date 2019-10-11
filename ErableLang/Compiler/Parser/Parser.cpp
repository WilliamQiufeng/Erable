//
// Created by Qiufeng54321 on 2019-07-12.
//

#include "Parser.hpp"

#include <utility>

namespace Erable::Utils {
}

Erable::Compiler::Parser::NodeData::NodeData(const std::variant<Symbols::SymbolPtr, Token> &type,
											 const std::vector<NodeData> &subData, int state) : type(type),
																								subData(subData),
																								state(state) {}

bool Erable::Compiler::Parser::NodeData::operator==(const Erable::Compiler::Parser::NodeData &rhs) const {
	bool res = false;
	if (std::holds_alternative<Symbols::SymbolPtr>(type) and std::holds_alternative<Symbols::SymbolPtr>(rhs.type)) {
		res = std::get<Symbols::SymbolPtr>(type)->is(std::get<Symbols::SymbolPtr>(rhs.type));
	} else if (std::holds_alternative<Token>(type) and std::holds_alternative<Token>(rhs.type)) {
		res = std::get<Token>(type).getName() == std::get<Token>(rhs.type).getName();
	}
	return res;
}

bool Erable::Compiler::Parser::NodeData::operator!=(const Erable::Compiler::Parser::NodeData &rhs) const {
	return !(rhs == *this);
}

namespace Erable::Compiler::Parser {
	void Parser::parse(TokenList tokenList) {
		indexes.emplace_back();
		while (true) {
			if (allError()) break;
		}
	}

	bool Parser::allError() {
		return false;
	}

	//Take a token and do an action
	void Parser::parseNext(Token token) {
		IndexesType newIndexes;
		for (auto &indexI : indexes) {
			MultiStackIntegralType &&data = multiStack.get(indexI);
		}
	}

	bool Parser::isParsable(Token token) {
		return false;
	}

	/**
	 * Does an action
	 * @param path the stack path of this
	 * @param action the action to be done
	 * @return if the action has been applied successfully
	 */
	bool Parser::next(Utils::MultiStackPath path, Action action) {
		MultiStackType::NodeList nodes = multiStack.getList(std::move(path));
	}
}

