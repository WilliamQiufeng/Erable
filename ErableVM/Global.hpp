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
 * File:   GlobalMacros.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月21日, 下午7:41
 */

#pragma once
#ifndef GLOBALMACROS_HPP
#define GLOBALMACROS_HPP


#define TEMPT template<typename type>
#define TTTTT template<typename T>
#define FTEMP template<typename D, typename E, typename F>
#define ISEQU(sth, t) sth->getValue()->type() == typeid (t)
#define ISNUM(sth) ISEQU(sth, int) or ISEQU(sth, double)
#define REPEAT(v, t) for(long long v=0;v<t;v++)
#define REPEAT_TIMES(t) for(long long _=0;_<t;_++)
#define THROW_UOE(op) throw Exceptions::UnsupportedOpException("Operation '" #op "'")



//---------For Instance Use-------------//

//-----Virtual OpFunction Declare-----//

#define DECLARE_INSTANCE_VIRTUAL(name, op)              \
    virtual Instance* name(Instance* other, int toid) {  \
        THROW_UOE(op);                                   \
    };

#define GET_NUM(ptr, v)             \
    double v;                       \
    if(ISEQU(ptr, int)){            \
        v=ptr->getAValue<int>();    \
    }else if(ISEQU(ptr, double)){   \
        v=ptr->getAValue<double>(); \
    }
#define ERABLE_INSTANCE_OP_DOUB(a, b, op, toid) new Double (a op b, toid, this->getParent())
#define ERABLE_INSTANCE_OP_NUM(a, b, op, toid, to)    \
    GET_NUM(a, numa);                           \
    GET_NUM(b, numb);                           \
    Instance* to;                               \
    if(ISEQU(a, int) && ISEQU(b, int))          \
        to = new Integer(numa op numb, toid, this->getParent());\
    else                                        \
        to = ERABLE_INSTANCE_OP_DOUB(numa, numb, op, toid);
#define ERABLE_INSTANCE_OP_NUM_FUNC(a, b, op, toid, to)    \
    GET_NUM(a, numa);                           \
    GET_NUM(b, numb);                           \
    Instance* to;                               \
    if(ISEQU(a, int) && ISEQU(b, int))          \
        to = new Integer(op(numa, numb), toid, this->getParent());\
    else                                        \
        to = new Double (op(numa, numb), toid, this->getParent());
#define ERABLE_DO_OP_NUM(a, b, op, toid)            \
    if (ISNUM(other)) {                             \
        ERABLE_INSTANCE_OP_NUM(a, b, -, toid, i);   \
        return i;                                   \
    }                                               \
    THROW_UOE(op);
#define ERABLE_DO_OP_NUM_FUNC(a, b, op, toid)       \
    if (ISNUM(other)) {                             \
        ERABLE_INSTANCE_OP_NUM_FUNC(this, other, op, toid, i);\
        return i;   \
    }\
    THROW_UOE(op);

//-----Instance Override-----//
#define DECLARE_INSTANCE_FUNC(name) Instance* name(Instance* other, int toid)
#define OVERRIDE_INSTANCE_FUNC(name) DECLARE_INSTANCE_FUNC(name) override

#define OVERRIDE_OP_NUM(name, op)                   \
    OVERRIDE_INSTANCE_FUNC(name){                        \
        ERABLE_DO_OP_NUM(this, other, op, toid);    \
    }
#define OVERRIDE_OP_NUM_FUNC(name, op)              \
    OVERRIDE_INSTANCE_FUNC(name){                        \
        ERABLE_DO_OP_NUM_FUNC(this, other, op, toid);\
    }
#define OUTER_OVERRIDE_OP_NUM(name, op)             \
    DECLARE_INSTANCE_FUNC(name){                    \
        ERABLE_DO_OP_NUM(this, other, op, toid);    \
    }
#define OUTER_OVERRIDE_OP_NUM_FUNC(name, op)             \
    DECLARE_INSTANCE_FUNC(name){                    \
        ERABLE_DO_OP_NUM_FUNC(this, other, op, toid);    \
    }
//-----------End Instance Use------------//
#endif /* GLOBALMACROS_HPP */

