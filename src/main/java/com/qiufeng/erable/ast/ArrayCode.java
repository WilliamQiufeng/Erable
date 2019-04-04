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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Qiufeng54321
 */
public class ArrayCode extends TempCode {
    public List<Integer> arr;
    public ArrayCode(List<Integer> arr, Code parent) {
	super(-1, OpCode.ARRAY, parent);
	this.arr=arr;
    }

    @Override
    public String toString() {
	return super.toString() + "  Array " + arr.toString() + " ->"+ this.id;
    }
    
}
