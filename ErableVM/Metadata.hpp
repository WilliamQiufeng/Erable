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
 * File:   Metadata.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月24日, 上午7:09
 */

#pragma once

#ifndef METADATA_HPP
#define METADATA_HPP

//#include <vector>
//#include "Metadata.hpp"
#include <iostream>

namespace Erable{
    namespace Meta{
	struct VersionMeta;
	struct IDLengthMeta;
	class Metadata;
    }
}
#include "Program.hpp"
//#include "IO.hpp"
//#include "Utils.h"

namespace Erable {

    namespace Meta {

        struct VersionMeta {
	    int major;
	    int minor;
	};

	struct IDLengthMeta {
	    int id;
	    int cid;
	};

        class Metadata{
	    Program::ProgramInputStream* in;
            VersionMeta ver;
            IDLengthMeta idlen;
	  public:

	    Metadata(Program::ProgramInputStream* in) :
	    in(in) {
	    }
	    inline IDLengthMeta getIdlen() const {
		return idlen;
	    }

	    inline void setIdlen(IDLengthMeta idlen) {
		this->idlen = idlen;
	    }

	    inline Program::ProgramInputStream* getIn() const {
		return in;
	    }

	    void setIn(Program::ProgramInputStream* in);

	    VersionMeta getVer() const {
		return ver;
	    }

	    void setVer(VersionMeta ver) {
		this->ver = ver;
	    }

	    void readMagic();
            void readVersion();
            void readIDLength();
            void readHeader();
            std::string toString();
	};
    }
}

#endif /* METADATA_HPP */

