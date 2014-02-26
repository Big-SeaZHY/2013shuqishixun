<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%@ page  import="com.seu.xueZhang.dao.*"%>
<%@ page  import="com.seu.xueZhang.dao.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Book book=(Book)request.getSession().getAttribute("book");
Thu_img img;
IBookShowDao dao=new IBookShowDaoImpl();
img=dao.findThuImgByBookID(book.getBook_id());
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");

String name2 = c.getUser_name();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-商品评论</title>
    
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
			background-position:bottom right;
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
							<a class="brand" href="page/comment.jsp">学长</a>
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

		<form action="servlet/AddCommentSev" method="post">
			<h3 class="muted">
				<img alt="" src="image/xuezhangw.png">
			</h3>
		<div class="span3">
		</div>
			<table align="left">
				<tbody>
					<tr>
						<td rowspan="4" align="center">
						<br><br>
						<img src="<%=img.getThu_path()%>"><br>
						<h3 class="text-center"><font face="华文行楷" size="6"><%=book.getBook_name() %></font></h3>
						</td>
						<td colspan="3">
							<br><br><br>
							<p ><font face="华文行楷" size="5">请填写您的评论内容：</font></p>
						</td>
					</tr>
					<tr>
					<td> 
					<a class="muted">好评</a><img src="./image/05.gif"><input type="radio" name="comment" value="3" checked/> 
					</td>
					<td>
					<a class="muted">中评</a><img src="./image/03.gif"><input type="radio" name="comment" value="2" />
					</td>
					<td>
					<a class="muted">差评</a><img src="./image/16.gif"><input type="radio" name="comment" value="1" />
					</td>
					</tr>
					<tr>
						<td colspan="3">
							<textarea name="commentarea">
							</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							 <button class="btn btn-info" type="submit"><font face="华文行楷" size="4">提交评论</font></button>
							  <button class="btn btn-danger" type="reset"><font face="华文行楷" size="4">重新填写</font></button>
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
