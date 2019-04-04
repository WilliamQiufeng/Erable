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

/**
 * 这个句式，与if,else一样有点特殊，
 * 因为遍历condition之前已经调用了enterWhilecond，也就是说已经进入了这个Scope，
 * 这个时候，condition会被加入这个while语句的codes中，
 * 虽然达到了动态效果，但需要处理，
 * 这时候，因为知道：
 * 条件永远都在code[0]处，
 * 所以，写出时，可以把condition直接分离。
 * @author Qiufeng54321
 */
public class WhileCode extends TempCode {
    public WhileCode(Code parent) {
	super(-1,OpCode.WHILE, parent);
	this.sign="^";
    }
    /*public void process(){
	this.codes.add(this.codes.size()-1, new MachineCode(OpCode.BREAKIF,this.codes.get(this.codes.size()-2).id,this));
    }
    */
    @Override
    public boolean addCode(Code code) {
	boolean ret=super.addCode(code);
	return ret;
    }
    
    @Override
    public String toString() {
	return super.toString() + "  while ->" + this.id + " :";
    }
    
}
