package com.myhouse.myhouseUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFileName {
	/**
	 * GetRamdomFileName()是获取上传文件时生成的文件名，保证不会重复。
	 * @return
	 */
	public static String GetRamdomFileName(){
		Date today = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmssms");
		String filename = "";
		int date = (int)(Math.random()*9000+1000);
		filename = dateformat.format(today)+date;
		return filename;
	}
}
