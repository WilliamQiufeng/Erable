#include <utility>

//
// Created by Qiufeng54321 on 2019-06-13.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "ProcessedData.hpp"
#include "Symbols.hpp"

Erable::Compiler::Data::ProcessedData::ProcessedData(Erable::Compiler::Symbols::SymbolPtr type,
                                                     Erable::Compiler::Data::DataList dataList) : type(std::move(type)),
                                                                                                  dataList(std::move(
                                                                                                          dataList)) {}

Erable::Compiler::Data::ProcessedData::ProcessedData(Erable::Compiler::Token token) : token(std::move(token)) {}

const Erable::Compiler::Symbols::SymbolPtr &Erable::Compiler::Data::ProcessedData::getType() const {
    return type;
}

void Erable::Compiler::Data::ProcessedData::setType(const Erable::Compiler::Symbols::SymbolPtr &type) {
    ProcessedData::type = type;
}

const Erable::Compiler::Data::DataList &Erable::Compiler::Data::ProcessedData::getDataList() const {
    return dataList;
}

void Erable::Compiler::Data::ProcessedData::setDataList(const Erable::Compiler::Data::DataList &dataList) {
    ProcessedData::dataList = dataList;
}

const Erable::Compiler::Token &Erable::Compiler::Data::ProcessedData::getToken() const {
    return token;
}

void Erable::Compiler::Data::ProcessedData::setToken(const Erable::Compiler::Token &token) {
    ProcessedData::token = token;
}

bool Erable::Compiler::Data::ProcessedData::isRule() {
    return this->type != nullptr;
}

std::string Erable::Compiler::Data::ProcessedData::getTag() {
    return isRule() ? this->type->tag : this->token.name;
}

Erable::Compiler::Data::ProcessedData::ProcessedData() : isNull(true) {}

bool Erable::Compiler::Data::ProcessedData::isExactly(const std::string &tag) {
	if (this->isRule()) {
		if (this->getType()->tag == tag) return true;
		if (this->getDataList().size() == 1) return this->dataList[0].isExactly(tag);
	} else {
		return this->getToken().getName() == tag;
	}
	return false;
}
