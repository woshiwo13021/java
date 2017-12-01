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
		<title>订单页面</title>
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
			<h2>确认订单信息</h2>
			<h2>配送地址:</h2>
			<table id="tb">
				<tr>
					<td>配送地址编号</td>
					<td>联系人</td>
					<td>配送地址</td>
					<td>联系电话</td>
					<td>
					<c:if test="${meg=='addmiss' }">
						<b class="error">请选择收货地址</b>
					</c:if>
					</td>
				</tr>
				<c:if test="${address==null }">
					<td colspan="4">没有默认收货地址，赶快去设置吧！！！</td>
					<td><a href="address.jsp">去设置</a></td>
				</c:if>
				<c:if test="${address!=null }">
				<tr>
					<td>${address.a_id }</td>
					<td>${address.v_name }</td>
					<td>${address.a_address }</td>
					<td>${address.a_phone }</td>
					<td>
						<a href="address.jsp">重新选择</a>
					</td>
				</tr>
				</c:if>
				
			</table>
			<form action="OrderFormServlet" method="post">
			配送方式:<input type="text" name="mode"/><br/><br/>
			支付方式:<input type="text" name="pay"/><br/><br/>
			留言方式:<input type="text" name="remarks"/><br/><br/>
			订单状态:<input type="text" name="status"/><br/><br/>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  <input class="btn" type="submit" value="提交"/><br/><br/>
			</form>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
