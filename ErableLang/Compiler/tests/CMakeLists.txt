project(ErableCompilerTest)
cmake_minimum_required(VERSION 3.14)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_C_FLAGS "${CMAKE_CXX_FLAGS} -fsanitize=address -g")
find_package(Catch2 REQUIRED)
find_library(ErableCompilerDyn ErableCompilerDyn REQUIRED)
find_library(ErableCompilerStatic ErableCompilerStatic REQUIRED)

include_directories(.)
include_directories(..)
link_directories(..)
include_directories(../Global)
include_directories(../include)


add_executable(ErableCompilerTest Erable_Compiler_AST_Name_Test.cpp Erable_Utils_List.cpp Erable_Utils_List.hpp)

target_link_libraries(ErableCompilerTest Catch2::Catch2)


link_libraries(ErableCompilerDyn)

include(CTest)
include(Catch)
catch_discover_tests(ErableCompilerTest)
