package com.cn.util;

public class Util {
	private Util(){}
	//判断一个字符串
	public static boolean hasStr(String str,String[] array){
		boolean f = false;
		for (int i = 0; i < array.length; i++) {
			if(str.indexOf(array[i])!=-1){
				f = true;
				break;
			}
		}
		return f;
	}
}
