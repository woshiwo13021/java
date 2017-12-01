<%@ page language="java" import="java.util.*,com.cn.dao.*,com.cn.entity.*" pageEncoding="utf-8"%>
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
		<title>购物车</title>
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
			<table id="tb">
				<tr>
					<td id="main"><input id="contr" type="checkbox" name="check"/>&nbsp;全选</td>
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品原价</td>
					<td>活动价钱</td>
					<td>最新评论</td>
					<td>商品数量</td>
					<td>合计价钱</td>
				</tr>
					<c:if test="${fn:length(cart.shoppingList)>0}">
					<c:forEach items="${cart.shoppingList}" var="commodity">
							<tr class="list">
							<td><input class="ctr" type="checkbox" name="check"/></td>
							<td class="cid">${commodity.id }</td>
							<td>${commodity.name }</td>
							<td>${commodity.oldPrice }</td>
							<td class="price">${commodity.newPrice }</td>
							<td>${commodity.description }</td>
							<td class="chNum">
								<input class="addNum" type="button" value="+"/>
								<input class="num" type="text" size="1" value="${commodity.num }"/>
								<input class="deleteNum" type="button" value="-"/>
							</td>
							<td class="money">${commodity.num*commodity.newPrice }</td>
							</tr>
					</c:forEach>
					<tr>
					<td><a href="index.jsp">继续添加</a></td>
					<td><a href="SubServlet">提交订单</a></td>
					<td><a href="ShoppingCartServlet?op=clear">清空购物车</a></td>
					<td colspan="4"><b>合计金额</b>:</td>
					<td id="total">0</td>
				</tr>	
				</c:if>
				<c:if test="${fn:length(cart.shoppingList)==0}">
					<tr>
						<td colspan="7"><b>购物车太空了，快去挑选商品吧</b></td>
						<td><a href="index.jsp">去购物</a></td>
					</tr>
				</c:if>
				
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
	<script type="text/javascript" src="js/cart.js"  charset="utf-8"></script>
	<script type="text/javascript" src="js/add.js"  charset="utf-8"></script>
</html>
