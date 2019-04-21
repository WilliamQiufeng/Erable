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
 * File:   OpCode.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 上午10:07
 */

#ifndef OPCODE_HPP
#define OPCODE_HPP

#include "Utils.h"

namespace Erable {
    class OpCodeElement{
    public:
        int argc;
        OpCodeElement(int argc){
            this->argc=argc;
        }
        
    };
    class OpCode_t {
    public:

        OpCode_t() {
            this->addEnum("CONSTANT_POOL", 0);
            this->addEnum("CP_NUM", 0);
            this->addEnum("CP_INT", 0);
            this->addEnum("CP_STR", 0);
            this->addEnum("ADD", 3);
            this->addEnum("SUB", 3);
            this->addEnum("MUL", 3);
            this->addEnum("DIV", 3);
            this->addEnum("MOD", 3);
            this->addEnum("POW", 3);
            this->addEnum("POS", 2);
            this->addEnum("NEG", 2);
            this->addEnum("ELEMENT", 3);
            this->addEnum("LS", 3);
            this->addEnum("RS", 3);
            this->addEnum("URS", 3);
            this->addEnum("LT", 3);
            this->addEnum("GT", 3);
            this->addEnum("LTE", 3);
            this->addEnum("GTE", 3);
            this->addEnum("EQ", 3);
            this->addEnum("NEQ", 3);
            this->addEnum("EQU", 3);
            this->addEnum("SWITCH", 3);
            this->addEnum("BNOT", 3);
            this->addEnum("BAND", 3);
            this->addEnum("BOR", 3);
            this->addEnum("BXOR", 3);
            this->addEnum("ADDEQ", 3);
            this->addEnum("SUBEQ", 3);
            this->addEnum("MULEQ", 3);
            this->addEnum("DIVEQ", 3);
            this->addEnum("MODEQ", 3);
            this->addEnum("PUSH_SCOPE", 1);
            this->addEnum("POP_SCOPE", 1);
            this->addEnum("REF", 2);
            this->addEnum("GREF", 2);
            this->addEnum("RETURN", 2);
            this->addEnum("BREAK", 2);
            this->addEnum("VAR", 2);
            this->addEnum("LOADC", 2);
            this->addEnum("FUNCTION", 2);
            this->addEnum("ARRAY", 1);
            this->addEnum("PUSH_ELEMENT", 2);
            this->addEnum("CALL_PREPARE", 2);
            this->addEnum("PUSH_ARG", 2);
            this->addEnum("CALL", 2);
            this->addEnum("IF", 1);
            this->addEnum("ELSE", 2);
            this->addEnum("WHILE", 1);
            this->addEnum("END", 1);
            this->addEnum("BREAKIF", 1);
            this->addEnum("JUMPIF", 2);
            this->addEnum("OBJECT", 1);
            this->addEnum("START_PAIR", 0);
            this->addEnum("KEY", 1);
            this->addEnum("VALUE", 1);
            this->addEnum("END_PAIR", 0);
            this->addEnum("TRY", 2);
            this->addEnum("NATIVE_FUNCDECL", 3);
            this->addEnum("LOAD_LIB", 1);
            this->addEnum("DYN_LOAD", 3);
            this->addEnum("DYNCALL", 3);
            this->addEnum("EXIT", 0);
        }
        /**
         * Stores the whole enumeration
         */
        Utils::Enum<int> vals;

        Utils::Enum<int> values() {
            return vals;
        }

        void addEnum(string name, int element) {
            this->vals.addEnum(name, element);
        }
        char getByte(string name){
            return static_cast<char>(values().find(name)->value);
        }
    };

    Erable::OpCode_t OpCode;
}


#endif /* OPCODE_HPP */

