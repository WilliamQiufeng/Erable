/*
 * Copyright (c) Tanpero 2019
 * This CPP file is created by Qiufeng54321
 * All rights reserved.
 *
 * Provide a set of useful methods to easily call
 * the interface in the dynamic link library.
 *
 * A subproject of Tanpero Foundation Classes (TFC)
 */

#include <Exceptions.hpp>
#include "dynamicro.h"

bool Dynamicro::load(const std::string &dllPath) {
#if ON_OTHER
    m_hMod = LoadLibraryA(dllPath.data());
#elif ON_LINUX
    m_hMod = dlopen(dllPath.data(), RTLD_NOW);
    if (!m_hMod) {
        const char *err = dlerror();
        Erable::Exceptions::ValidateException(std::string("Failed to load ") + dllPath + ": " + err).throwException();
    }
#endif // ON_OTHER

    if (m_hMod == nullptr) {
        printf("load library failed\n");
        return false;
    }

    return true;
}

bool Dynamicro::unload() {
    if (m_hMod == nullptr)
        return true;

#ifdef ON_OTHER
    auto b = FreeLibrary(m_hMod);
#elif ON_LINUX
    auto b = dlclose(m_hMod);
#endif

    if (!b)
        return false;

    m_hMod = nullptr;
    return true;
}

//template<typename T>
//std::function<T> Dynamicro::get(const std::string& funcName)

//template<typename T, typename... Args>
//std::result_of<std::function<T>()()>::type Dynamicro::exec(const std::string& funcName, Args&& args)



