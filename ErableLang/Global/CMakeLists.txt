cmake_minimum_required(VERSION 3.10)
project(ErableGlobal)
set(CMAKE_CXX_STANDARD 17)

add_library(ErableGlobal ./*.h ./*.*pp)
set_property(TARGET ErableGlobal PROPERTY CXX_STANDARD 17)