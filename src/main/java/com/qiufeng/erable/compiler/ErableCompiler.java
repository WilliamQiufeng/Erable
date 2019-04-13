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
package com.qiufeng.erable.compiler;

import com.qiufeng.erable.Const;
import com.qiufeng.erable.ErableLexer;
import com.qiufeng.erable.ErableParser;
import com.qiufeng.erable.ast.Code;
import com.qiufeng.erable.ast.EListener;
import com.qiufeng.erable.ast.FuncDeclCode;
import com.qiufeng.erable.ast.VarCode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Qiufeng54321
 */
public class ErableCompiler {
    public void output(OutputStream os,EListener el){
	try {
	    os.write(Const.HEADER);
	    el.root.setFile(os);
	    el.root.write();
	}
	catch (IOException ex) {
	    Logger.getLogger(ErableCompiler.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public void writeDyn(OutputStream os,Code root) throws IOException{
	Properties p=new Properties();
	p.put("@maxid", String.valueOf(Code.currentId));
	for(Code c : root.codes){
	    if(c instanceof VarCode || c instanceof FuncDeclCode){
		p.put(c.tag, String.valueOf(c.id));
	    }
	}
	p.store(os, "Erable Dynamic Lib");
    }
    public void reset(){
	Code.currentId=0;
	Const.setIdLen(1);
	Const.setCidLen(1);
    }
    public EListener compile(String file,EListener parent){
	try{
	    reset();
	    long start=System.currentTimeMillis();
	    ErableParser parser=this.parse(file);
	    ParseTree pt=this.tree(parser);
	    
	    System.out.println("Parsed file "+file);
	    EListener el=this.walk(pt,parser,parent);
	    long end=System.currentTimeMillis();
	    long duration=end-start;
	    //System.out.println(pt.toStringTree());
            //System.out.println(pt.toString());
	    System.out.println("File "+file+" finished.Total time:"+duration+" ms.");
	    return el;
	}catch(IOException e){
	    e.printStackTrace();
	}
	return null;
    }
    public ErableParser parse(String file) throws IOException{
	FileInputStream fis=new FileInputStream(file);
	ANTLRInputStream ais=new ANTLRInputStream(fis);
	//var ais=CharStreams.fromStream(fis);
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
