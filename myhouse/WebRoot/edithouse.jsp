<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改房屋信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type = "text/javascript" src= "js/public.js"></script>
	</head>
	<body>
		<DIV id="header" class="wrap">
			<DIV id="logo"> 
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id="regLogin" class="wrap">
			<DIV class="dialog">
				<DL class="clearfix">
					<DD class="past">
						修改房屋信息
					</DD>
				</DL>

				<DIV class="box">
					<FORM id="add_action" method="post" name="edithouse"
						action="ListServlet?op=edit">
						<DIV class="infos">
							<TABLE class="field">
								<TBODY>
									<TR>
										<TD class="field">
											标 题：
										</TD>
										<TD>
											<input type = "hidden" name = "id" />
											<INPUT id="add_title" class="text" type="text" name="title" value = "${requestScope.result.title }">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											户 型：
										</TD>
										<TD>
										
											<SELECT class="text" name="type_id">
											<c:forEach items="${requestScope.htlist}" var = "ht"  >
												<OPTION  value=${ht.id }
												<c:if test="${ht.id==requestScope.result.housetype}">
												selected ="selected" 
												</c:if>
				>				
													${ht.name }
												</OPTION>
											</c:forEach>
											</SELECT>
										</TD>
									</TR>
									<TR>
										<TD class="field">
											面 积：
										</TD>
										<TD>
											<INPUT id="add_floorage" class="text" type="text"
												name="floorage" value = "${requestScope.result.floorage }">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											价 格：
										</TD>
										<TD>
											<INPUT id="add_price" class="text" type="text" name="price" value = "${requestScope.result.price }">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											房产证日期：
										</TD>
										<TD>
											<INPUT class="text" type="text" name="houseDate" id = "add_housedate" value = "${requestScope.result.housedate }">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											位 置：
										</TD>
										<TD>
											区：
											<SELECT class="text" name="district_id" >
												<c:forEach items="${requestScope.dislist}" var = "dis">
												<OPTION  value=${dis.id } 
												<c:if test="${dis.id==requestScope.result.district_id}">
												selected ="selected"
												</c:if>
												>
													${dis.name }
												</OPTION>
											</c:forEach>
											
											</SELECT>
											街：
											<SELECT class="text" name="street_id">
											<c:forEach items="${requestScope.strlist}" var = "str">
											
												<OPTION  value=${str.id } 
												<c:if test="${str.id==requestScope.result.street_id}">
												selected ="selected"
												</c:if>
												>
													${str.name }
												</OPTION>
											
											</c:forEach>
												
											</SELECT>
										</TD>
									</TR>
									<TR>
										<TD class="field">
											联系方式：
										</TD>
										<TD>
											<INPUT id="add_contact" class="text" type="text"
												name="contact" value = "${requestScope.result.contact }">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name="description" id = "add_description" >${requestScope.result.content }</TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class="buttons">
								<INPUT onclick='return checknull();' value=提交
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
	</body>
</html>
