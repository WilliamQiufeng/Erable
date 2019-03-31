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
package com.qiufeng.erable.exception;

/**
 *
 * @author Qiufeng54321
 */
public class BaseException {
    int line,column,errno;
    String title,message,what;
    ErrorType type;
    
    public static enum ErrorType{
	COMPILATION("Compilation"),
	PARSING("Parsing"),
	OPTIMISIZATION("Optimization");
	public String name;
	ErrorType(String name){
	    this.name=name;
	}
    }
    
    public BaseException(ErrorType type,String title,String message,String what,int line,int column,int errno){
	this.type=type;
	this.title=title;
	this.message=message;
	this.what=what;
	this.line=line;
	this.column=column;
	this.errno=errno;
    }
    public void throwException(){
	System.err.println("-----------------ERROR-----------------");
	System.err.println(title + "  :");
	System.err.println("\t"+this.message);
	System.err.println("\t\t at #" + line + ", column " + column + "(With Text '" + what + "')");
	System.err.println("-------Erable Compiler Terminated-------");
	System.exit(this.errno);
    }
}
