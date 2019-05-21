/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "StdLibs.hpp"

void load() {
    ADD_NATIVE(print, Erable::Native::BuiltIn::print);
    ADD_NATIVE(scan, Erable::Native::BuiltIn::scan);
    ADD_NATIVE(log, Erable::Native::BuiltIn::log);
    ADD_NATIVE(sqrt, Erable::Native::BuiltIn::sqrt);
}