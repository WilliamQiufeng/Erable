cmake_minimum_required(VERSION 3.14)
project(stdlib)
set(CMAKE_CXX_STANDARD 17)
find_package(Boost 1.57.0 COMPONENTS system filesystem REQUIRED)

find_library(ERABLEVM ErableVMDyn ../cmake-build-debug/)

if (Boost_FOUND)

    message(STATUS "Boost_INCLUDE_DIRS: ${Boost_INCLUDE_DIRS}")
    message(STATUS "Boost_LIBRARIES: ${Boost_LIBRARIES}")
    message(STATUS "Boost_VERSION: ${Boost_VERSION}")

    include_directories(${Boost_INCLUDE_DIRS})

endif ()

include_directories(/usr/local/include)
link_directories(/usr/local/lib)
include_directories(.)
include_directories(..)
include_directories(../include)

link_libraries(${ERABLEVM})


add_library(stdlib SHARED IOS.hpp IOS.cpp StdLib.cpp StdLib.hpp)
set_property(TARGET stdlib PROPERTY CXX_STANDARD 17)


if (Boost_FOUND)

    target_link_libraries(stdlib ${Boost_LIBRARIES})

endif ()

