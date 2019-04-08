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
import com.qiufeng.erable.util.ArrayUtils;
import com.qiufeng.erable.util.BitUtils;

/**
 * A type of constant pool element which stores numbers(stored as {@link Double})
 * @author Qiufeng54321
 */
public class ConstantPoolNumber extends ConstantPoolElement {
    public static byte TAG=(byte)OpCode.CP_NUM.ordinal();
    public ConstantPoolNumber(Double obj) {
	super(obj);
	
    }
    /**
     * Join the header and double together.
     * @see ConstantPoolString
     * @return the result of joining
     */
    @Override
    public byte[] serialise() {
	byte[] header=this.generateHeader();
	byte[] doub=new byte[8];
	BitUtils.putDouble(doub,0,(double)obj);
	header=ArrayUtils.push(header, doub);
	return header;
    }
    /**
     * Generated the header
     * @return new byte[]{TAG}
     */
    @Override
    public byte[] generateHeader() {
	byte[] header=new byte[0];
	header=ArrayUtils.push(header, ConstantPoolNumber.TAG);
	return header;
    }
    
}
