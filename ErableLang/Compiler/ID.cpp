//
// Created by Qiufeng54321 on 2019-06-23.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "ID.hpp"

Erable::Compiler::AST::ID::ID(unsigned int idType, int id) : idType(idType), id(id), from(0) {}

Erable::Compiler::AST::ID::ID(unsigned int idType, int id, int from) : idType(idType), id(id),
																	   from(from) {}

std::ostream &Erable::Compiler::AST::operator<<(std::ostream &os, const Erable::Compiler::AST::ID &id) {
	if ((id.idType & LABEL) != 0)
		os << "Label";
	else if ((id.idType & EXTERNAL) != 0) //Detects if the type shows the id is external
		os << "External ";
	else
		os << "Internal ";
	if ((id.idType & INTERNAL_CID) != 0) {
		os << "C";
	}
	os << "ID{";
	os << id.id << " from module " << id.from << "}";
	return os;
}

Erable::Compiler::AST::ID Erable::Compiler::AST::make_id() {
	return Erable::Compiler::AST::ID(INTERNAL_ID, currentId++);
}

Erable::Compiler::AST::ID Erable::Compiler::AST::make_cid() {
	return Erable::Compiler::AST::ID(INTERNAL_CID, currentCid++);
}

Erable::Compiler::AST::ID Erable::Compiler::AST::make_label() {
	return Erable::Compiler::AST::ID(LABEL, currentLabelID++);
}
