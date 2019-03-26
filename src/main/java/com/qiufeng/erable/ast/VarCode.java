package com.qiufeng.erable.ast;
/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class VarCode extends TempCode {
	public int val;
	public VarCode(int name,int refid) {
		super(name);
		// TODO Auto-generated constructor stub
		this.val=refid;
	}
	@Override
	public String toString() {
		return "VarCode [name=" + refid + ", id=" + id + ", value=" + val+ ", type=" + type + "]";
	}

}
