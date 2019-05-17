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

    std::ostream& operator<<(std::ostream& os, ConstantPool& obj) {
	os << "ConstantPool[" << obj.elements.size() << "] :" << std::endl;
	for (auto&[key, value] : obj.elements) {
	    os << "\t";
	    os << key;
	    os << " = ";
	    os << value;
	    os << std::endl;
	}
	return os;
    }

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

    void ConstantPool::load(Program::ProgramInputStream* in) {
	//std::cout << "Reading Size..." << std::endl;
	int times = in->readId(in->getData()->meta->getIdlen().cid);
	//std::cout << "Constant Pool Size: " << times << std::endl;

	REPEAT(i, times) {
	    OpCodeElement type = in->readOpCode();
	    Types::Instance* instance;
	    //std::cout << "Element Type: " << type.op << std::endl;
	    if (type.op is "CP_NUM") {
		std::vector<char> doubcv = in->readNBytes(8);
		double doub = Utils::BitUtils.getDouble(doubcv, 0);
		//std::cout << "ADDED CONSTANT_POOL NUMBER : ID = " << i << ", VALUE = " << doub << std::endl;
		instance = new Types::Double(doub, i, nullptr);
	    } else if (type.op is "CP_INT") {
		std::vector<char> intcv = in->readNBytes(4);
		int integer = Utils::BitUtils.getInt(intcv, 0);
		instance = new Types::Integer(integer, i, nullptr);
		//std::cout << "ADDED CONSTANT_POOL INTEGER: ID = " << i << ", VALUE = " << integer << std::endl;
	    } else if (type.op is "CP_STR") {
		int length = in->readId(4);
		std::vector<char> strcv = in->readNBytes(length);
		strcv.push_back('\0');
		char* strdata = strcv.data();
		std::string str(strdata);
		instance = new Types::String(str, i, nullptr);
		//std::cout << "ADDED CONSTANT_POOL STRING : ID = " << i << ", VALUE = " << str << std::endl;
	    } else {
		std::stringstream ss;
		ss << "Constant Pool Element not valid: " << type.op << std::endl;
		std::string err(ss.str());
		throw Exceptions::ValidateException(err);
	    }
	    //std::cout << "Added Constant Pool Element: " << instance << std::endl;
	    this->setElement(i, instance);
	}
	//std::cout << "Constant Pool Ended..." << std::endl;
    }
}