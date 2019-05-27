#include <iostream>
#include "IO.hpp"
#include "Lexer.hpp"

int main(int argc, char* argv[]) {
    using namespace Erable::Compiler;
    Lexer lexer = Lexer(Erable::IO::InputStream("/williamye/program/antlr/erable/ErableLang/tests/lex.erable"));
    lexer.lex();
    for (auto token : lexer.getTokens()) {
        std::cout << "Token " << token.name << "[" << token.data << "]" << std::endl;
    }
    return 0;
}
