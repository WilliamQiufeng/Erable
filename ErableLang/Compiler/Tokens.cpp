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
        return Utils::StringUtils::startsWith(match, curdata);
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
                //std::cout<<string<<" matches regex /" << reg << "/yi" << std::endl;
                ind++;
            } else {
                break;
            }
        }
        if (ind > this->max)this->max = ind;
        return ind;
    }

    bool MultipleRegexTokenElement::check(std::string string) {
        int count = countValid(string);
        return count == max and count > -1;
    }

    bool MultipleRegexTokenElement::finished() {
        bool fin = !valid() and countValid(buffer.getData()) == regexes.size() - 1 and not buffer.getData().empty();
        return fin;
    }

    void StringRegexTokenElement::finish() {
        auto str = getBuffer().getData();
        this->buffer.setData(str.substr(1, str.size() - 2));
    }

    std::vector<char> StringRegexTokenElement::hexes{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    StringRegexTokenElement::StringRegexTokenElement()
            : TokenElement("STRING", "", nullptr) {}

    bool StringRegexTokenElement::check(std::string string) {
        return Utils::StringUtils::startsWith(string, "\"");
    }

    bool StringRegexTokenElement::finished() {
        if (getBuffer().getData().size() > 2) {
            bool cond = Utils::StringUtils::endsWith(getBuffer().getData(), "\"");
            return valid() and cond;
        }
        return false;
    }

    void StringRegexTokenElement::consumeOne(char i) {
        if (escape) {
            switch (type) {
                case UNICODE:
                    int index = Utils::ArrayUtils::indexOf(hexes, i);
                    unicode <<= 4;
                    unicode |= index;
                    ind++;
                    if (ind > 3) {
                        //std::cout<<unicode<<std::endl;
                        resetEscape(unicode);
                    }
                    return;
            }
            switch (i) {
                case 'n':
                    resetEscape('\n');
                    return;
                case 'r':
                    resetEscape('\r');
                    return;
                case 't':
                    resetEscape('\t');
                    return;
                case 'b':
                    resetEscape('\b');
                    return;
                case '\\':
                    resetEscape('\\');
                    return;
                case '"':
                    resetEscape('"');
                    return;
                case 'u':
                    type = UNICODE;
                    ind = 0;
                    unicode = 0;
                    escape = true;
                    return;
                default:
                    std::stringstream ss;
                    ss << "EscapeError: unknown escape code '"
                       << i
                       << "'";
                    throw std::runtime_error(ss.str());
            }
        } else if (i == '\\') {
            escape = true;
            return;
        } else {
            TokenElement::consumeOne(i);
        }
    }

    void StringRegexTokenElement::resetEscape(char c) {
        this->buffer.data.push_back(c);
        resetEscapes();
    }

    void StringRegexTokenElement::resetEscapes() {
        ind = 0;
        unicode = 0;
        escape = false;
        type = '\0';
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

    void TokenElement::finish() {
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


    //TOKENS HERE.......
    void Tokens_t::generateTokenList() {
        if (tokens.empty()) {
            tokens.push_back(new PlainTokenElement("IF", "if"));
            tokens.push_back(new PlainTokenElement("WHILE", "while"));
            tokens.push_back(new PlainTokenElement("LEFT_PAREN", "("));
            tokens.push_back(new PlainTokenElement("RIGHT_PAREN", ")"));
            tokens.push_back(new PlainTokenElement("LEFT_ARR", "["));
            tokens.push_back(new PlainTokenElement("RIGHT_ARR", "]"));
            tokens.push_back(new PlainTokenElement("START_SCOPE", "{"));
            tokens.push_back(new PlainTokenElement("END_SCOPE", "}"));
            tokens.push_back(new PlainTokenElement("COLON", ":"));
            tokens.push_back(new PlainTokenElement("SEMICOLON", ";"));
            tokens.push_back(new PlainTokenElement("DOT", "."));
            tokens.push_back(new PlainTokenElement("ACCESS", "::"));
            tokens.push_back(new PlainTokenElement("SET", "="));
            tokens.push_back(new PlainTokenElement("ADD", "+"));
            tokens.push_back(new PlainTokenElement("SUB", "-"));
            tokens.push_back(new PlainTokenElement("MUL", "*"));
            tokens.push_back(new PlainTokenElement("DIV", "/"));
            tokens.push_back(new PlainTokenElement("MOD", "%"));
            tokens.push_back(new PlainTokenElement("BIT_AND", "&"));
            tokens.push_back(new PlainTokenElement("BIT_OR", "|"));
            tokens.push_back(new PlainTokenElement("BIT_NOT", "~"));
            tokens.push_back(new PlainTokenElement("AND", "&&"));
            tokens.push_back(new PlainTokenElement("OR", "||"));
            tokens.push_back(new PlainTokenElement("NOT", "!"));
            tokens.push_back(new PlainTokenElement("LEFT_SHIFT", "<<"));
            tokens.push_back(new PlainTokenElement("RIGHT_SHIFT", ">>"));
            tokens.push_back(new PlainTokenElement("UNSIGNED_RIGHT_SHIFT", ">>>"));
            tokens.push_back(new PlainTokenElement("COMMA", ","));
            tokens.push_back(new PlainTokenElement("VAR", "var"));
            tokens.push_back(new PlainTokenElement("CONST", "const"));
            tokens.push_back(new PlainTokenElement("FUNCTION", "function"));
            tokens.push_back(new PlainTokenElement("CLASS", "class"));
            tokens.push_back(new PlainTokenElement("RETURN", "return"));
            tokens.push_back(new PlainTokenElement("CONTINUE", "continue"));
            tokens.push_back(new PlainTokenElement("BREAK", "break"));
            tokens.push_back(new MultipleRegexTokenElement("HEX", {"0.*", "0x.*", "0x[0-9a-f]+"}));
            tokens.push_back(new MultipleRegexTokenElement("BIN", {"0.*", "0b.*", "0b[01]+"}));
            tokens.push_back(new MultipleRegexTokenElement("OCT", {"0.*", "0o.*", "0o[0-8]+"}));
            tokens.push_back(new MultipleRegexTokenElement("DOUBLE", {"[0-9]+.*", "[0-9]+\\..*", "[0-9]+\\.[0-9]+"}));
            tokens.push_back(new RegexTokenElement("INT", "[0-9]+"));
            tokens.push_back(new StringRegexTokenElement());
            tokens.push_back(new MultipleRegexTokenElement("LINE_COMMENT", {"/.*", "//.*", "//.*?"}));
            tokens.push_back(new MultipleRegexTokenElement("BLOCK_COMMENT", {"/\\*.*", "/\\*.*\\*/"}));
            tokens.push_back(new RegexTokenElement("NAME", "[a-zA-Z_$][a-zA-Z0-9_$]*"));
        }
    }
}