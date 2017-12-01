<%@ page language="java" import="java.util.*,com.cn.dao.impl.*,com.cn.entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人中心</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/center.css" />
	</head>
	<body>
		<div id="nav">
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<c:if test="${minfo!=null}">
				<li>欢迎您！<a href="percenter.jsp">${minfo}</a></li>
				<li><a href="pshoping.jsp">个人订单</a></li>
				<li><a href="ExitServlet">退出</a></li>
				</c:if>
				<c:if test="${minfo==null}">
					<li><a href="login.jsp">登录</a></li>
					<li><a href="register.jsp">注册</a></li>
				</c:if>
				<li><a href="shoppingcart.jsp">购物车</a></li>
				<li><a href="percenter.jsp">个人中心</a></li>
				
			</ul>
		</div>
		<div id="top">
			<h1>欢迎光临网上美食订餐系统-个人中心</h1>
		</div>
				<table>
				<c:if test="${member!=null}">
			<tr>
				<td>用户id:</td>
				<td>${member.v_id}</td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td>${member.v_name}</td>
			</tr>
			<tr>
				<td>电话:</td>
				<td>${member.v_phone}</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>${member.v_email}</td>
			</tr>
			<tr>
				<td>修改密码:</td>
				<td><a href="repass.jsp">修改</a></td>
			</tr>
			<tr>
				<td>个人订单:</td>
				<td><a href="PersonServlet?op=getallorder">查看</a></td>
			</tr>
			<tr>
				<td>收货地址:</td>
				<td><a href="PersonServlet?op=getalladdress">查看</a></td>
			</tr>
			<tr>
				<td>商品管理:</td>
				<td><a href="CommodityServlet?op=all">查看</a></td>
			</tr>
			</c:if>
		</table>
		<div id="footer">
			
		</div>
	</body>
</html>
