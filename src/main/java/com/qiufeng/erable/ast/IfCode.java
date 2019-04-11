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
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 这个更特殊，
 * 因为甚至不知道进入的语句是不是判断语句。
 * @see WhileCode
 * @author Qiufeng54321
 */
public class IfCode extends TempCode {
    public ArrayList<ElseCode> elses;
    public IfCode(Code parent) {
	super(-1, OpCode.IF, parent);
	this.sign="^";
    }
    public void process(){
	this.codes.add(this.codes.size()-1, new MachineCode(OpCode.BREAKIF,new int[]{this.codes.get(this.codes.size()-2).id},this));
    }

    @Override
    public String toString() {
	return super.toString() + "  if ->" + this.id; 
    }
    /**
     * [TAG 1B] [ID 4B] [CODES (unknown Bytes)] [END]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.id);
	this.writeCodes();
	//this.writeOpCode(OpCode.END);
	//this.writeId(id);
    }
    
}
