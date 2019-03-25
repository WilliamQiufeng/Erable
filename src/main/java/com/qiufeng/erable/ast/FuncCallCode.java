package com.qiufeng.erable.ast;

import java.util.Arrays;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class FuncCallCode extends TempCode {
	public int[] args;
	//temp refid
	public FuncCallCode(int refid,int[] args) {
		super(refid);
		// TODO Auto-generated constructor stub
		this.args=args;
	}
	@Override
	public String toString() {
		return "FuncCallCode [args=" + Arrays.toString(args) + ", id=" + id + ", refid=" + refid + ", type=" + type
				+ "]";
	}
	

}
