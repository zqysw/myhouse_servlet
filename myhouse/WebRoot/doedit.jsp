<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.myhouseUtils.Datechange"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
<%@page import="com.myhouse.entity.HouseType"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.entity.District"%>
<%@page import="com.myhouse.entity.Street"%>
<%@ include file="checkLogin.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset = utf-8");
	String owner = us.getName();
	String title = request.getParameter("title");
	String housetype = request.getParameter("type_id");
	HouseType htype = new HouseType();
	htype.setId(Integer.valueOf(housetype));
	String floorage = request.getParameter("floorage");
	String price = request.getParameter("price");
	String housedate01 = request.getParameter("houseDate");
	Date housedate = Datechange.getDateByStr(housedate01, "yyyy-MM-dd");
	String district_id = request.getParameter("district_id");
	District district = new District();
	district.setId(Integer.valueOf(district_id));
	String street_id = request.getParameter("street_id");
	Street street = new Street();
	street.setId(Integer.valueOf(street_id));
	String contact = request.getParameter("contact");
	String content = request.getParameter("description");
	int id = Integer.valueOf(request.getParameter("id"));
	HouseInfo house = new HouseInfo(id,title, htype.getId(), floorage,
			price, housedate, district.getId(), street.getId(),
			contact, content,owner);
			out.print("id:"+id+",title:"+title+", htype.getId():"
			+htype.getId()+",floorage:"+floorage+",price:"+price+",housedate:"+housedate+",district.getId():"+district.getId()+
			",street.getId():"+street.getId()+",contact:"+contact+",content:"+content+",owner:"+owner);
	HouseInfoService service = new HouseInfoService();
	int result = service.editHouse(house);
	if (result == 1) {
		response.sendRedirect("list.jsp");
	} else if (result == 0) {
		out.print("<script>alert('没有存入数据库');history.go(-1);</script>");
	} else if (result == -1) {
		out
				.print("<script>alert('没有找到该房屋信息');history.go(-1);</script>");
	}
%>
