/*
 * Copyright (C) 2019 Qiufeng54321
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/* 
 * File:   OpCodeTTest.cpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 上午10:00
 */

#include <cstdlib>
#include <string>
#include <iostream>
#include "OpCode.hpp"

using namespace std;
/*
 * Simple C++ Test Suite
 */

//Erable::OpCode_t::OpCode_t();

void testOpCode_t() {
    Erable::OpCode_t opCode_t;
    for (Erable::Utils::EnumElement<int> *ele : opCode_t.values().elements) {
        cout << ele->name << ":" << ele->value << endl;
    }
    /*if (true) {
        std::cout << "%TEST_FAILED% time=0 testname=testOpCode_t (OpCodeTTest) message=error message sample" << std::endl;
    }*/
}

//Erable::Utils::Enum<int> Erable::OpCode_t::values();

void testValues() {
    Erable::OpCode_t opCode_t;
    Erable::Utils::Enum<int> result = opCode_t.values();
    Erable::Utils::EnumElement<int> *find = result.find(2);
    if (!(find->value == 0 && find->name == "CP_INT") /*check result*/) {
        std::cout << "%TEST_FAILED% time=0 testname=testValues (OpCodeTTest) message=error message sample" << std::endl;
    }
}

//void Erable::OpCode_t::addEnum(string name, int element);

void testAddEnum() {
    string name;
    int element;
    Erable::OpCode_t opCode_t;
    opCode_t.addEnum(name, element);
    if (true /*check result*/) {
        std::cout << "%TEST_FAILED% time=0 testname=testAddEnum (OpCodeTTest) message=error message sample"
                  << std::endl;
    }
}

class A {
    int sth;
};

A a;

int main(int argc, char **argv) {
    std::cout << typeid(a).name() << "==" << typeid(A).name() << std::endl;
    std::cout << "%SUITE_STARTING% OpCodeTTest" << std::endl;
    std::cout << "%SUITE_STARTED%" << std::endl;

    std::cout << "%TEST_STARTED% testOpCode_t (OpCodeTTest)" << std::endl;
    testOpCode_t();
    std::cout << "%TEST_FINISHED% time=0 testOpCode_t (OpCodeTTest)" << std::endl;

    std::cout << "%TEST_STARTED% testValues (OpCodeTTest)" << std::endl;
    testValues();
    std::cout << "%TEST_FINISHED% time=0 testValues (OpCodeTTest)" << std::endl;

    std::cout << "%TEST_STARTED% testAddEnum (OpCodeTTest)" << std::endl;
    testAddEnum();
    std::cout << "%TEST_FINISHED% time=0 testAddEnum (OpCodeTTest)" << std::endl;

    std::cout << "%SUITE_FINISHED% time=0" << std::endl;

    return (EXIT_SUCCESS);
}

