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
public class ErableNumber extends ErableInstance<Double> {

    public ErableNumber(Double value, int id) {
	super(value, id);
    }

    @Override
    public ErableInstance<?> add(ErableInstance<?> other, int toid) {
	if(other instanceof ErableString){
	    return new ErableString(this.value + (String)other.getValue(), toid);
	}
	if(other instanceof ErableNumber)
	    return new ErableNumber(value + (Double)other.getValue(), toid);
	else if(other instanceof ErableInteger)
	    return new ErableNumber(getValue()+(Integer)other.getValue(),toid);
	new UnsupportedOperationErr("+", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> sub(ErableInstance<?> other, int toid) {
	if(other instanceof ErableNumber)
	    return new ErableNumber(value - (Double)other.getValue(), toid);
	else if(other instanceof ErableInteger)
	    return new ErableNumber(getValue()+(Integer)other.getValue(),toid);
	new UnsupportedOperationErr("-", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> mul(ErableInstance<?> other, int toid) {
	if(other instanceof ErableNumber)
	    return new ErableNumber(value * (Double)other.getValue(), toid);
	else if(other instanceof ErableInteger)
	    return new ErableNumber(getValue()*(Integer)other.getValue(),toid);
	new UnsupportedOperationErr("*", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> div(ErableInstance<?> other, int toid) {
	if(other instanceof ErableNumber)
	    return new ErableNumber(value / (Double)other.getValue(), toid);
	else if(other instanceof ErableInteger)
	    return new ErableNumber(getValue() / (Integer)other.getValue(),toid);
	new UnsupportedOperationErr("/", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> mod(ErableInstance<?> other, int toid) {
	if(other instanceof ErableNumber)
	    return new ErableNumber(value % (Double)other.getValue(), toid);
	else if(other instanceof ErableInteger)
	    return new ErableNumber(getValue() % (Integer)other.getValue(),toid);
	new UnsupportedOperationErr("%", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> ls(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr("<<", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInstance<?> rs(ErableInstance<?> other, int toid) {
	new UnsupportedOperationErr(">>", "Operation between "+this+" and "+other).throwException();
	return null;
    }

    @Override
    public ErableInteger eq(ErableInstance<?> other, int toid) {
	return new ErableInteger(value == other.getValue()?1:0, id);
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
	byte[] thbts=new byte[8];
	BitUtils.putDouble(thbts, 0, value);
	byte[] otbts=new byte[8];
	BitUtils.putDouble(otbts, 0, (Double)other.getValue());
	BitSet bs=BitSet.valueOf(thbts);
	bs.and(BitSet.valueOf(otbts));
	byte[] resbts=bs.toByteArray();
	Double resDouble=BitUtils.getDouble(resbts, 0);
	return new ErableNumber(resDouble, id);
    }

    @Override
    public ErableInstance<?> or(ErableInstance<?> other, int toid) {
	byte[] thbts=new byte[8];
	BitUtils.putDouble(thbts, 0, value);
	byte[] otbts=new byte[8];
	BitUtils.putDouble(otbts, 0, (Double)other.getValue());
	BitSet bs=BitSet.valueOf(thbts);
	bs.or(BitSet.valueOf(otbts));
	byte[] resbts=bs.toByteArray();
	Double resDouble=BitUtils.getDouble(resbts, 0);
	return new ErableNumber(resDouble, id);
    }

    @Override
    public ErableInstance<?> xor(ErableInstance<?> other, int toid) {
	byte[] thbts=new byte[8];
	BitUtils.putDouble(thbts, 0, value);
	byte[] otbts=new byte[8];
	BitUtils.putDouble(otbts, 0, (Double)other.getValue());
	BitSet bs=BitSet.valueOf(thbts);
	bs.xor(BitSet.valueOf(otbts));
	byte[] resbts=bs.toByteArray();
	Double resDouble=BitUtils.getDouble(resbts, 0);
	return new ErableNumber(resDouble, id);
    }

    @Override
    public ErableInstance<?> not(int toid) {
	byte[] thbts=new byte[8];
	BitUtils.putDouble(thbts, 0, value);
	BitSet bs=BitSet.valueOf(thbts);
	bs.flip(0, bs.length());
	byte[] resbts=bs.toByteArray();
	Double resDouble=BitUtils.getDouble(resbts, 0);
	return new ErableNumber(resDouble, id);
    }
    
    
}
