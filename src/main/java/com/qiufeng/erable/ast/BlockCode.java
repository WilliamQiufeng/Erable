package com.qiufeng.erable.ast;

/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class BlockCode extends TempCode {
	Scope scope;
	public BlockCode(Scope scope) {
		super(-1);
		// TODO Auto-generated constructor stub
		this.scope=scope;
	}
	@Override
	public String toString() {
		return "BlockCode [scope=\n" + scope.treeVF(6) + "]";
	}

}
