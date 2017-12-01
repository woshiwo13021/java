<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<base href="http://localhost:8080/DCMS/">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8"/>
<title>注册</title>
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/style.css">
<body>

<div class="register-container">
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
	<h1>欢迎来到网上美食订购商城</h1>
	<div class="connect">
		<p>好吃不贵，天天实惠</p>
		<c:if test="${meg=='err' }">
			<p class="error">用户名重复，请重新注册</p>
			<c:remove var="meg"/>
			</c:if>
	</div>
	
	<form action="RegServlet" method="post" id="registerForm">
		<div>
			<input type="text" name="uname" class="username" placeholder="您的用户名"/>
		</div>
		<div>
			<input type="password" name="upass" class="password" placeholder="输入密码"/>
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" />
		</div>
		<div>
			<input type="text" name="uphone" class="phone_number" placeholder="输入手机号码" id="number"/>
		</div>
		<div>
			<input type="email" name="uemail" class="email" placeholder="输入邮箱地址"  />
		</div>
		<button id="submit" type="submit">注 册</button> 
		
	</form>
	<a href="index.html">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>

</body>
<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js"></script>
</html>