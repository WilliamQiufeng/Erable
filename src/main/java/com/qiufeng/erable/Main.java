package com.qiufeng.erable;
import com.qiufeng.erable.ast.EListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
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
		System.out.println(element.toString());
	    }
	    System.out.println(el.root.tree(0));
	    System.out.println("Walked file "+file);
	    long end=System.currentTimeMillis();
	    long duration=end-start;
	    //System.out.println(pt.toStringTree());
            //System.out.println(pt.toString());
	    System.out.println("Program finished.Total time:"+duration+" ms.");
	}catch(Throwable e){
	    e.printStackTrace();
	}
    }
}
