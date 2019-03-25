package com.qiufeng.erable.ast;

import java.util.Arrays;
/**
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class ArrayCode extends TempCode {
	public int[] arr;
	public ArrayCode(int[] arr) {
		super(-1);
		// TODO Auto-generated constructor stub
		this.arr=arr;
	}
	@Override
	public String toString() {
		return "ArrayCode [id=" + id + ", arr=" + Arrays.toString(arr) + ", refid=" + refid + ", type=" + type + "]";
	}

}
