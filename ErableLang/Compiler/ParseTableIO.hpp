//
// Created by Qiufeng54321 on 2019-07-06.
//

#ifndef ERABLELANG_PARSETABLEIO_HPP
#define ERABLELANG_PARSETABLEIO_HPP

#include "Headers.hpp"
#include "ParseTable.hpp"

namespace Erable::Compiler::Syntax::IO {
	struct Action {
		int state;
		int columnID;
		Parser::Action action;
	};
}

#endif //ERABLELANG_PARSETABLEIO_HPP
