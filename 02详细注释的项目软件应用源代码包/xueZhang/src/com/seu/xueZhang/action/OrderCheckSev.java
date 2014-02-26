package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.xueZhang.dao.*;
import com.seu.xueZhang.dao.impl.*;
import com.seu.xueZhang.entity.*;

public class OrderCheckSev extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public OrderCheckSev() {
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
		IAddressDao addDao = new IaddressDaoImpl();
		List<Rec_Addr> addrs = addDao.queryAddress(user.getUser_id());
		session.setAttribute("address", addrs);
		Set<Pur_Items> items = new HashSet<Pur_Items>();
		
		if(request.getParameter("CheckInType") != null){
			session.setAttribute("CheckInType", "direct");
			Pur_Items item = new Pur_Items();
			Book bk = (Book)session.getAttribute("book");
			item.setBook(bk);
			int num = Integer.parseInt(request.getParameter("number"));
			session.setAttribute("number", num);
			item.setQuantity(num);
			item.setUser((Customer)session.getAttribute("user"));
			items.add(item);
			IAccountManagerDaoImpl acc = new IAccountManagerDaoImpl();
			CustomerLevel level = acc.queryUserLevelByUserID(user.getUser_id());
			session.setAttribute("counts", level.getCounts());
			double total = bk.getPrice() * num * level.getCounts();
			
			DecimalFormat df = new DecimalFormat("#.00"); 
			
			double t =Double.parseDouble(df.format(total));
			session.setAttribute("total",t);
			System.out.print(t);
		}
		else{
			session.setAttribute("CheckInType", "cart");
			IPurchaseDao purDao = new IPurchaseDaoImpl(); 
			items = purDao.queryPurchaseInfoByUserId(user.getUser_id());
			int counter = 0;
			for(Pur_Items pur:items){
				String tempNum = (String)request.getParameter("quantity"+counter);
				if (!tempNum.equals("")){
					Book bk = pur.getBook();
					int tempStockCount = bk.getStock_count() + pur.getQuantity() - Integer.parseInt(tempNum);
					if(tempStockCount < 0){
						response.sendRedirect("/xueZhang/page/shoppingCart.jsp");
						return;
					}
					else{
						bk.setStock_count(tempStockCount);
						purDao.updateBook(bk);
					}
					pur.setQuantity(Integer.parseInt(tempNum));
					counter++;				
				}				
			}
			purDao.updatePurchase(items);
		}
			
		request.getSession().setAttribute("orderItems", items);
		response.sendRedirect("/xueZhang/page/orderCheck.jsp");
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
