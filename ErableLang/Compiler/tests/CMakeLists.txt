project(ErableCompilerTest)
cmake_minimum_required(VERSION 3.14)
set(CMAKE_CXX_STANDARD 17)
find_package(Catch2 REQUIRED)
find_library(ErableCompilerDyn ErableCompilerDyn REQUIRED)

include_directories(.)
include_directories(..)
include_directories(../Global)
include_directories(../include)


add_executable(ErableCompilerTest Erable_Compiler_AST_Name_Test.cpp)

target_link_libraries(ErableCompilerTest Catch2::Catch2)


target_link_libraries(ErableCompilerTest ErableCompilerDyn)

include(CTest)
include(Catch)
catch_discover_tests(ErableCompilerTest)
