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
	//using namespace std;

	class Integer : public Instance {
	  public:

	    Integer(int value, int id, Descriptor* parent = nullptr) :
	    Instance(value, id, parent) {

	    }

	    /*
	     * 递归下降，如果不是integer就让other来执行operation,如果other也不支持就抛出Exceptions::UnsupportedOpException错误
	     * Does other store an integer?
	     * √: add and return
	     * ∆: execute other->add(this, toid);
	     * this won't make any difference when exchanging lvalue and rvalue
	     */
	    OVERRIDE_INSTANCE_FUNC(add) {
		return other->add(this, toid);
	    }

	    OVERRIDE_INSTANCE_FUNC(mul) {
		return other->mul(other, toid);
	    };

	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(div);
	    OVERRIDE_INSTANCE_FUNC(pow);
	};

	class Double : public Instance {
	  public:

	    Double(double value, int id, Descriptor* parent = nullptr) :
	    Instance(value, id, parent) {
	    }

	    OVERRIDE_OP_NUM(add, +);

	    OVERRIDE_OP_NUM(sub, -);

	    OVERRIDE_OP_NUM(mul, *);

	    OVERRIDE_OP_NUM(div, /);

	    OVERRIDE_INSTANCE_FUNC(pow);
	};
	//Integer* Integer::sub(Integer* other, int toid) override

	/*
	 * Implementations of operations
	 */
	OUTER_OVERRIDE_OP_NUM(Integer::sub, -);

	OUTER_OVERRIDE_OP_NUM(Integer::div, /);

	OUTER_OVERRIDE_OP_NUM_FUNC(Integer::pow, std::pow);

	OUTER_OVERRIDE_OP_NUM_FUNC(Double::pow, std::pow);

	class String : Instance {
	    //string value="";

	    //using Instance<string>::Instance;
	  public:

	    String(std::string value, int id, Descriptor* parent = nullptr) :
	    Instance(value, id, parent) {
	    }

	    OVERRIDE_INSTANCE_FUNC(add) {
		std::string cpy(this->getAValue<std::string>());
		if (ISEQU(other, std::string)) {
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
	    OVERRIDE_INSTANCE_FUNC(sub) {
		throw Erable::Exceptions::UnsupportedOpException("Unsupported substraction of String");
	    };

	    OVERRIDE_INSTANCE_FUNC(mul) {
		std::string cpy(this->getAValue<std::string>());
		std::string res(cpy);
		if (ISEQU(other, int)) {
		    int times = other->getAValue<int>();

		    REPEAT_TIMES(times) {
			res += cpy;
		    }
		}
		return new String(res, toid, this->getParent());
	    }
	};

	class Function : Instance {
	  public:

	    Function(std::vector<Code*> value, int id, Descriptor* parent) :
	    Instance(value, id, parent) {

	    }

	};
    }
}

#undef TEMPT