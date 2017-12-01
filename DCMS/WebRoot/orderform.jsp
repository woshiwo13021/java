<%@ page language="java" import="java.util.*,com.cn.dao.*,com.cn.entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单信息</title>
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
				<c:if test="${orderForm!=null}">
					<td>${orderForm.o_id}</td>
					<td>${orderForm.o_name}</td>
					<td>${orderForm.o_address}</td>
					<td>${orderForm.o_phone}</td>
					<td>${orderForm.o_mode}</td>
					<td>${orderForm.o_pay}</td>
					<td>${orderForm.o_remarks}</td>
					<td>${orderForm.o_money}</td>
					<td>${orderForm.o_status}</td>
					<td><a href="PersonServlet?op=getallorder">查看所有订单</a></td>
				</c:if>
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
	<script type="text/javascript" src="js/cart.js"  charset="utf-8"></script>
	<script type="text/javascript" src="js/add.js"  charset="utf-8"></script>
</html>
