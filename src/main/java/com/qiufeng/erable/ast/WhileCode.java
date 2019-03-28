/*
 * Copyright (C) 2019 Qiufeng54321 <Qiufeng54321 at qiufeng54321.github.io>
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

/**
 * @since 27 March 2019
 * @author Qiufeng54321
 */
public class WhileCode extends TempCode {
    public Scope pdo;
    public WhileCode(int refid,Scope pdo) {
	super(refid);
	this.pdo=pdo;
    }

    @Override
    public String toString() {
	return "WhileCode [cond=" + refid + ", pdo=" + pdo + ']';
    }
    
}
