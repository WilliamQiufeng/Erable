//
// Created by tanpero
// Made it compatible by Qiufeng54321
//

#ifndef ERABLESTDLIB_MATH_HPP
#define ERABLESTDLIB_MATH_HPP

#include "VM/Descriptor.hpp"
#include "VM/VMGlobal.hpp"

namespace Erable::Native::BuiltIn {
    DEFINE_NATIVE_FUNCTION(sqrt);

    DEFINE_NATIVE_FUNCTION(log);

    DEFINE_NATIVE_FUNCTION(pow);

    DEFINE_NATIVE_FUNCTION(sin);

    DEFINE_NATIVE_FUNCTION(cos);

    DEFINE_NATIVE_FUNCTION(tan);
}

#endif //ERABLESTDLIB_MATH_HPP
