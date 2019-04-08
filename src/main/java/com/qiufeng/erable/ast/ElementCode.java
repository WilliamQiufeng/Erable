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

import static com.qiufeng.erable.Const.ID_LENGTH;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.util.BitUtils;
import java.io.IOException;

/**
 *
 * @author Qiufeng54321
 */
public class ElementCode extends BinaryOpCode{

    public ElementCode(int ltid, int rtid, Code parent) {
	super(ltid, rtid, OpCode.ELEMENT, parent);
    }
    /**
     * [OP 1B] [LEFT ID 4B] [RIGHT ID 4B] [ID 4B]
     * @throws IOException 
     */
    @Override
    public void write() throws IOException {
	super.write();
    }
}
