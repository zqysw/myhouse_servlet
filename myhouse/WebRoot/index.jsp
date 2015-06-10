<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
<%@page import="com.myhouse.entity.HouseType"%>
<%@page import="com.myhouse.myhouseUtils.Datechange"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>

	<body>

		<DIV id="header" class="wrap">
			<DIV id="logo">
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id="navbar" class="wrap">
			<DL class="search clearfix">

				<form id="sform" method="get" action="IndexServlet?op=search">
					<DT>
						<UL>
							<LI class="bold">
								房屋信息
							</LI>
							<LI>
								标题：
								<input type = "hidden" name = "op" value = "search"/>
								<INPUT class="text" type="text" name="title" value= "${requestScope.title }">
								<LABEL class="ui-blue">
										<INPUT  value="搜索房屋" type="submit" name="search">
								</LABEL>
							</LI>
						</UL>
					</DT>
					<DD>
						<UL>
							<LI class="first">
								价格
							</LI>
							<LI>
								<SELECT name="price">
									<OPTION selected value ="">
										不限
									</OPTION>
									<OPTION value="0-100">
										100元以下
									</OPTION>
									<OPTION value="100-200">
										100元—200元
									</OPTION>
									<OPTION value="200-1000000">
										200元以上
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class="first">
								房屋位置
							</LI>
							<LI>
								<SELECT id="street" name="street_id">
									<OPTION selected value ="">
										不限
									</OPTION>
									<OPTION value="1000">
										知春路
									</OPTION>
									<OPTION value="1001">
										中关村大街
									</OPTION>
									<OPTION value="1002">
										学院路
									</OPTION>
									<OPTION value="1003">
										朝阳路
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class="first">
								房型
							</LI>
							<LI>
								<SELECT name="type_id">
									<OPTION selected value ="">
										不限
									</OPTION>
									<OPTION value="1000">
										一室一厅
									</OPTION>
									<OPTION value="1001">
										一室两厅
									</OPTION>
									<OPTION value="1002">
										两室一厅
									</OPTION>
									<OPTION value="1003">
										两室两厅
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class="first">
								面积
							</LI>
							<LI>
								<SELECT name="floorage">
									<OPTION selected value ="">
										不限
									</OPTION>
									<OPTION value="0-40">
										40以下
									</OPTION>
									<OPTION value="40-500">
										40-500
									</OPTION>
									<OPTION value="500-1000000">
										500以上
									</OPTION>
								</SELECT>
							</LI>
						</UL>
					</DD>
				</form>
			</DL>
		</DIV>
		<DIV class="main wrap">
			<TABLE class="house-list">
				<TBODY>
				<c:if test="${requestScope.result!=null}">
				<c:forEach items="${requestScope.result}" var="house">
					<TR>
						<TD class="house-thumb">
							<span><A href="IndexServlet?op=detail&id=${house.id }" target="_blank"><img
										src="images/thumb_house.gif" width="100" height="75" alt="">
							</a>
							</span>
						</TD>
					
						<TD>
							<DL>
								<DT>
						
									<A href="IndexServlet?op=detail&id=${house.id }" target="_blank">${house.title }</A>
								</DT>
								
								<DD>${requestScope.district }区${requestScope.street },${house.floorage }㎡<BR>
									联系方式：${house.contact }
								</DD>
							</DL>
						</TD>
						<TD class="house-type">${requestScope.type }</TD>
						<TD class="house-price">
							<SPAN>${house.price }</SPAN>元/月
						</TD>
					</TR>
					</c:forEach>
					</c:if>
				</TBODY>
			</TABLE>
			<DIV class="pager">
				<UL>
				<c:if test="${requestScope.pagecount==0}">
					${requestScope.message };
				</c:if>
				<c:if test = "${requestScope.pageindex>1}">
				<LI class="current">
						<A href="IndexServlet?page=1&title=${requestScope.title }&price=${requestScope.price }&type_id=${requestScope.type_id }&street_id=${requestScope.street_id }&floorage=${requestScope.floorage }&op=search">首页</A>
					</LI>
					<LI>
						<A href="IndexServlet?page=${requestScope.pageindex-1}&title=${requestScope.title}&price=${requestScope.price}&type_id=${requestScope.type_id }&street_id=${requestScope.street_id }&floorage=${requestScope.floorage }&op=search">上一页</A>
					</LI>
				</c:if>
					<c:if test="${requestScope.pageindex<requestScope.pagecount}">
					<LI>
						<A href="IndexServlet?page=${requestScope.pageindex+1}&title=${requestScope.title }&price=${requestScope.price }&type_id=${requestScope.type_id }&street_id=${requestScope.street_id }&floorage=${requestScope.floorage }&op=search">下一页</A>
					</LI>
					<LI>
						<A href="IndexServlet?page=${requestScope.pagecount}&title=${requestScope.title }&price=${requestScope.price }&type_id=${requestScope.type_id }&street_id=${requestScope.street_id }&floorage=${requestScope.floorage }&op=search">末页</A>
					</LI>

					
					</c:if>
				</UL>
				<SPAN class="total">${requestScope.pageindex}/${requestScope.pagecount}</SPAN>
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
