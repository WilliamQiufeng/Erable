//
// Created by jessie zhang on 2019-05-23.
//

#ifndef ERABLEVM_IOS_HPP
#define ERABLEVM_IOS_HPP

#include "VM/Descriptor.hpp"
#include "VM/VMGlobal.hpp"

namespace Erable::Native::BuiltIn {
    DEFINE_NATIVE_FUNCTION(print);

    DEFINE_NATIVE_FUNCTION(scan);
	
	DEFINE_NATIVE_FUNCTION(println);
}


#endif //ERABLEVM_IOS_HPP
