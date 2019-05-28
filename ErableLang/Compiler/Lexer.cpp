//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Lexer.hpp"

namespace Erable::Compiler {
    Lexer::Lexer(std::string in) {
        this->in.open(in);
        this->reset();
    }
    char Lexer::read() {
        char finalChar;
        if(forwards.empty()) {
            finalChar = in.get();
        }else{
            finalChar = forwards.front();
            forwards.erase(forwards.begin());
        }
        return finalChar;
    }
    char Lexer::forward() {
        char finalChar = read();
        forwards.push_back(finalChar);
        return finalChar;
    }
    void Lexer::readToken() {
        clearWS();
        reset();
        if(available.size()==1) {
            auto last = available[0];
            bool allValid = last->consume();
            if (last->finished()) {
                this->tokens.push_back(last->getBuffer());
                this->reset();
            }
        }else {
            bool finished = false;
            while (!finished) {
                if (forward() == EOF)break;
                for (auto st = available.begin(); st != available.end();) {
                    auto tk = *st;
                    if (tk->valid()) {
                        tk->consumeOne(forward());
                    } else if (!tk->finished()) {
                        st = available.erase(st);
                        continue;
                    }
                    ++st;
                }

                //Finish read
                read();
                for (auto tk : available) {
                    if (tk->finished()) {
                        this->tokens.push_back(tk->getBuffer());
                        this->reset();
                        finished = true;
                        break;
                    }
                }

                /*//Remove all invalid elements.
                available.erase(std::remove_if(available.begin(), available.end(), [](TokenElement *x) -> bool {
                    return !x->allValid();
                }), available.end());*/
            }
        }
    }

    void Lexer::reset() {
        Tokens.generateTokenList();
        Tokens.initialize(this);
        available = std::vector<TokenElement *>(Tokens.tokens);
    }

    void Lexer::clearWS() {
        bool finished = false;
        while (!finished) {
            char c = forward();
            if (c != '\n' && c != '\r' && c != ' ') {
                finished = true;
                break;
            }
            read();
        }
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
}