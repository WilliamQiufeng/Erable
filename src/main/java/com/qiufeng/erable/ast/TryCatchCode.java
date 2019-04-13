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
import java.io.OutputStream;
import java.util.Arrays;

/**
 *
 * @author Qiufeng54321
 */
public class TryCatchCode extends TempCode {
    public Scope t,c,f;
    //Catch ID
    public int C;
    public TryCatchCode(Code parent) {
	super(-1,OpCode.TRY, parent);
	this.sign="^";
    }

    @Override
    public void setFile(OutputStream file) {
	super.setFile(file);
	t.setFile(file);
	c.setFile(file);
	if(f!=null)
	    f.setFile(file);
    }

    @Override
    public String tree(int depth) {
	return super.tree(depth) + '\n' + t.tree(depth+2) + '\n' + c.tree(depth+2) + (f==null?"":'\n' + f.tree(depth+2));
    }
    
    /**
     * [[TRY 1B] [CATCH ID 4B] [ID 4B]] [TRY_START 1B] [CODES] [TRY_END 1B] [CATCH_ID 4B] [CATCH_START 1B] [CODES] [CATCH_END 1B] [[FINALLY 1B] [CODES]]? [END]  
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	//System.out.println("___TRY "+this+"___");
	this.writeOpCode(this.op);
	this.writeId(this.C);
	this.writeId(id);
	this.t.write();
	this.writeOpCode(OpCode.JUMPIF);
	this.writeId(this.findVar("true"));
	if(f==null)
	    this.writeId(currentId);
	else
	    this.writeId(this.f.id);
	this.c.write();
	this.f.write();
	this.writeOpCode(OpCode.END);
	this.writeId(id);
	//System.out.println("__END TRY "+this+"__");
    }

    @Override
    public String toString() {
	return super.toString() + "  try ->" + this.id + " :";
    }
    
}
