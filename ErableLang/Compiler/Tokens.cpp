//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include <regex>
#include "Tokens.hpp"

namespace Erable::Compiler {

    void Tokens_t::generateTokenList() {
        if (!tokens.empty()) {
            tokens.push_back(new PlainTokenElement("IF", "if"));
        }
    }

    void Tokens_t::setLexer(Erable::Compiler::Lexer *lexer) {
        for (auto element : tokens) {
            element->setLexer(lexer);
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

    bool TokenElement::allValid() {
        return match.find(buffer.data) == 0;
    }

    bool TokenElement::finished() {
        return buffer.data == match;
    }

    void TokenElement::consumeOne(char c) {
        buffer.data.push_back(c);
    }

    void TokenElement::clear() {
        buffer.data.clear();
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

    TokenElement::TokenElement(Lexer *lexer, const std::string &name, const std::string &match) : lexer(lexer),
                                                                                                  name(name),
                                                                                                  match(match) {}

    TokenElement::TokenElement(const std::string &name, const std::string &match) : name(name), match(match) {}

    bool PlainTokenElement::valid() {
        char check = lexer->forward();
        std::string curdata(buffer.data);
        curdata+=check;
        return match.find(curdata) == 0;
    }

    PlainTokenElement::PlainTokenElement(const std::string &name, const std::string &match) : TokenElement(name,
                                                                                                           match) {}
}