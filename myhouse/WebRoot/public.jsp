<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseTypeService"%>
<%@page import="com.myhouse.entity.HouseType"%>
<%@page import="com.myhouse.service.DistrictService"%>
<%@page import="com.myhouse.service.StreetService"%>
<%@page import="com.myhouse.entity.Street"%>
<%@page import="com.myhouse.entity.District"%>
<%@ include file="checkLogin.jsp"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>发布房屋信息</title>

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
			<DIV id="logo">&nbsp;  
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id="regLogin" class="wrap">
			<DIV class="dialog">
				<DL class="clearfix">
					<DT>
						新房屋信息发布
					</DT>
					<DD class="past">
						填写房屋信息
					</DD>
				</DL>
				<DIV class="box">
					<FORM id="add_action" method="post" name="addhouse"
						action="PublicServlet" enctype = "multipart/form-data">
						<DIV class="infos">
							<TABLE class="field">
								<TBODY>
									<TR>
										<TD class="field">
											标 题：
										</TD>
										<TD>
											<INPUT id="add_title" class="text" type="text" name="title">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											户 型：
										</TD>
										<TD>
											<SELECT class="text" name="type_id">
											<c:forEach items="${requestScope.type}" var="t">
											<OPTION selected value=${t.id}>
													${t.name}
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
												name="floorage">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											价 格：
										</TD>
										<TD>
											<INPUT id="add_price" class="text" type="text" name="price">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											房产证日期：
										</TD>
										<TD>
											<INPUT class="text" type="text" name="houseDate" id = "add_housedate">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											位 置：
										</TD>
										
										<TD>
											区：
											
											<SELECT class="text" name="district_id">
											<c:forEach items="${requestScope.district}" var = "dis">
										
											<OPTION selected value=${dis.id}>
													${dis.name} 
												</OPTION>
											</c:forEach>
											</SELECT>
											街：
											<SELECT class="text" name="street_id">
											<c:forEach items="${requestScope.street}" var="str">
											<OPTION selected value=${str.id}>
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
												name="contact">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											上传图片：
										</TD>
										<TD>
											<INPUT id="picfile" class="text" type="file"
												name="picfile">
										</TD>
									</TR>
									<TR>
										<TD class="field">
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name="description" id = "add_description"></TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class="buttons">
								<INPUT onclick='return checknull();' value=立即发布
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
