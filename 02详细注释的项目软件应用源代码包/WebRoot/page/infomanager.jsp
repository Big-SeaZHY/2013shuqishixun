<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"errorPage="/page/fail.jsp"%>

<%@ page import = "com.seu.xueZhang.entity.*" %>
<%@ page import = "com.seu.xueZhang.dao.*" %>
<%@ page import ="com.seu.xueZhang.dao.impl.*" import="java.text.DecimalFormat"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
Customer c = (Customer)request.getSession().getAttribute("user");
ICollectionDao cl = new ICollectionDaoImpl();
IBookShowDao bs = new IBookShowDaoImpl();
IAccountManagerDao ac = new IAccountManagerDaoImpl();
List<Book> collection = cl.queryCollectionByUserID(c.getUser_id());
Book book;
Thu_img img;
CustomerLevel level = ac.queryUserLevelByUserID(c.getUser_id());
System.out.println(level.toString());
IOrdersDao ordDao = new IOrdersDaoImpl();
Set<Orders> orders = ordDao.queryOrdersByUserId(c.getUser_id());
Iterator<Orders> iterator = orders.iterator();
Orders order;
%>
<%
	DecimalFormat df = new DecimalFormat("#.##");
	double balance= Double.parseDouble(df.format(c.getBalance()));
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-cn" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="shortcut icon" href="../image/favicon.ico" type="image/x-ico"  />
<title>学长网-个人信息管理</title>

<style type="text/css">
	body{
		background-image:url(../image/zhu_left.jpg);
		background-position:bottom left;
		background-repeat:no-repeat;
	}
	</style>
</head>
<body>
	<script src="../js/jQuery.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script type="text/javascript">
