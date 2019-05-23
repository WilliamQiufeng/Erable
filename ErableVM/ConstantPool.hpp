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
 * File:   ConstantPool.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月30日, 上午7:10
 */
#pragma once
#ifndef CONSTANTPOOL_HPP
#define CONSTANTPOOL_HPP


#include <map>
#include <sys/_types/_size_t.h>
//#include "Metadata.hpp"
namespace Erable {
    class ConstantPool;
}

#include "IO.hpp"
#include "Program.hpp"
#include "Descriptor.hpp"
#include "Types.hpp"


namespace Erable {

    class ConstantPool {
        std::map<int, Erable::Types::Instance *> elements;
    public:
        void setElement(int id, Erable::Types::Instance *element) {
            elements[id] = element;
        }

        Erable::Types::Instance *getElement(std::size_t id) {
            return this->elements[id];
        }

        std::map<int, Erable::Types::Instance *> getElements() const {
            return elements;
        }

        void setElements(std::map<int, Erable::Types::Instance *> elements) {
            this->elements = elements;
        }

        ConstantPool operator+(Erable::Types::Instance *right) const;

        ConstantPool &operator+=(Erable::Types::Instance *right);

        Erable::Types::Instance *operator[](std::size_t index);

        const Erable::Types::Instance *operator[](std::size_t index) const;

        friend std::ostream &operator<<(std::ostream &os, ConstantPool &obj);

        void load(Program::ProgramInputStream *in);

    };
}

#endif /* CONSTANTPOOL_HPP */

