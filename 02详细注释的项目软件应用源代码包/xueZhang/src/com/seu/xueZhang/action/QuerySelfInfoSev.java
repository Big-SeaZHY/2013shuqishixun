package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.xueZhang.dao.IAccountManagerDao;
import com.seu.xueZhang.dao.ICollectionDao;
import com.seu.xueZhang.dao.IOrdersDao;
import com.seu.xueZhang.dao.impl.IAccountManagerDaoImpl;
import com.seu.xueZhang.dao.impl.ICollectionDaoImpl;
import com.seu.xueZhang.dao.impl.IOrdersDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.entity.Orders;

public class QuerySelfInfoSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuerySelfInfoSev() {
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

		response.setContentType("text/html");
		Customer user =   (Customer) request.getSession().getAttribute("user");
		//收藏夹
		ICollectionDao coda = new ICollectionDaoImpl();
			
		List<Book> books = coda.queryCollectionByUserID(user.getUser_id());
		request.getSession().setAttribute("collection_all",	books);
		//积分
		IAccountManagerDao acda = new IAccountManagerDaoImpl();
		CustomerLevel level = acda.queryUserLevelByUserID(user.getUser_id());
		request.getSession().setAttribute("userlevel", level);
		//交易记录
		IOrdersDao ioda = new IOrdersDaoImpl();
		Set<Orders> orders = ioda.queryOrdersByUserId(user.getUser_id());
		request.getSession().setAttribute("order_all", orders);
		
		
		
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
