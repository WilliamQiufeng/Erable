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

package com.qiufeng.erable.vm.types;

import com.qiufeng.erable.exception.UnsupportedOperationErr;
import com.qiufeng.erable.vm.ErableDescriptor;

/**
 * @since 2019年4月15日
 * @author Qiufeng54321
 */
public abstract class ErableInstance<T> {
    public T value;
    public int id ;
    public ErableDescriptor descriptor;

    public ErableInstance(T value, int id) {
	this(value,id,null);
    }

    public ErableInstance(T value, int id, ErableDescriptor descriptor) {
	this.value = value;
	this.id = id;
	this.descriptor = descriptor;
    }
    
    public T getValue() {
	return value;
    }

    public void setValue(T value) {
	this.value = value;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public ErableDescriptor getDescriptor() {
	return descriptor;
    }

    public void setDescriptor(ErableDescriptor descriptor) {
	this.descriptor = descriptor;
    }
    public abstract ErableInstance<?> add(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> sub(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> mul(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> div(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> mod(ErableInstance<?> other, int toid);
    
    public abstract ErableInstance<?> ls(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> rs(ErableInstance<?> other, int toid);
    public abstract ErableInteger eq(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> urs(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> ref(int toid);
    public abstract ErableInteger gref(int toid);
    public abstract ErableInstance<?> and(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> or(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> xor(ErableInstance<?> other, int toid);
    public abstract ErableInstance<?> not(int toid);
    
    public ErableInstance<?> pow(ErableInstance<?> other, int toid){
	if(other instanceof ErableInteger){
	    ErableInstance ei=this;
	    for(int i=0;i<(Integer)other.getValue();i++){
		ei=ei.mul(ei, toid);
	    }
	    return ei;
	}
	new UnsupportedOperationErr("**", "Operation between "+this+" and "+other).throwException();
	return null;
    }
    
    @Override
    public String toString() {
	return getClass().getSimpleName() + "{" + "id=" + id + ", value=" + value + '}';
    }
    
}
