cmake_minimum_required(VERSION 3.10)
project(ErableLang)
find_package(Doxygen)
set(CMAKE_CXX_STANDARD 17)
if (DOXYGEN_FOUND)

    set(DOXYGEN_INPUT ${SOURCE_FILES})
    set(DOXYGEN_OUTPUT ${CMAKE_CURRENT_BINARY_DIR}/Doxyfile)

    add_custom_command(
            OUTPUT ${DOXYGEN_OUTPUT}
            COMMAND ${CMAKE_COMMAND} -E echo_append "Building API Documentation..."
            COMMAND ${DOXYGEN_EXECUTABLE} ${DOXYGEN_INPUT}
            COMMAND ${CMAKE_COMMAND} -E echo "Done."
            WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}
            DEPENDS ${DOXYGEN_INPUT}
    )

    add_custom_target(apidoc ALL DEPENDS ${DOXYGEN_OUTPUT})

    add_custom_target(apidoc_forced
            COMMAND ${CMAKE_COMMAND} -E echo_append "Building API Documentation..."
            COMMAND ${DOXYGEN_EXECUTABLE} ${DOXYGEN_INPUT}
            COMMAND ${CMAKE_COMMAND} -E echo "Done."
            WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}
            )
    #[[SET(doxyfile_in Doxyfile.in)
    SET(doxyfile Doxyfile)

    CONFIGURE_FILE(${doxyfile_in} ${doxyfile} @ONLY)

    ADD_CUSTOM_TARGET(doc
            COMMAND ${DOXYGEN_EXECUTABLE} ${doxyfile}
            WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}
            COMMENT "Generating API documentation with Doxygen"
            VERBATIM)]]

    INSTALL(DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/html DESTINATION share/doc)

endif (DOXYGEN_FOUND)


add_subdirectory(stdlib)
add_subdirectory(VM)
add_subdirectory(Compiler)
add_subdirectory(Playground)


install(TARGETS ErableVM DESTINATION bin)
install(TARGETS ErableCompiler DESTINATION bin)
install(TARGETS ErableVMDyn DESTINATION lib)
install(TARGETS ErableStdlib DESTINATION lib)