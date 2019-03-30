package com.qiufeng.util;

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
	    for(T t : arr2){
		arr=ArrayUtils.push(arr, t);
	    }
	    return arr;
	}
	public static byte[] push(byte[] arr,byte[] arr2){
	    for(byte t : arr2){
		arr=ArrayUtils.push(arr, t);
	    }
	    return arr;
	}
	public static byte[] join(byte[] arr,String str){
	    return ArrayUtils.push(arr, str.getBytes());
	}
}
