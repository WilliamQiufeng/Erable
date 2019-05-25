/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ios.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年5月18日, 上午11:09
 */
#pragma once
#ifndef MATH_HPP
#define MATH_HPP

#include "../NativeFunctions.hpp"
#include "../Global.hpp"
namespace Erable{
    namespace Native{
	namespace BuiltIn{
	    DEFINE_NATIVE_FUNCTION(sqrt);
	    DEFINE_NATIVE_FUNCTION(log);
		DEFINE_NATIVE_FUNCTION(pow);
	}
    }
}

#endif /* MATH_HPP */

