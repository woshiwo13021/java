<%@ page language="java" import="java.util.*,com.cn.dao.*,com.cn.entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>新增商品</title>
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/addCommodity.css" />
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
			<form action="CommodityServlet?op=add" method="post">
				<table>
				<tr>
					<td>商品名称</td>
					<td>
						<input type="text" name="c_name"/>
					</td>
				</tr>
				<tr>
					<td>商品原价</td>
					<td>
						<input type="text" name="c_o_price"/>
					</td>
				</tr>
				<tr>
					<td>活动价</td>
					<td>
						<input type="text" name="c_n_price"/>
					</td>
				</tr>
				<tr>
					<td>图片路径</td>
					<td>
						<input type="text" name="c_img"/>
					</td>
				</tr>
				<tr>
					<td>商品描述</td>
					<td>
						<input type="text" name="c_des"/>
					</td>
				</tr>
				<tr>
					<td>商品数量</td>
					<td>
						<input type="text" name="c_num"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input id="smit" type="submit" value="新增"/></td>
				</tr>
			</table>
			</form>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
