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
#include "NativeFunctions.hpp"
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

	std::ostream& operator<<(std::ostream& os, Types::Array::arrtype obj) {
	    os << "[";
	    for (int i = 0; i < obj.size(); inc i) {
		os << obj[i];
		if (i < obj.size() - 1)os << ", ";
	    }
	    os << "]";
	    return os;
	}

	std::ostream& operator<<(std::ostream& os, Instance* obj) {
	    // Write obj to stream
	    //	    os << obj->getTypeName()
	    //		    << "{ID: "
	    //		    << obj->id
	    //		    << ", Value: ";
	    if (obj->getTypeName() == "Integer") {
		os << obj->getAValue<int>();
	    } else if (obj->getTypeName() == "Double") {
		os << obj->getAValue<double>();
	    } else if (obj->getTypeName() == "String") {
		//		os << "\"";
		os << obj->getAValue<std::string>();
		//		os << "\"";
	    } else if (obj->getTypeName() == "Array") {
		os << obj->getAValue<Types::Array::arrtype >();
	    } else if (obj->getTypeName() == "Object") {
		os << ":" << std::endl;
		for (auto&[key, value] : *(obj->getAValue<Types::Object::form>())) {
		    os << "\t\t" << key->id << " = " << value << std::endl;
		}
		os << "\t:";
	    } else if (obj->getTypeName() == "Function") {
		Function* func = (Function*) obj;
		os << "#" << func->id
			<< "[" << func->getArgc() << "] ->" << func->getRetId()
			<< func->getAValue<std::vector<Program::Op> >();
	    } else if (obj->getTypeName() == "NativeFunction") {
		NativeFunction* func = (NativeFunction*) obj;
		os << "#" << func->id
			<< "[" << func->getArgc() << "] ->" << func->getRetId() << " calls "
			<< func->getAValue<std::string>();
	    } else {
		os << "[Unknown Type \"" << obj->getTypeName() << "\"]";
	    }
	    //	    os << "}";
	    return os;
	}

	bool Instance::operator==(Instance& right) const {
	    bool result = right.equ(const_cast<Instance*> (this), -1)->getAValue<int>() == 1; // 比较此处的 right 和 *this
	    return result;
	}


	/*
	 * Implementations of operations
	 */

	OUTER_OVERRIDE_CAGTN(Integer, int);
	OUTER_OVERRIDE_CAGTN(Double, double);
	OUTER_OVERRIDE_CAGTN(String, std::string);
	OUTER_OVERRIDE_CAGTN(Function, codet);
	OUTER_OVERRIDE_CAGTN(NativeFunction, std::string);
	OUTER_OVERRIDE_CAGTN(Array, Types::Array::arrtype);
	OUTER_OVERRIDE_CAGTN(Object, form);
	OUTER_OVERRIDE_OP_NUM(Integer::add, +);
	OUTER_OVERRIDE_OP_NUM(Integer::sub, -);
	OUTER_OVERRIDE_OP_NUM(Integer::mul, *);


	OUTER_OVERRIDE_OP_NUM(Integer::div, /);

	OUTER_OVERRIDE_OP_NUM(Double::add, +);

	OUTER_OVERRIDE_OP_NUM(Double::sub, -);

	OUTER_OVERRIDE_OP_NUM(Double::mul, *);

	OUTER_OVERRIDE_OP_NUM(Double::div, /);

	OUTER_OVERRIDE_OP_NUM_FUNC(Integer::pow, std::pow);

	OUTER_OVERRIDE_OP_NUM_FUNC(Double::pow, std::pow);

	//	/*
	//	 * 递归下降，如果不是integer就让other来执行operation,如果other也不支持就抛出Exceptions::UnsupportedOpException错误
	//	 * Does other store an integer?
	//	 * √: add and return
	//	 * ∆: execute other->add(this, toid);
	//	 * this won't make any difference when exchanging lvalue and rvalue
	//	 */
	//	DECLARE_INSTANCE_FUNC(Integer::add) {
	//	    std::cout << this << " + " << other << std::endl;
	//	    return other->add(this, toid);
	//	}
	//
	//	DECLARE_INSTANCE_FUNC(Integer::mul) {
	//	    return other->mul(other, toid);
	//	};

	DECLARE_INSTANCE_FUNC(Integer::mod) {
	    int numa = this->getAValue<int>();
	    int numb = other->getAValue<int>();
	    Instance* to;
	    if (TYPE_IS_EQU(this, int) and TYPE_IS_EQU(other, int))
		to = new Integer(numa % numb, toid, this->getParent());
	    return to;
	}

	DECLARE_INSTANCE_FUNC(Double::mod) {
	    throw Erable::Exceptions::UnsupportedOpException("Unsupported mod of Double");
	};

	/*
	 * String Addition
	 * Used to concat strings and other types
	 * Examples:
	 *	"abc" + "def";//"abcdef"
	 *	"abc" + 123;//"abc123"
	 *	"abc" + 1.234;//"abc1.234"
	 *	"abc" + [1,2,3,4];//"abc[1,2,3,4]"
	 */
	DECLARE_INSTANCE_FUNC(String::add) {
	    std::stringstream ss;
	    ss << this->getAValue<std::string>();
	    ss << other;
	    String* s = new String(ss.str(), toid, this->getParent());
	    return s;
	}

	/*
	 * This is not appropriate for String to use "-" operator
	 */
	DECLARE_INSTANCE_FUNC(String::sub) {
	    throw Erable::Exceptions::UnsupportedOpException("Unsupported substraction of String");
	};

	/*
	 * String Multiplication
	 * Repeats the whole string operand[1] times
	 * Example:
	 *	"abc" * 3;//"abcabcabc"
	 *	"haha" * 4;//"hahahahahahahaha"
	 */
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

	DECLARE_INSTANCE_FUNC(String::mod) {
	    throw Erable::Exceptions::UnsupportedOpException("Unsupported mod of String");
	};

	/*
	 * Array Addition
	 * Pushes 'other' to the back of the whole array.
	 * Example:
	 *	[0,1,2,3,4,5] + 6; //[0,1,2,3,4,5,6]
	 * Notice:
	 *  When adding array to array, it doesn't flatten the array being added.
	 *	[0,1,2,3,4,5] + [6,7,8,9]; //[0,1,2,3,4,5,[6,7,8,9]]
	 */
	DECLARE_INSTANCE_FUNC(Array::add) {
	    Types::Array::arrtype cpy(this->getAValue<Types::Array::arrtype >());
	    cpy.push_back(other);
	    return new Array(cpy, toid, this->parent);
	}

	/*
	 * Access The Array with Index
	 * Example:
	 *	[1,2,3,4][0];//1
	 *	[1,[2,3],4][1][1];//3
	 */
	DECLARE_INSTANCE_FUNC(Array::acc) {
	    if (other->getTypeName() == "Integer") {
		int pos = other->getAValue<int>();
		Instance* element = this->getAValue<arrtype>()[pos];
		//Doesn't change its ID. It will allow 'arr[index] = xxx;' operand.
		return element;
	    }
	    THROW_UOE([]);
	}

	/*
	 * Access The Array with Index
	 * Example:
	 *	[1,2,3,4][0];//1
	 *	[1,[2,3],4][1][1];//3
	 */
	DECLARE_INSTANCE_FUNC(Object::acc) {
	    Instance pos = *other;
	    for (auto&[key, value] : *(this->getAValue<form>())) {
		//std::cout << "value : " << value << std::endl;
		if (other->equ(key, -1)->getAValue<int>() == 1) {
		    //std::cout << "Found: " << value << std::endl;
		    return value;
		}
	    }
	    //Doesn't change its ID. It will allow 'arr[index] = xxx;' operand.

	    return nullptr;
	}

	/*
	 * Number condition operation
	 * Returns 1 if the number is above 0,
	 *         0 if not.
	 */
	DECLARE_UNARY_INSTANCE_FUNC(Integer::cond) {
	    int val = this->getAValue<int>();
	    Instance* res = new Integer((val > 0 ? 1 : 0), toid, this->getParent());

	    return res;
	}

	DECLARE_UNARY_INSTANCE_FUNC(Double::cond) {
	    double val = this->getAValue<double>();
	    Instance* res = new Integer((val > 0 ? 1 : 0), toid, this->getParent());

	    return res;
	}

	/*
	 * String, Array, Object Condition Operation
	 * Returns 1 if the literal is not empty, or else returns 0.
	 */
	DECLARE_UNARY_INSTANCE_FUNC(String::cond) {
	    std::string str = this->getAValue<std::string>();
	    Instance* res = new Integer((str.empty() ? 0 : 1), toid, this->getParent());

	    return res;
	}

	DECLARE_UNARY_INSTANCE_FUNC(Array::cond) {
	    Array::arrtype arr = this->getAValue<Array::arrtype>();
	    Instance* res = new Integer((arr.empty() ? 0 : 1), toid, this->getParent());

	    return res;
	}

	DECLARE_UNARY_INSTANCE_FUNC(Object::cond) {
	    Object::form obj = this->getAValue<Object::form>();
	    Instance* res = new Integer((obj->empty() ? 0 : 1), toid, this->getParent());

	    return res;
	}

	/*
	 * Function Condition Operation
	 * Note that the structure of functions always require [OpCode END {Functuon ID}] at the end,
	 * which means that functions always have more than 1 Ops no matter if they are empty or not.
	 * Returns 1 if the amount of codes are more than 1, if not, returns 0.
	 */
	DECLARE_UNARY_INSTANCE_FUNC(Function::cond) {
	    Function::codet codes = this->getAValue<Function::codet>();
	    Instance* res = new Integer((codes.size() > 1 ? 1 : 0), toid, this->getParent());

	    return res;
	}

	/*
	 * Native Function Condition Operation
	 * Checks if what the native function calls exists in Erable::Native::Functions.functions
	 * Returns 1 if it exists, or else returns 0.
	 */
	DECLARE_UNARY_INSTANCE_FUNC(NativeFunction::cond) {
	    std::string nativeCall = this->getAValue<std::string>();
	    Erable::Native::funcmap::iterator iter = Erable::Native::Functions.functions.find(nativeCall);
	    bool found = (iter == Erable::Native::Functions.functions.end());
	    Instance* res = new Integer(found, toid, this->getParent());
	    return res;
	}
    }
}
