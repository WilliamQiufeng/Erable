//
// Created by Qiufeng54321 on 2019-06-21.
// Copyright (c) Qiufeng54321 All rights reserved.
//
//#include "catch.hpp"

#define CATCH_CONFIG_MAIN

#include "AST.hpp"
#include <catch2/catch.hpp>

using namespace Erable::Compiler;

TEST_CASE("Name Construct", "[name][construct]") {
    AST::NameNode defaultNS({AST::NameType::NAMESPACE, "__default"})
    , NS2{AST::NameType::NAMESPACE, "__anonymous0"}
    , block1{AST::NameType::BLOCK, "0"}
    , block2{AST::NameType::BLOCK, "1"}
    , value1{AST::NameType::VALUE, "thereIsACatMeowingAsYouWish"}
    , value2{AST::NameType::VALUE, "coooool"}
    , value3{AST::NameType::VALUE, "NaN"}
    , typeInt{AST::NameType::TYPE, "int"};

    SECTION("Basic Root Name Construction") {
        auto nameToStr = defaultNS.toString();
        REQUIRE(nameToStr == ":__default");
        std::cout << nameToStr << std::endl;
    }SECTION("Name Construction in Tree") {
        /*
         * Something like:
         * namespace __default{
         *      {
         *          struct int occupies 32;
         *          var thereIsACatMeowingAsYouWish = 0;
         *      }
         *      var coooool = 1;
         * }
         */
        auto *newTree = AST::tree.add(block1);
        newTree->add(typeInt);
        newTree->add(value1);
        auto *NSTree = newTree->add(NS2);
        NSTree->add(value3);
        auto *blockTree = AST::tree.add(block2);
        blockTree->add(value2);
    }SECTION("Finding in Tree") {
        auto *nameTreePtr = AST::tree.find(AST::Name{{defaultNS, block1, value1}});
        auto nameTreeToStr = nameTreePtr->getName();
        std::cout << std::string(nameTreeToStr) << std::endl;
        REQUIRE(std::string(nameTreeToStr) == ":__default>0#thereIsACatMeowingAsYouWish");
    }SECTION("Finding with scope") {
        auto *NS2Tree = AST::tree.find(AST::Name{{defaultNS, block1, NS2, value3}});
        auto *foundBlock2 = NS2Tree->findWithScope(block2);
        auto foundBlock2Name = foundBlock2->getName();
        REQUIRE(std::string(foundBlock2Name) == ":__default>1");
        auto *foundValue2 = NS2Tree->findWithScope(value2);
        REQUIRE(foundValue2 == nullptr);
    }
}

