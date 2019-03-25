/**
 * @author QiuFeng54321
 * @since 2019年3月25日
 * @version 1.0
 */
package com.qiufeng.erable.ast;

import java.util.Arrays;

public class FuncDeclCode extends TempCode {
	public int[] args;
	public Scope pdo;
	/**
	 * @param name as <em>refid</em>
	 * @param args temp ids for arguments
	 * @param pdo  what to do after function calling.
	 */
	public FuncDeclCode(int name,int[] args,Scope pdo) {
		super(name);
		// TODO Auto-generated constructor stub
		this.args=args;
		this.pdo=pdo;
	}
	@Override
	public String toString() {
		return "FuncDeclCode [ args=" + Arrays.toString(args) + ", id=" + id
				+ ", refid=" + refid + ", type=" + type + ", pdo=\n" + pdo + "]";
	}
	

}
