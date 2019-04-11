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

import static com.qiufeng.erable.Const.ID_LENGTH;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Qiufeng54321
 */
public class TempCode extends Code {
    public int cid;
    public TempCode(int cid,OpCode op, Code parent) {
	super("",op, parent);
	this.tag=this.id+"";
	this.cid=cid;
	this.sign=Code.TEMP;
    }
    public TempCode(int cid,Code parent){
	this(cid,OpCode.LOADC,parent);
    }

    @Override
    public String toString() {
	String ret=super.toString();
	if(this.getClass().getSimpleName().equals("TempCode")){
	    ret+="  buffer " + this.cid;
	    ret+=" to @"+this.id;
	}
	return ret;
    }
    /**
     * LOADC [cid (4B)] [id (4B)]<br>
     * [0 tag] [1 2 3 4 cid] [5 6 7 8 id]<br>
     * Total: 9B
     * @throws java.io.IOException
     */
    @Override
    public void write() throws IOException{
	this.writeOpCode(this.op);
	this.writeCid(this.cid);
	this.writeId(id);
	System.out.println("__TEMP "+this+"____");
    }
    
}
