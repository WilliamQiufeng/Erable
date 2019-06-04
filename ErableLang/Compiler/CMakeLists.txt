cmake_minimum_required(VERSION 3.10)
project(ErableCompiler)

set(CMAKE_CXX_STANDARD 17)

find_library(LevelDB leveldb REQUIRED)


include_directories(.)
include_directories(..)
include_directories(../Global)
include_directories(../include)
#include_directories(/usr/local/Cellar/leveldb/1.22/include)

add_executable(ErableCompiler main.cpp Tokens.cpp Tokens.hpp Lexer.cpp Lexer.hpp Scanner.hpp)

link_libraries(${LevelDB})

set_property(TARGET ErableCompiler PROPERTY CXX_STANDARD 17)
