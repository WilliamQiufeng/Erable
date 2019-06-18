//
// Created by Qiufeng54321 on 2019-05-27.
// Copyright (c) Qiufeng54321 All rights reserved.
//

#ifndef ERABLELANG_VMGLOBAL_HPP
#define ERABLELANG_VMGLOBAL_HPP

#define TEMPT template<typename type>
#define TTTTT template<typename T>
#define FTEMP template<typename D, typename E, typename F>
#define TYPE_IS_OBJ_EQU(sth, t) sth.getValue()->type()==typeid (t)
#define TYPE_IS_EQU(sth, t) sth->getValue()->type()==typeid (t)
#define ISNUM(sth) TYPE_IS_EQU(sth, int) or TYPE_IS_EQU(sth, double)
#define THROW_UOE(op)    \
    std::stringstream ss;\
    ss<<"Operation '" #op "' between '"\
    <<this->getTypeName()\
    <<"' and '"\
    <<other->getTypeName()\
    <<"'";        \
    Exceptions::UnsupportedOpException(ss.str()).throwException();
#define THROW_UNARY_UOE(op)    \
    std::stringstream ss;\
    ss<<"Operation '" #op "' to '"\
    <<this->getTypeName()\
    <<"'";        \
    Exceptions::UnsupportedOpException(ss.str()).throwException();
#define DECLARE_INSTANCE_FUNC(name) Instance* name(Instance* other, int toid)
#define DECLARE_UNARY_INSTANCE_FUNC(name) Instance* name(int toid)
#define OVERRIDE_INSTANCE_FUNC(name) DECLARE_INSTANCE_FUNC(name) override
#define OVERRIDE_UNARY_INSTANCE_FUNC(name) DECLARE_UNARY_INSTANCE_FUNC(name) override
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
#define INSTANCE_CONSTRUCTOR(cls, type)        cls(type value, int id, Descriptor* parent = nullptr, Instance* parentInstance = nullptr) : Instance(value, id, parent, parentInstance) {}    \
                        cls(boost::any* value, int id, Descriptor* parent = nullptr, Instance* parentInstance = nullptr) : Instance(value, id, parent, parentInstance) {}
#define OVERRIDE_INSTANCE_EQU(name, type)            \
    DECLARE_INSTANCE_FUNC(name::equ) {                \
    return new Integer(this->getTypeName() == other->getTypeName() and this->getAValue<type>() == other->getAValue<type>(), toid, this->getParent()); \
    }
#define DECLARE_INSTANCE_VIRTUAL(name, op)  \
    virtual Instance* name(Instance* other, int toid) {  \
        THROW_UOE(op);                                   \
    };
#define DECLARE_UNARY_INSTANCE_VIRTUAL(name, op)  \
    virtual Instance* name(int toid) {  \
        THROW_UNARY_UOE(op);                                   \
    };
#define GET_NUM(ptr, v)             \
    double v;                       \
    if(TYPE_IS_EQU(ptr, int)){            \
        v=ptr->getAValue<int>();    \
    }else if(TYPE_IS_EQU(ptr, double)){   \
        v=ptr->getAValue<double>(); \
    }                    \
    //std::cout<<v<<std::endl;
#define ERABLE_INSTANCE_OP_DOUB(a, b, op, toid) new Double (a op b, toid, this->getParent())
#define ERABLE_INSTANCE_OP_NUM(a, b, op, toid, to)    \
    GET_NUM(a, numa);                           \
    GET_NUM(b, numb);                           \
    Instance* to;                               \
    if(TYPE_IS_EQU(a, int) and TYPE_IS_EQU(b, int))         \
        to = new Integer(numa op numb, toid, this->getParent());\
    else                                        \
        to = new Double (numa op numb, toid, this->getParent())
#define ERABLE_INSTANCE_OP_NUM_FUNC(a, b, op, toid, to)    \
    GET_NUM(a, numa);                           \
    GET_NUM(b, numb);                           \
    Instance* to;                               \
    if(TYPE_IS_EQU(a, int) and TYPE_IS_EQU(b, int))         \
        to = new Integer(op(numa, numb), toid, this->getParent());\
    else                                        \
        to = new Double (op(numa, numb), toid, this->getParent());
#define ERABLE_DO_OP_NUM(a, b, op, toid)            \
    if (ISNUM(b)) {                             \
        ERABLE_INSTANCE_OP_NUM(a, b, op, toid, i);   \
        return i;                                   \
    }                                               \
    THROW_UOE(op);
#define ERABLE_DO_OP_NUM_FUNC(a, b, op, toid)       \
    if (ISNUM(b)) {                             \
        ERABLE_INSTANCE_OP_NUM_FUNC(this, other, op, toid, i);\
        return i;   \
    }\
    THROW_UOE(op);
#define CASE_OPCODE(opcode) if (op.op.op==opcode)
#define ELSE_CASE_OPCODE(opcode) else CASE_OPCODE(opcode)
#define DEFINE_NATIVE_FUNCTION(name) Types::Instance* name(Descriptor* desc, Types::NativeFunction * self, Types::Array* argv)
#define OVERRIDE_NATIVE_BUILTIN(name) DEFINE_NATIVE_FUNCTION(BuiltIn::name)
#define ADD_NATIVE(name, func)    Erable::Native::functype name##_FN = std::bind(&func, std::placeholders::_1, std::placeholders::_2, std::placeholders::_3);\
                Erable::Native::Functions.functions[#name] = name##_FN;
#define ADD_NATIVE_INCLASS(name, func, obj)    Erable::Native::functype name##_FN = std::bind(&func, obj, std::placeholders::_1, std::placeholders::_2, std::placeholders::_3);\
                        Erable::Native::Functions.functions[#name] = name##_FN;
#define OVERRIDE_CLONE_AND_GTN                \
    Instance* clone() override;                \
    std::string getTypeName() override;
#define OUTER_OVERRIDE_CAGTN(cls, type)            \
    Instance* cls::clone(){                \
    return new cls(this->getAValue<type>(), this->getId(), this->getParent()); \
    }                            \
    std::string cls::getTypeName(){                \
    return #cls;                    \
    }                            \
    OVERRIDE_INSTANCE_EQU(cls,type);

//#include <cstdlib>
//#include <string>
//#include <boost/filesystem.hpp>
//#include <regex>

#endif //ERABLELANG_VMGLOBAL_HPP
