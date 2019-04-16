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

package com.qiufeng.erable.vm;

import com.qiufeng.erable.OpCode;
import java.util.List;
import java.util.Objects;

/**
 * @since 2019年4月15日
 * @author Qiufeng54321
 */
public class OpCodeIns {
    public OpCode op;
    public List<Integer> args;
    public static int WHATEVER=-2;
    public static int UNKNOWN =-1;
    public OpCodeIns(OpCode op, List<Integer> args){
	this.op=op;
	this.args=args;
    }
    public void validate(){
	assert op.argc==args.size();
    }

    @Override
    public String toString() {
	return "OpCodeIns{" + "op=" + op + ", args=" + args + '}';
    }

    @Override
    public int hashCode() {
	int hash = 5;
	hash = 61 * hash + Objects.hashCode(this.op);
	hash = 61 * hash + Objects.hashCode(this.args);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final OpCodeIns other = (OpCodeIns) obj;
	if (this.op == other.op) {
	    return true;
	}
	if(this.args.size()==other.args.size()){
	    for(int i=0;i<this.args.size();i++){
		if(args.get(i)==-2)continue;
		if(!Objects.equals(args.get(i), other.args.get(i)))return false;
	    }
	}
	return false;
    }
    
}
