#include <utility>

#include <utility>

//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include <regex>
#include <utility>
#include "Tokens.hpp"

namespace Erable::Compiler {

    void Tokens_t::generateTokenList() {
        if (tokens.empty()) {

            tokens.push_back(new PlainTokenElement("IF", "if"));
            tokens.push_back(new PlainTokenElement("WHILE", "while"));
            tokens.push_back(new PlainTokenElement("LEFT_BRACKET", "("));
            tokens.push_back(new PlainTokenElement("RIGHT_BRACKET", ")"));
            tokens.push_back(new MultipleRegexTokenElement("HEX", {"0.*", "0x.*", "0x[0-9a-f]+"}));
            tokens.push_back(new RegexTokenElement("BIN", "0b[01]+"));
            tokens.push_back(new RegexTokenElement("OCT", "0o[0-8]+"));
            tokens.push_back(new MultipleRegexTokenElement("DOUBLE", {"\\d+.*", "\\d+\\..*", R"(\d+\.\d*)"}));
            tokens.push_back(new RegexTokenElement("INT", "\\d+"));
            tokens.push_back(new MultipleRegexTokenElement("STRING", {"\".*", "\".*", R"(".*")"}));
            tokens.push_back(new MultipleRegexTokenElement("LINE_COMMENT", {"/.*", "//.*", "//.*?"}));
            tokens.push_back(new RegexTokenElement("NAME", "[a-zA-Z_$][a-zA-Z0-9_$]*"));


        }
    }

    bool regex_token_check(std::string match, const std::string &str) {
        std::regex reg(match, std::regex_constants::ECMAScript | std::regex_constants::icase);
        bool pass = std::regex_match(str, reg);
        return pass;
    }

    void Tokens_t::initialize(Erable::Compiler::Lexer *lexer) {
        for (auto element : tokens) {
            element->setLexer(lexer);
            element->clear();
        }
    }

    void TokenElement::setMatch(const std::string &match) {
        TokenElement::match = match;
    }

    TokenElement::TokenElement(const std::string &name, std::string match, Lexer *lexer = nullptr) : lexer(lexer),
                                                                                                     name(name),
                                                                                                     match(std::move(
                                                                                                             match)) {
        this->buffer.name = name;
    }

    bool PlainTokenElement::check(std::string curdata) {
        return match.find(curdata) == 0;
    }

    PlainTokenElement::PlainTokenElement(const std::string &name, const std::string &match) : TokenElement(name,
                                                                                                           match) {}

    RegexTokenElement::RegexTokenElement(const std::string &name, const std::string &match) : TokenElement(name,
                                                                                                           match) {}

    bool RegexTokenElement::check(std::string curdata) {
        return regex_token_check(match, curdata);
    }

    bool RegexTokenElement::finished() {
        //valid();//Use this twice.
        bool ret = !(this->valid()) && !this->getBuffer().getData().empty();// && !buffer.data.empty();
        return ret;
    }

    MultipleRegexTokenElement::MultipleRegexTokenElement(const std::string &name, std::vector<std::string> regexes)
            : TokenElement(name, ""), regexes(std::move(regexes)) {}

    int MultipleRegexTokenElement::countValid(const std::string &string) {
        ind = -1;
        for (const auto &reg : this->regexes) {
            if (regex_token_check(reg, string)) {
                ind++;
            }
        }
        return ind;
    }

    bool MultipleRegexTokenElement::check(std::string string) {
        return countValid(string) > -1;
    }

    bool MultipleRegexTokenElement::finished() {
        return !valid() and countValid(buffer.getData()) == regexes.size() - 1 and not buffer.getData().empty();
    }

}

namespace Erable::Compiler {
    void TokenElement::setLexer(Erable::Compiler::Lexer *lexer) {
        this->lexer = lexer;
    }

    bool TokenElement::check(std::string) {
        return false;
    }

    bool TokenElement::valid() {
        return check(buffer.getData() + lexer->forward());
    }

    bool TokenElement::consume() {
        while (valid()) {
            consumeOne(lexer->read());
        }
        return allValid();
    }

    bool TokenElement::allValid() {
        return check(buffer.getData());
    }

    bool TokenElement::finished() {
        return buffer.data == match;
    }

    void TokenElement::consumeOne(char c) {
        this->buffer.data.push_back(c);
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
}


namespace Erable::Compiler {
    const std::string &Token::getName() const {
        return name;
    }

    void Token::setName(const std::string &name) {
        Token::name = name;
    }

    const std::string &Token::getData() const {
        return data;
    }

    void Token::setData(const std::string &data) {
        Token::data = data;
    }
}