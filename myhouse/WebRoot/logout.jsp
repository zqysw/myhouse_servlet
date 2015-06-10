<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
session.removeAttribute("loginuser");
response.sendRedirect("login.jsp");
%>
