//
// Created by Qiufeng54321 on 2019-06-13.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLECOMPILER_PROCESSEDDATA_HPP
#define ERABLECOMPILER_PROCESSEDDATA_HPP

#include "Symbols.hpp"
#include "Tokens.hpp"

namespace Erable::Compiler::Data {
    class ProcessedData;

    typedef std::vector<ProcessedData> DataList;

    struct ProcessedData {
        Symbols::SymbolPtr type;
        DataList dataList;
        Token token;

        explicit ProcessedData(Token token);

        ProcessedData(Symbols::SymbolPtr type, DataList dataList);

        bool isRule();

        const Symbols::SymbolPtr &getType() const;

        void setType(const Symbols::SymbolPtr &type);

        const DataList &getDataList() const;

        void setDataList(const DataList &dataList);

        const Token &getToken() const;

        void setToken(const Token &token);
    };
}

#endif //ERABLECOMPILER_PROCESSEDDATA_HPP
