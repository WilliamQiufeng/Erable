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
//#include "Types.hpp"
#include "Descriptor.hpp"

namespace Erable {
    namespace Types {
        //using namespace std;

        template <typename type>
        class Instance {
        public:
            type value;
            int id;
            Descriptor* parent;

            Instance(type value, int id, Descriptor* parent=nullptr) :
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
            template<typename T>
            Instance* add(Instance<T>* other, int toid);

        };

        class Integer : public Instance<int> {

            Integer(int value, int id, Descriptor* parent) :
            Instance<int>(value, id, parent) {
            }

            template<typename T>
            Instance* add(Instance<T>* other, int toid) {
                if (typeid (Integer) == typeid (*other)) {
                    Integer* i = new Integer(this->getValue() + other->getValue(), toid, this->getParent());
                    return i;
                }
            }
        };

        class Double : public Instance<double> {

            Double(double value, int id, Descriptor* parent) :
            Instance<double>(value, id, parent) {
            }

            template<typename T>
            Double* add(Instance<T>* other, int toid) {
                if (typeid (Double) == typeid (*other) || typeid (Integer) == typeid (*other)) {
                    Double* i = new Double(this->getValue() + other->getValue(), toid, this->getParent());
                    return i;
                }
            }
        };
        class String : Instance<std::string> {
            //string value="";

            //using Instance<string>::Instance;
            String(std::string value, int id, Descriptor* parent=nullptr) :
            Instance<std::string>(value, id, parent) {
            }


            template <typename T>
            String* add(Instance<T>* other, int toid) {
                if (typeid (String) == typeid (*other)) {
                    String* s = new String((this->getValue()) + (other->getValue()), toid, this->getParent());
                    return s;
                }
            }
        };
    }
}