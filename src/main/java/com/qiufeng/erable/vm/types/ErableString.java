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
import com.qiufeng.erable.util.BitUtils;
import java.util.BitSet;

/**
 * @since 2019年4月15日
 * @author Qiufeng54321
 */
public class ErableString extends ErableInstance<String> {

    public ErableString(String value, int id) {
	super(value, id);
    }
    @Override
    public ErableInstance<?> add(ErableInstance<?> other, int toid) {
	return new ErableString(this.value + String.valueOf(other.getValue()), toid);
    }

    @Override
    public ErableInstance<?> sub(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr("-", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> mul(ErableInstance<?> other, int toid) {
	if(other instanceof ErableInteger)
	    return new ErableString(value.repeat((Integer)other.getValue()), toid);
	new UnsupportedOperationErr("*", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> div(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr("/", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> mod(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr("%", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> ls(ErableInstance<?> other, int toid) {
	if(other instanceof ErableInteger)
	    return new ErableString(value.substring((Integer)other.getValue()), toid);
	new UnsupportedOperationErr("<<", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> rs(ErableInstance<?> other, int toid) {
	if(other instanceof ErableInteger)
	    return new ErableString(value.substring(0,value.length()-(Integer)other.getValue()), toid);
	new UnsupportedOperationErr(">>", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInteger eq(ErableInstance<?> other, int toid) {
	return new ErableInteger(value .equals( other.getValue() )?1:0, id);
    }


    @Override
    public ErableInstance<?> urs(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr(">>>", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> ref(int toid) {
	new UnsupportedOperationErr("@", "Operation to "+this).throwException();
	return null;
    }

    @Override
    public ErableInteger gref(int toid) {
	return new ErableInteger(id, toid);
    }

    @Override
    public ErableInstance<?> and(ErableInstance<?> other, int toid) {
	BitSet bs=BitSet.valueOf(value.getBytes());
	bs.and(BitSet.valueOf(((String)other.getValue()).getBytes()));
	byte[] resbts=bs.toByteArray();
	return new ErableString(new String(resbts),toid);
    }

    @Override
    public ErableInstance<?> or(ErableInstance<?> other, int toid) {
	BitSet bs=BitSet.valueOf(value.getBytes());
	bs.or(BitSet.valueOf(((String)other.getValue()).getBytes()));
	byte[] resbts=bs.toByteArray();
	return new ErableString(new String(resbts),toid);
    }

    @Override
    public ErableInstance<?> xor(ErableInstance<?> other, int toid) {
	BitSet bs=BitSet.valueOf(value.getBytes());
	bs.xor(BitSet.valueOf(((String)other.getValue()).getBytes()));
	byte[] resbts=bs.toByteArray();
	return new ErableString(new String(resbts),toid);
    }

    @Override
    public ErableInstance<?> not(int toid) {
	BitSet bs=BitSet.valueOf(value.getBytes());
	bs.flip(0, bs.length());
	byte[] resbts=bs.toByteArray();
	return new ErableString(new String(resbts),toid);
    }
    
}
