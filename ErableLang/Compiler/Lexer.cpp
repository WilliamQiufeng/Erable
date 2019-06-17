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
            finalChar = forceRead();
        } else {
            finalChar = forwards.front();
            forwards.erase(forwards.begin());
        }
        return finalChar;
    }

    char Lexer::forceRead() {
        char finalChar = in.get();
        if (finalChar == '\n') {
            line++;
            column = 0;
        } else {
            column++;
        }
        buffer += finalChar;
        return finalChar;
    }

    char Lexer::forward() {
        return forward(1);
    }

    char Lexer::forward(int i) {
        int actual = i - forwards.size();
        //input:    abcde
        //forward:  3 => c -> a,b,c
        //forward:  4 => d -> a,b,c,d
        //forward:  2 => b -> a,b,c,d
        if (actual < 0) {
            return forwards[(-actual) - 1];
        } else if (actual == 0) {
            return forwards[forwards.size() - 1];
        }
        char finalChar = EOF;
        for (int j = 0; j < actual; j++) {
            finalChar = forceRead();
            forwards.push_back(finalChar);
        }
        return finalChar;
    }

    bool Lexer::readToken() {
        clearWS();
        reset();
        std::vector<TokenElement *> finisheds;
        while (true) {
            bool oneValid = false;//If one token is valid, set it to true
            char forw = forward();
            for (auto st = available.begin(); st != available.end();) {
                auto tk = *st;
                //std::cout<<(int)forw << " '" << forw << "'"<<std::endl;\
                //If the token is still valid and the forword token is not EOF
                //  Consume the forword char
                //  set oneValid to true because it is valid
                //else if it is neither valid nor finished
                //  remove it
                if (tk->valid() and forw not_eq EOF) {
                    tk->consumeOne(forw);
                    oneValid = true;
                } else if (not tk->finished()) { //If it is neither valid nor finished
                    goto remove;
                }
                if (tk->finished() or forw == EOF) {
                    if (std::find(finisheds.begin(), finisheds.end(), tk) == finisheds.end()) {
                        finisheds.push_back(tk);
                        goto remove;
                    }
                }
                ++st;
                continue;

                remove:
                {
                    st = available.erase(st);
                    continue;
                }
            }
            //Break if no available tokens can be lexed
            if (!oneValid) {
                break;
            }
            //Finish read
            read();
        }
        if (finisheds.empty()) {
            if (forward() == EOF) return false;
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
        return forward() != EOF;
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
            if ((c != '\n' && c != '\r' && c != ' ') || c == EOF) {
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
            auto res = readToken();
            if (!res) break;
            std::cout << tokens[tokens.size() - 1] << " "/* << std::endl*/;
            if (tokens.size() == 146) {

            }
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