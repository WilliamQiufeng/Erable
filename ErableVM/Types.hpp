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
 * File:   Types.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 下午1:17
 */

#ifndef TYPES_HPP
#define TYPES_HPP

#include "Descriptor.hpp"


namespace Erable{
    namespace Types {
        template <typename type>
        class Instance;
        class Double;
        class Integer;
        //template<typename type=std::string>
        class String;
        template <typename T>
        class Function;
    }
}

#endif /* TYPES_HPP */

