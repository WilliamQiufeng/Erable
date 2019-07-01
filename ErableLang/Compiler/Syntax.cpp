//
// Created by Qiufeng54321 on 2019-07-01.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#include "Syntax.hpp"

namespace Erable::Compiler::Syntax {

	void initSyntax() {
		auto A = "A"_rule;
		auto S = "S"_rule;
		A = A
			| ("a"_token + A)
			| ("b"_token);
		S = S
			| (A + A);
		root = S;
	}
}