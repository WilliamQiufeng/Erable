package com.qiufeng.erable.ast;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class DotCode extends TempCode {
	public int targid;
	public DotCode(int refid,int targid) {
		super(refid);
		// TODO Auto-generated constructor stub
		this.targid=targid;
	}
	@Override
	public String toString() {
		return "DotCode [targid=" + targid + ", id=" + id + ", refid=" + refid + ", type=" + type + "]";
	}

}
