package com.qiufeng.erable.ast;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class BinaryOpCode extends TempCode {
	public static enum BinOp{
		POW("**"),ADD("+"),SUB("-"),MUL("*"),DIV("/"),MOD("%"),
		AND("&&"),OR("||"),XOR("^^"),BAND("&"),BOR("|"),BXOR("^"),BNOT("!"),
		LS("<<"),RS(">>"),ULS("<<<"),URS(">>>"),
		EQ("=="),NEQ("!="),LT("<"),GT(">"),LTE("<="),RTE(">="),
		ADDEQ("+="),SUBEQ("-="),MULEQ("*="),DIVEQ("/="),MODEQ("%="),SWITCH("<=>"),
		EQU("=");
		String sign;
		BinOp(String sign) {
			this.sign=sign;
		}
	}
	BinOp op;
	int left,right;//temp id for left&right
	public BinOp getOp() {
		return op;
	}
	public void setOp(BinOp op) {
		this.op = op;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public BinaryOpCode(String sign,/*temp id L&R*/int left,int right) {
		super(-1);
		// TODO Auto-generated constructor stub
		op=findOp(sign);
		this.left=left;
		this.right=right;
	}
	public static BinOp findOp(String sign) {
		for(BinOp bo : BinOp.values()) {
			if(bo.sign.equals(sign))
				return bo;
		}
		return null;
	}
	@Override
	public String toString() {
		return "BinaryOpCode [op=" + op + ", left=" + left + ", right=" + right + ", id=" + id + ", refid=" + refid
				+ ", type=" + type + "]";
	}
	
	
}
