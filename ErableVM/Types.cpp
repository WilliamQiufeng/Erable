/*
 * Copyright (C) 2019 Qiufeng54321
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
#include "Types.hpp"
#include "Exceptions.hpp"
//#include "Descriptor.hpp"
#include <string>
#include <cmath>
#include <complex>





namespace Erable {
    namespace Types {
        //using namespace std;

        TEMPT class Instance {
        public:
            type value;
            int id;
            Descriptor* parent;

            Instance(type value, int id, Descriptor* parent = nullptr) :
            value(value), id(id), parent(parent) {
            }

            void setValue(type value) {
                this->value = value;
            }

            type getValue() {
                return this->value;
            }

            int getId() const {
                return id;
            }

            void setId(int id) {
                this->id = id;
            }

            Descriptor* getParent() const {
                return parent;
            }

            void setParent(Descriptor* parent) {
                this->parent = parent;
            }

            virtual Instance* add(Instance* other, int toid);
            virtual Instance* sub(Instance* other, int toid);
            virtual Instance* mul(Instance* other, int toid);
            virtual Instance* div(Instance* other, int toid);
            virtual Instance* mod(Instance* other, int toid);
            virtual Instance* pow(Instance* other, int toid);

        };

        TTTTT class Integer : Instance<int, int> {

            Integer(int value, int id, Descriptor* parent = nullptr) :
            Instance<int, int>(value, id, parent) {

            }

            /*
             * 递归下降，如果不是integer就让other来执行operation,如果other也不支持就抛出Exceptions::UnsupportedOpException错误
             * Does other store an integer?
             * √: add and return
             * ∆: execute other->add(this, toid);
             * this won't make any difference when exchanging lvalue and rvalue
             */
            Integer<T>* add(Integer<T>* other, int toid) override {
                if (ISEQU(other, int)) {
                    Integer* i = new Integer(this->getValue() + other->getValue(), toid, this->getParent());
                    return i;
                }
                return other->add(this, toid);
            }

            Integer<T>* sub(Integer<T>* other, int toid) override {
                if (ISNUM(other)) {
                    Integer* i = new Integer(this->getValue() - other->getValue(), toid, this->getParent());
                    return i;
                }
                throw Exceptions::UnsupportedOpException("Operation '-' between Integer and non-Number literal");
            };
            Integer<T>* pow(Integer<T>* other, int toid) override;
        };

        TTTTT class Double : public Instance<double, double> {
        public:

            Double(double value, int id, Descriptor* parent = nullptr) :
            Instance<double, double>(value, id, parent) {
            }

            Double<T>* add(Double<T>* other, int toid) override {
                if (ISNUM(other)) {
                    Double<T>* i = new Double(this->getValue() + other->getValue(), toid, this->getParent());
                    return i;
                }
                return other->add(this, toid);
            }

            Double<T>* sub(Double<T>* other, int toid) override {
                if (ISNUM(other)) {
                    Double<T>* i = new Double(this->getValue() - other->getValue(), toid, this->getParent());
                    return i;
                }
                throw Exceptions::UnsupportedOpException("Operation '-' between Double and non-Number literal");
            }
            Double<T>* pow(Double<T>* other, int toid) override;
        };
        //Integer* Integer::sub(Integer* other, int toid) override

        TTTTT Integer<T>* Integer<T>::pow(Integer<T>* other, int toid) {
            Integer<T>* i = nullptr;
            if (ISNUM(other)) {
                i = new Integer<T>(std::pow(this->getValue(), other->getValue()), toid, this->getParent());
                return i;
            }
            throw Exceptions::UnsupportedOpException("Operation '**' between Integer and non-Number literal");
        }

        TTTTT Double<T>* Double<T>::pow(Double<T>* other, int toid) {
            Double<T>* i = nullptr;
            if (ISNUM(other)) {
                i = new Double(std::pow(this->getValue(), other->getValue()), toid, this->getParent());
                return i;
            }
            throw Exceptions::UnsupportedOpException("Operation '**' between Double and non-Number literal");
        }

        TTTTT class String : Instance<std::string, std::string> {
            //string value="";

            //using Instance<string>::Instance;

            String(std::string value, int id, Descriptor* parent = nullptr) :
            Instance<std::string, std::string>(value, id, parent) {
            }

            String<T>* add(String<T>* other, int toid) {
                std::string cpy(this->getValue());
                if (ISEQU(other, std::string)) {
                    cpy.append(other->getValue());
                } else if (ISNUM(other)) {
                    cpy.append(other->getValue());
                }
                String* s = new String(cpy, toid, this->getParent());
                return s;
            }

            /*
             * This is not appropriate for String to use "-" operator
             */
            String<T>* sub(String<T>* other, int toid) {
                throw Erable::Exceptions::UnsupportedOpException("Unsupported substraction of String");
            };
        };

        TEMPT class Function : Instance<std::function<Instance<type, R> * >, std::function<Instance<type, R> * > > {

            Function(std::function<Instance<type, R>*> value, int id, Descriptor* parent) :
            Instance<std::function<Instance<type, R>*>, std::function<Instance<type, R> * > >(value, id, parent) {

            }

        };
    }
}

#undef TEMPT