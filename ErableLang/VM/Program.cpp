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

#include "Program.hpp"


namespace Erable::Program {

    template<typename T>

    std::ostream &operator<<(std::ostream &os, const std::vector<T> &obj) {
        os << "[";
        for (int i = 0; i < obj.size(); inc i) {
            os << (int) obj[i];
            if (i < obj.size() - 1)os << ",";
        }
        os << "]";
        return os;
    }

    std::ostream &operator<<(std::ostream &os, const std::vector<Op> &obj) {
        os << "{\n";
        for (const Op &op : obj) {
            os << "\t\t";
            os << op;
            os << ";\n";
        }
        os << "\n\t}";
        return os;
    }

    bool Op::operator==(const Op &right) const {
        if (!(this->op == right.op)) return false;
        if (this->argv.size() isnt right.argv.size()) return false;
        int ind = 0;
        for (int arg : this->argv) {
            if (arg == -1 or right.argv[ind] == -1) continue;
            if (arg != right.argv[ind]) return false;
        }
        return true;
    }

    int &Op::operator[](std::size_t index) {
        return this->argv[index];
    }

    const int &Op::operator[](std::size_t index) const {
        // Ether actual access to element
        // or reuse non-const operator, for example:
        return const_cast<int &> ((*this)[index]);
    }

    int &Op::operator*() {
        std::cout << "Call to Op::operator*()" << std::endl;
        if (this->op.idind == -1) return Erable::UNKNOWN;
        return this->argv[this->op.idind];
    }

    const int &Op::operator*() const {
        return const_cast<int &> (*(*this));
    }

    void ProgramInputStream::readConstantPool() {
        this->data->pool->load(this);
    }

    void ProgramInputStream::readMeta() {
        this->data->meta->readHeader();
    }

    void ProgramInputStream::init() {
        this->setData(new Data{new ConstantPool(), new Meta::Metadata(this)});
    }

    OpCodeElement ProgramInputStream::readOpCode() {
        char c = this->read();
        OpCodeElement ele = Erable::OpCode.values().find(c).value;
        return ele;
    }

    Op ProgramInputStream::readOp() {
        OpCodeElement ele = this->readOpCode();
        std::vector<int> argv;
        if (ele.op == "LOADC") {
            int cid = this->readId(this->getData()->meta->getIdlen().cid);
            int id = this->readId(this->getData()->meta->getIdlen().id);
            argv.push_back(cid);
            argv.push_back(id);
        } else if (ele.op == "DYNCALL") {
            int mid = this->readId(this->getData()->meta->getIdlen().id);
            int aid = this->readId(4);
            int tid = this->readId(this->getData()->meta->getIdlen().id);
            argv.push_back(mid);
            argv.push_back(aid);
            argv.push_back(tid);
        } else {
            for (int i = 0; i < ele.argc; ++i) {
                int id = this->readId(this->getData()->meta->getIdlen().id);
                argv.push_back(id);
            }
        }
        Op op = Op{ele, argv};
        return op;
    }

    int ProgramInputStream::readId(int len) {
        std::vector<char> charv = this->readNBytes(len);
        //std::cout << "Reading ID : " << charv << std::endl;
        switch (len) {
            case 1:
                return charv[0];
            case 2:
                return Utils::BitUtils.getShort(charv, 0);
            case 4:
                return Utils::BitUtils.getInt(charv, 0);
            default:
                std::stringstream ss;
                ss << "Invalid ID Length:" << len;
                Exceptions::ValidateException(ss.str()).throwException();
        }
        return -1;
    }

    std::ostream &operator<<(std::ostream &os, const Op &obj) {
        os << obj.op.op
           << "("
           << obj.argv
           << ")";
        if (obj.op.idind != -1) {
            os << " -> "
               << obj.argv[obj.op.idind];
        }
        return os;
    }


    }