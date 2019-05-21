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
#pragma once
#ifndef OPCODE_HPP
#define OPCODE_HPP

#include "Utils.h"


namespace Erable {
    inline std::string OPCODE_WHATEVER = "WHATEVER";

    class OpCodeElement {
    public:
	int argc;
	int idind;
	std::string op;

	OpCodeElement(std::string op, int argc, int idind) : op(op), argc(argc), idind(idind) {

	}

	bool operator==(const OpCodeElement& right) const {
	    bool result = argc is right.argc and idind is right.idind and (op is right.op or op is OPCODE_WHATEVER or right.op is OPCODE_WHATEVER);
	    return result;
	}

    };

    class OpCode_t {
    public:

	OpCode_t() {
	    this->addEnum("CONSTANT_POOL", 0, -1); // Index 0
	    this->addEnum("CP_NUM", 0, -1); // Index 1
	    this->addEnum("CP_INT", 0, -1); // Index 2
	    this->addEnum("CP_STR", 0, -1); // Index 3
	    this->addEnum("ADD", 3, 2); // Index 4
	    this->addEnum("SUB", 3, 2); // Index 5
	    this->addEnum("MUL", 3, 2); // Index 6
	    this->addEnum("DIV", 3, 2); // Index 7
	    this->addEnum("MOD", 3, 2); // Index 8
	    this->addEnum("POW", 3, 2); // Index 9
	    this->addEnum("POS", 2, 1); // Index 10
	    this->addEnum("NEG", 2, 1); // Index 11
	    this->addEnum("COND", 2, 1); // Index 12
	    this->addEnum("ELEMENT", 3, 2); // Index 13
	    this->addEnum("LS", 3, 2); // Index 14
	    this->addEnum("RS", 3, 2); // Index 15
	    this->addEnum("URS", 3, 2); // Index 16
	    this->addEnum("LT", 3, 2); // Index 17
	    this->addEnum("GT", 3, 2); // Index 18
	    this->addEnum("LTE", 3, 2); // Index 19
	    this->addEnum("GTE", 3, 2); // Index 20
	    this->addEnum("EQ", 3, 2); // Index 21
	    this->addEnum("NEQ", 3, 2); // Index 22
	    this->addEnum("EQU", 3, 2); // Index 23
	    this->addEnum("SWITCH", 3, 2); // Index 24
	    this->addEnum("BNOT", 3, 2); // Index 25
	    this->addEnum("BAND", 3, 2); // Index 26
	    this->addEnum("BOR", 3, 2); // Index 27
	    this->addEnum("BXOR", 3, 2); // Index 28
	    this->addEnum("ADDEQ", 3, 2); // Index 29
	    this->addEnum("SUBEQ", 3, 2); // Index 30
	    this->addEnum("MULEQ", 3, 2); // Index 31
	    this->addEnum("DIVEQ", 3, 2); // Index 32
	    this->addEnum("MODEQ", 3, 2); // Index 33
	    this->addEnum("PUSH_SCOPE", 1, 0); // Index 34
	    this->addEnum("POP_SCOPE", 1, 0); // Index 35
	    this->addEnum("REF", 2, 1); // Index 36
	    this->addEnum("GREF", 2, 1); // Index 37
	    this->addEnum("RETURN", 2, 1); // Index 38
	    this->addEnum("BREAK", 2, 1); // Index 39
	    this->addEnum("COPY", 2, -1); // Index 40
	    this->addEnum("LOADC", 2, 1); // Index 41
	    this->addEnum("FUNCTION", 2, 1); // Index 42
	    this->addEnum("ARRAY", 1, 0); // Index 43
	    this->addEnum("PUSH_ELEMENT", 2, -1); // Index 44
	    this->addEnum("CALL", 2, 1); // Index 45
	    this->addEnum("IF", 1, -1); // Index 46
	    this->addEnum("ELSE", 2, -1); // Index 47
	    this->addEnum("WHILE", 1, -1); // Index 48
	    this->addEnum("END", 1, -1); // Index 49
	    this->addEnum("BREAKIF", 1, -1); // Index 50
	    this->addEnum("JUMPIF", 2, -1); // Index 51
	    this->addEnum("OBJECT", 1, -1); // Index 52
	    this->addEnum("PAIR", 3, -1); // Index 53
	    this->addEnum("TRY", 2, -1); // Index 54
	    this->addEnum("NATIVE_FUNCDECL", 3, -1); // Index 55
	    this->addEnum("LOAD_LIB", 1, -1); // Index 56
	    this->addEnum("DYN_LOAD", 3, -1); // Index 57
	    this->addEnum("DYNCALL", 3, -1); // Index 58
	    this->addEnum("EXIT", 0, -1); // Index 59
	}
	/**
	 * Stores the whole enumeration
	 */
	Utils::Enum<OpCodeElement> vals;

	Utils::Enum<OpCodeElement> values() {
	    return vals;
	}

	void addEnum(std::string name, int element, int idind) {
	    this->vals.addEnum(name, OpCodeElement{name, element, idind});
	}

	char getByte(std::string name) {
	    return static_cast<char> (values().findIndex(name));
	}
    };

    inline Erable::OpCode_t OpCode;
}


#endif /* OPCODE_HPP */

