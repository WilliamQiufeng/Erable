package com.qiufeng.erable;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
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
    public String file;
    @Argument
    private List<String> arguments=new ArrayList<String>();
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
	if(arguments.isEmpty()){
	    file="test.erable";
	    System.out.println("File not specified.Using default:"+file);
	}
	try{
	    FileInputStream fis=new FileInputStream(file);
	    ANTLRInputStream ais=new ANTLRInputStream(fis);
	    ErableLexer lexer=new ErableLexer(ais);
	    CommonTokenStream cts=new CommonTokenStream(lexer);
	    ErableParser parser=new ErableParser(cts);
	    ParseTree pt=parser.prog();
	    
	    System.out.println(pt.toStringTree());
            System.out.println(pt.toString());
	}catch(Throwable e){
	    e.printStackTrace();
	}
    }
}
