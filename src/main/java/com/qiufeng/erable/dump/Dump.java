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

package com.qiufeng.erable.dump;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * @since 2019年4月9日
 * @author Qiufeng54321
 */
public class Dump {
    @Option(name="-f",usage="specify the file to dump")
    public String file="test.ec";
    @Option(name="-o",usage="...")
    public String useless;
    public String out="dump.log";
    public static void main(String[] args){
	new Dump().nmain(args);
    }
    public void nmain(String[] args){
	CmdLineParser clp=new CmdLineParser(this);
	try{
	    clp.parseArgument(args);
	}catch(CmdLineException e){
	    System.err.println("[ERROR]"+e.getMessage());
	    clp.printUsage(System.err);
	    return;
	}
	try {
	    FileInputStream fis=new FileInputStream(this.file);
	    ErableDumper ed=new ErableDumper(fis);
	    var os=new FileOutputStream(out);
	    ed.dump(os);
	}
	catch (IOException ex) {
	    Logger.getLogger(Dump.class.getName()).log(Level.SEVERE, null, ex);
	}
	
    }
}
