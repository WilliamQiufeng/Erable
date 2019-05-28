#include <iostream>
#include "Lexer.hpp"

int main(int argc, char* argv[]) {
    using namespace Erable::Compiler;
	
#ifndef TANPERO_BUILD
	Lexer lexer = Lexer("/williamye/program/antlr/erable/ErableLang/tests/lex.erable");
#else
	Lexer lexer = Lexer("D:\lex.erable");
#endif

    lexer.lex();
    for (auto token : lexer.getTokens()) {
        std::cout << "Token " << token.name << "[" << token.data << "]" << std::endl;
    }
    return 0;
}
