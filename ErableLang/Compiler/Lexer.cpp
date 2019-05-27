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
            bool allValid = available[0]->consume();
            if(available[0]->finished()) {
                this->tokens.push_back(tk->getBuffer());
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
}