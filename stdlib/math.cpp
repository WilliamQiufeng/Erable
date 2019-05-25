/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "math.hpp"
#include <cmath>
#include <algorithm>

namespace Erable {
    namespace Native::BuiltIn {

	    DEFINE_NATIVE_FUNCTION(sqrt) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return sqrt(val.getAValue<double>());
	    }

	    DEFINE_NATIVE_FUNCTION(log) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return log(val.getAValue<double>());
	    }
		
		DEFINE_NATIVE_FUNCTION(pow) {
			Types::Instance* a = argv->getAValue<Types::Array::arrtype>().at(0);
			Types::Instance* b = argv->getAValue<Types::Array::arrtype>().at(1);
			return pow(a.getAValue<double>(), b.getAValue<double>());
	    }
		
		DEFINE_NATIVE_FUNCTION(sin) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return sin(val.getAValue<double>());
		}
		
		DEFINE_NATIVE_FUNCTION(cos) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return cos(val.getAValue<double>());
		}
		
		DEFINE_NATIVE_FUNCTION(tan) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return tan(val.getAValue<double>());
		}

	}
}