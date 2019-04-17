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

import com.qiufeng.erable.vm.ErableDescriptor;
import com.qiufeng.erable.vm.OpCodeIns;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 2019年4月15日
 * @author Qiufeng54321
 */
public class ErableFunction extends ErableInstance<ErableFunction> implements Function<Arguments, Object>{
    List<OpCodeIns> does;
    int retid;
    int argc;

    public ErableFunction(List<OpCodeIns> does, ErableDescriptor descriptor,int retid, int id) {
	super(null,id,descriptor);
	this.value=this;
	this.does = does;
	this.retid=retid;
	this.argc=this.retid-this.id-1;
    }

    @Override
    public ErableInstance<?> add(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> sub(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> mul(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> div(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> mod(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> ls(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> rs(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInteger eq(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> urs(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> ref(int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInteger gref(int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> and(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> or(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> xor(ErableInstance<?> other, int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErableInstance<?> not(int toid) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Object apply(Arguments args) {
	try {
	    descriptor.executeAll(does);
	    return descriptor.buffer.get(retid);
	}
	catch (IOException ex) {
	    Logger.getLogger(ErableFunction.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    @Override
    public String toString() {
	return getClass().getSimpleName() + "{" + "id=" + id + ", argc=" + this.argc + ", returns=" + retid + '}';
    }
}
