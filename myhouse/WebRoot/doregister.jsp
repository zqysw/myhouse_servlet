<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.entity.User"%>
<%@page import="com.myhouse.service.UserService"%>
<%@page import="java.io.PrintWriter"%>

<%
	response.setContentType("text/html;charset = utf-8");
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String telephone = request.getParameter("telephone");
	String username = request.getParameter("username");
	User user = new User(name, password, telephone, username);
	UserService service = new UserService();
	int result = service.addUser(user);
	if (result == -1) {
		out.print("<script>alert('用户名已存在');history.go(-1);</script>");
	} else if (result == 0) {
		out.print("<script>alert('未知原因，注册失败');history.go(-1);</script>");
	} else {
		request.getRequestDispatcher("regsuccess.jsp").forward(request, response);
		//response.sendRedirect("regsuccess.jsp");
	}
	out.close();
%>
