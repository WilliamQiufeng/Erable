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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract Code.
 * @author Qiufeng54321
 */
public abstract class Code implements Comparable{
    /**
     * Current id
     */
    public static int    currentId = 0;
    
    public static String     SCOPE = "#";
    public static String       VAR = "%";
    public static String      TEMP = "@";
    public static String      CODE = "|";
    /**
     * Sign of the code
     */
    public        String      sign = Code.CODE;
    /**
     * Codes inside
     */
    public        List<Code> codes = new ArrayList<>();
    /**
     * The Tag
     */
    public        String       tag = null;
    /**
     * The parent it has
     */
    public        Code      parent = null;
    /**
     * The code's id
     * 所有Code的id都是独立的
     * All Code has a unique id.
     */
    public        int           id = Code.currentId++;
    /**
     * The file for output.
     */
    public        File        file ;
    /**
     * OpCode
     */
    public        OpCode        op ;
    
    /**
     * Creates a code.
     * @param tag tag name
     * @param parent its parent
     */
    public Code(String tag,OpCode op,Code parent){
        this.tag=tag;
	this.op=op;
        this.bind(parent);
    }
    /**
     * A simple wrapper for {@link Code#Code(java.lang.String, com.qiufeng.erable.ast.Code)}
     * @param tag tag name
     */
    public Code(String tag){
        this(tag,null,null);
    }
    /**
     * write method
     * @return the serialised string including the codes it has
     */
    public abstract String write();
    /**
     * bind a parent
     * @param code specify its parent
     */
    public void bind(Code code){
        this.parent=code;
    }
    /**
     * Set file for output.
     * @param file output file.
     */
    public void setFile(File file){
	this.file=file;
    }
    /**
     * find a code with the tag.<br>
     * usually used to find a variable or function.
     * @param tag tag name
     * @return the code found.
     */
    public Code find(String tag){
        for(Code c : codes){
            if(c.tag.equals(tag))
                return c;
        }
        return null;
    }
    /**
     * Find a code with the id.<br>
     * It is used to find a code when we know what the id is.
     * @param id
     * @return the code found.
     */
    public Code find(int id){
        for(Code c : codes){
            if(c.id==id)
                return c;
        }
        return null;
    }
    /**
     * Try to add the code.<br>
     * It sets <code>this</code> to the parent of the code to add.
     * @param code the code to add.
     * @return whether it is successfully added or not(if it fails it is usually because of the memory)
     */
    public boolean addCode(Code code){
        code.parent=this;
        return codes.add(code);
    }
    /**
     * Sets the sign to mark the code.
     * @param sign the sign.
     */
    public void setSign(String sign) {
        this.sign = sign;
    }
    /**
     * Sets the tag of the code.
     * @param tag the tag.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    /**
     * Same as {@link Code#bind(com.qiufeng.erable.ast.Code)}.
     * @param parent the parent to bind.
     */
    public void setParent(Code parent) {
        this.parent = parent;
    }
    /**
     * Getter of {@link Code#sign}
     * @return {@link Code#sign}
     */
    public String getSign() {
        return sign;
    }
    /**
     * Getter of {@link Code#tag}
     * @return {@link Code#tag}
     */
    public String getTag() {
        return tag;
    }
    /**
     * Getter of {@link Code#parent}
     * @return {@link Code#parent}
     */
    public Code getParent() {
        return parent;
    }
    /**
     * Find variable/function by the given name.
     * @param name the name to try to find
     * @return the id found.
     */
    public int findVar(String name){
	for(var code : codes){
	    System.out.println("finding:"+code);
	    if(code.tag.equals(name)&&code.sign.equals(Code.VAR)){
		System.out.println("ID:"+code);
		return code.id;
	    }
	}
	if(this.getParent()!=null){
	    return this.getParent().findVar(name);
	}
	System.out.println("ID NOT FOUND:"+name);
	return -1;
    }
    public int findCid(int id){
	var temp=(TempCode)this.find(id);
	return temp.cid;
    }
    /**
     * Generates the full name.
     * @return the full name.
     */
    public String getAbsoluteName(){
	String ts="";
        if(parent!=null){
            ts=parent.getAbsoluteName();
        }
        ts+=sign;
        ts+=tag;
        return ts;
    }
    public String tree(int depth){
	String ret="-".repeat(depth)+">";
	ret+=this.toString();
	ret+="\n";
	for(var code : this.codes){
	    ret+=code.tree(depth+1);
	    ret+="\n";
	}
	return ret;
    }
    @Override
    public String toString() {
        return this.getAbsoluteName();
    }

    @Override
    public int compareTo(Object o) {
	if(!(o instanceof Code)){
	    return -1;
	}
	return this.id-((Code)o).id;
    }
    
}
