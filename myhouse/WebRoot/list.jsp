<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
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

		<title>用户管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript">
		function del(){
		return	confirm("是否确定要删除？");
		}
		</script>

	</head>

	<body>
		<DIV id="header" class="wrap">
			<DIV id="logo">
				<IMG src="images/logo.gif">
			</DIV>
			<DIV class="search">
				<LABEL class="ui-green searchs">
					<a href="PublicServlet" title="">发布房屋信息</a>
				</LABEL>
				<LABEL class="ui-green searchs">
					<a href="logout.jsp">退出</a>
				</LABEL>
			</DIV>
		</DIV>
		<DIV class="main wrap">
		<div class ="like">
			<h1>猜你喜欢<h1><br>
			<ul>
			<c:forEach items="${requestScope.cookie}" var = "cook">
			<li>${cook }<br></li>
			</c:forEach>
			</ul>
			
		</div>
			<DIV id="houseArea">
				<TABLE class="house-list">
					<TBODY>
					<c:forEach items="${requestScope.houselist}" var="house">
					 <TR>
							<TD class="house-thumb">
								<SPAN><A href="IndexServlet?op=detail&id=${house.id }" target="_blank"><img
											src="images/thumb_house.gif" width="100" height="75" alt="">
								</A> </SPAN>
							</TD>
							<TD>
								<DL>
									<DT>
										<A href="IndexServlet?op=detail&id=${house.id }" target="_blank">${house.title}</A>
									</DT>
									<DD>
										${requestScope.district }区${requestScope.street },${house.floorage}㎡
										<BR>
										联系方式：${house.contact}
									</DD>
								</DL>
							</TD>
							<TD class="house-type">
								
									<a href = "ListServlet?op=editprepare&id=${house.id }" >修改</a>
							
							</TD>
							<TD class="house-price">
							
									<a href = "ListServlet?op=del&id=${house.id }" onclick = "return del();">删除</a>
							
							</TD>
						</TR>
	
				</c:forEach>		
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
		<DIV class="pager">
				<UL>
				<c:if test = "${requestScope.pageindex>1}">
				<LI class="current">
						<A href="ListServlet?op=list&page=1">首页</A>
					</LI>
					<LI>
						<A href="ListServlet?op=list&page=${requestScope.pageindex-1 }">上一页</A>
					</LI>
				</c:if>
					<c:if test="${requestScope.pageindex<requestScope.pagecount}">
					
					<LI>
						<A href="ListServlet?op=list&page=${requestScope.pageindex+1 }">下一页</A>
					</LI>
					<LI>
						<A href="ListServlet?op=list&page=${requestScope.pagecount }">末页</A>
					</LI>

					</c:if>
					
				</UL>
				<SPAN class="total">${requestScope.pageindex }/${requestScope.pagecount }</SPAN>
			</DIV>
		<DIV id=footer class=wrap>
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
