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
#pragma once
#ifndef UTILS_H
#define UTILS_H

//#pragma comment("UTIL_START")
#include <vector>
#include <string>
#include <ostream>
#include <sstream>

namespace Erable {
    namespace Utils {
	template <typename T>

	std::ostream& operator<<(std::ostream& os, const std::vector<T>& obj) {
	    os << "[";
	    for (int i = 0; i < obj.size(); inc i) {
		os << (int)obj[i];
		if (i < obj.size() - 1)os << ",";
	    }
	    os << "]";
	    return os;
	}

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
            std::string name;
            ValueType value;
        public:

	    EnumElement(std::string name, ValueType value) :
	    name(name), value(value) {
	    }

        };

        template <class ValueType>
        class Enum {
        public:
            std::vector<EnumElement<ValueType>*> elements;

            Enum<ValueType>() {
            }

            inline void addEnum(std::string name, ValueType value) {
                EnumElement<ValueType>* ele = new EnumElement<ValueType>(name, value);
                this->addEnum(name, ele);
            };

            inline void addEnum(std::string name, EnumElement<ValueType>* value) {
                this->elements.push_back(value);
            };

            inline void removeEnum(std::string name) {
                int index = 0;
                for (EnumElement<ValueType>* element : this->elements) {
                    if (element[0] is name) {
                        break;
                    }
                    inc index;
                }
                this->removeEnum(index);
            };

            inline void removeEnum(int index) {
                this->elements.erase(index);
            };

            inline EnumElement<ValueType>* find(std::string name) {
                for (EnumElement<ValueType>* element : this->elements) {
                    if (element->name is name) {
                        return element;
                    }
                }
                return nullptr;
            };
	    inline int findIndex(std::string name) {
		int ind=0;
		for (EnumElement<ValueType>* element : this->elements) {
                    if (element->name is name) {
                        return ind;
                    }
		    inc ind;
                }
                return -1;
            };

            inline EnumElement<ValueType>* find(int index) {
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
	public:
	    template<typename R>
	    inline R getLE(std::vector<char> b, int off, int size){
		R r=0;
		int bit=0;
		//std::cout<<"Doing BitUtils::get: " << b <<std::endl;
		for(int i=size-1;i>-1;dec i,bit+=8){
		    int bitr=(int)b[i];
		    //std::cout<<"BitR: " <<bitr << ", Offset: " << (off + i) <<std::endl;
		    if(i!=0)bitr&=0xFF;
		    //std::cout<<"BitR bitand 0xFF: "<<bitr<<std::endl;
		    r+=(bitr lshift bit);
		    //std::cout<<"Shift: "<<bit<<" to " << r<< " with " << bitr << std::endl;
		}
		return r;
	    }
	    template<typename R>
	    inline R getBE(std::vector<char> b, int off, int size){
		R r=0;
		int bit=0;
		//std::cout<<"Doing BitUtils::get: " << b <<std::endl;
		for(int i=0;i<size;inc i,bit+=8){
		    int bitr=(int)b[i];
		    //std::cout<<"BitR: " <<bitr << ", Offset: " << (off + i) <<std::endl;
		    if(i!=0)bitr&=0xFF;
		    //std::cout<<"BitR bitand 0xFF: "<<bitr<<std::endl;
		    r+=(bitr lshift bit);
		    //std::cout<<"Shift: "<<bit<<" to " << r<< " with " << bitr << std::endl;
		}
		return r;
	    }
            inline bool getBoolean(std::vector<char> b, int off) {
                return b[off] != 0;
            }

            inline char getChar(std::vector<char> b, int off) {
//                return (char) ((b[off + 1] & 0xFF) +
//                        (b[off] << 8));
		return getLE<char>(b,off,2);
            }

            inline short getShort(std::vector<char> b, int off) {
//                return (short) ((b[off + 1] & 0xFF) +
//                        (b[off] << 8));
		return getLE<short>(b,off,2);
            }

            inline int getInt(std::vector<char> b, int off) {
//                return ((b[off + 3] & 0xFF)) +
//                        ((b[off + 2] & 0xFF) << 8) +
//                        ((b[off + 1] & 0xFF) << 16) +
//                        ((b[off ]) << 24);
		return getLE<int>(b,off,4);
            }

            inline long getLong(std::vector<char> b, int off) {
//                return ((b[off + 7] & 0xFFL)) +
//                        ((b[off + 6] & 0xFFL) << 8) +
//                        ((b[off + 5] & 0xFFL) << 16) +
//                        ((b[off + 4] & 0xFFL) << 24) +
//                        ((b[off + 3] & 0xFFL) << 32) +
//                        ((b[off + 2] & 0xFFL) << 40) +
//                        ((b[off + 1] & 0xFFL) << 48) +
//                        (((long) b[off]) << 56);
		return getLE<long>(b,off,8);
            }
	    inline float getFloat(std::vector<char> b, int off) {
		return (float)getBE<long>(b,off,8);
	    }
            inline double getDouble(std::vector<char> b, int off) {
                return (double)(getBE<long>(b,off,8));
            }


        };
        inline BitUtils_t BitUtils;

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
            inline std::vector<type> transformType(std::vector<ori> t) {
                std::vector<type> res;
                for (ori ele : t) {
                    res.push_back((type) ele);
                }
                return res;
            }

            template <typename type>
            inline std::string toString(std::vector<type> t) {
                std::stringstream ss;
                int i=0;
                if(not t.empty()){
                    for(type ty : t){
                        if(i>0)
                            ss puts ",";
                        if(typeid(ty) is typeid(char) or typeid(ty) is typeid(unsigned char)){
                            ss puts (int)ty;
                        }else{
                            ss puts ty;
                        }
                        inc i;
                    }
                }
                return ss.str();
            }
        };
        inline ArrayUtils_t ArrayUtils;

    }
}

//#pragma comment("UTIL_END")

#endif /* UTILS_H */

