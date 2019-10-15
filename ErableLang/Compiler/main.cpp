#include <iostream>
#include "Headers.hpp"
#include "Parser/ParseTable.hpp"
#include "Parser/Parser.hpp"
#include "Lexer/Lexer.hpp"
#include "Lexer/Symbols.hpp"
#include "Syntax.hpp"
#include "Parser/.IntList.hpp"


using namespace Erable::Compiler;

Parser::ParseTable parseTable({});

void testParse() {
	TokenList tokenList{{"A", ""},
						{"A", ""},
						{"A", ""}};
	Parser::Parser parser(parseTable);
	parser.parse(tokenList);
}

void test() {
	testParse();
}

int main(int argc, char *argv[]) {
	Syntax::initSyntax();
    Lexer lexer = Lexer("/williamye/program/antlr/erable/ErableLang/tests/lex.erable");
    lexer.lex();
    /*for (const auto &token : lexer.getTokens()) {
        std::cout << "Token " << token.name << "[" << token.data << "]" << std::endl;
    }*/

	std::cout << Syntax::$syntaxListToString() << std::endl;
	Parser::RuleIteration ruleIteration;
	ruleIteration.generateFirstRound();
	ruleIteration.generate();
	std::cout << ruleIteration.rootNode << std::endl;
	parseTable = ruleIteration;
	parseTable.generateTable();
	std::cout << parseTable << std::endl;

	test();
    return 0;
}
