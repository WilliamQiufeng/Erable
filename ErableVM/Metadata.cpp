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

//#include "IO.hpp"
#include "Metadata.hpp"
#include "Utils.h"
#include "Exceptions.hpp"

namespace Erable {

    namespace Meta {
	std::vector<char> magic{(char) (unsigned char) 0xe4, (char) (unsigned char) 0xab};
	//std::vector<unsigned char> magic{0xe4, 0xab};

	void Metadata::readMagic() {
	    std::vector<char> bts = this->in->readNBytes(2);
	    if (magic != bts) {
		std::cout << "Assertion Error: VM is expecting magic number "
			<< Utils::ArrayUtils.toString(magic)
			<< ", but got "
			<< Utils::ArrayUtils.toString(bts)
			;

		throw Exceptions::ValidateException("Magic number not correct");
	    }

	    //assert magic==bts;
	}

	void Metadata::readVersion() {
	    char major = this->in->read();
	    char minor = this->in->read();
	    this->ver = VersionMeta{major, minor};
	}

	void Metadata::readIDLength() {
	    char len = this->in->read();
	    int id_len = len >> 4;
	    int cid_len = len & 0b00001111;
	    this->idlen = IDLengthMeta{id_len, cid_len};
	}

	void Metadata::readHeader() {
	    this->readMagic();
	    this->readVersion();
	    this->readIDLength();
	}

	std::string Metadata::toString() {
	    std::stringstream ss;
	    ss << "Metadata{"
		    << "Major: "
		    << this->ver.major
		    << ", Minor: "
		    << this->ver.minor
		    << ", ID length: "
		    << this->idlen.id
		    << ", CID length: "
		    << this->idlen.cid
		    << "}"
		    ;
	    return ss.str();
	}
    }
}