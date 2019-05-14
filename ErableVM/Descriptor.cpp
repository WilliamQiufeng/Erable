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
	os << "Buffer Dump[" << obj.idmap->size() << "]:" << std::endl;
	for (auto&[key, value] : *(obj.idmap)) {
	    os << "\t";
	    os << key << " = " << value << std::endl;
	}
	return os;
    }

    class Code {
    };

    void Descriptor::set(int id, Erable::Types::Instance* instance) {
	try {
	    Types::Instance* abs = get(id);
	    (*abs) = (*instance);
	} catch (std::out_of_range e) {
	    (*this->idmap)[id] = instance;
	}

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
	std::vector<Program::Op> codes;
	Program::Op current = Program::UNKNOWN;
	while (not(until is current)) {
	    current = this->record();
	    codes.push_back(current);
	}
	return codes;
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

	ELSE_CASE_OPCODE("EQU") {
	    int origId = op[0];
	    int targId = op[1];
	    Types::Instance* targ = this->get(targId);
	    if (origId == retId) {
		retVal = targ;
		return;
	    }
	    this->set(origId, targ);
	}

	ELSE_CASE_OPCODE("ADD") {
	    int insAId = op[0];
	    int insBId = op[1];
	    int targId = op[2];
	    Types::Instance* insA = this->get(insAId);
	    Types::Instance* insB = this->get(insBId);
	    //std::cout << insA << "+" << insB << std::endl;
	    Types::Instance* res = insA->add(insB, targId);
	    //std::cout << res << std::endl;
	    this->set(targId, res);
	}

	ELSE_CASE_OPCODE("SUB") {
	    int insAId = op[0];
	    int insBId = op[1];
	    int targId = op[2];
	    Types::Instance* insA = this->get(insAId);
	    Types::Instance* insB = this->get(insBId);
	    Types::Instance* res = insA->sub(insB, targId);
	    this->set(targId, res);
	}

	ELSE_CASE_OPCODE("MUL") {
	    int insAId = op[0];
	    int insBId = op[1];
	    int targId = op[2];
	    Types::Instance* insA = this->get(insAId);
	    Types::Instance* insB = this->get(insBId);
	    Types::Instance* res = insA->mul(insB, targId);
	    this->set(targId, res);
	}

	ELSE_CASE_OPCODE("DIV") {
	    int insAId = op[0];
	    int insBId = op[1];
	    int targId = op[2];
	    Types::Instance* insA = this->get(insAId);
	    Types::Instance* insB = this->get(insBId);
	    Types::Instance* res = insA->div(insB, targId);
	    this->set(targId, res);
	}

	ELSE_CASE_OPCODE("MOD") {
	    int insAId = op[0];
	    int insBId = op[1];
	    int targId = op[2];
	    Types::Instance* insA = this->get(insAId);
	    Types::Instance* insB = this->get(insBId);
	    Types::Instance* res = insA->mod(insB, targId);
	    this->set(targId, res);
	}

	ELSE_CASE_OPCODE("ARRAY") {
	    int targId = op[0];
	    Types::Instance* arr = new Types::Array(std::vector<Types::Instance*>(), targId, this);
	    this->set(targId, arr);
	}

	ELSE_CASE_OPCODE("PUSH_ELEMENT") {
	    int eleId = op[0];
	    int arrId = op[1];
	    Types::Instance* arr = this->get(arrId);
	    Types::Instance* ele = this->get(eleId);
	    Types::Instance* res = arr->add(ele, arr->id);
	    this->set(arrId, res);
	}

	ELSE_CASE_OPCODE("FUNCTION") {
	    int retId = op[0];
	    int targId = op[1];
	    int argc = retId - targId - 1;
	    std::vector<int> untilArgv{targId};
	    std::vector<Program::Op> codes = this->recordAll(Program::Op(OpCode.values().find("END")->value, untilArgv));
	    Types::Function* func = new Types::Function(codes, targId, this);
	    func->setArgc(argc);
	    func->setRetId(retId);
	    this->set(targId, func);
	}
    }

    void Descriptor::executeAll(Program::Op until) {
	Program::Op current = Program::UNKNOWN;
	while (not(until is current)) {
	    current = this->record();
	    this->execute(current);
	    if (retVal != nullptr) {
		return;
	    }
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