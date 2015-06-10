<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.entity.User"%>
<%
	Object object = session.getAttribute("loginuser");
	User us = null;
	if (object == null) {

		response.sendRedirect("login.jsp");
		return;
	}else{
	us = (User)object;
	}
%>
