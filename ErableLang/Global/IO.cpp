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
#include "IO.hpp"


#include "Exceptions.hpp"
#include "Global.hpp"
//#include "VM/VMGlobal.hpp"
//#include "Utils.h"

namespace Erable::IO {

    template<typename T>

    std::ostream &operator<<(std::ostream &os, const std::vector<T> &obj) {
        os << "[";
        for (int i = 0; i < obj.size(); ++ i) {
            os << (int) obj[i];
            if (i < obj.size() - 1)os << ",";
        }
        os << "]";
        return os;
    }

    void File::mkdir() {
        boost::filesystem::create_directory(this->path);
        //::access(this->path, 6);
    }

    std::vector<boost::filesystem::path> File::listFiles() {
        boost::filesystem::directory_iterator d(this->path);
        boost::filesystem::directory_iterator e = boost::filesystem::end(d);
        std::vector<boost::filesystem::path> v;
        while (d != e) {
            v.push_back(*d);
            d++;
        }
        return v;
    }

    void InputStream::open(File f) {
        std::string path(boost::filesystem::absolute(f.getPath()).string());
        this->in = new std::ifstream(path, std::ios::in | std::ios::binary);
        //this->in->get();
        ERABLE_DEBUG std::cout << "Opened:" << path << std::endl;
        if (in->fail()) {
            std::cout << "Open Failed!!Message:" << strerror(errno) << std::endl;
        }
        begin = std::istreambuf_iterator<char>(*(this->in));
        end = std::istreambuf_iterator<char>();
    }

    char InputStream::read() {

        char c = *begin;
        ++begin;
        //std::cout << "Current Cursor Position: " << curpos << ", read: " << (int) c << std::endl;
        //if (c == EOF) Exceptions::IOException("EOF").throwException();
        return c;
    }

    std::vector<char> InputStream::readNBytes(long long n) {
        std::vector<char> bts;

        REPEAT_TIMES(n) {
            char c = this->read();
            //std::cout << (int) c << std::endl;
            bts.push_back(c);
        }
        //std::cout << bts << std::endl;
        return bts;
    }

    std::vector<char> InputStream::readAllBytes() {
        std::vector<char> bts = std::vector<char>();
        std::copy(begin, end, std::back_inserter(bts));
        return bts;
    }

    void InputStream::skip(long long n) {
        this->in->ignore(n, EOF);
    }

    void InputStream::close() {
        this->in->close();
    }
}
