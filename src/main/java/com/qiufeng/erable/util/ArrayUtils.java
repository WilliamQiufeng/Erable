package com.qiufeng.erable.util;

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
	public static byte[] push(byte[] arr,byte element) {
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=element;
		return arr;
	}
	public static <T> T[] push(T[] arr,T[] arr2){
	    int offset=arr.length;
	    arr=Arrays.copyOf(arr, arr.length+arr2.length);
	    System.arraycopy(arr2, 0, arr, offset, arr2.length);
	    return arr;
	}
	public static byte[] push(byte[] arr,byte[] arr2){
	    int offset=arr.length;
	    arr=Arrays.copyOf(arr, arr.length+arr2.length);
	    System.arraycopy(arr2, 0, arr, offset, arr2.length);
	    return arr;
	}
	public static<T> T[] push(T[]... arrs){
	    if(arrs.length<2)
		throw new UnsupportedOperationException("Length under 2");
	    for(int i=1;i<arrs.length;i++){
		arrs[0]=ArrayUtils.push(arrs[0],arrs[i]);
	    }
	    return arrs[0];
	}
	public static byte[] join(byte[] arr,String str){
	    return ArrayUtils.push(arr, str.getBytes());
	}
	public static <T> T[] cut(T[] arr,int from,int to){
	    Arrays.copyOfRange(arr, from, to);
	    return arr;
	}
	public static byte[] cut(byte[] arr,int from,int to){
	    Arrays.copyOfRange(arr, from, to);
	    return arr;
	}
}
