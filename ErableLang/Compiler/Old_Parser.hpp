//
// Created by Qiufeng54321 on 2019-06-06.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_PARSER_HPP
#define ERABLECOMPILER_PARSER_HPP


#include "Headers.hpp"
#include "ProcessedData.hpp"
#include <deque>
#include <vector>
#include <string>

namespace Erable::Compiler {
	class Old_Parser {
		Old_Parser *parent = nullptr;
		Data::ProcessedData lastParsed;
		Data::DataDeque stack;
	public:
		explicit Old_Parser(Erable::Compiler::TokenList inputTokens);

		Old_Parser(Erable::Compiler::Old_Parser *parent, Erable::Compiler::TokenList inputTokens);


		TokenList inputTokens;

		Data::DataList dataList;

		Data::ProcessedData forwardData;

		Data::ProcessedData read();

		Data::ProcessedData forward();

		Data::ProcessedData parseRule(Symbols::SymbolPtr, TokenList &);

		static Symbols::SyntaxList scanAvailable(Symbols::SymbolPtr);

		static Symbols::SyntaxList updateAvailable(Symbols::SyntaxList);

		bool isSubparser();
	};
}

#endif //ERABLECOMPILER_PARSER_HPP
