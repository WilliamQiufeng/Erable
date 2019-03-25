package com.qiufeng.erable.ast;

/**
 * @since 25 March 2019
 * @version 1.0
 * @author QiuFeng54321
 *
 */
public class TempCode extends Code {
	public static int tempId=0;
	public int id;
	public int refid;
	public TempCode(int refid) {
		super();
		//temp id
		this.id = tempId;
		//reference
		this.refid=refid;
		tempId++;
		this.type=Type.TEMP;
	}
	public String toString() {
		return type.name()+" [tempid=" + id + " , refid=" + refid +  "]";
	}
}
