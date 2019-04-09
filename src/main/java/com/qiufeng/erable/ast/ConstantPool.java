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

import com.qiufeng.erable.Const;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.util.ArrayUtils;
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author Qiufeng54321
 */
public class ConstantPool extends Code {
    public ArrayList<ConstantPoolElement> elements;
    public int currentId=0;
    public ConstantPool(Code parent){
	super("ConstantPool",OpCode.CONSTANT_POOL,parent);
	elements=new ArrayList<>();
    }
    /**
     * Adds the {@link ConstantPoolElement} if it does not exist in {@link #elements}
     * @param cpe the {@link ConstantPoolElement} to add.
     * @return the ID the element is given.
     */
    public int addElement(ConstantPoolElement cpe){
	int iexists=this.findElementId(cpe.obj);
	if(iexists!=-1)
	    return iexists;
	//Set the id
	cpe.id=this.currentId++;
	elements.add(cpe);
	if(currentId>Byte.MAX_VALUE)
	    Const.setCidLen(2);
	if(currentId>Short.MAX_VALUE)
	    Const.setCidLen(4);
	return cpe.id;
    }
    /**
     * Finds the element by ID.
     * @param id The id for searching.
     * @return The element found.If not found return null.
     */
    public ConstantPoolElement findElement(int id){
	for(ConstantPoolElement c : elements){
	    if(c.id==id)
		return c;
	}
	return null;
    }
    /**
     * Find element's ID from object(If the object exists in constant pool.
     * @param obj the object to find
     * @return ID found.If not found return -1.
     */
    public int findElementId(Object obj){
	for(ConstantPoolElement c : elements){
	    if(c.equals(obj))
		return c.id;
	}
	return -1;
    }

    @Override
    public void setFile(OutputStream file) {
	super.setFile(file);
	for(var cpe : this.elements){
	    cpe.setFile(file);
	}
    }
    
    /**
     * Generate the whole ConstantPool.<br>
     * Structure:<br>
     * -- HEADER: TAG(1 byte)<br>
     * -------- + LENGTH OF ELEMENTS(4 bytes)<br>
     * -+ SERIALISED ELEMENTS
     * @see ConstantPoolElement,ConstantPoolString,ConstantPoolNumber
     * @return 
     */
    @Override
    public void write()throws IOException {
	var len=this.elements.size();
	this.writeOpCode(this.op);
	this.writeCid(len);
	for(var element : this.elements){
	    element.write();
	}
    }
}
