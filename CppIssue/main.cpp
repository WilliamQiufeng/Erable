/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.cpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月20日, 下午10:04
 */

#include <cstdlib>
#include <string>
#include "sth.hpp"

using namespace std;
#include<iostream>
using namespace std;

class Base {
  public:

    Base(int x = 3) {
	cout << "Cout from Base::Base" << endl;
	cout << x << endl;
	this->x = x;
	cout << "Base x=" << this->x << endl;
    }
    int x;
};

class Derived : Base {
  public:

    Derived(int x = 0) {
	cout << "Cout from Derived::Derived" << endl;
	cout << x << endl;
	cout << "Finished" << endl;
	//this->x=x;
	cout << "Derived x=" << this->x << endl;
    }
    int x;
  private:
    Base val = Base(2);
};

template <typename C>
class TBase {
  public:
    C a;

    TBase(C a) :
    a(a) {
    }

    inline virtual void dosth(TBase* t, int i) {
	cout << "hi " << static_cast<int> (a) << ":" << i << endl;

    }
};

class TImpl : public TBase<int> {
  public:

    TImpl(int a) :
    TBase<int>(a) {
    }
    //using TBase::dosth;
    //template <>

    void dosth(TBase<int>* t, int i) override {
	cout << "Impl " << this->a << ":" << i << endl;
    }

};

class TImpl2 : public TBase<int> {
  public:

    TImpl2(int a) :
    TBase(a) {
    }
    //using TBase::dosth;
    //template <>

    void dosth(TBase<int>* t, int i) override {
	cout << "Impl2 " << a << ":" << i << endl;
    }

};

class ACCA {
  public:
    int i = 0;

    void b() {
	std::cout << i + 2934 << std::endl;
    };
};
#define ACCAA(name) & ACCA::name

int main() {
    Derived d(1);
    TBase<int>* a = new TImpl(1);
    TBase<int>* c = new TImpl2(7);
    TBase<int>* b = new TBase<int>(2);
    a->dosth(a, 3);
    b->dosth(b, 4);
    b->dosth(a, 5);
    a->dosth(b, 6);
    c->dosth(a, 8);
    cout << endl << typeid (double).name() << endl;
    ACCA acca;
    std::function<void() > accab = std::bind(ACCAA(b), acca);
    accab();
    //    '__bind<Erable::Types::Instance *(Erable::Native::BuiltIn_t::*)(Erable::Descriptor *, Erable::Types::NativeFunction *, Erable::Types::Array *), Erable::Native::BuiltIn_t &>'
    //    'function<Types::Instance *(Erable::Descriptor *, Erable::Types::NativeFunction *, Erable::Types::Array *)>'
    return 0;
}


