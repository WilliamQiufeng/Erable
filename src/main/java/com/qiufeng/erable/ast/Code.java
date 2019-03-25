package com.qiufeng.erable.ast;

public abstract class Code {
	public static enum Type{
		VARIABLE,
		FUNCTION,
		TEMP;
	}
	public Type type;
	@Override
	public String toString() {
		return type.name();
	}
}
