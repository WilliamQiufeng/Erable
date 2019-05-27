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
#include "Utils.h"

namespace Erable {
    //
    //    std::string getHome() {
    //	const char* home = getenv("ERABLE_HOME");
    //	return std::string(home);
    //    }
    std::string checkExists(const std::string &key) {
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

    std::string findStdLib() {
        //auto startTime = std::chrono::system_clock::now();
        std::vector<std::string> libs = Erable::Utils::ArrayUtils.split(getLib(), ":");
        std::string stdlib = findInFollowing(libs, "(ErableStdlib)");
        if (stdlib.empty()) {
            Exceptions::ValidateException("StdLib not found.").throwException();
        }
        //auto total = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now() - startTime);
        //std::cout<<"Found StdLib in " << total.count() << "ms."<<std::endl;
        return stdlib;
    }

    std::string findInFollowing(const std::vector<std::string> &paths, std::string reg) {
        std::regex regexp(reg, std::regex_constants::ECMAScript | std::regex_constants::icase);
        for (std::string s : paths) {
            boost::filesystem::path path(s);
            std::string found = searchFile(path, regexp);
            if (!found.empty()) {
                return found;
            }
        }
        return "";
    }

    std::string searchFile(boost::filesystem::path path, std::regex reg) {
        boost::filesystem::directory_iterator start(path);
        boost::filesystem::directory_iterator end;
        for (; start != end; ++start) {
            boost::filesystem::path p = *start;
            /*if (boost::filesystem::is_directory(*start)) {
                std::string found = searchFile(*start, reg);
                if (!found.empty()) {
                    return found;
                }
            } else {*/
            //std::cout<<p.string()<<std::endl;
            if (std::regex_search(p.leaf().string(), reg)) {
                return p.string();
            }
            //}
        }
        return std::string("");
    }
}