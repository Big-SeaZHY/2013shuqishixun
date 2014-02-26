package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.xueZhang.dao.*;
import com.seu.xueZhang.dao.impl.*;
import com.seu.xueZhang.entity.*;

public class ShoppingCartSev extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ShoppingCartSev() {
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
		IPurchaseDaoImpl purchase = new IPurchaseDaoImpl();
		
		if(request.getParameter("clearPurchase") != null){
			purchase.clearPurchaseByUserId(user.getUser_id(),false);
			//session.removeAttribute("purchasedItems");
		}
		else if(request.getParameter("addPurchase") != null){
			Pur_Items item = new Pur_Items();
			Book bk = (Book)session.getAttribute("book");
			int num = Integer.parseInt(request.getParameter("number"));
			if(bk.getStock_count() - num < 0){
				response.sendRedirect("/xueZhang/home/home.jsp");
				return;
			}
			
			item.setBook(bk);
			item.setQuantity(num);
			ICustomerManagerDaoImpl cus = new ICustomerManagerDaoImpl();
			user = cus.queryUserInfoByUserID(user.getUser_id());
			item.setUser(user);	
			Set<Pur_Items> pur = purchase.queryPurchaseInfoByUserId(user.getUser_id());
			
			boolean ifexist = false;
			for(Pur_Items pur_item:pur){
				Book temp = pur_item.getBook();
				if(temp.getBook_id().equals(bk.getBook_id())){
					pur_item.setQuantity(pur_item.getQuantity() + num);
					temp.setStock_count(temp.getStock_count() - num);
					purchase.updatePurchase(pur);
					purchase.updateBook(temp);
					ifexist = true;
					break;
				}
			}
			if(!ifexist){
				purchase.addPurchase(item);
			}
		}
		
		response.sendRedirect("/xueZhang/page/shoppingCart.jsp");
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
