<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>商品详情</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/details.css" />
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
			<h1>欢迎光临网上美食订餐系统</h1>
		</div>
		<div id="box">
		<c:if test="${commodity!=null }">
			<div class="commd">
				<img src="${commodity.imgURL }" alt="" width="800px" height= auto/>
			</div>
			<p>商品编号:${commodity.id }</p>
			<p>商品名称:${commodity.name }</p>
			<p>商品原价:${commodity.oldPrice }</p>
			<p>活动价:${commodity.newPrice }</p>
			<p>商品数量:${commodity.num }</p>
			<p>商品描述:${commodity.description }</p>
		</c:if>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
