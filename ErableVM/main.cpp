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
    argparse.add("debug", 'd', "Turn on developer debugging mode");
    argparse.add("no-stdlib", 'S', "Don't load Default ErableStdlib on start");
    argparse.parse_check(argc, argv);
    std::string ec = argparse.get<std::string>("file");
    Erable::Config::debug = argparse.exist("debug");
    Erable::Config::stdlib = !argparse.exist("no-stdlib");

    if (Erable::Config::stdlib) {
        //Load the standard library.
        Erable::Native::Library::Loader loader;
        loader.load(Erable::findStdLib());
    }
    //Erable::Native::loadBuiltIn();

    //Execute the whole program
    Erable::Descriptor desc;
    desc.setInput(new Erable::Program::ProgramInputStream(ec));
    ERABLE_DEBUG std::cout << "------------------------------------------------" << std::endl;
    desc.doAll();
    ERABLE_DEBUG std::cout << "------------------------------------------------" << std::endl;

    //Dump ConstantPool and Buffer Map on exit
    ERABLE_DEBUG {
        std::cout << "Dump >_<" << std::endl;
        std::cout << desc << std::endl;
    }
    return 0;
}

