#include <iostream>
#include "Lexer.hpp"

int main(int argc, char* argv[]) {
    using namespace Erable::Compiler;
    Lexer lexer = Lexer("/williamye/program/antlr/erable/ErableLang/tests/lex.erable");
    lexer.lex();
    for (auto token : lexer.getTokens()) {
        std::cout << "Token " << token.name << "[" << token.data << "]" << std::endl;
    }
    return 0;
}
