<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-cn" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<title>学长网-找回密码</title>
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/buttons.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-ico"  />
	<script src="js/jQuery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
		<style type="text/css">
		body{
			background-image:url(../image/shanshui.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
			background-color:#f4f4f2
		}
	</style>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form name="form1" id="form1" method="post">
				<fieldset>
					<legend><strong><font face="华文行楷" size="6">找回密码</font></strong></legend>
					<p>
						<font face="华文行楷" size="5">用户名：</font>
					</p>
					<p>
						<input type="text" name="user"/>
					</p>
					<p>
						<font face="华文行楷" size="5">手机号码：</font>
					</p>
					<p>
						<input type="text" name="phone"/>
					</p> 
					<span class="help-block">（请正确输入您的手机号码，如果没有手机号码保存则无法找回密码）</span>
					<button class="btn btn-info" onClick="document.form1.action='../servlet/FindPwdSev'" type="submit"><font face="微软雅黑" size="4">确认</font></button>
					</fieldset>
					</form>
				</div>
			</div>
		</div>
				<div class="row-fluid">
	</div>
</body>
</html>