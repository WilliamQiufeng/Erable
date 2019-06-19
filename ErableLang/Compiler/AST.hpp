//
// Created by Qiufeng54321 on 2019-06-19.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_AST_HPP
#define ERABLECOMPILER_AST_HPP

#include <string>
#include <vector>
#include <ostream>
#include "Parser.hpp"

namespace Erable::Compiler::AST {
    enum class NameType : char {
        NAMESPACE = ':',
        TYPE = '-',
        BLOCK = '>',
        VALUE = '#'
    };

    struct NameNode {
        NameType type;
        std::string name;

        bool operator==(const NameNode &rhs) const;

        bool operator!=(const NameNode &rhs) const;
    };

    class Name {
        std::vector<NameNode> nodes;
    public:
        explicit Name(std::vector<NameNode> nodes);

        Name(std::vector<NameNode> parent, NameNode node);

        const std::vector<NameNode> &getNodes() const;

        void setNodes(const std::vector<NameNode> &nodes);

        bool matchEnd(NameType type, std::string name);

        friend std::ostream &operator<<(std::ostream &os, const Name &name);

        explicit virtual operator std::string();

        bool operator==(const Name &rhs) const;

        bool operator!=(const Name &rhs) const;
    };

    class NameTree {
    protected:
        static int currentId;
        NameTree *parent{};
        std::vector<NameTree *> tree;
        Name name;
    public:
        NameTree *getParent() const;

        void setParent(NameTree *parent);

        int id;

        NameTree(std::vector<NameTree *> tree, Name name, NameTree *parent);

        NameTree(Name name, NameTree *parent);

        void add(NameTree *nameTree);

        void add(NameType type, std::string strName);

        NameTree *find(const Name &);

        NameTree *findWithScope(NameType type, std::string n);
    };

    inline extern NameTree tree;

    class ASTNode {
        Parser *parent;
    public:
        explicit ASTNode(Parser *parent);

        virtual void codegen(std::ostream) = 0;
    };
}

#endif //ERABLECOMPILER_AST_HPP
