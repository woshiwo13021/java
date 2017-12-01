<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="UTF-8"/>
<title>登录</title>
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/style.css">
<body>

<div class="login-container">
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
	<h1>欢迎来到网上美食商城</h1>
	
	<div class="connect">
		<p>吃好喝好，身体好</p>
	</div>
	
	<form action="LoginServlet" method="post" id="loginForm">
		<div>
			<c:if test="${meg=='err' }">
			<p class="error">账号或密码错误</p>
			<c:remove var="meg"/>
			</c:if>
			<c:if test="${meg=='suc' }">
			<p class="suc">注册成功，请登录</p>
			<c:remove var="meg"/>
			</c:if>
			<input type="text" name="uname" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="upass" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">登 陆</button>
	</form>

	<a href="register.html">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>