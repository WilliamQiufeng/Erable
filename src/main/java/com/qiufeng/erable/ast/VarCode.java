package com.qiufeng.erable.ast;
/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class VarCode extends TempCode {
	public int name;
	public VarCode(int name,int refid) {
		super(refid);
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	@Override
	public String toString() {
		return "VarCode [name=" + name + ", id=" + id + ", refid=" + refid + ", type=" + type + "]";
	}

}
