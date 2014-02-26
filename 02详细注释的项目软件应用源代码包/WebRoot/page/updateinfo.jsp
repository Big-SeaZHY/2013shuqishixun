<%@ page language="java" import="java.util.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
int flag;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-cn" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="shortcut icon" href="../image/favicon.ico" type="image/x-ico"  />
	<style type="text/css">
		body{
			background-image:url(../image/xiugai.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
		}
	</style>
<title>学长网-修改个人信息</title>
</head>
<body>
     <script src="../js/jQuery.js"></script>
<script src="../js/bootstrap.js"></script>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
				<br> <br>
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="updateinfo.jsp">学长</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a>欢迎你，<%=name2 %></a></li>
									<li class="divider">-</li>
									<li><a href="../home/home.jsp">主页</a></li>
									<li><a href="infomanager.jsp">个人信息</a></li>
									<li><a href="shoppingCart.jsp">购物车</a></li>
								</ul>
								<ul class="nav pull-right">
									<li><a>欢迎光临</a></li>
									<li><a href="lianxiXueZhang.jsp">联系学长</a></li>
									<li><a href="login.jsp" >切换账号</a>
								</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			<form method = "post"action="../servlet/ModifySelfInfoSev">
			<h3 class="muted">
				<img alt="" src="../image/xuezhangw.png">
			</h3>
				<fieldset>
					 <legend><font face="华文行楷" size="6">修改个人信息</font></legend> <label><font face="华文行楷" size="5">用户名：</font> </label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="text" name = "username"/>
								</td>
								<td>
									<span class="help-block">修改用户名.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">密码：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="password" name = "password"/>
								</td>
								<td>
									<span class="help-block">请输入密码.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">重复密码：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="password" name = "password2"/>
								</td>
								<td>
									<span class="help-block">请再次输入密码.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">姓名：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="text" name = "name"/>
								</td>
								<td>
									<span class="help-block">请输入姓名.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">生日：</font></label>
					<table>
						<tbody>
							<tr>
								<td colspan="2">
							 <select name="year" id="year"> 
							 <option value="90"selected="selected">1990</option> 
							 <option value="91">1991</option> 
							 <option value="92">1992</option> 
							 <option value="93">1993</option> 
							 <option value="94">1994</option> 
							 <option value="95">1995</option> 
							 <option value="96">1996</option> 
							 <option value="97">1997</option> 
							 <option value="98">1998</option> 
							 <option value="99">1999</option></select> 
							 <select name="month" id="month"> 
							 <option value="1" selected="selected" >1</option> 
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
							 <option value="12">12</option></select> 
							 <select name="day" id="day"> 
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
							 <option value="31">31</option></select>
							</td>
							<td>
								<span class="help-block">请填写您的出生日期</span>
							</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">手机号码：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="text" name = "phone"/>
								</td>
								<td>
									<span class="help-block">请输入手机号码，手机号码是取回密码的重要凭证.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">邮箱：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="text" name = "email"/>
								</td>
								<td>
									<span class="help-block">请输入您的邮箱地址.</span>
								</td>
							</tr>
						</tbody>
					</table> <label><font face="华文行楷" size="5">身份证号码：</font></label>
					<table>
						<tbody>
							<tr>
								<td>
									<input type="text" name ="idcard"/>
								</td>
								<td>
									<span class="help-block">请输入您的身份证号码.</span>
								</td>
							</tr>
						</tbody>
					</table>
					 	<tr>
							<td>
								<label><font face="华文行楷" size="5">验证码:</font></label>
							</td>
							<td colspan="2">
								<input name="identity" type="text" size="6" onBlur="javascript:checkIdentity(register)"/>
								<script>
								function reloadImage(){
									document.getElementById('btn').disabled = true;
									document.getElementById('identity').src='../servlet/IdentitySev?ts='
									 + new Date().getTime();
								}
								</script>
								<img src="../servlet/IdentitySev" id="identity" onload="btn.disabled = false;"/>
								<input type=button class="btn btn-link" value="换个图片" onclick="reloadImage()" id="btn">
							</td>
						</tr>
						<tr>
						<td>
						<div id="Identity">
						<%if(request.getSession().getAttribute("flagIdentity")!=null)
								{
								flag=(Integer)request.getSession().getAttribute("flagIdentity");
								if(flag==0)
								{%>
									<font color=#FF0000>验证码输入错误,请重新输入！</font>
								<% }
								}
								%>
						</div>
						</td>
						</tr>
					<button type="submit" class="btn"><font face="华文行楷" size="4">提交</font></button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
		<div class="row-fluid">
		<div class="span12">
			<h3 class="text-center muted">
			<br><br>
				<img alt="" src="../image/xiabiao.gif">
				<br><small>Copyright © 2002-2013  版权所有  3G移动互联电子商务系统第二小组   苏ICP证B2-20100204  [乙测资字32005078]</small>
			</h3>
		</div>
	</div>
</body>
</html>
