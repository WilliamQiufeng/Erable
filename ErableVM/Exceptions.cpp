//
// Created by jessie zhang on 2019-05-23.
//
#include "Exceptions.hpp"

namespace Erable::Exceptions {
    void Exception::throwException() {
        throw (*this);
    }
}
