<%@ page language="java" import="java.util.*" import="com.seu.xueZhang.entity.*" import="com.seu.xueZhang.dao.impl.*"  
import="com.seu.xueZhang.dao.*"  import="java.text.DecimalFormat" pageEncoding="utf-8" errorPage="/page/fail.jsp"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>
<%
	ICustomerManagerDaoImpl cus = new ICustomerManagerDaoImpl();
	Customer user = (Customer)(request.getSession().getAttribute("user"));
	Pur_Items purchase = new Pur_Items();
	Set<Pur_Items> pur;
	Iterator<Pur_Items> purchases;
	double count = 1;
	double total = 0;
	DecimalFormat df = new DecimalFormat("#.##"); 
	IBookShowDao b = new IBookShowDaoImpl();
	Book bo = b.bookDetails((long)1);
	
	IPurchaseDaoImpl purDao = new IPurchaseDaoImpl();
	pur = purDao.queryPurchaseInfoByUserId(user.getUser_id());
		
	purchases = pur.iterator();
	IAccountManagerDaoImpl acc = new IAccountManagerDaoImpl();
	CustomerLevel level = acc.queryUserLevelByUserID(user.getUser_id());
	count = level.getCounts();
	request.getSession().setAttribute("purchasedItems", pur);
	request.getSession().setAttribute("counts",count);
	int counter = 0;
 %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
		p {text-align:center;}
	</style>
    <title>学长网-我的购物车</title>
    
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
	<script type="text/javascript">
        function IsNum(e) {
            var k = window.event ? e.keyCode : e.which;
            if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
            } else {
                if (window.event) {
                    window.event.returnValue = false;
                }
                else {
                    e.preventDefault(); 
                }
            }
        } 
	</script> 
	<script type="text/javascript">
	function deleteRow(tableID, obj) {//参数为表格ID，触发对象
    //获得触发对象的行号，parentElement的个数取决于触发对象为TR的第几级子项，input=>td=>tr，所以parentElement有两个
       var rowIndex = obj.parentElement.parentElement.rowIndex;
    //var table = document.getElementById(tableID).deleteRow(rowIndex);
    obj.parentElement.parentElement.parentElement.deleteRow(rowIndex -1); //再简化：省略tableID参数
    }
    </script>
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
							<a class="brand" href="page/shoppingCart.jsp">学长</a>
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
	<div class="row-fluid">
		<div class="span1"></div>
		<div class="span10">
			<h3>
			<img src="image/01.ico"/><font face="华文行楷" size="6">我的购物车</font></h3>
			<% if(pur.size() > 0) {%>
			<form name="shoppingCart" method="post">
			<table class="table table-striped table-hover" id="tb">
				<thead>
					<tr>
				      <th class="span4"><p><font color="#999999" face="华文行楷" size="5">书籍</font></p></th>
                      <th class="span2"><p><font color="#999999"face="华文行楷" size="5">单价</font></p></th>
                      <th class="span1"><p><font color="#999999"face="华文行楷" size="5">数量</font></p></th>
                      <th class="span2"><p><font color="#999999"face="华文行楷" size="5">小计</font></p></th>
                      <th class="span1"><p><font color="#999999"face="华文行楷" size="5">操作</font></p></th>
					</tr>
				</thead>
				<tbody>
					<% while(purchases.hasNext()){
						 purchase = purchases.next();
						 Book temp = purchase.getBook();
						 Thu_img img=b.findThuImgByBookID(temp.getBook_id());
					%>
					<tr>
						<td>
							<p><img src="<%=img.getThu_path()%>" width="150" height="160"/>　　　　<b class="muted"><font color="000000" size="5"><%= temp.getBook_name() %></font></b></p>
						</td>
						<td>
							<p><br /><br /><br /><font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%=temp.getPrice() %></font></p>
						</td>
						<td>
							<p><br /><br /><input name="quantity<%= counter %>" class="input-mini" maxlength="2" type="text" placeholder="<%= purchase.getQuantity() %>" onkeypress="return IsNum(event)" /></p>
						</td>
						<td>
							<p><br /><br /><br /><font face="Adobe 黑体 Std R" color="#ff6600" size="5"><%= Double.parseDouble(df.format(temp.getPrice() * purchase.getQuantity())) %></font>
							<% total += temp.getPrice() * purchase.getQuantity(); %></p>
						</td>
						<td >
							<p><br /><br /><input class="btn btn-small btn-danger" type="button"
											value="删除" onclick="deleteRow('tb',this)" /></p>
						</td>
					</tr>
					<% counter++;} %>
					<tr>
						<td >
							<p><br /><b class="muted"><font size="4">总价：￥</font>   <font face="Adobe 黑体 Std R" color="#ff6600" size="5"><% total = Double.parseDouble(df.format(total)); %><%= total %></font></b>
							<b class="muted"><font size="4">折后价：￥ </font> <font face="Adobe 黑体 Std R" color="#ff6600" size="5"><% total = total * count; total = Double.parseDouble(df.format(total));
									request.getSession().setAttribute("total", total);
							 	%><%= total %>　</font></b>
							<button class="btn btn-default btn-success" type="submit" onClick="document.shoppingCart.action='servlet/OrderCheckSev'">找学长结算</button></p>
						</td>
						<td >
							&nbsp
						</td>
						<td>
							&nbsp
						</td>
						<td>
							&nbsp
						</td>
						<td>
							<p><br /><button class="btn btn-default btn-danger" name="clearPurchase" type="submit" onClick="document.shoppingCart.action='servlet/ShoppingCartSev'">清空</button></p>
						</td>
					</tr>
				</tbody>
				
			</table>
			</form>
			<%} else{ %><font color="#999999" face="华文行楷" size="5">您尚未购买商品</font><% } %>	
		</div>
		<hr/>
		<div class="span1"></div>
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
