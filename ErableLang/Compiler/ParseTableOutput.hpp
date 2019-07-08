//
// Created by Qiufeng54321 on 2019-07-06.
//

#ifndef ERABLELANG_PARSETABLEOUTPUT_HPP
#define ERABLELANG_PARSETABLEOUTPUT_HPP

#include "Headers.hpp"

namespace Erable::Compiler::Syntax::IO {
	class ParseTableOutput {
		std::ofstream out;
	public:
		ParseTableOutput(std::string path);

		ParseTableOutput();

		void writeAll(Parser::ParseTable &);

		void write(Parser::ParseTable &);

		void close();
	};
}

#endif //ERABLELANG_PARSETABLEOUTPUT_HPP
