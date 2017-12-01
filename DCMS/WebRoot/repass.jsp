<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="http://localhost:8080/DCMS/">
		<meta charset="UTF-8">
		<title>个人中心</title>
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
			<h1>欢迎光临网上美食订餐系统</h1>
		</div>
		<form action="MemberServlet?op=repass" method="post">
			<table>
			<tr>
				<c:if test="${meg=='err' }">
				<td colspan = "2" style="text-align:center;color:red;">
					旧密码错误，请重新输入
				</td>	
				</c:if>
				<c:if test="${meg=='suc' }">
				<td colspan = "2" style="text-align:center;color:green;">
					恭喜您！密码修改成功
				</td>
				</c:if>
			</tr>
			<tr>
				<td>旧密码:</td>
				<td><input type="password" name="oupass"/></td>
			</tr>
			<tr>
				<td>新密码:</td>
				<td><input type="password" name="nupass"/></td>
			</tr>
			<tr>
				<td>密码确认:</td>
				<td><input type="password" name="renpass"/></td>
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
