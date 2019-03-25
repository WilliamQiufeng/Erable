package com.qiufeng.erable.ast;
import java.util.*;

/**
 * @since 23 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class Scope {
	public static HashSet<IDElement> idTable=new HashSet<>();
	ArrayList<Code> codes=new ArrayList<>();
	Scope parent;
	public static enum Type{
		FUNCTION,
		VARIABLE,
		CODEBLOCK;
	}
	public static int currentId=0;
	public Type type;
	public Scope(Scope p,Type t) {
		parent=p;
		type=t;
		//System.out.println("current depth:"+cdepth);
		
	}
	public Scope getParent() {
		return parent;
	}
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
	public int declareFunction(int name,int[] args,Scope code) {
		FuncDeclCode fdc=new FuncDeclCode(name,args,code);
		addCode(fdc);
		return fdc.id;
	}
	public int declareVariable(int id,int value) {
		VarCode c=new VarCode(id,value);
		addCode(c);
		return c.id;
	}
	public void addCode(Code c) {
		codes.add(c);
	}
	public int temp(int id) {
		TempCode tc=new TempCode(id);
		addCode(tc);
		return tc.id;
	}
	public Scope findFunction(int id) {
		for(Code me : codes) {
			if(me.type!=Code.Type.FUNCTION)continue;
			FuncDeclCode trans=(FuncDeclCode)me;
			if(trans.id==id) {
				return trans.pdo;
			}
		}
		if(parent!=null) {
			return parent.findFunction(id);
		}
		return null;
	}
	public int findVariable(int id) {
		for(Code me : codes) {
			if(!(me instanceof VarCode))continue;
			VarCode trans=(VarCode)me;
			if(trans.id==id) {
				return trans.id;
			}
		}
		if(parent!=null) {
			return parent.findVariable(id);
		}
		return -1;
	}
	/**
	 * @deprecated Now It is not compatible.
	 * @param id
	 * @return
	 */
	public Scope find(int id) {
		/*Scope ret=findFunction(id);
		  if(ret==null)
		  	return findVariable(id);
		  return ret;
		*/
		return null;
	}
	public int addObject(Object o) {
		for(IDElement me : idTable) {
			if(me.obj.equals(o)) {
				return me.id;
			}
		}
		idTable.add(new IDElement(o, currentId));
		return currentId++;
	}
	public Object findObject(int id) {
		for(IDElement me : idTable) {
			if(me.id==id) {
				return me.obj;
			}
		}
		if(parent!=null) {
			return parent.findObject(id);
		}
		return null;
	}
	public int findId(Object obj) {
		for(IDElement me : idTable) {
			if(me.obj==obj) {
				return me.id;
			}
		}
		if(parent!=null) {
			return parent.findId(obj);
		}
		return -1;
	}
	public String tree() {
		String res="-----------ID Table-----------\n";
		String prefix="->";
		for(IDElement me : idTable) {
			String out=prefix;
			out+=me.obj;
			out+="        ID:";
			out+=me.id;
			out+="\n";
			res+=out;
		}
		res+=treeVF(1);
		return res;
	}
	public void printTree() {
		System.out.println(tree());
	}
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
