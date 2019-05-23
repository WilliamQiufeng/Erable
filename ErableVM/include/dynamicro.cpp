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

#include "dynamicro.h"

bool Dynamicro::load(const std::string &dllPath) {
#if ON_OTHER
    m_hMod = LoadLibraryA(dllPath.data());
#elif ON_LINUX
    m_hMod = dlopen(dllPath.data(), RTLD_NOW);
    dlerror();
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



