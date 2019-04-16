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

package com.qiufeng.erable.vm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * @since 2019年4月9日
 * @author Qiufeng54321
 */
public class ErableVM {
    @Option(required = true, usage = "Chooses the file to execute.", name = "-f")
    public String file="test/test.ec";
    
    public static void main(String[] args) {
	new ErableVM().nmain(args);
    }
    public void nmain(String[] args) {
	CmdLineParser clp=new CmdLineParser(this);
	try{
	    clp.parseArgument(args);
	}catch(CmdLineException e){
	    System.err.println("[ERROR]"+e.getMessage());
	    clp.printUsage(System.err);
	    return;
	}
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    ErableDescriptor descriptor=new ErableDescriptor(in);
	    descriptor.doAll();
	}
	catch (Exception ex) {
	    Logger.getLogger(ErableVM.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
