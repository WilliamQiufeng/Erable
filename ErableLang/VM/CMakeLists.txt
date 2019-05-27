cmake_minimum_required(VERSION 3.10)
project(ErableVM)

set(CMAKE_CXX_STANDARD 17)



find_package(Boost 1.57.0 COMPONENTS system filesystem REQUIRED)

if (Boost_FOUND)
    message(STATUS "Boost_INCLUDE_DIRS: ${Boost_INCLUDE_DIRS}")
    message(STATUS "Boost_LIBRARIES: ${Boost_LIBRARIES}")
    message(STATUS "Boost_VERSION: ${Boost_VERSION}")
    include_directories(${Boost_INCLUDE_DIRS})

endif ()

include_directories(/usr/local/include)
include_directories(../Global)
link_directories(/usr/local/lib)
include_directories(..)
include_directories(../include)

set(SOURCES
        ../include/dynamicro.cpp
        ../include/dynamicro.h
        ../include/cmdline.h
        ConstantPool.cpp
        ConstantPool.hpp
        Descriptor.cpp
        Descriptor.hpp
        ../Global/Exceptions.hpp
        Global.cpp
        Global.hpp
        ../Global/IO.cpp
        ../Global/IO.hpp
        LibLoader.cpp
        LibLoader.hpp
        Metadata.cpp
        Metadata.hpp
        NativeFunctions.cpp
        NativeFunctions.hpp
        Program.cpp
        Program.hpp
        Types.cpp
        Types.hpp
        ../Global/Utils.h ../Global/Exceptions.cpp)
set(ERABLE_MAIN main.cpp)
set(TARGETS ErableVM ErableVMDyn ErableVMStatic)

add_executable(ErableVM ${SOURCES} ${ERABLE_MAIN})
add_library(ErableVMDyn SHARED ${SOURCES})
add_library(ErableVMStatic STATIC ${SOURCES})

set_property(TARGET ${TARGETS} PROPERTY CXX_STANDARD 17)
if (Boost_FOUND)

    target_link_libraries(ErableVM ${Boost_LIBRARIES})
    target_link_libraries(ErableVMDyn ${Boost_LIBRARIES})
    target_link_libraries(ErableVMStatic ${Boost_LIBRARIES})

endif ()
