//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Syntax.hpp"
#include "Symbols.hpp"
#include <iostream>

namespace Erable::Compiler::Syntax {

	void initSyntax() {
		auto A = "A"_container;
		auto S = "S"_container;
		S = S
			| (-A + -A);
		A = A | ("a"_token + -A)
			| ("b"_token);
		auto front = A->getFront();
		for (auto &item : front) {
			std::cout << item->toString() << " ";
		}
		std::cout << std::endl;
		Syntax::root = Syntax::root | S;
	}
}