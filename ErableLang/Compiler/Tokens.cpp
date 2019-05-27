//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include <regex>
#include "Tokens.hpp"

namespace Erable::Compiler {
    void Tokens::setLexer(Erable::Compiler::Lexer *lexer) {
        for(auto&[name, value] : this->vals.elements) {
            value->setLexer(lexer);
        }
    }
    void TokenElement::setLexer(Erable::Compiler::Lexer *lexer) {
        this->lexer=lexer;
    }
    bool TokenElement::valid() {
        return false;
    }
    bool TokenElement::consume() {
        while(valid()) {
            consumeOne(lexer->read());
        }
        return allValid();
    }

    Lexer *TokenElement::getLexer() const {
        return lexer;
    }

    const Token &TokenElement::getBuffer() const {
        return buffer;
    }

    void TokenElement::setBuffer(const Token &buffer) {
        TokenElement::buffer = buffer;
    }

    const std::string &TokenElement::getName() const {
        return name;
    }

    void TokenElement::setName(const std::string &name) {
        TokenElement::name = name;
    }

    const std::string &TokenElement::getMatch() const {
        return match;
    }

    void TokenElement::setMatch(const std::string &match) {
        TokenElement::match = match;
    }

    bool PlainTokenElement::valid() {
        char check = lexer->forward();
        std::string curdata(buffer.data);
        curdata+=check;
        std::regex regex(match);

    }
}