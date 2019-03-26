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
	public int findConstByTemp(int tempid) {
		System.out.println("Finding const by temp: "+tempid);
		
		for(Code me : codes) {
			if(me instanceof TempCode) {
				TempCode tc=(TempCode)me;
				System.out.println("Iterating reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(tempid==tc.id) {
					System.out.println("Found id:"+tc.refid);
					return tc.refid;
				}
			}
		}
		if(parent!=null) {
			return parent.findConstByTemp(tempid);
		}
		return -1;
	}
	public int findTempByConst(int constid) {
		System.out.println("Finding temp by const: "+constid);
		
		for(Code me : codes) {
			if(me instanceof TempCode) {
				TempCode tc=(TempCode)me;
				System.out.println("Iterating reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(constid==tc.refid) {
					System.out.println("Found id:"+tc.id);
					return tc.id;
				}
			}
		}
		if(parent!=null) {
			return parent.findTempByConst(constid);
		}
		return -1;
	}
	public int findTempExists(int id) {
		System.out.println("Finding temp exists: "+id);
		
		for(Code me : codes) {
			if(me instanceof VarCode) {
				VarCode tc=(VarCode)me;
				int cid=this.findConstByTemp(tc.refid);
				System.out.println("Iterating var reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(id==cid) {
					System.out.println("Found var id:"+tc.id);
					return tc.id;
				}
			}else if(me instanceof FuncDeclCode) {
				FuncDeclCode tc=(FuncDeclCode)me;
				int cid=this.findConstByTemp(tc.refid);
				System.out.println("Iterating funcdecl reference ids:"+tc.refid+", tmp id:"+tc.id);
				if(id==cid) {
					System.out.println("Found funcdecl id:"+tc.id);
					return tc.id;
				}
			}
		}
		if(parent!=null) {
			return parent.findTempExists(id);
		}
		return -1;
	}
	public int temp(int id) {
		int varid=findTempExists(id);
		if(varid!=-1)return varid;
		TempCode tc=new TempCode(id);
		addCode(tc);
		return tc.id;
	}
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
	 * @param id
	 * @return Scope
	 */
	public int find(int id) {
		int ret=findFunction(id);
		if(ret==-1)
		  ret=findVariable(id);
		System.out.println("result finding var/func id "+ id+ "="+ ret);
		return ret;
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
