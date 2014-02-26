<%@ page language="java" import="java.util.*" import="com.seu.xueZhang.entity.Thu_img" import="com.seu.xueZhang.entity.Book" pageEncoding="utf-8" errorPage="/page/fail.jsp"%>
<%@ page  import="com.seu.xueZhang.dao.IBookShowDao"%>
<%@ page  import="com.seu.xueZhang.dao.impl.IBookShowDaoImpl"%>
<%@ page import = "com.seu.xueZhang.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Book> book;
Thu_img img;
IBookShowDao dao=new IBookShowDaoImpl();
book=dao.bookShowInHomePage();
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-首页</title>
    
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
	<style type="text/css">
		body{
			background-image:url(image/di.jpg);
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
									<li><a href="page/dlAndroid.jsp">下载区</a></li>
									<li><a href="page/login.jsp" >切换账号</a>
								</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<h3 class="muted">
				<img alt="" src="image/xuezhangw.png">
			</h3>
		</div>
		<div class="span5">
		</div>
		<div class="span4">
			<form class="form-search" align="center" action="page/searchResult.jsp" method="post">
			<br>
			书名
			<input type="radio"  name="search" value="1" checked />
			作者
			<input type="radio" name="search" value="2" />
			出版社
			<input type="radio" name="search" value="3" /><br>
				<input class="input-medium search-query" type="text" name="keyword"/><button class="btn btn-info" type="submit")><img src="image/04.ico">关键字搜索</button>
			</form>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<ul class="nav nav-list">
				<li class="nav-header">
					<h3>分类栏</h3>
				</li>
				<li>
					<a href="home/home.jsp">首页</a>
				</li>
				<li>
					<a href="home/home.jsp#remai">热卖</a>
				</li>
				<li>
					<a href="home/home.jsp#tuijian">推荐</a>
				</li>
				<li>
					<a href="home/home.jsp#dazhe">打折</a>
				</li>
			</ul>
			<div class="accordion" id="accordion-772315">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle collapsed" data-parent="#accordion-772315" data-toggle="collapse" href="#accordion-element-912555">具体分类</a>
					</div>
					<div class="accordion-body collapse" id="accordion-element-912555">
						<div class="accordion-inner">
							 <a href="page/classify.jsp?id=<%=1%>&name=青春">青春</a> <a href="page/classify.jsp?id=<%=2%>&name=少儿">少儿</a><br />  <a href="page/classify.jsp?id=<%=3%>&name=政治">政治</a> <a href="page/classify.jsp?id=<%=4%>&name=历史">历史</a><br />  <a href="page/classify.jsp?id=<%=5%>&name=文学">文学</a> <a href="page/classify.jsp?id=<%=6%>&name=旅游">旅游</a><br />  <a href="page/classify.jsp?id=<%=7%>&name=地理">地理</a> <a href="page/classify.jsp?id=<%=8%>&name=爱情">爱情</a><br />  <a href="page/classify.jsp?id=<%=9%>&name=教辅">教辅</a> <a href="page/classify.jsp?id=<%=10%>&name=科幻">科幻</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="span9">
			<div class="carousel slide" id="carousel-124545">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-124545">
					</li>
					<li data-slide-to="1" data-target="#carousel-124545">
					</li>
					<li data-slide-to="2" data-target="#carousel-124545">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<a href="home/homeDetail.jsp?id=1"><img alt="" src="image/book/1.jpg" /></a>
						<div class="carousel-caption">
							<h4>
								<a href="home/homeDetail.jsp?id=1">《我最想要的化妆书》&nbsp;&nbsp;&nbsp;&nbsp;￥15.00</a>
							</h4>
							<p>
								别小看彩妆VIP边惠玉“大婶”的功力，她的每一篇妆容指导都能引发韩国国内的化妆大热潮。从底妆、眼妆、轮廓整形妆、唇妆到卸妆，作者将她受追捧的所有精华全部收录进此书中……
							</p>
						</div>
					</div>
					<div class="item">
						<a href="home/homeDetail.jsp?id=10"><img alt="" src="image/book/10.jpg" /></a>
						<div class="carousel-caption">
							<h4>
								<a href="home/homeDetail.jsp?id=10">《文化苦旅》&nbsp;&nbsp;&nbsp;&nbsp;￥22.00</a>
							</h4>
							<p>
								这是本文化散文集。它主要通过山水风物探求文化灵魂、人生真谛、中国文化的历史命运和中国文人的人格构成。既表现了历史的深邃荒凉，又展现了江南文化的清新婉约；既展示中国文人的艰难心路，又不忘揭露世态人情......
							</p>
						</div>
					</div>
					<div class="item">
						<a href="home/homeDetail.jsp?id=19"><img alt="" src="image/book/19.jpg" /></a>
						<div class="carousel-caption">
							<h4>
								<a href="home/homeDetail.jsp?id=19">《僵尸生存指南》&nbsp;&nbsp;&nbsp;&nbsp;￥23.00</a>
							</h4>
							<p>
								也许你正在回家的路上走着，几个僵尸就已经隐藏在路边拐角伺机而动。这并不是只有在电影和游戏中才会出现的场景，而是已经在人类历史上发生过无数次的僵尸灾难……
							</p>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-124545" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-124545" class="right carousel-control">›</a>
			</div>
		</div>
	<div id="remai"  class="row-fluid">
		<div class="span6">
			<h3 class="muted">
				<strong>热卖中......</strong>
			</h3>
		</div>
		<div class="span6" align="right">
			 <button class="btn btn-link btn-large" type="button">更多...</button>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(0).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(0).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(0).getBook_id()%>">
			<%=book.get(0).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(0).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(1).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(1).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(1).getBook_id()%>">
			<%=book.get(1).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(1).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(2).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(2).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(2).getBook_id()%>">
			<%=book.get(2).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(2).getPrice()%></font> 
			</b></font>
			</p>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span6">
			<h3 id="tuijian" class="muted">
				<strong>学长推荐......</strong>
			</h3>
		</div>
		<div class="span6" align="right">
			 <button class="btn btn-link btn-large" type="button">更多...</button>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(3).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(3).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(3).getBook_id()%>">
			<%=book.get(3).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(3).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(4).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(4).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(4).getBook_id()%>">
			<%=book.get(4).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(4).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(5).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(5).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(5).getBook_id()%>">
			<%=book.get(5).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(5).getPrice()%></font> 
			</b></font>
			</p>
		</div>
	</div>
	<div id="dazhe" class="row-fluid">
		<div class="span6">
			<h3 class="muted">
				<strong>打折促销中......</strong>
			</h3>
		</div>
		<div class="span6" align="right">
			 <button class="btn btn-link btn-large" type="button">更多...</button>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(6).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(6).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(6).getBook_id()%>">
			<%=book.get(6).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(6).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(7).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(7).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(7).getBook_id()%>">
			<%=book.get(7).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(7).getPrice()%></font> 
			</b></font>
			</p>
		</div>
		<div class="span4">
			<%img=dao.findThuImgByBookID(book.get(8).getBook_id());%>
			<p align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(8).getBook_id()%>"><img src="<%=img.getThu_path()%>" width="250" height="260"></a></p>
			<h3 align="center">
			<a class="text-error" href="home/homeDetail.jsp?id=<%=book.get(8).getBook_id()%>">
			<%=book.get(8).getBook_name()%>
			</a>
			</h3>
			<p align="center">
			<font size="4"><b class="muted">
			学长心动价:￥<font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.get(8).getPrice()%></font> 
			</b></font>
			</p>
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
</div>
</div>
  </body>
</html>
