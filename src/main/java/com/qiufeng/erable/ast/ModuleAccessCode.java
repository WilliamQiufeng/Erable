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
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;

/**
 * @since 2019年4月10日
 * @author Qiufeng54321
 */
public class ModuleAccessCode extends TempCode {
    DynLoadCode dlc;
    public int modid;
    public ModuleAccessCode(DynLoadCode dlc,String name,Code parent) {
	super(dlc.findVar(name),OpCode.DYNCALL, parent);
	this.dlc=dlc;
	this.modid=dlc.id;
    }
    /**
     * Because the length of id might be different in different ec files,The length of name id will always be 4
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(this.dlc.id);
	byte[] nid=new byte[4];
	BitUtils.putInt(nid, 0, cid);
	this.file.write(nid);
    }

    @Override
    public String toString() {
	return super.toString() + "  Module @" + this.dlc.id + " Accessing: @" + cid ;
    }
    
}
