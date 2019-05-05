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
#include "ConstantPool.hpp"
#include <map>

namespace Erable {

    class Code {
    };

    class Descriptor {
	//Fields
	std::map<int, Erable::Types::Instance*>* idmap;
	ConstantPool* constant_pool;
	Descriptor* parent;

      public:
	//Constructors

	Descriptor() {
	    this->init();
	}

	Descriptor(std::map<int, Erable::Types::Instance*>* idmap) :
	idmap(idmap) {
	}

	Descriptor(std::map<int, Erable::Types::Instance*>* idmap, ConstantPool* constant_pool) :
	idmap(idmap), constant_pool(constant_pool) {
	}

	Descriptor(Descriptor* other) :
	idmap(other->getIdmap()), constant_pool(other->getConstantPool()), parent(other) {
	}

	//Initialisation

	void init() {
	    this->idmap = new std::map<int, Erable::Types::Instance*>;
	    this->constant_pool = new ConstantPool;
	}

	//Getters and Setters

	std::map<int, Erable::Types::Instance*>* getIdmap() const {
	    return idmap;
	}

	void setIdmap(std::map<int, Erable::Types::Instance*>* idmap) {
	    this->idmap = idmap;
	}

	ConstantPool* getConstantPool() const {
	    return constant_pool;
	}

	void setConstantPool(ConstantPool* constant_pool) {
	    this->constant_pool = constant_pool;
	}

	Descriptor* getParent() const {
	    return parent;
	}

	void setParent(Descriptor* parent) {
	    this->parent = parent;
	}

    };
}