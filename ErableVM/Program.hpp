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
 * File:   Program.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年5月5日, 下午12:53
 */
#pragma once
#ifndef PROGRAM_HPP
#define PROGRAM_HPP


namespace Erable::Program {
    struct Data;
    struct Op;

    class ProgramInputStream;


    }

#include "ConstantPool.hpp"
#include "Metadata.hpp"
#include "OpCode.hpp"
#include "IO.hpp"
//#include "OpCode.hpp"
//#include "ConstantPool.hpp"
//#include "Metadata.hpp"




namespace Erable::Program {
    std::ostream &operator<<(std::ostream &os, std::vector<Op> obj);

    struct Data {
        ConstantPool *pool;
        Meta::Metadata *meta;
    };

    struct Op {
        OpCodeElement op;
        std::vector<int> argv;

        Op(OpCodeElement op, std::vector<int> argv) :
                op(op), argv(argv) {
        }

        bool operator==(const Op &right) const;

        int &operator[](std::size_t index);

        const int &operator[](std::size_t index) const;

        int &operator*();

        const int &operator*() const;

        friend std::ostream &operator<<(std::ostream &os, const Op &obj);
    };

    inline Op END = Op(Erable::OpCode.values().find("EXIT")->value, std::vector<int>());
    inline Op UNKNOWN = Op(Erable::OpCodeElement("", -1, -1), std::vector<int>());

    class ProgramInputStream : public IO::InputStream {
        Data *data;
    public:

        ProgramInputStream(IO::File f) :
                InputStream(f) {
            init();
        }

        ProgramInputStream(std::string f) :
                InputStream(f) {
            init();
        }

        void init();

        inline Data *getData() const {
            return data;
        }

        inline void setData(Data *data) {
            this->data = data;
        }

        void readConstantPool();

        void readMeta();

        OpCodeElement readOpCode();

        Op readOp();

        int readId(int len);
    };
    }

#endif /* PROGRAM_HPP */

