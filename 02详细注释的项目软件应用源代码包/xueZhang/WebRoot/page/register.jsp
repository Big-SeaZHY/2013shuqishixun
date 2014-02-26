<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int flag;
%>
<%
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-注册</title>
    
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
	<script language="javascript" src="js/check.js"></script>

	<style type="text/css">
		body{
			background-image:url(image/zhuce2.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
		}
	</style>
  </head>
  
  <body font-famiy="华文行楷">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<br><br><br><br>
			<h3 class="muted text-center">
				<strong>学长网用户注册</strong>
			</h3>
			<form id="register" name="register" method="post" action = "servlet/RegisterSev">
			<table class="table-condensed table-hover" align="center">
				<tbody>
					<tr>
						<td> 
							<font face="华文行楷" size="4">用户名：</font> 
						</td>
						<td>
							<input type="text" name="user_name" onBlur="javascript:checkUser(register)"/>
						</td>
						<td>
						<div id="user_name1"> 
							<font color="#999999">*请输入用户名</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">密码：</font>
						</td>
						<td>
							<input type="password" name="password" onBlur="javascript:checkmima(register)"/>
						</td>
						<td>
						<div id="mima1">
							<font color="#999999">*请输入密码</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">确认密码：</font>
						</td>
						<td>
							<input type="password" name="qrpassword" onBlur="javascript:checkmima1(register)"/>
						</td>
						<td>
						<div id="querenmima1">
							<font color="#999999">*请确认密码</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">真实姓名：</font>
						</td>
						<td>
							<input type="text" name="realName" onBlur="javascript:checkRealname(register)"/>
						</td>
						<td>
						<div id="realName1">
							<font color="#999999">*请填写真实姓名</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">Email：</font>
						</td>
						<td>
							<input type="text" name="Email" onBlur="javascript:checkEmail(register)"/>
						</td>
						<td>
						<div id="Email1">
							<font color="#999999">请填写Email</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">男</font><input type="radio" name="Sex" value="male" onclick="javascript:checksex(register)"/>
						</td>
						<td>
							<font face="华文行楷" size="4">女</font><input type="radio" name="Sex" value="female" onclick="javascript:checksex(register)"/>
						</td>
						<td>
						<div id="sex1">
							<font color="#999999">请选择您的性别</font></div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							 <select name="year" id="year" onchange="checkdate(register)"> 
							 <option value="90" selected="selected">1990</option> 
							 <option value="91">1991</option> 
							 <option value="92">1992</option> 
							 <option value="93">1993</option> 
							 <option value="94">1994</option> 
							 <option value="95">1995</option> 
							 <option value="96">1996</option> 
							 <option value="97">1997</option> 
							 <option value="98">1998</option> 
							 <option value="99">1999</option>
							 </select> <select name="month" id="month" onchange="checkdate(register)">
							  <option value="1" selected="selected">1</option>
							  <option value="2">2</option> 
							  <option value="3">3</option>
							  <option value="4">4</option> 
							  <option value="5">5</option> 
							  <option value="6">6</option> 
							  <option value="7">7</option> 
							  <option value="8">8</option> 
							  <option value="9" >9</option> 
							  <option value="10">10</option> 
							  <option value="11">11</option> 
							  <option value="12">12</option>
							  </select> <select name="day" id="day" onchange="checkdate(register)"> 
							  <option value="1" selected="selected">1</option> 
							  <option value="2">2</option> 
							  <option value="3">3</option> 
							  <option value="4">4</option> 
							  <option value="5">5</option> 
							  <option value="6">6</option> 
							  <option value="7">7</option> 
							  <option value="8">8</option> 
							  <option value="9">9</option> 
							  <option value="10">10</option> 
							  <option value="11">11</option> 
							  <option value="12">12</option> 
							  <option value="13">13</option> 
							  <option value="14">14</option> 
							  <option value="15">15</option> 
							  <option value="16">16</option> 
							  <option value="17">17</option> 
							  <option value="18">18</option> 
							  <option value="19">19</option> 
							  <option value="20">20</option> 
							  <option value="21">21</option> 
							  <option value="22">22</option> 
							  <option value="23">23</option> 
							  <option value="24">24</option> 
							  <option value="25">25</option> 
							  <option value="26">26</option> 
							  <option value="27">27</option> 
							  <option value="28">28</option> 
							  <option value="29">29</option> 
							  <option value="30">30</option> 
							  <option value="31">31</option>
							  </select>
						</td>
						<td>
						<div id="date">
							<font color="#999999">请填写您的出生日期</font>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">手机号码：</font>
						</td>
						<td>
							<input type="text" name="phone" onBlur="javascript:checknumber(register)"/>
						</td>
						<td>
						<div id="number11">
							<font color="#999999">*请填写真实的联系方式</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">地址：</font>
						</td>
						<td>
							<input type="text" name="address" onBlur="javascript:checkaddress(register)"/>
						</td>
						<td>
						<div id="address1">
							<font color="#999999">请填写您的真实地址</font></div>
						</td>
					</tr>
					<tr>
						<td>
							<font face="华文行楷" size="4">身份证号：</font>
						</td>
						<td>
							<input type="text" name="id_card" onBlur="javascript:checkid(register)"/>
						</td>
						<td>
						<div id="id">
							<font color="#999999">请填写您的身份证号</font></div>
						</td>
					</tr>
					<tr>
							<td>
								<font face="华文行楷" size="4">验证码:</font>
							</td>
							<td colspan="2">
								<input name="identity" type="text" size="6" onBlur="javascript:checkIdentity(register)"/>
								<script>
								function reloadImage(){
									document.getElementById('btn').disabled = true;
									document.getElementById('identity').src='servlet/IdentitySev?ts='
									 + new Date().getTime();
								}
								</script>
								<img src="servlet/IdentitySev" id="identity" onload="btn.disabled = false;"/>
								<input type=button class="btn btn-link" value="换个图片" onclick="reloadImage()" id="btn">
							</td>
						</tr>
						<tr>
						<td colspan="2">
						<div id="Identity">
						<%if(request.getSession().getAttribute("flagIdentityR")!=null)
								{
								flag=(Integer)request.getSession().getAttribute("flagIdentityR");
								if(flag==0)
								{%>
									<font color=#FF0000>验证码输入错误！</font>
								<% }
								}
								%>
						</div>
						</td>
						</tr>
					<tr>
						<td colspan="3">
							 <button class="btn btn-info" type="submit">立即注册</button> <button class="btn btn-info" type="reset">重新填写</button>
						</td>
					</tr>
				</tbody>
			</table>
			</form>
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
