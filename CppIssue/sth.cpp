/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include "sth.hpp"
#include "par.hpp"


template <typename type>
class A{
    public:
    type val;
    int sth;
    N* par;
    
    A(type val, int sth, N* par) :
    val(val), sth(sth), par(par) {
    }

};
class B : public A<int>{
    B(int val, int sth, N* par) :
    A<int>(val, sth, par) {
    }

};
class C : public A<std::string>{
    C(std::string val, int sth, N* par) :
    A<std::string>(val, sth, par) {
    }

};