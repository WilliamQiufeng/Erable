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
#include <boost/type_index/stl_type_index.hpp>

namespace Erable{
    namespace Types{
	class Instance;
        class Double;
        class Integer;
        //template<typename type=std::string>
        class String;
	class Array;
	class Object;
        class Function;
	class NativeFunction;
    }
}
//#include "Global.hpp"

#include "Descriptor.hpp"
#include "Global.hpp"
#include "Exceptions.hpp"

namespace Erable {
    namespace Types {
	std::ostream& operator<<(std::ostream& os, std::vector<Instance*> obj);
	std::ostream& operator<<(std::ostream& os, Instance* obj);
        class Instance {
	public:
	    
	    boost::any* value;
	    int id;
	    Descriptor* parent;
	    Instance* parentInstance;

	    TEMPT Instance(boost::any* value, int id, Descriptor* parent = nullptr, Instance* parentInstance = nullptr) :
	    value(new boost::any(boost::any_cast<type>(value))), id(id), parent(parent), parentInstance(parentInstance) {
		//std::cout<<"ANY:"<<boost::any_cast<type>(value)<<std::endl;
	    }
	    
	    TEMPT Instance(type value, int id, Descriptor* parent = nullptr, Instance* parentInstance = nullptr) :
	    value(new boost::any(value)), id(id), parent(parent), parentInstance(parentInstance) {
		//std::cout<<"TYPE:"<<value<<std::endl;
	    }

	    boost::any* getValue() {
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
	    
	    Instance* getParentInstance() const {
		return parentInstance;
	    }

	    void setParentInstance(Instance* parentInstance) {
		this->parentInstance = parentInstance;
	    }

	    
	    inline std::string toString(){
		std::stringstream ss;
		ss<<this;
		return ss.str();
	    }
	    friend std::ostream& operator<<(std::ostream& os, Instance* obj);
	    bool operator<(const Instance& right) const {
		return right > * this; // 重用大于运算符
	    }

	    bool operator>(const Instance& right) const {
		// Do actual comparison
		return this->id-right.id;
	    }
	    
	    bool operator==(Instance& right) const;



	    virtual std::string getTypeName();
	    virtual Instance* clone();
	    DECLARE_INSTANCE_VIRTUAL(add, +);
	    DECLARE_INSTANCE_VIRTUAL(sub, -);
	    DECLARE_INSTANCE_VIRTUAL(mul, *);
	    DECLARE_INSTANCE_VIRTUAL(div, /);
	    DECLARE_INSTANCE_VIRTUAL(mod, %);
	    DECLARE_INSTANCE_VIRTUAL(pow, **);
	    DECLARE_INSTANCE_VIRTUAL(acc, []);
	    DECLARE_INSTANCE_VIRTUAL(equ, ==);
	    DECLARE_INSTANCE_VIRTUAL(less, <);
	    DECLARE_INSTANCE_VIRTUAL(more, >);
	    DECLARE_INSTANCE_VIRTUAL(le,  <=);
	    DECLARE_INSTANCE_VIRTUAL(me,  >=);
	    DECLARE_INSTANCE_VIRTUAL(band, &);
	    DECLARE_INSTANCE_VIRTUAL(bor,  |);
	    DECLARE_INSTANCE_VIRTUAL(bxor, ^);
	    DECLARE_INSTANCE_VIRTUAL(ls,  <<);
	    DECLARE_INSTANCE_VIRTUAL(rs,  >>);
	    DECLARE_INSTANCE_VIRTUAL(urs,>>>);
	    DECLARE_UNARY_INSTANCE_VIRTUAL(cond, ?);

	};
	class Integer : public Instance {
	public:

	    INSTANCE_CONSTRUCTOR(Integer, int);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(mul);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(div);
	    OVERRIDE_INSTANCE_FUNC(mod);
	    OVERRIDE_INSTANCE_FUNC(pow);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_CLONE_AND_GTN;
	};
	class Double : public Instance {
	public:
	    INSTANCE_CONSTRUCTOR(Double, double);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(mul);
	    OVERRIDE_INSTANCE_FUNC(div);
	    OVERRIDE_INSTANCE_FUNC(mod);
	    OVERRIDE_INSTANCE_FUNC(pow);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_CLONE_AND_GTN;
	};
	class String : public Instance {
	public:
	    INSTANCE_CONSTRUCTOR(String, std::string);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(sub);
	    OVERRIDE_INSTANCE_FUNC(mul);
	    OVERRIDE_INSTANCE_FUNC(mod);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_CLONE_AND_GTN;
	};
	class Array : public Instance {
	public:
	    typedef std::vector<Instance*> arrtype;
	    INSTANCE_CONSTRUCTOR(Array, arrtype);
	    OVERRIDE_INSTANCE_FUNC(add);
	    OVERRIDE_INSTANCE_FUNC(acc);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_CLONE_AND_GTN;
	};
	class Object : public Instance {
	public:
	    typedef std::map<Instance*, Instance*> formmap;
	    typedef formmap* form;
	    INSTANCE_CONSTRUCTOR(Object, form);
	    OVERRIDE_INSTANCE_FUNC(acc);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_CLONE_AND_GTN;
	};
	class Function : public Instance {
	    int retId,argc;
	public:
	    typedef std::vector<Program::Op> codet;
	    INSTANCE_CONSTRUCTOR(Function, codet);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_CLONE_AND_GTN;
	    inline int getArgc() const {
		return argc;
	    }

	    inline void setArgc(int argc) {
		this->argc = argc;
	    }

	    inline int getRetId() const {
		return retId;
	    }

	    inline void setRetId(int retId) {
		this->retId = retId;
	    }
	};
	class NativeFunction : public Instance {
	    int retId,argc;
	public:
	    INSTANCE_CONSTRUCTOR(NativeFunction, std::string);
	    OVERRIDE_UNARY_INSTANCE_FUNC(cond);
	    OVERRIDE_INSTANCE_FUNC(equ);
	    OVERRIDE_CLONE_AND_GTN;
	    inline int getArgc() const {
		return argc;
	    }

	    inline void setArgc(int argc) {
		this->argc = argc;
	    }

	    inline int getRetId() const {
		return retId;
	    }

	    inline void setRetId(int retId) {
		this->retId = retId;	
	    }
	};
    }
}

#endif /* TYPES_HPP */

