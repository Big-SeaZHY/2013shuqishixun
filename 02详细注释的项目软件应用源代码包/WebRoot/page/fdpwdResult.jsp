<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fdpwdResult.jsp' starting page</title>
    
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
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<script src="js/jQuery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
  </head>
  
  <body>
   <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3>
				<img src="image/password.ico"><font face="华文彩云" size="7" color="#80ff00">找回密码：</font> 
			</h3>
			<h3 align="center">
			<%if(request.getSession().getAttribute("fdpassword")==null) {%>
				<img src="image/08.ico"><font size="6" color="#ff0000" face="楷体">找回密码失败，可能的原因：</font>
				<br><font class="muted" size="6">您输入的用户名或手机号码错误！</font>
				<%}else{ %>
				<img src="image/07.ico"><font size="6" color="#ff0000" face="楷体">找回密码成功，您的密码是：</font>
			</h3>
			<h3 align="center"><font class="muted" size="7">
				<%=request.getSession().getAttribute("fdpassword")%>
				<%} %>
			</font>
			<br><br>
			<button class="btn btn-inverse" onclick=window.open("page/login.jsp","_self") type="button">返回</button>
			</h3>
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
