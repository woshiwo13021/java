<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增送餐地址</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/repass.css" />
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
			<h1>欢迎光临网上美食订餐系统-新增送餐地址</h1>
		</div>
		<form action="#" method="post">
			<table>
			<tr>
				<td>编号:</td>
				<td><input type="number" name="oupass"/></td>
			</tr>
			<tr>
				<td>联系人:</td>
				<td><input type="text" name="nupass"/></td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td><input type="text" name="renpass"/></td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><textarea name="" rows="" cols=""></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" id="submit" value="确认修改"/>
				</td>
			</tr>
		</table>
		</form>
		<div id="footer">
			
		</div>
	</body>
</html>
