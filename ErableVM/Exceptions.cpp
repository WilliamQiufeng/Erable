//
// Created by jessie zhang on 2019-05-23.
//
#include "Exceptions.hpp"

namespace Erable::Exceptions {
    void Exception::throwException() {
        std::cerr << this->__msg_ << std::endl;
        throw (*this);
    }
}
