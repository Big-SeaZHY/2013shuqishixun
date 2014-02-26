package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.xueZhang.dao.impl.*;
import com.seu.xueZhang.entity.*;

public class CheckInSev extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckInSev() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Customer user = (Customer)session.getAttribute("user");
		ICustomerManagerDaoImpl cus = new ICustomerManagerDaoImpl();
		
		double total = (Double)session.getAttribute("total");
		
		Rec_Addr address = new Rec_Addr();
		
		String name = new String(((String)request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");
		String addr = new String((request.getParameter("address")).getBytes("ISO-8859-1"),"UTF-8");
		String idcard = request.getParameter("id");
		String phone = request.getParameter("phone");
		String postCode = request.getParameter("postCode");
		if(name.equals("")||addr.equals("")||idcard.equals("")||phone.equals("")||postCode.equals("")){
			response.sendRedirect("/xueZhang/page/orderCheck.jsp");
			return;
		}
		
		address.setRec_name(name);
		address.setRec_addr(addr);
		address.setRec_idCard(idcard);
		address.setRec_phone(phone);
		
		boolean ifExist = false;
		
		List<Rec_Addr> addrs = (List<Rec_Addr>)session.getAttribute("address");
		for(Rec_Addr add:addrs){
			if(add.getRec_addr().equals(addr) &&
				add.getRec_idCard().equals(idcard) && 
				add.getRec_name().equals(name) && 
				add.getRec_phone().equals(phone)){
				ifExist = true;
				break;
			}
		}
		if(!ifExist){
			IaddressDaoImpl addDao = new IaddressDaoImpl();
			addDao.addAddress(user.getUser_id(), address);
		}
		
		if(session.getAttribute("CheckInType").equals("direct")){
			
			ITradeDaoImpl trade = new ITradeDaoImpl();
			Book bk = (Book)session.getAttribute("book");
			if(trade.trade(total, user.getUser_id(), bk.getBook_id(), (Integer)session.getAttribute("number"), address, postCode)){

//				session.removeAttribute("number");
//				session.removeAttribute("address");
//				session.removeAttribute("orderItems");
//				session.removeAttribute("total");
//				session.removeAttribute("counts");
				response.sendRedirect("/xueZhang/page/shoppingSuccess.jsp");
				user = cus.queryUserInfoByUserID(user.getUser_id());
				session.setAttribute("user", user);
			}
			else{
				response.sendRedirect("/xueZhang/page/shoppingFail.jsp");
			}
		}
		else{ 
			IOrdersDaoImpl order = new IOrdersDaoImpl();
			if(order.checkIn(user.getUser_id(), total, address, postCode)){
//				session.removeAttribute("address");
//				session.removeAttribute("orderItems");
//				session.removeAttribute("total");
//				session.removeAttribute("counts");
				
				IPurchaseDaoImpl pur = new IPurchaseDaoImpl();
				pur.clearPurchaseByUserId(user.getUser_id(),true);
				user = cus.queryUserInfoByUserID(user.getUser_id());
				session.setAttribute("user", user);
				response.sendRedirect("/xueZhang/page/shoppingSuccess.jsp");
			}
			else{
				response.sendRedirect("/xueZhang/page/shoppingFail.jsp");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
