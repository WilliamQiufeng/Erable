/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "Descriptor.hpp"
#include "Program.hpp"

/*
 * File:   main.cpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月18日, 上午11:22
 */



#include <cstdlib>
#include <iostream>
#include "cmdline.h"
#include "Program.hpp"
#include "Descriptor.hpp"
#include "Metadata.hpp"
#include "LibLoader.hpp"
#include "NativeFunctions.hpp"

/*
 *
 */
int main(int argc, char **argv) {
    cmdline::parser argparse;
    argparse.add<std::string>("file", 'f', "file to execute", false,
                              "/williamye/program/antlr/erable/test/instance.ec");
    argparse.parse_check(argc, argv);
    std::string ec = argparse.get<std::string>("file");


    Erable::Native::Library::Loader loader;
    loader.load(Erable::getLib() + "libstdlib.dylib");
    //Erable::Native::loadBuiltIn();
    Erable::Descriptor desc;
    std::cout << "INITIALISED" << std::endl;
    desc.setInput(new Erable::Program::ProgramInputStream(ec));
    std::cout << "EXECUTE..." << std::endl;
    std::cout << "------------------------------------------------" << std::endl;
    desc.doAll();
    std::cout << "------------------------------------------------" << std::endl;
    std::cout << "TERMINATED..." << std::endl;
    std::cout << "Dump >_<" << std::endl;
    std::cout << desc << std::endl;
    return 0;
}

