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
 * File:   NativeFunctions.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年5月16日, 下午5:41
 */
#pragma once
#ifndef NATIVEFUNCTIONS_HPP
#define NATIVEFUNCTIONS_HPP


#include "Descriptor.hpp"
#include <functional>


namespace Erable{
    namespace Native{
	typedef std::function<Types::Instance*(Erable::Descriptor*, Erable::Types::NativeFunction*, Erable::Types::Array*)> functype;
	typedef std::map<std::string, functype> funcmap;
	class BuiltIn_t{
	public:
	    DEFINE_NATIVE_FUNCTION(print);
	    DEFINE_NATIVE_FUNCTION(scan);
	};
	class Functions_t{
	public:
	    funcmap functions;
	    Functions_t();
	};
	inline Functions_t Functions;
	inline BuiltIn_t BuiltIn;
    }
}

#endif /* NATIVEFUNCTIONS_HPP */

