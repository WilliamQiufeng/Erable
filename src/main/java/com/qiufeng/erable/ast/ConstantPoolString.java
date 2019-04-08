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
 *
 * @author Qiufeng54321
 */
public class ConstantPoolString extends ConstantPoolElement {
    public static byte TAG=(byte)OpCode.CP_STR.ordinal();
    public ConstantPoolString(String obj) {
	super(obj);
    }
    /**
     * Serialises the element.<br>
     * First, It fetches the header by {@link #generateHeader()}.<br>
     * Second,It fetches the bytes of the string stored and join them.
     * @return The serialised code.
     */
    @Override
    public byte[] serialise() {
	byte[] header=this.generateHeader();
	header=ArrayUtils.join(header, (String)obj);
	return header;
    }
    /**
     * Generates the header.<br>
     * Here the {@link #TAG} is 0,so first append one byte 0x00.<br>
     * Next It generates byte[4] to store the length of the string.<br>
     * Finally,It joins the tag and length to make byte[5] and returns it.<br>
     * For example we create an instance: <code>new ConstantPoolString("hello world!你好世界！")</code><br>
     * And then we get the header: new byte[]{0,    0,0,0,17}<br>
     * @return new byte[]{TAG,length(4 bytes)}
     */
    @Override
    public byte[] generateHeader() {
	String str=(String)obj;
	byte[] header=new byte[0];
	header=ArrayUtils.push(header, ConstantPoolString.TAG);
	byte[] length=new byte[4];
	BitUtils.putInt(length, 0, str.length());
	header=ArrayUtils.push(header, length);
	return header;
    }
    
}
