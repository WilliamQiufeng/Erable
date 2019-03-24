package com.qiufeng.erable.ast;
import java.util.*;

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
	public void declareFunction(int id,Scope s) {
		s.type=Type.FUNCTION;
		VFCode c=new VFCode(id,s,Code.Type.FUNCTION);
		codes.add(c);
	}
	public void declareVariable(int id,Scope s) {
		s.type=Type.VARIABLE;
		VFCode c=new VFCode(id,s,Code.Type.VARIABLE);
		codes.add(c);
	}
	public Scope findFunction(int id) {
		for(Code me : codes) {
			if(me.type!=Code.Type.FUNCTION)continue;
			VFCode trans=(VFCode)me;
			if(trans.id==id) {
				return trans.scope;
			}
		}
		if(parent!=null) {
			return parent.findFunction(id);
		}
		return null;
	}
	public Scope findVariable(int id) {
		for(Code me : codes) {
			if(me.type!=Code.Type.VARIABLE)continue;
			VFCode trans=(VFCode)me;
			if(trans.id==id) {
				return trans.scope;
			}
		}
		if(parent!=null) {
			return parent.findVariable(id);
		}
		return null;
	}
	public Scope find(int id) {
		Scope ret=findFunction(id);
		if(ret==null)
			return findVariable(id);
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
