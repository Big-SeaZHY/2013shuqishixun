<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-联系我们</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-ico"  />
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<style type="text/css">
		body{
			background-image:url(image/order.jpg);
			background-position:top right;
			background-repeat:no-repeat;
		}
	</style>
  </head>
  
  <body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
				<br> <br>
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="page/lianxiXueZhang.jsp">学长</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a>欢迎你，<%=name2 %></a></li>
									<li class="divider">-</li>
									<li><a href="home/home.jsp">主页</a></li>
									<li><a href="page/infomanager.jsp">个人信息</a></li>
									<li><a href="page/shoppingCart.jsp">购物车</a></li>
								</ul>
								<ul class="nav pull-right">
									<li><a>欢迎光临</a></li>
									<li><a href="page/lianxiXueZhang.jsp">联系学长</a></li>
									<li><a href="page/login.jsp" >切换账号</a>
								</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
		<div class="span3">
			<h3 class="muted">
				<img alt="" src="image/xuezhangw.png">
			</h3>
		</div>
		<div class="span4" align="center">
			<font face="华文行楷" size="5">
			<p class="text-center ">
			    <br><br><br><br><br>
				感谢您使用本软件*^o^*
			</p>
			<p class="text-center ">
				<br>出品人：3G移动电子商务2组
			</p>
			<p class="text-center ">
				<br>成员：马黎、张宇、张嘉树、<br>宿晨、陈通达
			</p>
			<p class="text-center ">
				<br>联系方式：15850680650
			</p>
		</font>
		</div>
		</div>
	</div>
</div>
		<div class="row-fluid">
		<div class="span12">
			<h3 class="text-center muted">
			<br><br>
				<img alt="" src="image/xiabiao.gif">
				<br><small>Copyright © 2002-2013  版权所有  3G移动互联电子商务系统第二小组   苏ICP证B2-20100204  [乙测资字32005078]</small>
			</h3>
		</div>
	</div>
	</body>
</html>
