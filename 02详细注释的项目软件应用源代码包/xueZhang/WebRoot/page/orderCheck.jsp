<%@ page language="java" import="java.util.*" import="com.seu.xueZhang.entity.*" pageEncoding="utf-8"errorPage="/page/fail.jsp"%>
<%@ page import = "com.seu.xueZhang.entity.*"  import="java.text.DecimalFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Rec_Addr> rec = (List<Rec_Addr>)request.getSession().getAttribute("address");
	int addr_size = rec.size();
	Rec_Addr[] addresses = rec.toArray(new Rec_Addr[addr_size]);
	
	Set<Pur_Items> pur = (Set<Pur_Items>)request.getSession().getAttribute("orderItems");
	int purchase_size = pur.size();
	Pur_Items[] purchases = pur.toArray(new Pur_Items[rec.size()]);
	int counter = 0;
	DecimalFormat df = new DecimalFormat("#.##");
	double count = (Double)request.getSession().getAttribute("counts");
	double total = 0;
%>
<%String name = "suchen" ;
Customer c = (Customer)request.getSession().getAttribute("user");
String name2 = c.getUser_name();
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
		p {text-align:center;}
	</style>
    <title>学长网-订单确认</title>
    
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
	<script language="javascript" src="js/check.js"></script>
	<script type="text/javascript">
		<%if (addr_size>0){%>
		function fillForm1(){
			document.getElementById("inputName").value="<%= addresses[0].getRec_name() %>";
			document.getElementById("inputID").value="<%= addresses[0].getRec_idCard() %>";
			document.getElementById("inputPhone").value="<%= addresses[0].getRec_phone() %>";
			document.getElementById("inputAddress").value="<%= addresses[0].getRec_addr() %>";
		}
		<%}if(addr_size>1){%>
		function fillForm2(){
			document.getElementById("inputName").value="<%= addresses[1].getRec_name() %>";
			document.getElementById("inputID").value="<%= addresses[1].getRec_idCard() %>";
			document.getElementById("inputPhone").value="<%= addresses[1].getRec_phone() %>";
			document.getElementById("inputAddress").value="<%= addresses[1].getRec_addr() %>";
		}
		<%}if(addr_size>2){%>
		function fillForm3(){
			document.getElementById("inputName").value="<%= addresses[2].getRec_name() %>";
			document.getElementById("inputID").value="<%= addresses[2].getRec_idCard() %>";
			document.getElementById("inputPhone").value="<%= addresses[2].getRec_phone() %>";
			document.getElementById("inputAddress").value="<%= addresses[2].getRec_addr() %>";
		}
		<%}if(addr_size>3){%>
		function fillForm4(){
			document.getElementById("inputName").value="<%= addresses[3].getRec_name() %>";
			document.getElementById("inputID").value="<%= addresses[3].getRec_idCard() %>";
			document.getElementById("inputPhone").value="<%= addresses[3].getRec_phone() %>";
			document.getElementById("inputAddress").value="<%= addresses[3].getRec_addr() %>";
		}
		<%}%>
	</script>
	<style type="text/css">
		body{
			background-image:url(./image/order.jpg);
			background-position:top right;
			background-attachment: fixed;
			background-repeat:no-repeat;
		}
	</style>
  </head>
  
  <body>
  <div class="container-fluid">
	<div class="row-fluid">
	<div class="navbar">
		<div class="span12">
				<br> <br>
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="btn btn-navbar"
								data-target=".navbar-responsive-collapse" data-toggle="collapse"></a>
							<a class="brand" href="page/orderCheck.jsp">学长</a>
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
			<div class="span2">
				<h3 class="muted">
					<img alt="" src="image/xuezhangw.png">
				</h3>
			</div>
				<div class="span8">
					<h3 align = "center"><br>修改收货地址</h3>
					<%
						for(int i = 0;i < addr_size;i++){ 
							Rec_Addr address = addresses[i];
							counter = i;
					%>
					<button class="btn btn-block"  type="button" onClick="fillForm<%= counter+1 %>()">
						<p><strong>
							收货人：<%= address.getRec_name() %>　　　　ID卡：<%= address.getRec_idCard() %>　　　　联系方式：<%= address.getRec_phone() %><br>
							收货地址：<%= address.getRec_addr() %>								
						</strong></p>
					</button><br />
					<% } %>
					<form class="form-horizontal" action="servlet/CheckInSev" method="post" id="rec_address" name="rec_address">
						<div class="control-group">
							<label class="control-label" for="name"><font face="华文行楷" size="5">收货人姓名</font></label>
							<div class="controls">
								<input type="text" name="name" id="inputName" placeholder="Name" onBlur="javascript:checkRName(rec_address)" onMouseOver="javascript:checkRName(rec_address)" onMouseOut="javascript:checkRName(rec_address)"/>
								<span id="insertName"></span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ID"><font face="华文行楷" size="5">身份证号</font></label>
							<div class="controls">
								<input type="text" name="id" id="inputID" placeholder="ID"  onBlur="javascript:checkRID(rec_address)" onMouseOver="javascript:checkRID(rec_address)" onMouseOut="javascript:checkRID(rec_address)"/>
								<span id="insertID"></span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="phone"><font face="华文行楷" size="5">联系方式</font></label>
							<div class="controls">
								<input type="text" name="phone" id="inputPhone" placeholder="Phone" onBlur="javascript:checkRPhone(rec_address)" onMouseOver="javascript:checkRPhone(rec_address)" onMouseOut="javascript:checkRPhone(rec_address)"/>
								<span id="insertPhone"></span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="address"><font face="华文行楷" size="5">地址</font></label>
							<div class="controls">
								<input class="span8" type="text" name="address" id="inputAddress" placeholder="Address" onBlur="javascript:checkRAddress(rec_address)" onMouseOver="javascript:checkRAddress(rec_address)" onMouseOut="javascript:checkRAddress(rec_address)"/>
								<span id="insertAddress"></span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="postCode"><font face="华文行楷" size="5">邮编</font></label>
							<div class="controls">
								<input type="text" name="postCode" id="inputPcode" placeholder="Postcode" onBlur="javascript:checkRPCode(rec_address)" onMouseOver="javascript:checkRPCode(rec_address)" onMouseOut="javascript:checkRPCode(rec_address)"/>
								<span id="insertPostcode"></span>
							</div>
						</div>
				<h3>书籍清单</h3>
				<table class="table table-striped">
				<thead>
					<tr>
				      <th class="span4"><p>书籍</p></th>
                      <th class="span2"><p>单价</p></th>
                      <th class="span2"><p>数量</p></th>
					</tr>
				</thead>
				<tbody>
					<% 
						for(int i = 0;i < purchase_size;i++){ 
							Pur_Items purchase = purchases[i];
					%>
					<tr>
						<td><p><%= purchase.getBook().getBook_name() %></p></td>
						<td><p><%= (purchase.getBook().getPrice()) %></p></td>
						<td><p><%= purchase.getQuantity() %></p></td>
					</tr>
					<% total += purchase.getBook().getPrice()*purchase.getQuantity();} 
						total *= count;
						total = Double.parseDouble(df.format(total));
						request.getSession().setAttribute("total", total);
					%>
					<tr>
						<td><p><strong>折后总价：  <%= total %></strong></p></td>
						<td><p><button class="btn btn-default btn-success" onclick=window.open("home/home.jsp") type="button">继续购物</button></p></td>
						<td><p><button class="btn btn-default btn-danger" type="submit">提交订单</button></p></td>
					</tr>
				</tbody>
				</table>
				</form>
				</div>
				<div class="span2">
				</div>
			</div>
			<hr/>
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
