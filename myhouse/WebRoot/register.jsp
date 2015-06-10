<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>找房网-用户注册</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<META content="text/html; charset=utf-8" http-equiv=Content-Type>
	<LINK rel=stylesheet type=text/css href="css/style.css">
	<script type="text/javascript" src = "js/register.js"></script>
	</head>
	
	
	<BODY>
		<DIV id="header" class="wrap">
			<DIV id="logo">
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id="regLogin" class="wrap">
			<DIV class="dialog">
				<DL class="clearfix">
					<DT>
						新用户注册
					</DT>
					<DD class="past">
						填写个人信息
					</DD>
				</DL>
				<DIV class="box">
					<FORM name = "frmreg" method = "post" action="RegisterServlet">
						<DIV class="infos">
							<TABLE class="field">
								<TBODY>
									<TR>
										<TD class="field">
											用 户 名：
										</TD>
										<TD>
											<INPUT class="text" type="text" name="name" id = "name" onblur ="checkname()">
											<div id = "myerror" style="display:inline;color:red;"></div>
										</TD>
									</TR>
									<TR>
										<TD class="field">
											密 码：
										</TD>
										<TD>
											<INPUT class="text" type="password" name="password" id = "password">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											确认密码：
										</TD>
										<TD>
											<INPUT class="text" type="password" name="repassword" id = "repassword">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											电 话：
										</TD>
										<TD>
											<INPUT class="text" type="text" name="telephone" id = "telephone" >
										</TD>
									</TR>
									<TR>
										<TD class="field">
											用户姓名：
										</TD>
										<TD>
											<INPUT class="text" type="text" name="username" id = "username">
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class="buttons">
								<INPUT onclick='return checknull();' value=立即注册
									type="submit">
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
	</BODY>
</html>
