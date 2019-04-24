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
#include <sstream>

namespace Erable {
    using namespace std;
    namespace Utils {

        /*                  *\
         *                  *|
         *                  *|
         *       Enum       *|
         *                  *|
         *                  *|
         *                  *|
         \*                 */
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
                EnumElement<ValueType>* ele = new EnumElement(name, value);
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

        /*                  *\
         *                  *|
         *                  *|
         *     BitUtils     *|
         *  Implementation  *|
         *     of Java      *|
         *                  *|
         *                  *|
         *                  *|
         \*                 */
        class BitUtils_t {

            /*
             * Methods for unpacking primitive values from char arrays starting at
             * given offsets.
             */

            bool getBoolean(char* b, int off) {
                return b[off] != 0;
            }

            char getChar(char* b, int off) {
                return (char) ((b[off + 1] & 0xFF) +
                        (b[off] << 8));
            }

            short getShort(char* b, int off) {
                return (short) ((b[off + 1] & 0xFF) +
                        (b[off] << 8));
            }

            int getInt(char* b, int off) {
                return ((b[off + 3] & 0xFF)) +
                        ((b[off + 2] & 0xFF) << 8) +
                        ((b[off + 1] & 0xFF) << 16) +
                        ((b[off ]) << 24);
            }

            long getLong(char* b, int off) {
                return ((b[off + 7] & 0xFFL)) +
                        ((b[off + 6] & 0xFFL) << 8) +
                        ((b[off + 5] & 0xFFL) << 16) +
                        ((b[off + 4] & 0xFFL) << 24) +
                        ((b[off + 3] & 0xFFL) << 32) +
                        ((b[off + 2] & 0xFFL) << 40) +
                        ((b[off + 1] & 0xFFL) << 48) +
                        (((long) b[off]) << 56);
            }

            double getDouble(char* b, int off) {
                long l = getLong(b, off);
                return reinterpret_cast<double&> (l);
            }


        };
        BitUtils_t BitUtils;

        /*                  *\
         *                  *|
         *                  *|
         *    ArrayUtils    *|
         *                  *|
         *                  *|
         *                  *|
         \*                 */
        class ArrayUtils_t {
        public:

            template <typename ori, typename type>
            std::vector<type> transformType(std::vector<ori> t) {
                std::vector<type> res;
                for (ori ele : t) {
                    res.push_back((type) ele);
                }
                return res;
            }

            template <typename type>
            std::string toString(std::vector<type> t) {
                std::stringstream ss;
                int i=0;
                if(!t.empty()){
                    for(type ty : t){
                        if(i>0)
                            ss<<",";
                        if(typeid(ty) == typeid(char) or typeid(ty) == typeid(unsigned char)){
                            ss<<(int)ty;
                        }else{
                            ss<<ty;
                        }
                        i++;
                    }
                }
                return ss.str();
            }
        };
        ArrayUtils_t ArrayUtils;

    }
}


#endif /* UTILS_H */

