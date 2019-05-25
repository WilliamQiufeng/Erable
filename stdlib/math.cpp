/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "math.hpp"
#include <cmath>
#include <algorithm>

namespace Erable {
    namespace Native {
	namespace BuiltIn {

	    DEFINE_NATIVE_FUNCTION(sqrt) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return sqrt(atof(val));
	    }

	    DEFINE_NATIVE_FUNCTION(log) {
			Types::Instance* val = argv->getAValue<Types::Array::arrtype>().at(0);
			return log(atof(val));
	    }
	}
    }
}