#include <iostream>
#include "ParseTable.hpp"
#include "Lexer.hpp"
#include "Symbols.hpp"
#include "Syntax.hpp"

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
    return 0;
}
