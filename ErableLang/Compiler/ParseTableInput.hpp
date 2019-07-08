//
// Created by Qiufeng54321 on 2019-07-06.
//

#ifndef ERABLELANG_PARSETABLEINPUT_HPP
#define ERABLELANG_PARSETABLEINPUT_HPP

#include "Headers.hpp"

namespace Erable::Compiler::Syntax::IO {
	class ParseTableInput {
		std::ifstream in;
	public:
		ParseTableInput();

		explicit ParseTableInput(std::string);

		Parser::ParseTable readTable();
	};
}

#endif //ERABLELANG_PARSETABLEINPUT_HPP
