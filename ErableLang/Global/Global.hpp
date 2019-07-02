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
 * File:   GlobalMacros.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月21日, 下午7:41
 */

#pragma once
#ifndef GLOBALMACROS_HPP
#define GLOBALMACROS_HPP

#include <cstdlib>
#include <string>
#include <boost/filesystem.hpp>
#include <regex>


#define REPEAT(v, t) for(long long (v)=0;v<t;++ v)
#define REPEAT_TIMES(t) REPEAT(_,t)
using namespace boost;
namespace Erable {
    class Config {
    public:
        inline static bool debug, stdlib;
    };

    inline int UNKNOWN = -1;

    std::string getLib();

    std::string getBin();

    std::string findStdLib();

	std::string searchFile(filesystem::path path, std::regex reg);

    std::string findInFollowing(const std::vector<std::string> &paths, std::string reg);

    std::string checkExists(const std::string &key);
}

#define ERABLE_DEBUG if(Erable::Config::debug)


//----Erable Type Check----//

//----Repeat----//


//----Throws Unsupported Operation Exception----//



//---------For Instance Use-------------//
//-----Instance Override-----//

//-----Virtual OpFunction Declare-----//

//-----OpCode Functions-----//

//-----BuiltiIn Native Function Initialising-----//

//-----Instance Clone and getTypeName-----//

//-----------End Instance Use------------//


#endif /* GLOBALMACROS_HPP */

