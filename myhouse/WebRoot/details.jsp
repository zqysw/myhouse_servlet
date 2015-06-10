<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.myhouse.service.HouseInfoService"%>
<%@page import="com.myhouse.entity.HouseInfo"%>
<%@page import="com.myhouse.entity.HouseType"%>

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

		<title>具体介绍</title>

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
			<DIV class="search">
				<FORM method="get">
					<INPUT class="text" type="text" name="keywords">
					<LABEL class="ui-green searchs">
						<a href="list.htm" target="_blank">搜索房屋</a>
					</LABEL>
				</FORM>
			</DIV>
		</DIV>
		<DIV id="navbar" class="wrap">
			<DL class="search clearfix">
				<FORM id="sform" method="post" action="search.action">
					<DT>
						<UL>
							<LI class="bold">
								房屋信息
							</LI>
							<LI>
								标题：
								<INPUT class="text" type="text" name="title">
								<LABEL class="ui-blue">
									<INPUT value="搜索房屋" type="button"
										name="search">
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
								<SELECT id="price" name="price">
									<OPTION selected value="">
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
									<OPTION selected value="">
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
								<SELECT id="housetype" name="type_id">
									<OPTION selected value="">
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
								<SELECT id="floorage" name="floorage">
									<OPTION selected value="">
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
				</FORM>
			</DL>
		</DIV>
		<DIV id="position" class="wrap">
			当前位置：找房网 - 浏览房源
		</DIV>
		<DIV id="view" class="main wrap">
			<DIV class="intro">
				<DIV class="lefter">
					<H1>
						${requestScope.house.title}
					</H1>
					<DIV class="subinfo">
						${requestScope.house.housedate}
					</DIV>
					<DIV class="houseinfo">
						<P>
							户 型：
							<SPAN>${requestScope.housetype}</SPAN>
						</P>
						<P>
							面 积：
							<SPAN>${requestScope.house.floorage}<SUP>
								</SUP>
							</SPAN>
						</P>
						<P>
							位 置：
							<SPAN>${requestScope.district}区${requestScope.street}</SPAN>
						</P>
						<P>
							联系方式：
							<SPAN>${requestScope.house.contact}</SPAN>
						</P>
					</DIV>
				</DIV>
				<DIV class="side">
					<P>
						<A class="bold" href="http://localhost:8080/House-2/#">北京找房网地产经纪公司</A>
					</P>
					<P>
						资质证书：有
					</P>
					<P>
						内部编号:1000
					</P>
					<P>
						联 系 人：
					</P>
					<P>
						联系电话：
						<SPAN></SPAN>
					</P>
					<P>
						手机号码：
						<SPAN>暂无</SPAN>
					</P>
				</DIV>
				<DIV class="clear"></DIV>
				<DIV class="introduction">
					<H2>
						<SPAN><STRONG>房源详细信息</STRONG>
						</SPAN>
					</H2>
					<DIV class="content">
						<P>
							${requestScope.house.content}
						</P>
					</DIV>
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
