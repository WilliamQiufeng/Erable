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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 2019年4月10日
 * @author Qiufeng54321
 */
public class DynLoadCode extends TempCode {
    String dyn;
    int ecid;
    Properties props;
    int maxid;
    int before;
    public DynLoadCode(String name,int ecpathid,String dynpath,int dynid, Code parent) {
	super(dynid,OpCode.DYN_LOAD, parent);
	this.ecid=ecpathid;
	this.dyn=dynpath;
	this.sign=Code.VAR;
	this.tag=name;
    }
    public void loadProps(){
	try {
	    props=new Properties();
	    props.load(new FileInputStream(this.dyn));
	    this.maxid=Integer.parseInt(props.getProperty("@maxid","0"));
	}
	catch (IOException ex) {
	    Logger.getLogger(DynLoadCode.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    
    @Override
    public int findFunction(String name, int argc) {
	return findVar(name);
    }

    @Override
    public int findVar(String name) {
	return Integer.parseInt((String)props.getOrDefault(name, -1));
    }

    @Override
    public void write() throws IOException {
	this.writeOpCode(this.op);
	this.writeId(ecid);
	this.writeId(cid);
	this.writeId(id);
    }

    @Override
    public String toString() {
	return super.toString() + "  Dynamic Load Module: " + this.ecid + ", Table: " + this.dyn + ", as " + this.id + " with name " + this.tag;
    }
    
}
