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

package com.qiufeng.erable.dump;

import com.qiufeng.erable.Const;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 2019年4月9日
 * @author Qiufeng54321
 */
public class ErableDumper {
    private static final Logger LOG = Logger.getLogger(ErableDumper.class.getName());
    public InputStream input;
    public int depth=0;
    public int id_len=1;
    public int cid_len=1;

    public InputStream getInput() {
	return input;
    }

    public void setInput(InputStream input) {
	this.input = input;
    }

    public ErableDumper(InputStream input) {
	this.input = input;
    }
    public String depthHeader(){
	return "-".repeat(depth)+">";
    }
    public void dump(OutputStream out) throws IOException{
	PrintStream ps=new PrintStream(out);
	byte[] magic=input.readNBytes(2);
	if(!(magic[0]==Const.MAGIC[0]&&magic[1]==Const.MAGIC[1])){
	    LOG.log(Level.SEVERE, "Magic not correct: {0}, Expecting: {1}", new Object[]{Arrays.toString(magic),Arrays.toString(Const.MAGIC)});
	    System.exit(2);
	}
	byte[] version=input.readNBytes(2);
	System.out.println("Major version: "+version[0]+", Minor version: "+version[1]);
	byte   len    =(byte)input.read();
	id_len=len>>4;
	cid_len=len&0x01;
	System.out.println("ID Length: "+id_len+", CID Length: "+cid_len);
	this.input.readNBytes(4);
	this.dumpConstantPool();
	this.dumpCodes();
    }
    public void dumpCodes() throws IOException{
	for(int i=0;(i=this.input.read())!=-1;){
	    System.out.print(this.depthHeader());
	    OpCode code=OpCode.values()[i];
	    //System.out.println(code);
	    if(code==OpCode.LOADC){
		int cid=this.readId(cid_len);
		int id =this.readId(id_len);
		System.out.println("Buffer "+cid+" to @"+id);
	    }else{
		System.out.print(code.name());
		for(int j=0;j<code.argc;j++){
		    int id=this.readId(id_len);
		    System.out.print(" @"+id);
		}
		System.out.println();
		if(code==OpCode.PUSH_SCOPE||code==OpCode.IF||code==OpCode.ELSE||code==OpCode.WHILE||code==OpCode.ARRAY||code==OpCode.TRY_START
			||code==OpCode.CATCH_START||code==OpCode.FINALLY||code==OpCode.OBJECT)
		    this.depth+=2;
		if(code==OpCode.POP_SCOPE||code==OpCode.END||code==OpCode.TRY_END||code==OpCode.CATCH_END)
		    this.depth-=2;
	    }
	    
	}
    }
    public void dumpConstantPool()throws IOException{
	int len=this.readId(cid_len);
	System.out.println("Constant Pool: Length="+len);
	for(int i=0;i<len;i++){
	    OpCode code=OpCode.values()[this.input.read()];
	    if(code==OpCode.CP_NUM){
		byte[] doubb=this.input.readNBytes(8);
		double doub=BitUtils.getDouble(doubb, 0);
		System.out.println("Constant Pool Number: ID="+i+", Value="+doub);
	    }else if(code==OpCode.CP_STR){
		int strlen=this.readId(4);
		String str=new String(this.input.readNBytes(strlen));
		System.out.println("Constant Pool String: ID="+i+", Value=\""+str+"\"");
	    }
	}
    }
    public int readId(int len) throws IOException{
	byte[] bs=this.input.readNBytes(len);
	return getId(bs,0,len);
    }
    public static int getId(byte[] bts,int off,int len){
	switch (len) {
	    case 4:
		return BitUtils.getInt(bts, off);
	    case 2:
		return BitUtils.getShort(bts, off);
	    case 1:
		return bts[off];
	    default:
		return -1;
	}
    }
}
