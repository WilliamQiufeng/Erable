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
    CONSTANT_POOL,CP_NUM,CP_INT,CP_STR,
    //1 op 2 ->ID 3
    ADD("+",3,2),SUB("-",3,2),MUL("*",3,2),DIV("/",3,2),MOD("%",3,2),POW("**",3,2),
    //op 1 -> ID 2
    POS(2,1),NEG(2,1),
    //1[2] -> ID 3
    ELEMENT(3,2),
    LS("<<",3,2),RS(">>",3,2),URS(">>>",3,2),
    LT("<",3,2),GT(">",3,2),LTE("<=",3,2),GTE(">=",3,2),EQ("==",3,2),NEQ("!=",3,2),
    EQU("=",3,2),SWITCH("<=>",3,2),
    BNOT("!",3,2),BAND("&",3,2),BOR("|",3,2),BXOR("^",3,2),
    ADDEQ("+=",3,2),SUBEQ("-=",3,2),MULEQ("*=",3,2),DIVEQ("/=",3,2),MODEQ("%=",3,2),
    PUSH_SCOPE(1,0),POP_SCOPE(1,0),
    REF("@",2,1),GREF("#",2,1),
    RETURN("return",2,1),BREAK("break",2,1),
    COPY(2),
    LOADC(2,1),
    FUNCTION(2,1),//REG_ARG(2),
    ARRAY(1,0),PUSH_ELEMENT(2),
    CALL(2,1),
    IF(1),ELSE(2),
    WHILE(1),
    END(1),
    //if 1 break
    BREAKIF(1),
    //If 1 jump 2
    JUMPIF(2),
    OBJECT(1),START_PAIR,KEY(1),VALUE(1),END_PAIR,
    TRY(2),
    NATIVE_FUNCDECL(3),LOAD_LIB(1),
    DYN_LOAD(3),DYNCALL(3),
    EXIT
    ;
    public String sign;
    public int argc;
    public int idIndex;

    private OpCode(String sign, int argc, int idIndex) {
	this.sign = sign;
	this.argc = argc;
	this.idIndex = idIndex;
    }
    
    OpCode(String sign,int argc){
	this(sign, argc, -1);
    }
    OpCode(String sign){
	this(sign,0);
    }

    OpCode(int argc, int idIndex) {
	this(null, argc, idIndex);
    }
    
    OpCode(int argc){
	this(argc, -1);
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
	for(OpCode op : OpCode.values()){
	    if(op.name().equals(code)){
		return op;
	    }
	}
	return null;
    }
    public static OpCode findOp(String sign){
	for(OpCode op : OpCode.values()){
	    if(sign.equals(op.sign)){
		return op;
	    }
	}
	return null;
    }
}
