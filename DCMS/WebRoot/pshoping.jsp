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
		<title>个人订单</title>
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
					<td>订单编号</td>
					<td>订餐人</td>
					<td>送餐地址</td>
					<td>联系电话</td>
					<td>配送方式</td>
					<td>支付方式</td>
					<td>留言</td>
					<td>总金额</td>
					<td>订单状态</td>
					<td></td>
				</tr>
				<c:if test="${fn:length(orderList)>0}">
				<c:forEach items="${orderList }" var="orderForm">
				<tr>
					<td>${orderForm.o_id}</td>
					<td>${orderForm.o_name}</td>
					<td>${orderForm.o_address}</td>
					<td>${orderForm.o_phone}</td>
					<td>${orderForm.o_mode}</td>
					<td>${orderForm.o_pay}</td>
					<td>${orderForm.o_remarks}</td>
					<td>${orderForm.o_money}</td>
					<td>${orderForm.o_status}</td>
					<td>
					<a href="PersonServlet?op=deleteorder&orderid=${orderForm.o_id }">删除订单</a><br/>
					<a href="OrderCommodityServlet?orderid=${orderForm.o_id}">查看订单商品</a>
					</td>
				</tr>	
				</c:forEach>
				</c:if>
				<c:if test="${fn:length(orderList)==0}">
					<tr>
						<td colspan="9">还没有订单，快去下单吧</td>
						<td><a href="index.jsp">去购物</a></td>
					</tr>
				</c:if>
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
