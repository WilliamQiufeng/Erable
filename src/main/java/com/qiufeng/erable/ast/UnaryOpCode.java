package com.qiufeng.erable.ast;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class UnaryOpCode extends TempCode {
	public static enum UnaryOp{
		BNOT("!"),
		RETURN("return"),
		BREAK("break"),
		POS("+"),NEG("-");
		String sign;
		UnaryOp(String sign){
			this.sign=sign;
		}
	}
	UnaryOp op;
	public UnaryOpCode(String sign,int refid) {//temp ref id
		super(refid);
		// TODO Auto-generated constructor stub
		op=findOp(sign);
		
	}
	public static UnaryOp findOp(String sign) {
		for(UnaryOp bo : UnaryOp.values()) {
			if(bo.sign.equals(sign))
				return bo;
		}
		return null;
	}
	@Override
	public String toString() {
		return "UnaryOpCode [op=" + op + ", id=" + id + ", refid=" + refid + ", type=" + type + "]";
	}
	
}
