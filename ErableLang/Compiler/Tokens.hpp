//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_TOKENS_HPP
#define ERABLELANG_TOKENS_HPP

namespace Erable::Compiler {
    struct Token;
    class TokenElement;
    class PlainTokenElement;
    class Tokens;
}

#include <Utils.h>
#include "Lexer.hpp"

namespace Erable::Compiler {
    struct Token {
        std::string name, data;

        const std::string &getName() const;

        void setName(const std::string &name);

        const std::string &getData() const;

        void setData(const std::string &data);

    };
    class TokenElement{
    protected:
        Lexer* lexer;
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

        TokenElement(const std::string &name, std::string match, Lexer *lexer);

        void setLexer(Lexer* lexer);

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
        bool finish;
        std::string start, end;
    public:
        bool check(std::string) override;

        void clear() override;

        bool finished() override;

        RegexTokenElement(const std::string &name, const std::string &match, std::string start = "",
                          std::string end = "");

    };

    class Tokens_t {
    public:
        std::vector<TokenElement *> tokens;

        void generateTokenList();

        void initialize(Lexer *lexer);
    };

    inline Tokens_t Tokens;
}


#endif //ERABLELANG_TOKENS_HPP
