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

#include "Global.hpp"
#include "Exceptions.hpp"

namespace Erable {
    //
    //    std::string getHome() {
    //	const char* home = getenv("ERABLE_HOME");
    //	return std::string(home);
    //    }
    std::string checkExists(std::string key) {
        const char *val = std::getenv(key.c_str());
        if (val == nullptr) {
            Erable::Exceptions::ValidateException(std::string("Cannot find enviroment variable '") + key +
                                                  "'. Please make sure that the variable has been set.").throwException();
        }
        return std::string(val);
    }

    std::string getLib() {
        return checkExists("ERABLE_LIB");
    }

    std::string getBin() {
        return checkExists("ERABLE_BIN");
    }
}