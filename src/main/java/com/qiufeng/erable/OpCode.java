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
package com.qiufeng.erable;

/**
 *
 * @author Qiufeng54321
 */
public enum OpCode {
    CONSTANT_POOL,CP_NUM,CP_STR,
    ADD("+",3),SUB("-",3),MUL("*",3),DIV("/",3),MOD("%",3),POW("**",3),
    ELEMENT(3),
    LS("<<",3),RS(">>",3),ULS("<<<",3),URS(">>>",3),
    LT("<",3),GT(">",3),LTE("<=",3),GTE(">=",3),EQ("==",3),NEQ("!=",3),
    EQU("=",3),SWITCH("<=>",3),
    BNOT("!",3),BAND("&",3),BOR("|",3),BXOR("^",3),
    ADDEQ("+=",3),SUBEQ("-=",3),MULEQ("*=",3),DIVEQ("/=",3),MODEQ("%=",3),
    PUSH_SCOPE(1),POP_SCOPE(1),
    REF("@",2),GREF("#",2),
    RETURN("return",2),BREAK("break",2),
    VAR(2),
    LOADC(2),
    FUNCTION(1),PUSH_ARGDECL(2),START_DO,END_FUNCDECL(1),
    ARRAY(1),PUSH_ELEMENT(1),END_ARRAY(1),
    CALL_PREPARE(1),PUSH_ARG(2),CALL(2),
    IF(1),ELSE(1),
    WHILE(1),
    START(1),END(1),
    BLOCK(1),END_BLOCK(1),
    BREAKIF(1),
    OBJECT(1),START_PAIR,KEY(1),VALUE(1),END_PAIR,
    TRY(1),TRY_START,TRY_END,CATCH_ID(1),CATCH_START,CATCH_END,FINALLY(1),
    NATIVE_FUNCDECL(2),LOAD_LIB(1),
    ;
    String sign;
    int argc;
    OpCode(String sign,int argc){
	this.sign=sign;
	this.argc=argc;
    }
    OpCode(String sign){
	this(sign,0);
    }
    OpCode(int argc){
	this(null,argc);
    }
    OpCode(){
	this(null);
    }

    @Override
    public String toString() {
	return super.toString() + "(" + this.getByte() + ")";
    }
    
    public byte getByte(){
	return (byte)this.ordinal();
    }
    public static OpCode find(String code){
	for(var op : OpCode.values()){
	    if(op.name().equals(code)){
		return op;
	    }
	}
	return null;
    }
    public static OpCode findOp(String sign){
	for(var op : OpCode.values()){
	    if(sign.equals(op.sign)){
		return op;
	    }
	}
	return null;
    }
}
