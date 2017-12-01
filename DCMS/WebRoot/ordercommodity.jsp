<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单商品详情</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/cart.css" />
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
		<div class="box">
			<table>
			<tr>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品价钱</td>
				<td>商品描述</td>
				<td>商品图片</td>
			</tr>
			<c:if test="${fn:length(ordercommoditylist)>0 }">
				<c:forEach items="${ordercommoditylist }" var="commodity">
				<tr>
				<td>${commodity.f_id }</td>
				<td>${commodity.f_name }</td>
				<td>${commodity.f_num }</td>
				<td>${commodity.f_price }</td>
				<td>${commodity.f_description }</td>
				<td><img src="${commodity.f_img }" width="60" height="auto"/></td>
			</tr>
				</c:forEach>
			</c:if>
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
