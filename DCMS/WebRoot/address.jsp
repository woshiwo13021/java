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
		<title>收货地址</title>
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
				<td>编号</td>
				<td>联系人</td>
				<td>联系电话</td>
				<td>详细地址</td>
				<td></td>
			</tr>
			<c:if test="${fn:length(addressList)>0 }">
				<c:forEach items="${addressList }" var="address">
				<tr>
					<td>${address.a_id }</td>
					<td>${address.v_name }</td>
					<td>${address.a_phone }</td>
					<td>${address.a_address }</td>
					<td>
					<a href="AddressServlet?op=preupdate&addressid=${address.a_id }">修改</a>
					<a href="AddressServlet?op=delete&addressid=${address.a_id }">删除</a>
					<a href="AddressServlet?op=choice&addressid=${address.a_id }">选择</a>
					<c:if test="${address.a_isdefault==0 }">
						<a href="AddressServlet?op=setadd&addressid=${address.a_id }">设为默认</a>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</c:if>
				<tr>
					<td colspan="4">
					<c:if test="${fn:length(addressList)==0 }">
					还没有设置收货地址
					</c:if>
					</td>
					<td><a href="addaddress.jsp"><b>新增</b></a></td>
				</tr>
			</table>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
