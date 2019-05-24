cmake_minimum_required(VERSION 3.14)
project(StdLib_Native)

set(CMAKE_CXX_STANDARD 17)

include_directories("../ErableVM/")

add_library(StdLib_Native SHARED IOS.cpp IOS.hpp)