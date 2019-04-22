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

/* 
 * File:   GlobalMacros.hpp
 * Author: Qiufeng54321
 *
 * Created on 2019年4月21日, 下午7:41
 */

#ifndef GLOBALMACROS_HPP
#define GLOBALMACROS_HPP

#define TEMPT template<typename type, typename R>
#define TTTTT template<typename T>
#define FTEMP template<typename D, typename E, typename F>
#define ISEQU(sth, type) typeid (sth->getValue()) == typeid (type)
#define ISNUM(sth) ISEQU(sth, int) or ISEQU(sth, double)

#endif /* GLOBALMACROS_HPP */

