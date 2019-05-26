//
// Created by tanpero
// Modified by Qiufeng54321
//

#include "Math.hpp"
#include <cmath>
#include <algorithm>

namespace Erable::Native::BuiltIn {

    DEFINE_NATIVE_FUNCTION(sqrt) {
        Types::Instance *val = argv->getAValue<Types::Array::arrtype>().at(0);
        auto res = new Types::Double(::sqrt(val->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

    DEFINE_NATIVE_FUNCTION(log) {
        Types::Instance *val = argv->getAValue<Types::Array::arrtype>().at(0);
        auto res = new Types::Double(::log(val->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

    DEFINE_NATIVE_FUNCTION(pow) {
        Types::Instance *a = argv->getAValue<Types::Array::arrtype>().at(0);
        Types::Instance *b = argv->getAValue<Types::Array::arrtype>().at(1);
        auto res = new Types::Double(::pow(a->getAValue<double>(), b->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

    DEFINE_NATIVE_FUNCTION(sin) {
        Types::Instance *val = argv->getAValue<Types::Array::arrtype>().at(0);
        auto res = new Types::Double(::sin(val->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

    DEFINE_NATIVE_FUNCTION(cos) {
        Types::Instance *val = argv->getAValue<Types::Array::arrtype>().at(0);
        auto res = new Types::Double(::cos(val->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

    DEFINE_NATIVE_FUNCTION(tan) {
        Types::Instance *val = argv->getAValue<Types::Array::arrtype>().at(0);
        auto res = new Types::Double(::tan(val->getAValue<double>()), self->getRetId(), desc);
        return res;
    }

}