package com.myhouse.myhouseUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public   class Datechange {
	/**
	 * 将字符串转化为日期类型
	 * @param datestr
	 * @param formatstr
	 * @return
	 */
	public static Date getDateByStr(String datestr,String formatstr){
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			date = format.parse(datestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 将日期类型转化为字符串
	 * @param date
	 * @param formatstr
	 * @return
	 */
	public static String getStrByDate(Date date,String formatstr){
		SimpleDateFormat dateformat = new SimpleDateFormat(formatstr);
		return dateformat.format(date);
	}
	//定义一个常量，表示每页显示数量为3
	public static final int PAGESIZE = 3;
}
