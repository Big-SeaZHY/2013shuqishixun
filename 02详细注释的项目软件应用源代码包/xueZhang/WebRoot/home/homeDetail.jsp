<%@ page language="java" import="java.util.*" import="com.seu.xueZhang.entity.Thu_img" import="com.seu.xueZhang.entity.*" pageEncoding="utf-8" %>
<%@ page  import="com.seu.xueZhang.dao.*"%>
<%@ page  import="com.seu.xueZhang.dao.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id;
int quantityR;
long book_id;
Comments comment;
List<Comments> comments;
id=request.getParameter("id");
book_id=Long.parseLong(id);
Book book;
Thu_img img;
Det_img Dimg;
List<Det_img> Dimgs;
IBookShowDao dao=new IBookShowDaoImpl();
ICommentDao Cdao=new ICommentDaoImpl();
book=dao.bookDetails(book_id);
Dimgs=dao.findDetImgByBookID(book_id);
comments=Cdao.lookComments(book_id);
request.getSession().setAttribute("book",book);
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学长网-商品详情</title>
    
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
			background-image:url(./image/xiangqing.jpg);
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
		</div>
	</div>

	<div class="row-fluid">
		<div class="span12">
		
			<h3 class="text-center muted">
				<%=book.getBook_name()%>
			</h3>
			<div class="row-fluid">
				<div class="span5">
				<%img=dao.findThuImgByBookID(book.getBook_id());%>
					<img align="right" src="<%=img.getThu_path()%>" />
				</div>
				<div class="span7">
				<form id="form1" name="form1" method="post">
					<table class="table-hover table-condensed">
						<tbody>
							<tr>
								<td align="right">
								<br><br>
								<b class="muted"><font size="4">
									学长心动价：￥</font></b>
								</td>
								<td>
								<br><br> 
									<b><font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.getPrice()%></font></b>
								</td>
							</tr>
							<tr>
								<td align="right">
									<b class="muted"><font size="4">
									库存：</font></b>
								</td>
								<td>
									<b><font face="Adobe 黑体 Std R" color="#ff6600" size="5">
									<%=book.getStock_count()%></font></b>
									<b class="muted"><font size="4">
									件</font></b>
								</td>
							</tr>
							<tr>
								<td align="right">
									<b class="muted"><font size="4">
									收藏量：</font></b>
								</td>
								<td> 
									<b><font face="Adobe 黑体 Std R" color="#ff6600" size="5">
									<%=book.getCollect_count()%></font></b>
									<b class="muted"><font size="4">
									件</font></b>
								</td>
							</tr>
							<tr>
								<td align="right">
									<b class="muted"><font size="4">
									销售量：</font></b>
								</td>
								<td>
									<b><font face="Adobe 黑体 Std R" color="#ff6600" size="5">
									<%=book.getSale_count()%></font></b>
									<b class="muted"><font size="4">
									件</font></b>
								</td>
							</tr>
							<tr>
								<td align="right">
									<b class="muted"><font size="4">
									物流运费：￥</font></b>
								</td>
								<td>
									<b><font face="Adobe 黑体 Std R" color="#ff6600" size="5">10</font></b>
								</td>
							</tr>
							<tr>
								<td align="right">
									<b><font size="6" color="#ff0000">
									我要买:</font></b>
								</td>
								<td>
									<select name="number" id="number">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									</select>
									<b class="muted"><font size="4">
									件</font></b>					
							</td>
							</tr>
							<tr>
								<td colspan="2">
								<br><br>
									<button class="btn btn-info" name="CheckInType" onClick="document.form1.action='servlet/OrderCheckSev'" type="submit">直接购买</button>
									<button class="btn btn-warning" name="addPurchase" onClick="document.form1.action='servlet/ShoppingCartSev'" type="submit">加入购物车</button>
									<button class="btn btn-danger" onClick="document.form1.action='servlet/AddCollectionSev'" type="submit">加入收藏夹</button>
								</td>
							</tr>
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<div class="tabbable" id="tabs-391696">
				<ul class="nav nav-tabs">
					<li class="active">
						<a data-toggle="tab" href="#panel-618558"><font face="华文行楷" size="4">宝贝详情</font></a>
					</li>
					<li>
						<a data-toggle="tab" href="#panel-455256"><font  face="华文行楷" size="4">评价详情</font></a>
					</li>
					<li>
						<a data-toggle="tab" href="#panel-500"><font face="华文行楷" size="4">交易记录</font></a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-618558">
						
							<table class="table-hover table-condensed" width="1000">
							<tr>
							<td>
							<font face="华文行楷" size="5">书本名称：<%=book.getBook_name() %></font>
							</td>
							<td>
							<font face="华文行楷" size="5">出版社：<%=book.getPublisher() %></font>
							</td>
							<td>
							<font face="华文行楷" size="5">作者：<%=book.getAuthor() %></font>
							</td>
							</tr>
							<tr>
							<td colspan="3">
							<br><font face="华文行楷" size="5">概要：</font><br>
							<font face="华文行楷" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=book.getOutline() %></font>
							</td>
							</tr>
							<tr>
							<td>
							<font face="华文行楷" size="5">详细图片：</font><br>
							</td>
							</tr>
							<%for(int i=0;i<Dimgs.size();i++)
							{
								Dimg=Dimgs.get(i);
							%>
							<tr>
							<td colspan="3">
							<img src="<%=Dimg.getDet_path()%>" />
							</td>
							</tr>
							<%} %>
							</table>
						
					</div>
					<div class="tab-pane" id="panel-455256">
					<table class="table table-hover" >
				<thead>
					<tr>
						<th>
							<font face="华文行楷" size="5">用户</font>
						</th>
						<th>
							<font face="华文行楷" size="5">评语</font>
						</th>
						<th>
							<font face="华文行楷" size="5">时间</font>
						</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i=0;i<comments.size();i++){
					comment=comments.get(i);
					%>
					<tr>
					<td>
					<%=comment.getUser().getName()%>
					</td>
					<td>
					<%=comment.getComments() %>
					</td>
					<td>
					<%=comment.getComment_date() %>
					</td>
					</tr>
					<%} %>
				</tbody>
			</table>
					</div>
					<div class="tab-pane" id="panel-500">
						<table class="table" contenteditable="true">
                  <thead>
                    <tr>
                      <th><font face="华文行楷" size="5">买家</font></th>
                      <th><font face="华文行楷" size="5">拍下价格</font></th>
                      <th><font face="华文行楷" size="5">数量</font></th>
                      <th><font face="华文行楷" size="5">付款时间</font></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>小明</td>
                      <td>￥10</td>
                      <td>1</td>
                      <td>01/04/2012</td>
                    </tr>
                    <tr>
                      <td>小明</td>
                      <td>￥10</td>
                      <td>1</td>
                      <td>01/04/2012</td>
                    </tr>
                    <tr>
                      <td>小明</td>
                      <td>￥10</td>
                      <td>1</td>
                      <td>01/04/2012</td>
                    </tr>
                    <tr>
                      <td>小明</td>
                      <td>￥10</td>
                      <td>1</td>
                      <td>01/04/2012</td>
                    </tr>
                    <tr>
                      <td>小明</td>
                      <td>￥10</td>
                      <td>1</td>
                      <td>01/04/2012</td>
                    </tr>
                  </tbody>
                </table>
					</div>
				</div>
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
