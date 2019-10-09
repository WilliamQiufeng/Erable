#include <iostream>
#include "Headers.hpp"
#include "Parser/ParseTable.hpp"
#include "Lexer/Lexer.hpp"
#include "Lexer/Symbols.hpp"
#include "Syntax.hpp"
#include "Parser/.IntList.hpp"

void testList() {
//	using namespace Erable;
//	Erable::Utils::IntList intList;
//	intList.push(2);
//	intList.push(3);
//	intList.push(4);
//	intList.erase(intList.end());
//	intList.erase(intList.begin());
//	for(int i : intList) {
//		std::cout << i << std::endl;
//	}
}

void test() {
	testList();
}

int main(int argc, char *argv[]) {
    using namespace Erable::Compiler;
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
	Parser::ParseTable parseTable(ruleIteration);
	parseTable.generateTable();
	std::cout << parseTable << std::endl;

	test();
    return 0;
}
