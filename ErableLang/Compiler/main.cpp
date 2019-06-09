#include <iostream>
#include "Lexer.hpp"
#include "Parser.hpp"

int main(int argc, char* argv[]) {
    using namespace Erable::Compiler;
    Syntax::initSyntaxes();
    Lexer lexer = Lexer("/williamye/program/antlr/erable/ErableLang/tests/lex.erable");
    lexer.lex();
    for (const auto &token : lexer.getTokens()) {
        std::cout << "Token " << token.name << "[" << token.data << "]" << std::endl;
    }
    Parser parser;
    for (auto &i : Syntax::syntaxTree) {
        std::cout << i->toString() << std::endl;
    }
    return 0;
}
