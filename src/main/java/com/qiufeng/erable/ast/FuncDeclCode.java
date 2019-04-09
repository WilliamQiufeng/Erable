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
 * It is too complex, I could only use my native language for readability.<br>
 * @author Qiufeng54321
 */
public class FuncDeclCode extends Code {
    public List<FPADCode> args;
    public int retType;
    /**
     * 把所有的FPADCode装入this.args<br>
     * @param name
     * @param args
     * @param pdo
     * @param parent 
     */
    public FuncDeclCode(String name,List<FPADCode> args, Code parent) {
	super(name, OpCode.FUNCTION,parent);
	this.args=args;
	this.sign=Code.VAR;
	this.tag=name;
    }
    public void addScope(Scope scope){
	this.addCode(scope);
    }
    /**
     * 查找变量需要包含传入参数，故重载
     * @param name
     * @return 
     */
    @Override
    public int findVar(String name) {
	for(var f : args){
	    if(f.name.equals(name)){
		return f.id;
	    }
	}
	return super.findVar(name);
    }
    public void writeArgs() throws IOException{
	for(FPADCode f : this.args){
	    this.writeOpCode(OpCode.PUSH_ARGDECL);
	    this.writeId(f.id);
	    System.out.println("___ARG_PUSH___"+f);
	}
    }
    /**
     * 
     * 写出的时候:<br>
     * 1、写入FUNCTION [id]<br>
     * 2、一个个按照this.args写入FUNCTION_PUSH_ARGS_DECL<br>
     * 3、写入PUSH_SCOPE<br>
     * 4、写入codes<br>
     * 5、写入POP_SCOPE<br>
     * [FUNCTION 1B] [ID 4B] [[PUSH_ARGDECL 1B] [ID 4B]]* [START_DO 1B] [CODES (unknown bytes)] [END_FUNCDECL 1B]
     * @return 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(id);
	System.out.println("___FUNCDECL___" + this);
	this.writeArgs();
	this.writeCodes();
	System.out.println("___END "+this+" ___");
    }

    @Override
    public String toString() {
	return super.toString() + " : function " + this.tag + args + " ->" + this.id + " :";
    }
    
}
