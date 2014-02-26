<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-购物失败</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-ico"  />
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/buttons.css">
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
	<script src="js/jQuery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<style type="text/css">
	body {padding-top: 4cm}
</style>
	<style type="text/css">
		body{
			background-image:url(image/shuimo1.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
			background-color:#efeff0
		}
	</style>
  </head>
  
  <body>
    <div class="container-fluid">
	<div class="row-fluid">
		<div class="span5" align="right">
			<img alt="140x90" src="image/09.jpg" />
		</div>
		<div class="span7">
			<h1 class="muted">
				<img src="image/08.ico" />
				<strong>很抱歉，购物失败！</strong>
			</h1>
			<h2 class="text-error">
				<strong>可能的问题：</strong>
			</h2>
			<p class="muted lead">
				<span><em>您的余额不够！或者货存不足！</em></span>
			</p> <button class="btn btn-primary btn-large" onclick=window.open("page/infomanager.jsp","_self") type="button">立即充值</button>
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