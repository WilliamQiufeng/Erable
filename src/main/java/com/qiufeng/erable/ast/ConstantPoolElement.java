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



/**
 * JavaBean-liked class.<br>
 * Used to store constant pool element.<br>
 * It will be as an abstract class.
 * @author Qiufeng54321
 */
public abstract class ConstantPoolElement extends Code implements Comparable {
    /**
     * The object it stores.
     */
    public Object obj;
    /**
     * Constructor of The Class.
     * @param id The ID given.
     * @param obj The value it stores.
     */
    public ConstantPoolElement(Object obj) {
	super(null);
	this.obj = obj;
	currentId--;
    }
    /**
     * Check if the two elements are equal or not.
     * @param cpe another {@link ConstantPoolElement}.
     * @return the result of comparation.
     */
    @Override
    public boolean equals(Object cpe){
	if(!(cpe instanceof ConstantPoolElement))
	    return obj.equals(cpe);
	ConstantPoolElement c=(ConstantPoolElement)cpe;
	return obj==c.obj;
    }

    @Override
    public int compareTo(Object o) {
	if(o instanceof ConstantPoolElement){
	    ConstantPoolElement ano=(ConstantPoolElement)o;
	    return this.id-ano.id;
	}
	return -1;
    }

    @Override
    public String toString() {
	return "ConstantPoolElement{" + "id=" + id + ", obj=" + obj + '}';
    }
    
}
