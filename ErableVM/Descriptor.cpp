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

    class Code {
    };

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
	if (op.op.op is "CONSTANT_POOL") {
	    std::cout << "Recording Constant Pool...." << std::endl;
	    this->getInput()->readConstantPool();
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