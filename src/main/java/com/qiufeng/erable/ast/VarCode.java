package com.qiufeng.erable.ast;
/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class VarCode extends TempCode {
	public int val;
	public boolean isArgs=false;
	public VarCode(int name,int refid,boolean isArgs) {
		super(name);
		// TODO Auto-generated constructor stub
		this.val=refid;
		this.isArgs=isArgs;
	}
	public VarCode(int name,int refid) {
		this(name,refid,false);
	}
	@Override
	public String toString() {
		return "VarCode [name=" + refid + ", id=" + id + ", value=" + val+ ", type=" + type + "]";
	}

}
