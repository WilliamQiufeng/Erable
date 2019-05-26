//
// Created by Qiufeng54321 on 2019-05-23.
//

#include "StdLib.hpp"

void loadNatives() {
    using namespace Erable::Native;
    Functions::functions["print"] = &BuiltIn::print;
    Functions::functions["scan"] = &BuiltIn::scan;
    Functions::functions["println"] = &BuiltIn::println;
    Functions::functions["sqrt"] = &BuiltIn::sqrt;
    Functions::functions["log"] = &BuiltIn::log;
    Functions::functions["pow"] = &BuiltIn::pow;
    Functions::functions["sin"] = &BuiltIn::sin;
    Functions::functions["cos"] = &BuiltIn::cos;
    Functions::functions["tan"] = &BuiltIn::tan;

}