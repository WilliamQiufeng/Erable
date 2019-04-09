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
public class VarCode extends TempCode {
    public short modifiers;
    public VarCode(String name,short modifiers,int refid, Code parent) {
	super(refid, OpCode.VAR,parent);
	this.modifiers=modifiers;
	this.sign=Code.VAR;
	this.tag=name;
    }

    @Override
    public String toString() {
	return super.toString() + " : variable `" + modifiers + "` "+ this.tag + " = @" + this.cid + " ->" + this.id;
    }

    /**
     * [TAG 1B] [VALUE ID 4B] [ID 4B]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.cid);
	this.writeId(this.id);
	System.out.println(this);
    }
    
    
}
