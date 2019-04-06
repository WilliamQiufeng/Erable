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
package com.qiufeng.erable;

import com.qiufeng.erable.ast.EListener;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Qiufeng54321
 */
public class ErableCompiler {
    public EListener compile(String file,EListener parent){
	try{
	    long start=System.currentTimeMillis();
	    var parser=this.parse(file);
	    var pt=this.tree(parser);
	    
	    System.out.println("Parsed file "+file);
	    var el=this.walk(pt,parser,parent);
	    long end=System.currentTimeMillis();
	    long duration=end-start;
	    //System.out.println(pt.toStringTree());
            //System.out.println(pt.toString());
	    System.out.println("File "+file+" finished.Total time:"+duration+" ms.");
	    return el;
	}catch(Throwable e){
	    e.printStackTrace();
	}
	return null;
    }
    public ErableParser parse(String file) throws IOException{
	FileInputStream fis=new FileInputStream(file);
	ANTLRInputStream ais=new ANTLRInputStream(fis);
	ErableLexer lexer=new ErableLexer(ais);
	CommonTokenStream cts=new CommonTokenStream(lexer);
	ErableParser parser=new ErableParser(cts);
	return parser;
    }
    public ParseTree tree(ErableParser parser){
	ParseTree pt=parser.prog();
	return pt;
    }
    public EListener walk(ParseTree pt,ErableParser parser,EListener parent){
	ParseTreeWalker ptw=new ParseTreeWalker();
	EListener el;
	if(parent==null)
	    el=new EListener(parser);
	else
	    el=new EListener(parser,parent);
	ptw.walk(el, pt);
	return el;
    }
}
