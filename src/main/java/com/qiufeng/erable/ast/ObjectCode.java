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
import java.io.IOException;

/**
 *
 * @author Qiufeng54321
 */
public class ObjectCode extends TempCode {
    public boolean isKey=true;
    public ObjectCode(Code parent) {
	super(-1,OpCode.OBJECT, parent);
    }
    /**
     * [OBJECT 1B] [[START_PAIR 1B] [CODE(KEY)] [KEY 4B] [CODE(VALUE)] [VALUE 4B] [END_PAIR 1B]]* [END 1B]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(id);
	System.out.println("__START OBJECT "+this+"__");
	this.writeCodes();
	this.writeOpCode(OpCode.END);
	this.writeId(id);
	System.out.println("__END OBJECT "+this+"__");
    }

    @Override
    public String toString() {
	return super.toString() + "  object ->" + this.id + " :";
    }
    
}
