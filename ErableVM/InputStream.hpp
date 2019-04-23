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
 * File:   InputStream.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月22日, 下午6:39
 */

#ifndef INPUTSTREAM_HPP
#define INPUTSTREAM_HPP

#include <fstream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <boost/filesystem.hpp>



#include "Exceptions.hpp"
#include "Global.hpp"


namespace Erable {
    namespace IO {
        /*
         * Implementation of java.io.File from java
         * Not full implemented
         */
        class File {
            boost::filesystem::path path;
        public:

            File(std::string str) {
                this->path = str;
            }

            File(std::string str, std::string child) {
                this->path = str;
                this->path += child;
            }

            boost::filesystem::path getPath() {
                return this->path;
            }
            void mkdir(){
                boost::filesystem::create_directory(this->path);
                //::access(this->path, 6);
            }
            std::vector<boost::filesystem::path> listFiles(){
                boost::filesystem::directory_iterator d(this->path);
                boost::filesystem::directory_iterator e=boost::filesystem::end(d);
                std::vector<boost::filesystem::path> v;
                while(d!=e){
                    v.push_back(*d);
                    d++;
                }
                return v;
            }
            
        };
        /*
         * Implementation of java.io.InputStream from java
         */
        class InputStream {
            std::ifstream in;
            std::istreambuf_iterator<char> begin;
            std::istreambuf_iterator<char> end;
        public:

            InputStream(File f) {
                this->open(f);
            }

            void open(File f) {
                this->in.open(f.getPath().generic_string(), std::ios::in | std::ios::binary);
                begin = std::istreambuf_iterator<char> (this->in);
                end = std::istreambuf_iterator<char>();
            }

            char read() {
                if (begin == end) {
                    return EOF;
                }
                char c = *begin;
                begin++;
                return c;
            }

            std::vector<char> readNBytes(long long n) {
                std::vector<char> bts;

                REPEAT_TIMES(n) {
                    bts.push_back(read());
                }
                return bts;
            }

            std::vector<char> readAllBytes() {
                std::vector<char> bts = std::vector<char>();
                std::copy(begin, end, std::back_inserter(bts));
                return bts;
            }

            void skip(long long n) {
                this->in.ignore(n, EOF);
            }
            void close(){
                this->in.close();
            }
        };
        
    }
}

#endif /* INPUTSTREAM_HPP */

