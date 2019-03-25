package com.qiufeng.erable.ast;
@Deprecated

public class VFCode extends Code {
	public int id;
	public Scope scope;
	public VFCode(int id, Scope scope,Type type) {
		super();
		this.id = id;
		this.scope = scope;
		this.type=type;
	}
	public String toString() {
		return type.name()+" [id=" + id + ", scope=\n" + scope + "]";
	}
	
}
