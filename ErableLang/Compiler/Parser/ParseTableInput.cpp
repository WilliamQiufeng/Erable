//
// Created by Qiufeng54321 on 2019-07-06.
//

#include "ParseTableInput.hpp"

Erable::Compiler::Syntax::IO::ParseTableInput::ParseTableInput() : ParseTableInput(ERABLE_PARSE_TABLE_PATH) {}

Erable::Compiler::Syntax::IO::ParseTableInput::ParseTableInput(std::string path) {
	in = std::ifstream(path, std::ios::in | std::ios::binary);
}