function deleteRow(tableID, obj) {//参数为表格ID，触发对象
    //获得触发对象的行号，parentElement的个数取决于触发对象为TR的第几级子项，input=>td=>tr，所以parentElement有两个
       var rowIndex = obj.parentElement.parentElement.rowIndex;
    //var table = document.getElementById(tableID).deleteRow(rowIndex);
    obj.parentElement.parentElement.parentElement.deleteRow(rowIndex); //再简化：省略tableID参数
    
}
</script>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<br> <br>
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="infomanager.jsp">学长</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a>欢迎你，<%=c.getUser_name() %></a></li>
									<li class="divider">-</li>
									<li><a href="../home/home.jsp">主页</a></li>
									<li><a href="infomanager.jsp">个人信息</a></li>
									<li><a href="shoppingCart.jsp">购物车</a></li>
								</ul>
								<ul class="nav pull-right">
									<li><a>欢迎光临</a></li>
									<li><a href="lianxiXueZhang.jsp">联系学长</a></li>
									<li><a href="login.jsp">切换账号</a></li>
								</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<h2 class="text-left">
					<img src="../image/05.ico">管理个人信息
				</h2>
				<hr class="text-left" />
				<p class="text-left"></p>
				<div class="tabbable" id="mytab">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#basicinfo">个人基本信息</a>
						</li>
						<li><a data-toggle="tab" href="#account">账户信息</a></li>
						<li><a data-toggle="tab" href="#collection">收藏夹</a></li>
						<li><a data-toggle="tab" href="#point">积分信息</a></li>
						<li><a data-toggle="tab" href="#record">交易记录</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="basicinfo">
							<table class="table">
								<tbody>
									<tr>
										<td><font face="华文行楷"  size="4">姓名</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getName() %></font></td>
									<tr>
										<td><font face="华文行楷"  size="4">性别</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getSex() %></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">生日</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getBirthday().toString()%></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">手机号码</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getPhone() %></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">身份证号码</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getIdCard() %></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">家庭住址</font></td>
										<td><font face="华文行楷"  size="4"><%=c.getHome_addr() %></font></td>
									</tr>
								</tbody>
							</table>
							<a href="updateinfo.jsp">修改个人信息</a>
						</div>
						<div class="tab-pane" id="account">
						<script type="text/javascript">
							function check(){
								var name=document.getElementById("money").value;
								if(name==""){
									alert('输入金额不能为空');
									document.baseForm.name.focus();
								}
								else{
									document.baseForm.submit();
								}
							}
						</script>
						<form  id="baseForm" name="baseForm" 
						method="post" action = "../servlet/RechargeSev" 
						onkeydown="javascript: if (event.keyCode == 13){return check();}">
							<p><font face="华文行楷"  color="#999999"size="6">你的账户余额为：</font></p>
							<p><font face="华文行楷" color="#999999" size="6">￥</font><font face="Adobe 黑体 Std R" color="#ff6600" size="6"><%=balance %></font></p>
							<p>
								<input id="money" type="text" name="money">
							</p>
							<button class="btn btn-info" type="submit" onclick="check()">充值</button>
						</form>
						</div>
						<div class="tab-pane" id="collection">
							<% if(collection.size()>0){%>
							<p align="right"><form action="../servlet/DeleteCollectionSev" method="post"> <button class="btn btn-default btn-danger" 
							name="clearCollection" type="submit" >清空收藏夹</button> </form></p>
							<table class="table" id="tb">
								<tbody>
								<%
									for(int j=0;j<collection.size();j++)
									{
									book=collection.get(j);
									long id = book.getBook_id();
									img=bs.findThuImgByBookID(book.getBook_id());%>
									<tr>
										<td>
										<a class="text-error" href="../home/homeDetail.jsp?id=<%=book.getBook_id()%>"><img alt = "图片不能显示T^T" src="../<%=img.getThu_path()%>" width="250" height="260"></a>
										</td>
										<td>
											<table class="table">
												<tbody>
													<tr>
														<td><a class="text-error" href="../home/homeDetail.jsp?id=<%=book.getBook_id()%>">
															<%=book.getBook_name()%>
															</a></td>
														<td><font face="华文行楷"  size="4">￥</font><font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=book.getPrice() %></font></td>
													</tr>
													<tr>
														<td><font face="华文行楷" size="4">作者：<%=book.getAuthor() %></font></td>
														<td><font face="华文行楷" size="4">出版社：<%=book.getPublisher() %></font></td>
													</tr>
													<tr>
														<td colspan="2"><font face="华文行楷"  size="4"><%=book.getOutline() %></font></td>
													</tr>
												</tbody>
											</table> <input class="btn btn-small btn-danger" type="button"
											value="删除" onclick="deleteRow('tb',this)" /></td>
									</tr>
								<%}} else{%>
								<font face="华文行楷" size="5">您尚未收藏书籍</font>
								<%}%>
								</tbody>
							</table>
						</div>
						<div class="tab-pane" id="point">
						<br>
							<p><font face="华文行楷" color="#999999" size="6">积分：</font><font face="Adobe 黑体 Std R" color="#ff6600" size="6"> <%=c.getPoint() %></font></p>
							<p><font face="华文行楷"  color="#999999"size="6">等级：</font><font face="华文行楷"  size="6" ><%=level.getLevel_name() %></font></p>
							<p><font face="华文行楷"  color="#999999"size="6">折扣：</font><font face="Adobe 黑体 Std R" color="#ff6600" size="6"><%=level.getCounts() %></font></p>
						</div>
						<div class="tab-pane" id="record">
							<% while(iterator.hasNext()){ 
								order = iterator.next();
								Set<OrderItems> items = order.getOrder_items();
							%>
							<a><font face="华文行楷" color="#999999" size="5">订单详情</font></a><hr/>
							<table class="table-hover table-condensed" width="700">
								<tbody>
									<tr>
										<td><font face="华文行楷"  size="4">交易时间：<%= order.getCreateDate() %></font></td>
										<td><font face="华文行楷"  size="4">交易金额：<%= order.getPrice() %></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">收货人：&nbsp;&nbsp;&nbsp;&nbsp;<%= order.getRec_name() %></font></td>
										<td><font face="华文行楷"  size="4">身份证号：<%= order.getRec_idCard() %></font></td>
										<td><font face="华文行楷"  size="4">联系方式：<%= order.getRec_phone() %></font></td>
									</tr>
									<tr>
										<td><font face="华文行楷"  size="4">收货地址：<%= order.getRec_addr() %></font></td>
										<td><font face="华文行楷"  size="4">邮政编码：<%= order.getPostCode() %></font></td>
									</tr>

								</tbody>
							</table>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th><font face="华文行楷" color="#999999" size="4">书名</font></th>
										<th><font face="华文行楷" color="#999999" size="4">单价</font></th>
										<th><font face="华文行楷" color="#999999" size="4">数量</font></th>
									</tr>
								</thead>
								<tbody>
									<% for(OrderItems order_item:items){ 
										Book bk = order_item.getBook();
									%>
									<tr>
										<td><font face="华文行楷"  size="4"><%= bk.getBook_name() %></font></td>
										<td><font face="Adobe 黑体 Std R" color="#ff6600" size="5">￥<%= bk.getPrice() %></font></td>
										<td><font face="华文行楷"  size="4"><%= order_item.getQuntity() %></font></td>
									</tr>
									<% } %>
								</tbody>
							</table>
							<% } %>
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
				<img alt="" src="../image/xiabiao.gif">
				<br><small>Copyright © 2002-2013  版权所有  3G移动互联电子商务系统第二小组   苏ICP证B2-20100204  [乙测资字32005078]</small>
			</h3>
		</div>
	</div>
</body>
</html>