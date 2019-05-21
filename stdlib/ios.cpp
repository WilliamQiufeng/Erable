/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "ios.hpp"

namespace Erable {
    namespace Native {
	namespace BuiltIn {

	    DEFINE_NATIVE_FUNCTION(print) {
		Types::Instance* toP = argv->getAValue<Types::Array::arrtype>().at(0);
		std::cout << toP << std::endl;
		return nullptr;
	    };

	    DEFINE_NATIVE_FUNCTION(scan) {
		std::string get;
		std::cin>>get;
		Types::Instance* ret = new Types::String(get, self->getRetId(), desc);
		return ret;
	    };
	}
    }
}