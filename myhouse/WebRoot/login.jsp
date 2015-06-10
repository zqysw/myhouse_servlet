<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>找房网-用户登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type = "text/javascript" src = "js/login.js"></script>
	</head>
	<body>
		<DIV id="header" class="wrap">
			<DIV id="logo">
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id="regLogin" class="wrap">
			<DIV class="dialog">
				<DIV class="box">
					<H4>
						用户登录
					</H4>
					<FORM id="user" method="post" name="user"
						action="LoginServlet">
						<DIV class="infos">
							<TABLE class="field">
								<TBODY>
									<TR>
										<TD colSpan=2></TD>
									</TR>
									<TR>
										<TD class="field">
											用 户 名：
										</TD>
										<TD>
											<!-- <input type="text" class="text" name="name" /> -->
											<INPUT id="user_name" class="text" type="text" name="name">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											密 码：
										</TD>
										<TD>
											<!-- <input type="password" class="text" name="password" /> -->
											<INPUT id="user_password" class="text" type="password"
												name="password">
										</TD>
									</TR>
									<!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						-->
								</TBODY>
							</TABLE>
							<DIV class="buttons">
								<INPUT onclick="return checknull();" value=登陆
									type="submit">
								<INPUT onclick='document.location="register.jsp"' value=注册
									type="button">
							</DIV>
						</DIV>
					</FORM>
				</DIV>
			</DIV>
		</DIV>
		<DIV id="footer" class="wrap">
			<DL>
				<DT>
					找房网 © 2010 找房网 京ICP证1000001号
				</DT>
				<DD>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</DD>
			</DL>
		</DIV>
	</body>
</html>

