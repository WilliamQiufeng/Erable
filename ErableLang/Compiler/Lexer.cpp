//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Lexer.hpp"

namespace Erable::Compiler {
    Lexer::Lexer(Erable::IO::InputStream in) : in(in) {}
    char Lexer::read() {
        char final;
        if(forwards.empty()) {
            final = in.read();
        }else{
            final = forwards.front();
            forwards.erase(forwards.begin());
        }
        return final;
    }
    char Lexer::forward() {
        char final = read();
        forwards.push_back(final);
        return final;
    }
    void Lexer::readToken() {
        if(available.size()==1) {
            auto last = available[0];
            bool allValid = last->consume();
            if (last->finished()) {
                this->tokens.push_back(last->getBuffer());
                this->reset();
            }
        }else {
            for (auto tk : available) {
                if (tk->valid()) {
                    tk->consumeOne(forward());
                }
                if (tk->finished()) {
                    this->tokens.push_back(tk->getBuffer());
                    this->reset();
                    break;
                }
            }
            //Finish read
            read();
        }
        //Remove all invalid elements.
        available.erase(std::remove_if(available.begin(), available.end(), [](TokenElement* x)->bool {
            return !x->allValid();
        }), available.end());
    }

    void Lexer::reset() {
        Tokens.generateTokenList();
        available = Tokens.tokens;
    }

    void Lexer::lex() {
        while (forward() != EOF) {
            readToken();
        }
    }

    int Lexer::getLine() const {
        return line;
    }

    void Lexer::setLine(int line) {
        Lexer::line = line;
    }

    int Lexer::getColumn() const {
        return column;
    }

    void Lexer::setColumn(int column) {
        Lexer::column = column;
    }

    const std::vector<TokenElement *> &Lexer::getAvailable() const {
        return available;
    }

    void Lexer::setAvailable(const std::vector<TokenElement *> &available) {
        Lexer::available = available;
    }

    const std::vector<Token> &Lexer::getTokens() const {
        return tokens;
    }

    void Lexer::setTokens(const std::vector<Token> &tokens) {
        Lexer::tokens = tokens;
    }

    const std::vector<char> &Lexer::getForwards() const {
        return forwards;
    }

    void Lexer::setForwards(const std::vector<char> &forwards) {
        Lexer::forwards = forwards;
    }

    const IO::InputStream &Lexer::getIn() const {
        return in;
    }

    void Lexer::setIn(const IO::InputStream &in) {
        Lexer::in = in;
    }
}