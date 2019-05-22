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
package com.qiufeng.erable.ast;

import com.qiufeng.erable.OpCode;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Qiufeng54321
 */
public class FuncCallCode extends TempCode {
    public List<Integer> args;
    public String name;
    public FuncCallCode(String name,List<Integer> args,int refid, Code parent) {
	super(refid, OpCode.ARRAY,parent);
	this.name=name;
	this.args=args;
    }

    @Override
    public String toString() {
	return super.toString() + "  " + this.name + "@" + this.cid + args.toString() + " ->" + this.id;
    }
    /**
     * [CALL_PREPARE 1B] [[PUSH_ARG 1B] [ID 4B]]* [[CALL 1B] [FUNCTION ID 4B] [ID 4B]]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.id);
	//System.out.println("__CALL_PREPARE "+this+"__");
	for(int aid : args){
	    this.writeOpCode(OpCode.PUSH_ELEMENT);
	    this.writeId(aid);
	    this.writeId(this.id);
	    //System.out.println("____PUSH_ARG "+aid+"____");
	}
	this.writeOpCode(OpCode.CALL);
	this.writeId(this.cid);
	this.writeId(this.id);
	//System.out.println("__CALL "+this+"__");
    }

    
}
