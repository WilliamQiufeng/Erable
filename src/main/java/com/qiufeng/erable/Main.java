package com.qiufeng.erable;
import com.qiufeng.erable.ast.EListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.kohsuke.args4j.*;
/**
 * @since 22 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class Main 
{
    @Option(name="-f",usage="Choose the file to parse")
    public String file=null;
    @Option(name="-s",usage="Show the tree generated")
    public boolean showTree=false;
    @Option(name="-d",usage="Write debug information to file")
    public String debugPath=null;
    public OutputStream dp;
    @Option(name="-q",usage="Quiet.No Outputs")
    public boolean quiet=false;
    @Argument
    List<String> arguments=new ArrayList<String>();
    public static void main( String[] args )
    {
        new Main().nmain(args);
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
	if(file==null){
	    file="test.erable";
	    System.out.println("File not specified.Using default:"+file);
	}
	if(this.debugPath!=null){
	    try{
		this.dp=new FileOutputStream(this.debugPath);
	    }catch(FileNotFoundException e){
		System.err.println("[ERROR]File not found.");
		e.printStackTrace();
	    }
	}
	try{
	    long start=System.currentTimeMillis();
	    FileInputStream fis=new FileInputStream(file);
	    ANTLRInputStream ais=new ANTLRInputStream(fis);
	    ErableLexer lexer=new ErableLexer(ais);
	    CommonTokenStream cts=new CommonTokenStream(lexer);
	    ErableParser parser=new ErableParser(cts);
	    ParseTree pt=parser.prog();
	    
	    System.out.println("Parsed file "+file);
	    ParseTreeWalker ptw=new ParseTreeWalker();
	    EListener el=new EListener(parser);
	    
	    ptw.walk(el, pt);
	    for(var element : el.pool.elements){
		println(element.toString());
	    }
	    var tree=el.root.tree(0);
	    if(showTree)
		println(tree);
	    println("Walked file "+file);
	    long end=System.currentTimeMillis();
	    long duration=end-start;
	    //System.out.println(pt.toStringTree());
            //System.out.println(pt.toString());
	    println("Program finished.Total time:"+duration+" ms.");
	}catch(Throwable e){
	    e.printStackTrace();
	}
    }
    public void println(String sth){
	if(!this.quiet){
	    System.out.println(sth);
	}
	if(this.dp!=null){
	    try {
		this.dp.write(sth.getBytes());
	    } catch (IOException ex) {
		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
