//
// Created by Qiufeng54321 on 2019-06-23.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_ID_HPP
#define ERABLELANG_ID_HPP

#include <ostream>

namespace Erable::Compiler::AST {
	enum IDType {
		INTERNAL_ID = 0b00,
		INTERNAL_CID = 0b01,
		EXTERNAL = 0b10,
		LABEL = 0b100
	};

	struct ID {
		unsigned int idType : 3;
		int id;
		int from;

		ID(unsigned int idType, int id);

		ID(unsigned int idType, int id, int from);

		friend std::ostream &operator<<(std::ostream &os, const ID &id);
	};

	inline int currentId = 0;
	inline int currentCid = 0;
	inline int currentLabelID = 0;

	ID make_id();

	ID make_cid();

	ID make_label();
}

#endif //ERABLELANG_ID_HPP
