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
package com.qiufeng.erable;

/**
 *
 * @author Qiufeng54321
 */
public enum VarModifiers {
    VAR(0),LET(1),CHANGEABLE(0b00),CONST(0b10),OBJ(0b000),REF(0b100);
    public short mod;
    VarModifiers(int mod){
	this.mod=(short)mod;
    }
    public static short add(short mod,short a){
	if(has(mod,a))return mod;
	return (short)(mod|a);
    }
    public static boolean has(short mod, short a){
	return (mod&a)!=0;
    }
    public static short clear(short mod, short a){
	if(!has(mod,a)){
	    return (short)(mod^a);
	}
	return mod;
    }
}
