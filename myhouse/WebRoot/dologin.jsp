<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.UserService"%>
<%@page import="com.myhouse.entity.User"%>
<%
request.setCharacterEncoding("utf-8");
 String name = request.getParameter("name");
 String password = request.getParameter("password");
 UserService service = new UserService();
 User user = new User(name,password);
 boolean result =  service.selUser(user);
 if(result == true){
 	response.sendRedirect("list.jsp");
 }else{
 	out.print("<script>alert('用户名或密码错误');history.go(-1);</script>");
 }
 %>
