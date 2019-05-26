//
// Created by jessie zhang on 2019-05-23.
//

#include "StdLib.hpp"

void loadNatives() {
    Erable::Native::Functions::functions["print"] = &Erable::Native::BuiltIn::print;
    Erable::Native::Functions::functions["scan"] = &Erable::Native::BuiltIn::scan;
	Erable::Native::Functions::functions["println"] = &Erable::Native::BuiltIn::println;
}