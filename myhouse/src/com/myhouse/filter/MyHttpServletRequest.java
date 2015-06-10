package com.myhouse.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 这个类是为了将用户输入的一些HTML标签等特殊字符进行转化。
 * @author zqy
 *
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper{
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	public String toHtml(String value){
		value=value.replaceAll("&", "&amp;");
		value=value.replaceAll("<", "&lt;");
		value=value.replaceAll(">", "&gt;");
		value=value.replaceAll("\"", "&quot;");
		value=value.replaceAll(" ", "&nbsp;");
		value=value.replaceAll("\n", "<br>");
		return value;
	}
	public String getParameter(String name){
		String value = super.getParameter(name);
		if(value==null){
			value = "";
		}else{
			value=toHtml(value);
		}
		return value;
	}
	
}
