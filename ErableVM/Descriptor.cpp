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

#include "Descriptor.hpp"
//#include "Metadata.hpp"

namespace Erable {

    std::ostream& operator<<(std::ostream& os, Descriptor& obj) {
	os << "Obj Dump:" << std::endl;
	os << (*(obj.input->getData()->pool)) << std::endl;
	os << "Buffer Dump:" << std::endl;
	for (auto&[key, value] : *(obj.idmap)) {
	    os << "\t";
	    os << key << " = " << value << std::endl;
	}
	return os;
    }

    class Code {
    };

    void Descriptor::set(int id, Erable::Types::Instance* instance) {
	(*(this->idmap))[id] = instance;
    }

    Types::Instance* Descriptor::get(int id) {
	Types::Instance* inst1 = this->idmap->at(id);
	int absId = id;
	while (absId != inst1->id) {
	    absId = inst1->id;
	    inst1 = this->idmap->at(absId);
	}
	return inst1;
    }

    void Descriptor::readHeader() {
	this->getInput()->readMeta();
    }

    Program::Op Descriptor::record() {
	return this->input->readOp();
    }

    std::vector<Program::Op> Descriptor::recordAll(Program::Op until) {

    }

    void Descriptor::execute(Program::Op op) {
	std::cout << op << std::endl;

	CASE_OPCODE("CONSTANT_POOL") {
	    std::cout << "Recording Constant Pool...." << std::endl;
	    this->getInput()->readConstantPool();
	}

	ELSE_CASE_OPCODE("LOADC") {
	    int cid = op[0];
	    int id = op[1];
	    Types::Instance* cpe = this->getInput()->getData()->pool->getElement(cid);
	    //std::cout << cpe << "->" << id << std::endl;
	    Types::Instance* ins = cpe->clone();
	    //std::cout << "Cloned" << std::endl;
	    ins->id = id;
	    this->set(id, ins);
	}

	ELSE_CASE_OPCODE("COPY") {
	    int origId = op[0];
	    int targId = op[1];
	    Types::Instance* orig = this->get(origId);
	    //std::cout << cpe << "->" << id << std::endl;
	    Types::Instance* ins = orig->clone();
	    //std::cout << "Cloned" << std::endl;
	    ins->id = targId;
	    this->set(targId, ins);
	}

	ELSE_CASE_OPCODE("GREF") {
	    int origId = op[0];
	    int targId = op[1];
	    Types::Instance* orig = this->get(origId);
	    Types::Integer* integer = new Types::Integer(orig->id, targId, orig->parent);
	    this->set(targId, integer);
	}

	ELSE_CASE_OPCODE("REF") {
	    int origId = op[0];
	    int targId = op[1];
	    Types::Instance* ref = this->get(origId);
	    Types::Instance* targ = this->get(ref->getAValue<int>());
	    this->set(targId, targ);
	}
    }

    void Descriptor::executeAll(Program::Op until) {
	Program::Op current = Program::UNKNOWN;
	while (not(until is current)) {
	    current = this->record();
	    this->execute(current);
	}
    }

    void Descriptor::executeAll(std::vector<Program::Op> code) {
	for (Program::Op op : code) {
	    this->execute(op);
	}
    }

    void Descriptor::doAll() {
	this->readHeader();
	std::cout << this->getInput()->getData()->meta->toString() << std::endl;
	this->executeAll(Program::END);
    }

    //class Descriptor
}