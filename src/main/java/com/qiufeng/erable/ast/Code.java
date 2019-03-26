package com.qiufeng.erable.ast;

public abstract class Code {
	public static enum Type{
		VARIABLE,
		FUNCTION,
		TEMP;
	}
	public Type type;
	/**
	 * Basically other classes will override this method for debug and diagnostics.
	 */
	@Override
	public String toString() {
		return type.name();
	}
}
