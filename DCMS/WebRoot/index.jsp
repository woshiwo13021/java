<%@ page language="java" import="java.util.*,com.cn.biz.*,com.cn.biz.impl.*,com.cn.entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>商品列表</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/index.css" />
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
			<c:if test="${commodityList!=null}">
			<c:forEach items="${commodityList}" var="commodity">
					<div class="comlist">
						<img src="${commodity.imgURL}" alt=""  width="210px" height="auto"/>
						<h2 class="cname">${commodity.name}</h2>
						<p>商品编号:<b class="cno">${commodity.id}</b></p>
						<p>原价:￥<del class="oprice">${commodity.oldPrice}</del></p>
						<p>活动价:￥<b class="cprice">${commodity.newPrice}</b>元</p>
						<p>评论:<b class="pl">${commodity.description}</b></p>
						<a href="CommodityServlet?commodityid=${commodity.id}&op=showone">查看详情</a>
						<a class="add" href="">加入购物车</a>
					</div>
			</c:forEach>
			</c:if>
		</div>
		<div id="footer">
			
		</div>
	</body>
	<script src="js/add.js" type="text/javascript" charset="utf-8"></script>
</html>
