package com.qiufeng.erable;

import java.util.Arrays;
/**
 * Util class for processing arrays.
 * @since 24 March 2019
 * @version 1.0
 * @author Qiufeng54321
 *
 */
public class ArrayUtils {
	public static <T> T[] push(T[] arr,T element) {
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=element;
		return arr;
	}
	public static int[] push(int[] arr,int element) {
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=element;
		return arr;
	}
}
