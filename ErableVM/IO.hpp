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
#pragma once
#ifndef INPUTSTREAM_HPP
#define INPUTSTREAM_HPP


#include <fstream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <boost/filesystem.hpp>
#include <iostream>


#include "Exceptions.hpp"
#include "Global.hpp"
//#include "Utils.h"

//#include "Metadata.hpp"


namespace Erable::IO {
        /*
         * Implementation of java.io.File from java
         * Not fully implemented
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

            void mkdir();

            std::vector<boost::filesystem::path> listFiles();

        };

        /*
         * Implementation of java.io.InputStream from java
         */
        class InputStream {
            std::ifstream *in;
            std::istreambuf_iterator<char> begin;
            std::istreambuf_iterator<char> end;
        public:

            InputStream(File f) {
                this->open(f);
            }

            InputStream(std::string f) {
                this->open(f);
            }

            void open(std::string f) {
                this->open(File(f));
            }

            void open(File f);

            char read();

            std::istreambuf_iterator<char> getBegin() const {
                return begin;
            }

            void setBegin(std::istreambuf_iterator<char> begin) {
                this->begin = begin;
            }

            std::istreambuf_iterator<char> getEnd() const {
                return end;
            }

            void setEnd(std::istreambuf_iterator<char> end) {
                this->end = end;
            }

            std::ifstream *getIn() const {
                return this->in;
            }

            void setIn(std::ifstream *in) {
                this->in = in;
            }

            std::vector<char> readNBytes(long long n);

            std::vector<char> readAllBytes();

            void skip(long long n);

            void close();
        };
    }

#endif /* INPUTSTREAM_HPP */

