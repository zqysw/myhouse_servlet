<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%
	String id = request.getParameter("id");
	int delId = Integer.valueOf(id);
	HouseInfoService service = new HouseInfoService();
	int result = service.delHouse(delId);
	if(result ==1){
		out.print("<script>alert('删除成功');</script>");
		response.sendRedirect("list.jsp");
		//request.getRequestDispatcher("list.jsp").forward(request, response);
	}else if(result ==0){
		out.print("<script>alert('其他原因，删除失败');history.go(-1);</script>");
	}else if(result ==-1){
		out.print("<script>alert('数据库中没有这条数据，删除失败');history.go(-1);</script>");
	}
	
 %>
