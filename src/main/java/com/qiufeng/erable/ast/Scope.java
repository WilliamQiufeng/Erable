package com.qiufeng.erable.ast;
import java.util.*;

/**
 * @since 23 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class Scope {
        /**
         * The global constant pool.
         */
	public static ArrayList<Object> idTable=new ArrayList<>();
        public String name="";
        public int currentIndex=0;
	static {
                Scope.idTable.add("null");
                Scope.idTable.add("true");
                Scope.idTable.add("false");
	}
        /**
         * The codes in the scope.
         */
	ArrayList<Code> codes=new ArrayList<>();
        /**
         * Shows its parent.
         */
	Scope parent;
        /**
         * Types the Scope could have.
         */
	public static enum Type{
		FUNCTION,
		VARIABLE,
		CODEBLOCK,
		IF,
                WHILE;
	}
        /**
         * shows the type.
         */
	public Type type;
        /**
         * Construct a new scope with parent <code>p</code> and type <code>t</code>
         * @param p
         * @param t 
         */
	public Scope(Scope p,Type t) {
		parent=p;
		type=t;
                if(p!=null){
                    name=parent.name+"#"+parent.currentIndex++;
                }
		//System.out.println("current depth:"+cdepth);
		
	}
	public Scope getParent() {
		return parent;
	}
        /**
         * @deprecated Not in use.<br>
         * Gets the root Scope.<br>
         * How it works:<br>
         * Scope root=current scope.<br>
         * while <code>root</code>'s parent is not null:<br>
         * &emsp;&emsp;set <code>root</code> to its parent<br>
         * return the root.
         * @return the absolute root scope
         */
	public Scope getRoot() {
		Scope rt=this;
		while(rt.parent!=null) {
			rt=rt.getParent();
		}
		return rt;
	}
	public Scope createChild(Type t) {
		return new Scope(this,t);
	}
        /**
         * Declares a function.<br>
         * Will create a temp id which points to the function once declared.
         * @param name name of the function
         * @param args arguments(name temp id)
         * @param code The Code scope is passed in here.
         * @return temp id.
         */
	public int declareFunction(int name,int[] args,Scope code) {
		FuncDeclCode fdc=new FuncDeclCode(name,args,code);
		addCode(fdc);
		return fdc.id;
	}
        /**
         * Declares a variable.<br>
         * Temp id is created once declared.
         * @param id name id(temp id)
         * @param value value id(temp id)
         * @param isArgs
         * @return temp id for variable.
         */
	public int declareVariable(int id,int value,boolean isArgs) {
		VarCode c=new VarCode(id,value,isArgs);
		addCode(c);
		return c.id;
	}
        /**
         * A wrapper to declare a not-args variable
         * @param id
         * @param value
         * @return 
         */
	public int declareVariable(int id,int value) {
		return this.declareVariable(id, value,false);
	}
        /**
         * A wrapper to add a code.
         * @param c {@link com.qiufeng.erable.ast.Code} to add.
         */
	public void addCode(Code c) {
		codes.add(c);
	}
        /**
         * @param tempid
         * @return 
         */
	public int findConstByTemp(int tempid) {
		//System.out.println("Finding const by temp: "+tempid);
		
		for(Code me : codes) {
			if(me instanceof TempCode) {
				TempCode tc=(TempCode)me;
				//System.out.println("Iterating reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(tempid==tc.id) {
					//System.out.println("Found id:"+tc.refid);
					return tc.refid;
				}
			}
		}
		if(parent!=null) {
			return parent.findConstByTemp(tempid);
		}
		return -1;
	}
        /**
         * @deprecated Not in use.
         * @param constid
         * @return 
         */
	public int findTempByConst(int constid) {
		//System.out.println("Finding temp by const: "+constid);
		
		for(Code me : codes) {
			if(me instanceof TempCode) {
				TempCode tc=(TempCode)me;
				//System.out.println("Iterating reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(constid==tc.refid) {
					//System.out.println("Found id:"+tc.id);
					return tc.id;
				}
			}
		}
		if(parent!=null) {
			return parent.findTempByConst(constid);
		}
		return -1;
	}
	/**
	 * Find variable/function id for the given name id(temp id).<br>
	 * If <strong>Not Found</strong>,return -1;
	 * @param id temp id of the name
	 * @return the variable/function id
	 */
	public int findTempExists(int id) {
		//System.out.println("Finding temp exists: "+id);
		
		for(Code me : codes) {
			/**
			 * Can only copy the code twice because <code>VarCode</code> and <code>FuncDeclCode</code>
			 * are different.
			 */
			if(me instanceof VarCode) {
				VarCode tc=(VarCode)me;
				int cid=this.findConstByTemp(tc.refid);
				//System.out.println("Iterating var reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(id==cid) {
					//System.out.println("---Found var id:"+tc.id);
					return tc.id;
				}
			}else if(me instanceof FuncDeclCode) {
				FuncDeclCode tc=(FuncDeclCode)me;
				int cid=this.findConstByTemp(tc.refid);
				//System.out.println("Iterating funcdecl reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(id==cid) {
					System.out.println("---Found funcdecl id:"+tc.id);
					return tc.id;
				}
			}
		}
		if(parent!=null) {
			return parent.findTempExists(id);
		}
		return -1;
	}
	/**
	 * Create a temp for <em>constant value</em>(Buffer).<br>
	 * If the value is a <strong>value/function</strong>,return an existed <strong>variable/function</strong> id pointer.
	 * @param id constant id
	 * @return {@link Integer}: temp id created.
	 */
	public int temp(int id) {
		int varid=findTempExists(id);
		if(varid!=-1)return varid;
		TempCode tc=new TempCode(id);
		addCode(tc);
		return tc.id;
	}
        /**
         * @deprecated Not in use.
         * @param id
         * @return 
         */
	public int findFunction(int id) {
		for(Code me : codes) {
			if(! (me instanceof FuncDeclCode))continue;
			FuncDeclCode trans=(FuncDeclCode)me;
			if(trans.id==id) {
				return trans.id;
			}
		}
		if(parent!=null) {
			return parent.findFunction(id);
		}
		return -1;
	}
        /**
         * @deprecated Not in use.
         * @param name
         * @return 
         */
	public int findVariable(int name) {
		for(Code me : codes) {
			if(!(me instanceof VarCode))continue;
			VarCode trans=(VarCode)me;
			if(trans.id==name) {
				return trans.id;
			}
		}
		if(parent!=null) {
			return parent.findVariable(name);
		}
		return -1;
	}
	/**
         * @deprecated Not in use.It is replaced by {@link com.qiufeng.erable.ast.Scope#findTempExists(int) }.
         * @see com.qiufeng.erable.ast.Scope#findTempExists(int) 
	 * @param id
	 * @return Scope
	 */
	public int find(int id) {
		int ret=findFunction(id);
		if(ret==-1)
		  ret=findVariable(id);
		//System.out.println("result finding var/func id "+ id+ "="+ ret);
		return ret;
	}
        /**
         * Adds the object into the constant pool
         * @param o object passed in
         * @return 
         */
	public static int addObject(Object o) {
                int fid=findId(o);
                if(fid!=-1)
                    return fid;
                Scope.idTable.add(o);
                return findId(o);
	}
	/**
	 * Find the object stored in constant pool.
	 * @param id constant pool id.
	 * @return {@link Object} the object found in constant pool.If not found, return <code>null</code>.
	 */
	public static Object findObject(int id) {
		return Scope.idTable.get(id);
	}
	/**
	 * Find id of the object in constant pool.
	 * @param obj value from constant pool.
	 * @return {@link Integer} the constant pool id found.If not found, return <code>-1</code>.
	 */
	public static int findId(Object obj) {
		return Scope.idTable.indexOf(obj);
	}
	/**
	 * For diagnostic and debug.
	 * @return {@link String}: tree structure parsed.
	 */
	public String tree() {
		String res="-----------ID Table-----------\n";
		String prefix="->";
		int cid=0;
		for(Object me : idTable) {
			String out=prefix;
			out+=me;
			out+="        ID:";
			out+=cid;
			out+="\n";
			res+=out;
			cid++;
		}
		res+=treeVF(1);
		return res;
	}
	/**
	 * A simple wrapper for <code>System.out.println(tree());</code>
	 */
	public void printTree() {
		System.out.println(tree());
	}
	/**
	 * tree-ify the current scope.<br>
	 * calls {@link com.qiufeng.erable.ast.Code#toString()}.<br>
	 * returns the codes declared.
	 * @param depth
	 * @return {@link String}: the string which contains stringified codes.
	 */
	String treeVF(int depth) {
		String prefix="-".repeat(depth)+">";
		String res="";
		res+=prefix;
		res+="CODES-----\n";
		for(Code me : codes) {
			res+=prefix;
			res+=me.toString();
			res+="\n";
		}
		return res;
	}
	@Override
	public String toString() {
		return treeVF(4);
	}
	
}
