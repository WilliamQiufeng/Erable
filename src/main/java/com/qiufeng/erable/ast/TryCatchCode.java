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
import java.util.Arrays;

/**
 *
 * @author Qiufeng54321
 */
public class TryCatchCode extends TempCode {
    public FPADCode mCatch;
    public TryCatchCode(Code parent) {
	super(-1,OpCode.TRY, parent);
	this.sign="^";
    }

    public FPADCode getmCatch() {
	return mCatch;
    }

    public void setmCatch(FPADCode mCatch) {
	this.mCatch = mCatch;
    }

    @Override
    public int findVar(String name) {
	if(this.mCatch!=null&&name.equals(mCatch.name)){
	    return mCatch.id;
	}
	return super.findVar(name);
    }
    /**
     * [[TRY 1B] [ID 4B]] [TRY_START 1B] [CODES] [TRY_END 1B] [CATCH_ID 4B] [CATCH_START 1B] [CODES] [CATCH_END 1B] [[FINALLY 1B] [CODES]]? [END]  
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.id);
	System.out.println("___TRY "+this+"___");
	this.writeCodes();
	this.writeOpCode(OpCode.END);
	this.writeId(this.id);
	System.out.println("__END TRY "+this+"__");
    }

    @Override
    public String toString() {
	return super.toString() + "  try ->" + this.id + " :";
    }
    
}
