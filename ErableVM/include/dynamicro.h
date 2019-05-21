#ifndef _TFC_DYNAMICRO_H_
#define _TFC_DYNAMICRO_H_

/*
 * Copyright (c) Tanpero 2019
 * All rights reserved.
 *
 * Provide a set of useful methods to easily call
 * the interface in the dynamic link library.
 *
 * A subproject of Tanpero Foundation Classes (TFC)
 */

#include <string>
#include <map>
#include <functional>
#include <type_traits>
#include <utility>
#include <boost/predef.h>


#if (BOOST_OS_UNIX || BOOST_OS_LINUX || BOOST_OS_MACOS)
#include <dlfcn.h>
#include <iostream>
#elif BOOST_OS_WINDOWS
#include <Windows.h>
#endif
#if defined(__GNUC__) && (BOOST_OS_LINUX || BOOST_OS_UNIX || BOOST_OS_MACOS)
#define ON_LINUX 1
#else
#define ON_OTHER 1
#endif

class Dynamicro {
public:

    Dynamicro() : m_hMod(nullptr) {
    }

    ~Dynamicro() {
	unload();
    }

    bool load(const std::string& dllPath);

    bool unload();

    template <typename T>
    std::function<T> get(const std::string& funcName) {
	std::map<std::string, moduleType>::iterator it = m_map.find(funcName);
	if (it == m_map.end()) {

#ifdef ON_OTHER
	    auto addr = GetProcAddress(m_hMod, funcName.c_str());
#elif ON_LINUX
	    auto addr = dlsym(m_hMod, funcName.data());
#endif // WIN32

	    if (!addr)
		return nullptr;
	    m_map.insert(std::make_pair(funcName, addr));
	    it = m_map.find(funcName);
	}

	return std::function<T>((T*) (it->second));
    };

    template <typename T, typename... Args>
    typename std::result_of<std::function<T>(Args...)>::type exec(const std::string& funcName, Args&&... args) {
	auto f = get<T>(funcName);
	if (f == nullptr) {
	    std::string s = "can not find this function " + funcName;
	    std::cout<<s<<std::endl;
	    throw std::exception();
	}

	return f(std::forward<Args>(args)...);
    };

private:

#ifdef ON_OTHER
    using moduleType = HMODULE;
#elif ON_LINUX
    using moduleType = void*;
#endif // WIN32

    moduleType m_hMod;
    std::map<std::string, moduleType> m_map;
};

#endif // !_TFC_DYNAMICRO_H_

