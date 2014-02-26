<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int flag;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="Content-Language" content="zh-cn" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/buttons.css">
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
	<script src="js/jQuery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script language="javascript" src="js/check.js"></script>
	<style type="text/css">
		body{
			background-image:url(image/zhu4.jpg);
			background-position:bottom right;
			background-repeat:no-repeat;
		}
	</style>
	<link rel="shortcut icon" href="image/favicon.ico" type="image/x-ico"  />
  </head>
  
  <body >
  <p><br /><input name="flag" class="input-tiny" type="hidden" placeholder = "0"></p><!-- 浏览器端  -->
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span8">
			<div class="carousel slide" id="carousel-284872">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-284872">
					</li>
					<li data-slide-to="1" data-target="#carousel-284872">
					</li>
					<li data-slide-to="2" data-target="#carousel-284872">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="image/chinese/1.jpg" width="880"/>
						<div class="carousel-caption">
							<h4>
								笔墨天下
							</h4>
							<p>
								读书破万卷，下笔如有神。
							</p>
						</div>
					</div>
					<div class="item">
					<img alt="" src="image/chinese/2.jpg" width="880"/>
						<div class="carousel-caption">
							<h4>
								心灵之窗
							</h4>
							<p>
								书籍
								&nbsp;&nbsp;——通过心灵观察世界的窗口。
								住宅里没有书，犹如房间没有窗户。
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="image/chinese/3.jpg" width="880"/>
						<div class="carousel-caption">
							<h4>
								心沉书海
							</h4>
							<p>
								史鉴使人明智，诗歌使人巧慧，数学使人精细，博物使人深沉，伦理之学使人庄重。
							</p>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-284872" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-284872" class="right carousel-control">›</a>
			</div>
		</div>
		<div class="span4">
			<p><img alt="" src="image/xuezhangw.png"></p>
			<form id="login" name="login" method="post" action="servlet/Login">
				<p class="text-left muted">
				<br> 
					请输入您的用户名和密码：
				</p>
				<table>
					<tbody>
						<tr>
							<td>
								<font face="华文行楷" size="5">用户:</font>
							</td>
							<td>
								<input name="user" type="text" onBlur="javascript:checkName(login)" onMouseOver="javascript:checkName(login)" onMouseOut="javascript:checkName(login)"/>
							</td>
						</tr>
						<tr>
						<td colspan="2">
						<div id="user_name">
						<%if(request.getSession().getAttribute("flagLogin")!=null)
								{
								flag=(Integer)request.getSession().getAttribute("flagLogin");
								if(flag==0)
								{%>
									<font color=#FF0000>用户名或密码错误！</font>
								<% }
								}
								%>
						</div>
						</td>
						</tr>
						<tr>
							<td>
								<font face="华文行楷" size="5">密码:</font>
							</td>
							<td>
								<input name="password" type="password" onBlur="javascript:checkPassword(login)"onMouseOver="javascript:checkPassword(login)" onMouseOut="javascript:checkPassword(login)" />
								<a href="page/findback.jsp">忘记密码？</a>
							</td>
						</tr>
						<tr>
						<td colspan="2">
						<div id="password1"></div>
						</td>
						</tr>
						<tr>
							<td>
								<font face="华文行楷" size="5">验证码:</font>
							</td>
							<td>
								<input name="identity" type="text" size="6" onBlur="javascript:checkIdentity(login)"onMouseOver="javascript:checkIdentity(login)" onMouseOut="javascript:checkIdentity(login)"/>
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
						<%if(request.getSession().getAttribute("flagIdentity")!=null)
								{
								flag=(Integer)request.getSession().getAttribute("flagIdentity");
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
							<td colspan="2">
								<button class="btn btn-info" type="submit">登陆</button>
							</td>
						</tr>
					</tbody>
				</table>
							</form>
				<p class="text-left muted">
					您还不是学长书屋的用户？
				</p>
				<p class="text-left muted">
					那么赶快加入我们吧！
				</p> <button class="btn btn-info" onclick=window.open("page/register.jsp") type="button">点击注册</button>

		</div>
	</div>
</div></body>
</html>
