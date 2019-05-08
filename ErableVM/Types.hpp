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
 * File:   Types.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 下午1:17
 */

#pragma once
#ifndef TYPES_HPP
#define TYPES_HPP

#include <boost/any.hpp>

namespace Erable{
    namespace Types{
	class Instance;
        class Double;
        class Integer;
        //template<typename type=std::string>
        class String;
        class Function;
    }
}
//#include "Global.hpp"

#include "Descriptor.hpp"
#include "Global.hpp"
#include "Exceptions.hpp"

namespace Erable {
    namespace Types {
        class Instance {
	public:
	    boost::any* value;
	    int id;
	    Descriptor* parent;

	    TEMPT Instance(type value, int id, Descriptor* parent = nullptr) :
	    value(new boost::any(value)), id(id), parent(parent) {
	    }

	    boost::any* getValue() const {
		return this->value;
	    }

	    TTTTT T getAValue() {
		return *(boost::any_cast<T>(this->getValue()));
	    }

	    int getId() const {
		return id;
	    }

	    void setId(int id) {
		this->id = id;
	    }

	    Descriptor* getParent() const {
		return parent;
	    }

	    void setParent(Descriptor* parent) {
		this->parent = parent;
	    }
	    DECLARE_INSTANCE_VIRTUAL(add, +);
	    DECLARE_INSTANCE_VIRTUAL(sub, -);
	    DECLARE_INSTANCE_VIRTUAL(mul, *);
	    DECLARE_INSTANCE_VIRTUAL(div, /);
	    DECLARE_INSTANCE_VIRTUAL(mod, %);
	    DECLARE_INSTANCE_VIRTUAL(pow, **);

	};
	class Integer : public Instance {
	public:

	    INSTANCE_CONSTRUCTOR(Integer, int);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(mul);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(div);
	    OVERRIDE_INSTANCE_FUNC(pow);
	};
	class Double : public Instance {
	public:
	    INSTANCE_CONSTRUCTOR(Double, double);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(mul);
	    OVERRIDE_INSTANCE_FUNC(div);
	    OVERRIDE_INSTANCE_FUNC(pow);
	};
	class String : public Instance {
	public:
	    INSTANCE_CONSTRUCTOR(String, std::string);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(mul);
	};
	class Function : public Instance {
	public:
	    INSTANCE_CONSTRUCTOR(Function, std::vector<Code*>);
	};
    }
}

#endif /* TYPES_HPP */

