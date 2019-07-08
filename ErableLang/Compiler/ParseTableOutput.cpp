#include <utility>

//
// Created by Qiufeng54321 on 2019-07-06.
//

#include "ParseTableOutput.hpp"
#include "Symbols.hpp"
#include "Syntax.hpp"
#include "ParseTable.hpp"
#include "ParseTableIO.hpp"


Erable::Compiler::Syntax::IO::ParseTableOutput::ParseTableOutput(std::string path) {
	this->out = std::ofstream(std::move(path), std::ios::out | std::ios::binary);
}


void Erable::Compiler::Syntax::IO::ParseTableOutput::writeAll(Parser::ParseTable &parseTable) {
	MetaData metaData{ERABLE_MAJOR, ERABLE_MINOR};
	out.write((char *) &metaData, sizeof(metaData));
	this->write(parseTable);
	bool halt = true;
	out.write((char *) &halt, sizeof(halt));
}

void Erable::Compiler::Syntax::IO::ParseTableOutput::write(Erable::Compiler::Parser::ParseTable &parseTable) {
	std::unordered_map<std::string, int> idmap;
	int current_id = 0;
	int amount_of_symbols = Syntax::tokenList.size();
	out.write((char *) &amount_of_symbols, sizeof(amount_of_symbols));
	for (auto &sym : Syntax::tokenList) {
		idmap[sym->getTag()] = current_id++;
		Symbol symbol{sym->getType() == Symbols::SymbolType::RULE, sym->getTag()};
		out.write((char *) &symbol, sizeof(symbol));
	}
	int lineNum = 0;
	for (auto &line : parseTable.getParseTable()) {
		for (auto &pair : line) {
			bool nohalt = false;
			out.write((char *) &nohalt, sizeof(nohalt));
			int id = idmap[pair.first];
			Action action{lineNum, id, pair.second};
			out.write((char *) &action, sizeof(action));
		}
		lineNum++;
	}
}

void Erable::Compiler::Syntax::IO::ParseTableOutput::close() {
	out.close();
}

Erable::Compiler::Syntax::IO::ParseTableOutput::ParseTableOutput() : ParseTableOutput(ERABLE_PARSE_TABLE_PATH) {}
