<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.myhouseUtils.Datechange"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
<%
	request.setCharacterEncoding("utf-8");
	HouseInfoService service = new HouseInfoService();
	String title = request.getParameter("title");
	String price = request.getParameter("price");
	int low_price =0;
	int high_price =0;
	String street_id = request.getParameter("street_id");
	String type_id = request.getParameter("type_id");
	String floorage = request.getParameter("floorage");
	int low_floorage = 0;
	int high_floorage = 0;
	if (title == null) {
		title = "";
	}
	if(price ==null){
		price = "";
	}
	if(street_id ==null){
		street_id = "";
	}
	if(type_id ==null){
		type_id = "";
	}
	if(floorage ==null){
		floorage = "";
	}
	if("".equals(price)){
		low_price =0;
		high_price =0;
	}else if("0-100".equals(price)){
		low_price =0;
		high_price =100;
	}else if("100-200".equals(price)){
		low_price =100;
		high_price =200;
	}else if("200-1000000".equals(price)){
		low_price =200;
		high_price =1000000;
	}
	if("".equals(street_id)){
		street_id = "";
	}
	if("".equals(type_id)){
		type_id = "";
	}
	if("".equals(floorage)){
		low_floorage = -1;
		high_floorage = -1;
	}else if("0-40".equals(floorage)){
		low_floorage = 0;
		high_floorage = 40;
	}else if("40-500".equals(floorage)){
		low_floorage = 40;
		high_floorage = 500;
	}else if("500-1000000".equals(floorage)){
		low_floorage = 500;
		high_floorage = 1000000;
	}
	String pagestr = request.getParameter("page");
	int pageindex = 1;
	if (pagestr == null) {
		pageindex = 1;
	}
	if (pagestr != null && !"".equals(pagestr)) {
		pageindex = Integer.valueOf(pagestr);
	}
	int pagecount = service.getPageCountByAll(Datechange.PAGESIZE,low_price, high_price, title, type_id, street_id, low_floorage, high_floorage);
	List<HouseInfo> list = service.search(pageindex,
			Datechange.PAGESIZE,low_price,high_price,title,type_id,street_id,low_floorage,high_floorage );
	request.setAttribute("result", list);
	request.setAttribute("pageindex",pageindex);
	request.setAttribute("pagecount",pagecount);
	request.setAttribute("title",title);
	request.setAttribute("price",price);
	request.setAttribute("street_id",street_id);
	request.setAttribute("type_id",type_id);
	request.setAttribute("floorage",floorage);
	request.getRequestDispatcher("index.jsp").forward(request, response);
%>
