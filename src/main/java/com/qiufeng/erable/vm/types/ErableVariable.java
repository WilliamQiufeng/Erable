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

/**
 * @since 2019年4月16日
 * @author Qiufeng54321
 */
public class ErableVariable extends ErableInstance<ErableInstance<?>> {
    public ErableVariable(ErableInstance<?> value, int id, ErableDescriptor descriptor) {
	super(value, id, descriptor);
    }

    public ErableVariable(Integer value, int id, ErableDescriptor descriptor) {
	super(descriptor.buffer.get(value), id, descriptor);
    }

    @Override
    public ErableInstance<?> getValue() {
	return super.getValue();
    }
    
    
    public int getRef(){
	return value.id;
    }

    @Override
    public ErableInstance<?> add(ErableInstance<?> other, int toid) {
	return value.add(other, toid);
    }

    @Override
    public ErableInstance<?> sub(ErableInstance<?> other, int toid) {
	return value.sub(other, toid);
    }

    @Override
    public ErableInstance<?> mul(ErableInstance<?> other, int toid) {
	return value.mul(other, toid);
    }

    @Override
    public ErableInstance<?> div(ErableInstance<?> other, int toid) {
	return value.div(other, toid);
    }

    @Override
    public ErableInstance<?> mod(ErableInstance<?> other, int toid) {
	return value.mod(other, toid);
    }

    @Override
    public ErableInstance<?> ls(ErableInstance<?> other, int toid) {
	return value.ls(other, toid);
    }

    @Override
    public ErableInstance<?> rs(ErableInstance<?> other, int toid) {
	return value.rs(other, toid);
    }

    @Override
    public ErableInteger eq(ErableInstance<?> other, int toid) {
	return value.eq(other, toid);
    }

    @Override
    public ErableInstance<?> urs(ErableInstance<?> other, int toid) {
	return value.urs(other, toid);
    }

    @Override
    public ErableInstance<?> ref(int toid) {
	return value.ref(toid);
    }

    @Override
    public ErableInteger gref(int toid) {
	return value.gref(toid);
    }

    @Override
    public ErableInstance<?> and(ErableInstance<?> other, int toid) {
	return value.and(other, toid);
    }

    @Override
    public ErableInstance<?> or(ErableInstance<?> other, int toid) {
	return value.or(other, toid);
    }

    @Override
    public ErableInstance<?> xor(ErableInstance<?> other, int toid) {
	return value.xor(other, toid);
    }

    @Override
    public ErableInstance<?> not(int toid) {
	return value.not(toid);
    }

    @Override
    public String toString() {
	return "ErableVariable{id=" + id + ", value=" + this.getValue() + ", refid=" + getRef() + '}';
    }
    
}
