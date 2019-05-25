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
#include "NativeFunctions.hpp"

#include "Global.hpp"
//#include "Metadata.hpp"

namespace Erable {

    std::ostream &operator<<(std::ostream &os, Descriptor &obj) {
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

    void Descriptor::set(int id, Erable::Types::Instance *instance) {
        //	if (parent != nullptr) {
        //	    parent->set(id, instance);
        //	    return;
        //	}
        try {
            Types::Instance *abs = get(id);
            (*abs) = (*instance);
        } catch (std::exception &e) {
            (*this->idmap)[id] = instance;
        }

    }

    Types::Instance *Descriptor::get(int id) {
        Types::Instance *inst1 = this->idmap->at(id);
        int absId = id;
        while (absId != inst1->id) {
            absId = inst1->id;
            inst1 = this->idmap->at(absId);
        }
        return inst1;
    }

    void Descriptor::del(int id) {
        this->idmap->erase(id);
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
        while (not(until == current)) {
            current = this->record();
            codes.push_back(current);
        }
        return codes;
    }

    void Descriptor::execute(Program::Op op) {
        //std::cout << op << std::endl;

        CASE_OPCODE("CONSTANT_POOL") {
            //std::cout << "Recording Constant Pool...." << std::endl;
            this->getInput()->readConstantPool();
        } ELSE_CASE_OPCODE("LOADC") {
            int cid = op[0];
            int id = op[1];
            Types::Instance *cpe = this->getInput()->getData()->pool->getElement(cid);
            //std::cout << cpe << "->" << id << std::endl;
            Types::Instance *ins = cpe->clone();
            //std::cout << "Cloned" << std::endl;
            ins->id = id;
            this->set(id, ins);
        } ELSE_CASE_OPCODE("COPY") {
            int origId = op[0];
            int targId = op[1];
            Types::Instance *orig = this->get(origId);
            //std::cout << cpe << "->" << id << std::endl;
            Types::Instance *ins = orig->clone();
            //std::cout << "Cloned" << std::endl;
            ins->id = targId;
            this->set(targId, ins);
        } ELSE_CASE_OPCODE("GREF") {
            int origId = op[0];
            int targId = op[1];
            Types::Instance *orig = this->get(origId);
            Types::Integer *integer = new Types::Integer(orig->id, targId, orig->parent);
            this->set(targId, integer);
        } ELSE_CASE_OPCODE("REF") {
            int origId = op[0];
            int targId = op[1];
            Types::Instance *ref = this->get(origId);
            Types::Instance *targ = this->get(ref->getAValue<int>());
            this->set(targId, targ);
        } ELSE_CASE_OPCODE("COND") {
            int origId = op[0];
            int targId = op[1];
            Types::Instance *ref = this->get(origId);
            Types::Instance *targ = ref->cond(targId);
            this->set(targId, targ);
        } ELSE_CASE_OPCODE("EQU") {
            int origId = op[0];
            int targId = op[1];
            Types::Instance *targ = this->get(targId);
            //std::cout << targ << std::endl;
            if (origId == retId) {
                retVal = targ;
            }
            this->set(origId, targ);
        } ELSE_CASE_OPCODE("ADD") {
            int insAId = op[0];
            int insBId = op[1];
            int targId = op[2];
            Types::Instance *insA = this->get(insAId);
            Types::Instance *insB = this->get(insBId);
            //std::cout << insA << "+" << insB << std::endl;
            Types::Instance *res = insA->add(insB, targId);
            //std::cout << res << std::endl;
            this->set(targId, res);
        } ELSE_CASE_OPCODE("SUB") {
            int insAId = op[0];
            int insBId = op[1];
            int targId = op[2];
            Types::Instance *insA = this->get(insAId);
            Types::Instance *insB = this->get(insBId);
            Types::Instance *res = insA->sub(insB, targId);
            this->set(targId, res);
        } ELSE_CASE_OPCODE("MUL") {
            int insAId = op[0];
            int insBId = op[1];
            int targId = op[2];
            Types::Instance *insA = this->get(insAId);
            Types::Instance *insB = this->get(insBId);
            Types::Instance *res = insA->mul(insB, targId);
            this->set(targId, res);
        } ELSE_CASE_OPCODE("DIV") {
            int insAId = op[0];
            int insBId = op[1];
            int targId = op[2];
            Types::Instance *insA = this->get(insAId);
            Types::Instance *insB = this->get(insBId);
            Types::Instance *res = insA->div(insB, targId);
            this->set(targId, res);
        } ELSE_CASE_OPCODE("MOD") {
            int insAId = op[0];
            int insBId = op[1];
            int targId = op[2];
            Types::Instance *insA = this->get(insAId);
            Types::Instance *insB = this->get(insBId);
            Types::Instance *res = insA->mod(insB, targId);
            this->set(targId, res);
        } ELSE_CASE_OPCODE("ARRAY") {
            int targId = op[0];
            Types::Instance *arr = new Types::Array(std::vector<Types::Instance *>(), targId, this);
            this->set(targId, arr);
        } ELSE_CASE_OPCODE("ELEMENT") {
            int arrId = op[0];
            int accId = op[1];
            int targId = op[2];
            Types::Instance *arr = this->get(arrId);
            Types::Instance *acc = this->get(accId);
            Types::Instance *ele = arr->acc(acc, targId);
            //	    std::cout << "Access: " << ele << std::endl;
            this->set(targId, ele);
        } ELSE_CASE_OPCODE("PUSH_ELEMENT") {
            int eleId = op[0];
            int arrId = op[1];
            Types::Instance *arr = this->get(arrId);
            Types::Instance *ele = this->get(eleId);
            Types::Instance *res = arr->add(ele, arr->id);
            this->set(arrId, res);
        } ELSE_CASE_OPCODE("OBJECT") {
            int targId = op[0];
            Types::Object *obj = new Types::Object(new Types::Object::formmap, targId, this);
            this->set(targId, obj);
            //std::cout << "New Object: " << obj << std::endl;
        } ELSE_CASE_OPCODE("PAIR") {
            int keyId = op[0];
            int valId = op[1];
            int objId = op[2];
            Types::Instance *key = this->get(keyId);
            Types::Instance *val = this->get(valId);
            Types::Instance *obj = this->get(objId);
            //std::cout << "Pair (" << key << ", " << val << ") to " << obj << std::endl;
            obj->getAValue<Types::Object::form>()->insert(std::pair(key, val));
        } ELSE_CASE_OPCODE("FUNCTION") {
            int retId = op[0];
            int targId = op[1];
            int argc = retId - targId - 1;
            std::vector<int> untilArgv{targId};
            std::vector<Program::Op> codes = this->recordAll(
                    Program::Op(OpCode.values().find("END")->value, untilArgv));
            Types::Function *func = new Types::Function(codes, targId, this);
            func->setArgc(argc);
            func->setRetId(retId);
            this->set(targId, func);
        } ELSE_CASE_OPCODE("NATIVE_FUNCDECL") {
            int retId = op[0];
            int targId = op[1];
            int nativeCall = op[2];
            int argc = retId - targId - 1;
            Types::Instance *nativeCI = this->get(nativeCall);
            std::string nativeCS = nativeCI->getAValue<std::string>();
            Types::NativeFunction *func = new Types::NativeFunction(nativeCS, targId, this);
            func->setArgc(argc);
            func->setRetId(retId);
            this->set(targId, func);
        } ELSE_CASE_OPCODE("CALL") {
            int funcId = op[0];
            int targId = op[1];
            Types::Array *argv = (Types::Array *) this->get(targId);
            Descriptor *desc = new Descriptor(this);
            Types::Instance *inst = this->get(funcId);
            //	    std::cout << "Calling function " << inst << std::endl;
            if (inst->getTypeName() == "Function") {
                int ind = 1;
                for (Types::Instance *arg : argv->getAValue<Types::Array::arrtype>()) {
                    int absId = inst->id + ind;
                    this->set(absId, arg);
                    inc ind;
                }
                Types::Function *func = (Types::Function *) inst;
                Types::Function::codet codes = func->getAValue<Types::Function::codet>();
                desc->retId = func->getRetId();
                desc->executeAll(codes);
            } else if (inst->getTypeName() == "NativeFunction") {
                Types::NativeFunction *func = (Types::NativeFunction *) inst;
                std::string nativeCS = func->getAValue<std::string>();
                Native::functype nativeFunc = Native::Functions::findFunc(nativeCS);
                desc->retId = func->getRetId();
                Types::Instance *ret = nativeFunc(this, func, argv);
                if (ret != nullptr) {
                    desc->retVal = ret;
                }
            } else {
                std::stringstream ss;
                ss << "Calling to ";
                ss << inst->getTypeName();
                Exceptions::TypeCheckException(ss.str()).throwException();
            }
            if (desc->retVal != nullptr) {
                //std::cout << inst << " returned " << desc->retVal << std::endl;
                Types::Instance *cl = desc->retVal->clone();
                cl->setId(targId);
                (*this->idmap)[targId] = cl;
                //std::cout << this->idmap->at(targId) << std::endl;
            } else {
                //Delete Argument Buffer, GC
                this->del(targId);
            }
        }
    }

    void Descriptor::executeAll(Program::Op until) {
        Program::Op current = Program::UNKNOWN;
        while (not(until == current)) {
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
            if (retVal != nullptr) {
                return;
            }
        }
    }

    void Descriptor::doAll() {
        this->readHeader();
        ERABLE_DEBUG std::cout << this->getInput()->getData()->meta->toString() << std::endl;
        this->executeAll(Program::END);
    }

    //class Descriptor
}