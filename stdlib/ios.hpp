/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ios.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年5月18日, 下午12:04
 */
#pragma once
#ifndef IOS_HPP
#define IOS_HPP

#include "../NativeFunctions.hpp"
#include "../Global.hpp"


namespace Erable{
    namespace Native{
	namespace BuiltIn{
	    DEFINE_NATIVE_FUNCTION(print);
	    DEFINE_NATIVE_FUNCTION(scan);
	}
    }
}

#endif /* IOS_HPP */

