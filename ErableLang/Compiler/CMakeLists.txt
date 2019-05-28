cmake_minimum_required(VERSION 3.10)
project(ErableCompiler)

set(CMAKE_CXX_STANDARD 17)


include_directories(/usr/local/include)
link_directories(/usr/local/lib)
include_directories(.)
include_directories(..)
include_directories(../Global)
include_directories(../include)

add_executable(ErableCompiler main.cpp Tokens.cpp Tokens.hpp Lexer.cpp Lexer.hpp)
