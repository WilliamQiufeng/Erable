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
import static com.qiufeng.erable.Const.ID_LENGTH;
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Qiufeng54321
 */
public class BinaryOpCode extends TempCode{
    public int rtid;
    public OpCode op;
    public BinaryOpCode(int ltid,int rtid,OpCode op, Code parent) {
	super(ltid,op, parent);
	this.rtid=rtid;
	this.op=op;
    }

    @Override
    public String toString() {
	return super.toString()+"  @" + this.cid + " " + this.op + " @" + this.rtid + " ->" + this.id;
    }
    /**
     * [OP 1B] [LEFT ID 4B] [RIGHT ID 4B] [ID 4B]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.cid);            //Left
	System.out.println(this);
	this.writeId(this.rtid); //Right
	this.writeId(this.id); //Self ID
    }
    
}
