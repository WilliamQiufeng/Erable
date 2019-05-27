cmake_minimum_required(VERSION 3.10)
project(ErableCompiler)

set(CMAKE_CXX_STANDARD 17)
find_package(Boost 1.57.0 COMPONENTS system filesystem REQUIRED)

if (Boost_FOUND)
    message(STATUS "Boost_INCLUDE_DIRS: ${Boost_INCLUDE_DIRS}")
    message(STATUS "Boost_LIBRARIES: ${Boost_LIBRARIES}")
    message(STATUS "Boost_VERSION: ${Boost_VERSION}")
    include_directories(${Boost_INCLUDE_DIRS})

endif ()

include_directories(../Global)
include_directories(../include)

add_executable(ErableCompiler main.cpp Tokens.cpp Tokens.hpp Lexer.cpp Lexer.hpp)

if (Boost_FOUND)

    target_link_libraries(ErableCompiler ${Boost_LIBRARIES})

endif ()