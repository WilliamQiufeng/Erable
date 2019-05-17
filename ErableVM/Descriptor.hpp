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
 * File:   Descriptor.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 下午1:20
 */

#pragma once
#ifndef DESCRIPTOR_HPP
#define DESCRIPTOR_HPP

//#include <map>
//#include "InputStream.hpp"
//#include "Types.hpp"
namespace Erable{
    class Code;
    class Descriptor;
}
#include "Program.hpp"
#include "Types.hpp"
#include <map>


namespace Erable {
    class Descriptor {
	//Fields
	std::map<int, Erable::Types::Instance*>* idmap;
	Program::ProgramInputStream* input;
	Descriptor* parent;
	Types::Instance* retVal;
	int retId;

      public:
	//Constructors

	Descriptor() {
	    this->init();
	}

	Descriptor(std::map<int, Erable::Types::Instance*>* idmap) :
	idmap(idmap) {
	    this->reset();
	}

	Descriptor(Program::ProgramInputStream* in) :
	input(in) {
	    this->reset();
	}

	Descriptor(Descriptor* other) :
	input(other->input), parent(other), idmap(other->idmap){
	    this->reset();
	}

	//Initialisation

	inline void init() {
	    this->idmap = new std::map<int, Erable::Types::Instance*>;
	    this->parent=nullptr;
	    reset();
	}
	inline void reset(){
	    retVal=nullptr;
	    retId=-1;
	}

	//Getters and Setters

	std::map<int, Erable::Types::Instance*>* getIdmap() const {
	    return idmap;
	}

	void setIdmap(std::map<int, Erable::Types::Instance*>* idmap) {
	    this->idmap = idmap;
	}
	void set(int, Erable::Types::Instance*);
	Types::Instance* get(int);
	Program::ProgramInputStream* getInput() const {
	    return input;
	}

	void setInput(Program::ProgramInputStream* input) {
	    this->input = input;
	}

	Descriptor* getParent() const {
	    return parent;
	}

	void setParent(Descriptor* parent) {
	    this->parent = parent;
	}
	int getRetId() const {
	    return retId;
	}

	void setRetId(int retId) {
	    this->retId = retId;
	}

	Types::Instance* getRetVal() const {
	    return retVal;
	}

	void setRetVal(Types::Instance* retVal) {
	    this->retVal = retVal;
	}

	void readHeader();
	void execute(Program::Op op);
	void executeAll(Program::Op until);
	void executeAll(std::vector<Program::Op> code);
	std::vector<Program::Op> recordAll(Program::Op until);
	Program::Op record();
	void doAll();
	
	
	friend std::ostream& operator<<(std::ostream& os, Descriptor& obj);

    };
    
}

#endif /* DESCRIPTOR_HPP */

