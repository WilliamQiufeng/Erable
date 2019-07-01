#include <utility>

//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Old_Parser.hpp"
#include "Old_Syntax.hpp"

namespace Erable::Compiler {
	Old_Parser::Old_Parser(TokenList inputTokens) : inputTokens(std::move(inputTokens)) {}

	Old_Parser::Old_Parser(Old_Parser *parent, TokenList inputTokens)
			: parent(parent), inputTokens(std::move(inputTokens)) {}

	Data::ProcessedData Old_Parser::read() {
		if (this->forwardData.isNull) {
			auto tkn(this->inputTokens.front());
			this->inputTokens.erase(inputTokens.begin());
			return Data::ProcessedData(tkn);
		} else {
			auto forward(this->forwardData);
			this->forwardData = Data::ProcessedData();
			return forward;
		}
	}

	Data::ProcessedData Old_Parser::forward() {
		return this->forwardData = read();
	}

	bool Old_Parser::isSubparser() {
		return parent != nullptr;
	}

	/*
	 *
	 */
	Data::ProcessedData Old_Parser::parseRule(Symbols::SymbolPtr root, TokenList &tokenList) {
		Symbols::SyntaxList available = scanAvailable(std::move(root));
		Symbols::SyntaxList lastAvail;
		if (!stack.empty()) {
			if (available.empty()) {
				auto elem = stack[0];
				return elem;
			}
		}
		while (!available.empty()) {
			//Push a token into a copied stack
			auto newStack = stack;
			newStack.emplace_back(Data::ProcessedData{tokenList.front()});
			//Update available rules
			available = lastAvail;
			lastAvail = updateAvailable(available);
			//Remove the front token if there are still available rules
			if (!lastAvail.empty()) {
				tokenList.erase(tokenList.begin());
			}
		}

		Symbols::SymbolPtr certain;
		for (auto &syntax : available) {
			if (syntax->matchesAll(stack)) {
				certain = syntax;
			}
		}
		if (certain == nullptr) {
			Old_Parser parser(this, inputTokens);
		}
		return Data::ProcessedData();
	}

	Symbols::SyntaxList Old_Parser::scanAvailable(Symbols::SymbolPtr) {

		return Erable::Compiler::Symbols::SyntaxList();
	}

	Symbols::SyntaxList Old_Parser::updateAvailable(Symbols::SyntaxList syntaxList) {
		return Erable::Compiler::Symbols::SyntaxList();
	}
}
