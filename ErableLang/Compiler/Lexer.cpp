//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//
#include "Lexer.hpp"

namespace Erable::Compiler {
    Lexer::Lexer(const std::string &in) {
        this->in.open(in);
        this->reset();
    }

    char Lexer::read() {
        char finalChar;
        if (forwards.empty()) {
            finalChar = in.get();
            if (finalChar == '\n') {
                line++;
                column = 0;
            } else {
                column++;
            }
            buffer += finalChar;
        } else {
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
        std::vector<TokenElement *> finisheds;
        while (true) {
            if (forward() == EOF)break;
            bool oneValid = false;//If one token is valid, set it to true
            for (auto st = available.begin(); st != available.end();) {
                auto tk = *st;
                char forw = forward();
                bool remove = false;
                if (tk->valid() and forw not_eq EOF) {
                    tk->consumeOne(forw);
                    //std::cout<<"Consumed '" << tk->getBuffer().getData() << "' to " << tk->getName() << std::endl;
                    oneValid = true;
                } else if (not tk->finished()) {
                    //std::cout<<"Remove: '" << tk->getBuffer().getData() << "' to " << tk->getName() << std::endl;
                    remove = true;
                }
                if (tk->finished() or forw == EOF) {
                    if (std::find(finisheds.begin(), finisheds.end(), tk) == finisheds.end()) {
                        //std::cout<<"Finished '" << tk->getBuffer().getData() << "' to " << tk->getName() << std::endl;
                        finisheds.push_back(tk);
                        oneValid = true;
                        remove = true;
                    }
                }
                if (remove) {
                    st = available.erase(st);
                    continue;
                }
                ++st;
            }
            //Break if no available tokens can be lexed
            if (!oneValid) {
                break;
            }
            //Finish read
            read();
            /*//Remove all invalid elements.
            available.erase(std::remove_if(available.begin(), available.end(), [](TokenElement *x) -> bool {
                return !x->allValid();
            }), available.end());*/
        }
        if (finisheds.empty()) {
            std::stringstream ss;
            ss << "The token cannot be lexed: '"
               << buffer
               << "' at line "
               << line
               << " column "
               << column;
            throw std::runtime_error(ss.str());
        } else {
            int len = 0;
            int ind = Tokens.tokens.size() - 1;
            for (auto *tkn : finisheds) {
                auto iter = std::find(Tokens.tokens.begin(), Tokens.tokens.end(), tkn);
                if (iter != Tokens.tokens.end()) {
                    int nind = iter - Tokens.tokens.begin();
//                    Use priority
//                    if (nind < ind)ind = nind;
                    //Token with the most length is matched
                    int tknlen = tkn->getBuffer().getData().size();
                    if (tknlen > len) {
                        len = tknlen;
                        ind = nind;
                    }
                }
            }
            auto *tk = Tokens.tokens[ind];
            tk->finish();
            this->tokens.push_back(tk->getBuffer());
            this->reset();
        }
    }

    void Lexer::reset() {
        Tokens.generateTokenList();
        Tokens.initialize(this);
        available = std::vector<TokenElement *>(Tokens.tokens);
        buffer = "";
    }

    void Lexer::clearWS() {
        while (true) {
            char c = forward();
            if (c != '\n' && c != '\r' && c != ' ') {
                break;
            }
            read();
        }
    }

    void Lexer::cleanUp() {
        for (auto start = tokens.begin(); start != tokens.end();) {
            auto &name = start->getName();
            if (name == "COMMENT") {
                start = tokens.erase(start);
                continue;
            }
            start++;
        }
    }

    void Lexer::lex() {
        while (forward() != EOF) {
            readToken();
        }
        cleanUp();
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