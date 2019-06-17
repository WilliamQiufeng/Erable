//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#pragma once
#ifndef ERABLELANG_TOKENS_HPP
#define ERABLELANG_TOKENS_HPP

#include <vector>

namespace Erable::Compiler {
    struct Token;

    class TokenElement;

    class PlainTokenElement;

    class Tokens;

    typedef std::vector<Token> TokenList;
}

#include <Utils.h>
#include <ostream>
#include "Lexer.hpp"

namespace Erable::Compiler {
    struct Token {
        std::string name, data;

        const std::string &getName() const;

        void setName(const std::string &name);

        const std::string &getData() const;

        void setData(const std::string &data);

        friend std::ostream &operator<<(std::ostream &os, const Token &token);

    };

    class TokenElement {
    protected:
        Lexer *lexer;
        Token buffer;
        std::string name;
        std::string match;
    public:
        virtual bool check(std::string);

        virtual bool valid();

        virtual bool allValid();

        virtual bool finished();

        virtual void consumeOne(char);

        virtual bool consume();

        virtual void clear();

        virtual void finish();

        TokenElement(const std::string &name, std::string match, Lexer *lexer);

        void setLexer(Lexer *lexer);

        Lexer *getLexer() const;

        const Token &getBuffer() const;

        void setBuffer(const Token &buffer);

        const std::string &getName() const;

        void setName(const std::string &name);

        const std::string &getMatch() const;

        void setMatch(const std::string &match);
    };

    class PlainTokenElement : public TokenElement {
    public:
        bool check(std::string) override;

        PlainTokenElement(const std::string &name, const std::string &match);
    };

    class RegexTokenElement : public TokenElement {
    public:
        bool check(std::string) override;

        bool finished() override;

        RegexTokenElement(const std::string &name, const std::string &match);

    };

    class MultipleRegexTokenElement : public TokenElement {
        std::vector<std::string> regexes;
        int ind = -1;
        int max = -1;
    public:
        MultipleRegexTokenElement(const std::string &name, std::vector<std::string> regexes);

        bool check(std::string string) override;

        bool finished() override;

        int countValid(const std::string &string);

    };

    class BlockCommentTokenElement : public TokenElement {
    public:
        BlockCommentTokenElement();

        bool check(std::string string) override;

        bool finished() override;
    };

    class StringTokenElement : public TokenElement {
        bool escape = false;
        char type = '\0';
        int ind = 0;
        char unicode = 0;
        static constexpr char UNICODE = 'u';
        static std::vector<char> hexes;
    public:
        StringTokenElement();

        bool check(std::string string) override;

        void consumeOne(char i) override;

        bool finished() override;

        void finish() override;

        void resetEscape(char c);

        void resetEscapes();
    };

    /*
     * TODO:
     *      when lexing '0b11' (on lex.erable), the result splits into two tokens: 'BIN[0b]', 'DEC[11]',
     *      but the expected behavior is to produce only one token: 'BIN[0b11]'.
     *      The reason why it happens has not been cleared yet so it is currently put on the highest priority
     *      of all TODOs.
     */
    class NumberTokenElement : public TokenElement {
        int radix = 10;
        static std::vector<char> digits;
    public:
        NumberTokenElement();

        void clear() override;

        bool check(std::string string) override;

        bool finished() override;

        void consumeOne(char i) override;

        void finish() override;
    };

    class Tokens_t {
    public:
        std::vector<TokenElement *> tokens;

        void generateTokenList();

        void initialize(Lexer *lexer);
    };

    inline Tokens_t Tokens;

}

std::ostream &Erable::Compiler::operator<<(std::ostream &os, const Erable::Compiler::Token &token);

#endif //ERABLELANG_TOKENS_HPP
