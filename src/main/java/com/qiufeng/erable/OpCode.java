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
    CONSTANT_POOL,
    ADD("+"),SUB("-"),MUL("*"),DIV("/"),MOD("%"),POW("**"),
    DOT("."),ELEMENT,
    LS("<<"),RS(">>"),ULS("<<<"),URS(">>>"),
    LT("<"),GT(">"),LTE("<="),GTE(">="),EQ("=="),NEQ("!="),
    EQU("="),SWITCH("<=>"),
    BNOT("!"),BAND("&"),BOR("|"),BXOR("^"),
    ADDEQ("+="),SUBEQ("-="),MULEQ("*="),DIVEQ("/="),MODEQ("%="),
    PUSH_SCOPE,POP_SCOPE,
    REF("@"),GREF("#"),
    RETURN("return"),BREAK("break"),
    VAR,
    LOADC,
    FUNCTION,PUSH_ARGDECL,
    ARRAY,PUSH_ELEMENT,
    CALL_PREPARE,PUSH_ARG,CALL,
    IF,ELSE,
    WHILE,
    BLOCK,
    BREAKIF,
    OBJECT,DECIDE_COUNT,START_PAIR,KEY,VALUE,END_PAIR,
    TRY_START,TRY_END,CATCH_ID,CATCH_START,CATCH_END,FINALLY
    ;
    String sign;
    OpCode(String sign){
	this.sign=sign;
    }
    OpCode(){
	this(null);
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
