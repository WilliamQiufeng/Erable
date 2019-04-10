package com.qiufeng.erable;
import com.qiufeng.erable.compiler.ErableCompiler;
import com.qiufeng.erable.ast.Code;
import com.qiufeng.erable.ast.ConstantPool;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.*;
/**
 * @since 22 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class Main 
{
    @Option(name="-s",usage="Show the tree generated")
    public boolean showTree=false;
    @Option(name="-d",usage="Write debug information to file")
    public String debugPath=null;
    public OutputStream dp;
    @Option(name="-q",usage="Quiet.No Outputs")
    public boolean quiet=false;
    @Option(name="-o",usage="specifies the output compiled file")
    public String output=null;
    @Option(name="-f4",usage="Force using 4-bytes long id")
    public boolean use4=false;
    @Option(name="-dyn",usage="output a name prop")
    public boolean dyn=false;
    @Argument
    List<String> files=new ArrayList<String>();
    public static void main( String[] args )
    {
        new Main().nmain(args);
	new Main().test();
    }
    public void test(){
	
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
	System.out.println(this.files);
	if(use4){
	    Const.setCidLen(4);
	    Const.setIdLen(4);
	}
	if(files.isEmpty()){
	    files.add("test.erable");
	    System.out.println("File not specified.Using default:"+files);
	}
	if(this.quiet){
	    try {
		System.setOut(new PrintStream("null.log"));
	    }
	    catch (FileNotFoundException ex) {
		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	if(this.debugPath!=null){
	    try{
		this.dp=new FileOutputStream(this.debugPath);
		PrintStream ps=System.out;
		PrintStream dps=new PrintStream(this.dp);
		MultiplePrintStream mps=new MultiplePrintStream(new PrintStream[]{dps},ps);
		System.setOut(mps);
	    }catch(FileNotFoundException e){
		System.err.println("[ERROR]File not found.");
		e.printStackTrace();
	    }
	}
	for(String s : files)
	    compile(s);
    }
    public void compile(String file){
	output=file.replace(".erable", "").concat(".ec");
	var compiler=new ErableCompiler();
	var el=compiler.compile(file,null);
	this.printConstantPool(el.getPool());
	this.printTree(el.root);
	if(el.root.currentId>Byte.MAX_VALUE){
	    Const.setIdLen(2);
	}
	if(el.root.currentId>Short.MAX_VALUE){
	    Const.setIdLen(4);
	}
	System.out.println("Starting Compiler...");
	try {
	    FileOutputStream fos=new FileOutputStream(this.output);
	    compiler.output(fos, el);
	    if(this.dyn){
		String dyn=file.replace(".erable","").concat(".dynec");
		var dos=new FileOutputStream(dyn);
		compiler.writeDyn(dos, el.root);
	    }
	}
	catch (IOException ex) {
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    public void println(String sth){
	System.out.println(sth);
    }
    public void println(String sth,boolean showTree){
	if(showTree)
	    println(sth);
    }
    
    public void printConstantPool(ConstantPool cp){
	cp.elements.forEach((element) -> {
	    println(element.toString());
	});
    }
    public void printTree(Code root){
	if(!showTree)return;
	var tree=root.tree(0);
	println(tree,showTree);
    }
}
