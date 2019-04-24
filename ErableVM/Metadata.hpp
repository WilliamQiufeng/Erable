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

#ifndef METADATA_HPP
#define METADATA_HPP

//#include <vector>
#include <iostream>
#include "InputStream.hpp"
//#include "Utils.h"

namespace Erable {

    namespace Meta {

        struct VersionMeta {
	    char major;
	    char minor;
	};

	struct IDLengthMeta {
	    int id;
	    int cid;
	};

        class Metadata{
	    IO::InputStream* in;
            VersionMeta ver;
            IDLengthMeta idlen;
	  public:

	    Metadata(IO::InputStream* in) :
	    in(in) {
	    }

	    void readMagic();
            void readVersion();
            void readIDLength();
            void readHeader();
	};
    }
}

#endif /* METADATA_HPP */

