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
import java.util.List;

/**
 *
 * @author Qiufeng54321
 */
public class NativeFuncDeclCode extends FuncDeclCode {
    public int nativeCall;
    public NativeFuncDeclCode(String name,int nativeCall, List<FPADCode> args, Code parent) {
	super(name, args, parent);
	this.nativeCall=nativeCall;
	this.op=OpCode.NATIVE_FUNCDECL;
    }

    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(id);
	this.writeId(this.nativeCall);
	//System.out.println("___NATIVE_FUNCDECL___" + this);
	this.writeArgs();
	//System.out.println("___END "+this+" ___");
    }

    @Override
    public String toString() {
	return super.toString() + " native " + nativeCall;
    }
    
}
