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

#include "ConstantPool.hpp"


namespace Erable {

    ConstantPool ConstantPool::operator+(Erable::Types::Instance* right) const {
	ConstantPool result(*this); // 复制自身。
	result += right; // 重用复合赋值
	return result;
    }

    ConstantPool& ConstantPool::operator+=(Erable::Types::Instance* right) {
	// Do addition of right to *this here
	this->elements[right->id] = right;
	return *this;
    }

    Erable::Types::Instance* ConstantPool::operator[](std::size_t index) {
	// Actual access to element
	return elements[index];
    }

    const Erable::Types::Instance* ConstantPool::operator[](std::size_t index) const {
	// Ether actual access to element
	// or reuse non-const operator, for example:
	return const_cast<Erable::Types::Instance*> ((*this)[index]);
    }

    void ConstantPool::load(IO::InputStream& in) {

    }
}