cmake_minimum_required(VERSION 3.13)
project(ErableLang)

set(CMAKE_CXX_STANDARD 17)

add_subdirectory(stdlib)
add_subdirectory(VM)


install(TARGETS ErableVM DESTINATION bin)
install(TARGETS ErableVMDyn DESTINATION lib)
install(TARGETS ErableStdlib DESTINATION lib)