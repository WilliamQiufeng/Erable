/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Utils.h
 * Author: Qiufeng54321
 *
 * Created on 2019年4月18日, 下午7:47
 */

#ifndef UTILS_H
#define UTILS_H

#include <vector>
#include <string>
#include <ostream>

namespace Erable {
    using namespace std;
    namespace Utils {

        template <class ValueType>
        struct EnumElement {
            string name;
            ValueType value;
        public:

            EnumElement<ValueType>(string name, ValueType value) {
                this->name = name;
                this->value = value;
            }
        };

        template <class ValueType>
        class Enum {
        public:
            vector<EnumElement<ValueType>*> elements;

            Enum<ValueType>() {
            }

            void addEnum(string name, ValueType value) {
                EnumElement<ValueType>* ele=new EnumElement(name, value);
                this->addEnum(name, ele);
            };

            void addEnum(string name, EnumElement<ValueType>* value) {
                this->elements.push_back(value);
            };

            void removeEnum(string name) {
                int index = 0;
                for (EnumElement<ValueType>* element : this->elements) {
                    if (element[0] == name) {
                        break;
                    }
                    index++;
                }
                this->removeEnum(index);
            };

            void removeEnum(int index) {
                this->elements.erase(index);
            };

            EnumElement<ValueType>* find(string name) {
                for (EnumElement<ValueType>* element : this->elements) {
                    if (element->name == name) {
                        return element;
                    }
                }
                return nullptr;
            }
            ;

            EnumElement<ValueType>* find(int index) {
                return this->elements[index];
            };
        };
    }
}


#endif /* UTILS_H */

