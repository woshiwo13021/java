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
		<title>商品管理</title>
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
				<td>商品原价</td>
				<td>活动价</td>
				<td>商品描述</td>
				<td>商品图片</td>
				<td>商品数量</td>
				<td><a href="addcommodity.jsp"><b>新增</b></a></td>
			</tr>
			<c:if test="${fn:length(list)>0 }">
				<c:forEach items="${list }" var="commodity">
				<tr>
				<td>${commodity.id }</td>
				<td>${commodity.name }</td>
				<td>${commodity.oldPrice }</td>
				<td>${commodity.newPrice }</td>
				<td>${commodity.description }</td>
				<td><img src="${commodity.imgURL }" width="60" height="auto"/></td>
				<td>${commodity.num }</td>
				<td>
					<a href="CommodityServlet?op=preupdate&commodityid=${commodity.id }">修改</a>
					<a href="CommodityServlet?op=delete&commodityid=${commodity.id }">删除</a>
				</td>
			</tr>
				</c:forEach>
			</c:if>
				<tr>
					<td colspan="7">
					<c:if test="${fn:length(list)==0 }">
					您的仓库空空的，赶快添加商品吧！！
					</c:if>
					</td>
					<td><a href="addcommodity.jsp"><b>新增</b></a></td>
				</tr>
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
