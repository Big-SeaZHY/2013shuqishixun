<%@ page language="java" import="java.util.*" import="com.seu.xueZhang.entity.Thu_img" import="com.seu.xueZhang.entity.Book" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page  import="com.seu.xueZhang.dao.IBookShowDao"%>
<%@ page  import="com.seu.xueZhang.dao.impl.IBookShowDaoImpl"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%@ page import = "java.text.DecimalFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>
<%DecimalFormat df = new DecimalFormat("#.00"); 
double b=c.getBalance();
double balance =Double.parseDouble(df.format(b));
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-购物成功</title>
    
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
			padding-top: 4cm;
			background-image:url(image/shuimo1.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
			background-color:#efeff0
		}
	</style>
  </head>
  
  <body >
	<div class="row-fluid">
		<div class="span12">
				<br> <br>
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="#">学长</a>
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
									<li><a href="page/login.jsp" >退出登陆</a>
								</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
    <div class="container-fluid">
	<div class="row-fluid">
		<div class="span5" align="right">
			<img alt="140x140" src="image/06.gif" />
		</div>
		<div class="span7">
			<h1 class="text-success">
				<img src="image/07.ico" />
				<strong>恭喜您，购物成功！！</strong>
			</h1>
			<h2 class="text-error">
				您的余额为：<br>￥<b><font face="Adobe 黑体 Std R" color="#ff6600" size="6"><%=balance%></font></b>
			</h2>
			<button class="btn btn-success" onclick=window.open("home/home.jsp","_self") type="button">继续购物</button>
			<button class="btn btn-info" onclick=window.open("page/infomanager.jsp","_self") type="button">查看已购商品</button>
			<button class="btn btn-danger" onclick=window.open("page/comment.jsp","_self") type="button">点击评论</button>
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
