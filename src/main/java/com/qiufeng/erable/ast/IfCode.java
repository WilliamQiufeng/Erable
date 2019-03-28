/**
 * @author QiuFeng54321
 * @since 2019年3月26日
 * @version 
 */
package com.qiufeng.erable.ast;

import java.util.Arrays;

public class IfCode extends TempCode {
	public Scope[] elses;
	public Scope ido;
	/**
	 * @param cond
	 * @since 2019年3月26日
	 * @author Qiufeng54321
	 */
	public IfCode(int cond,Scope ido,Scope[] elses) {
		super(cond);
		// TODO Auto-generated constructor stub
		this.ido=ido;
		this.elses=elses;
	}
	@Override
	public String toString() {
		return "IfCode [condition=" + refid + ", ido=" + ido + ", elses=" + Arrays.toString(elses) + ", id=" + id
				+ ", type=" + type + "]";
	}
	
}
