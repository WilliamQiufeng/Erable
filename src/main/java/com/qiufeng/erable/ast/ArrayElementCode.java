package com.qiufeng.erable.ast;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class ArrayElementCode extends TempCode {
	public int keyid;
	public ArrayElementCode(int refid,int keyid) {
		super(refid);
		// TODO Auto-generated constructor stub
		this.keyid=keyid;
	}
	@Override
	public String toString() {
		return "ArrayElementCode [keyid=" + keyid + ", id=" + id + ", refid=" + refid + ", type=" + type + "]";
	}

}
