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
#include "Types.hpp"
#include "IO.hpp"
#include <string>
#include <cmath>
#include <complex>
#include <boost/any.hpp>
#include <boost/type_index.hpp>
#include <malloc/_malloc.h>





namespace Erable {
    namespace Types {

	Instance* Instance::clone() {
	    return new Instance(this->getValue(), this->id, this->parent);
	}

	std::string Instance::getTypeName() {
	    return "Instance";
	}

	std::ostream& operator<<(std::ostream& os, Instance* obj) {
	    // Write obj to stream
	    os << obj->getTypeName()
		    << "{ID: "
		    << obj->id
		    << ", Value: ";
	    if (obj->getTypeName() == "Integer") {
		os << obj->getAValue<int>();
	    } else if (obj->getTypeName() == "Double") {
		os << obj->getAValue<double>();
	    } else if (obj->getTypeName() == "String") {
		os << "\"";
		os << obj->getAValue<std::string>();
		os << "\"";
	    } else {
		os << "[Unknown Type \"" << obj->getTypeName() << "\"]";
	    }
	    os << "}";
	    return os;
	}

	std::ostream& operator<<(std::ostream& os, std::vector<Code*> obj) {
	    os << "Function";
	    return os;
	}

	/*
	 * Implementations of operations
	 */
	OUTER_OVERRIDE_CAGTN(Integer, int);
	OUTER_OVERRIDE_CAGTN(Double, double);
	OUTER_OVERRIDE_CAGTN(String, std::string);
	OUTER_OVERRIDE_CAGTN(Function, std::vector<Code*>);
	OUTER_OVERRIDE_OP_NUM(Integer::sub, -);

	OUTER_OVERRIDE_OP_NUM(Integer::div, /);

	OUTER_OVERRIDE_OP_NUM(Double::add, +);

	OUTER_OVERRIDE_OP_NUM(Double::sub, -);

	OUTER_OVERRIDE_OP_NUM(Double::mul, *);

	OUTER_OVERRIDE_OP_NUM(Double::div, /);

	OUTER_OVERRIDE_OP_NUM_FUNC(Integer::pow, std::pow);

	OUTER_OVERRIDE_OP_NUM_FUNC(Double::pow, std::pow);

	/*
	 * 递归下降，如果不是integer就让other来执行operation,如果other也不支持就抛出Exceptions::UnsupportedOpException错误
	 * Does other store an integer?
	 * √: add and return
	 * ∆: execute other->add(this, toid);
	 * this won't make any difference when exchanging lvalue and rvalue
	 */
	DECLARE_INSTANCE_FUNC(Integer::add) {
	    return other->add(this, toid);
	}

	DECLARE_INSTANCE_FUNC(Integer::mul) {
	    return other->mul(other, toid);
	};

	DECLARE_INSTANCE_FUNC(String::add) {
	    std::string cpy(this->getAValue<std::string>());
	    if (TYPE_IS_EQU(other, std::string)) {
		cpy += other->getAValue<std::string>();
	    } else if (ISNUM(other)) {
		GET_NUM(this, a);
		cpy += a;
	    }
	    String* s = new String(cpy, toid, this->getParent());
	    return s;
	}

	/*
	 * This is not appropriate for String to use "-" operator
	 */
	DECLARE_INSTANCE_FUNC(String::sub) {
	    throw Erable::Exceptions::UnsupportedOpException("Unsupported substraction of String");
	};

	DECLARE_INSTANCE_FUNC(String::mul) {
	    std::string cpy(this->getAValue<std::string>());
	    std::string res(cpy);
	    if (TYPE_IS_EQU(other, int)) {
		int times = other->getAValue<int>();

		REPEAT_TIMES(times) {
		    res += cpy;
		}
	    }
	    return new String(res, toid, this->getParent());
	};


    }
}

#undef TEMPT