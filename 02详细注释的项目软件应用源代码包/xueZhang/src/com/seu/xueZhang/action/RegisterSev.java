/** 
* 2013-9-5 
* RegisterSev.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Customer;

public class RegisterSev extends HttpServlet {
	private static final long serialVersionUID = -7653358604088587485L;

	/**
	 * Constructor of the object.
	 */
	public RegisterSev() {
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

		System.out.println("hehe");
		response.setContentType("text/html");
		
		ICustomerManagerDao reg = new ICustomerManagerDaoImpl(); 
		Customer c = new Customer();
		
		String userName = request.getParameter("user_name");
		String userNameR = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
		String Idt = request.getParameter("identity").toUpperCase();
		String Identity=(String)request.getSession().getAttribute("randomString");
		int flagIdentityR=0;
		if(Idt.equals(Identity))
		{
		if(!(reg.checkUserexist(userName)))
		{
			System.out.println("youchognde ?");
			response.sendRedirect("/xueZhang/page/registerFail.jsp");
		}else{			

			String password = request.getParameter("password");
			String password2 = request.getParameter("qrpassword");		
		
			if(password.equals(password2))
			{
			
				String realName = request.getParameter("realName");		
				String name = new String(realName.getBytes("ISO-8859-1"),"UTF-8");
				String email = request.getParameter("Email");
				String sex = request.getParameter("Sex");
		
				String y = request.getParameter("year");
				int year = Integer.parseInt(y);
				String m = request.getParameter("month");
				int month = Integer.parseInt(m);
				String d = request.getParameter("day");
				int day = Integer.parseInt(d);
		
				Date date = new Date(year, month, day);
		
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String addressR = new String(address.getBytes("ISO-8859-1"),"UTF-8");
				String idCard = request.getParameter("id_card");
		

				c.setUser_name(userNameR);
				c.setPassword(password);
				c.setName(name);
				c.setSex(sex);
				c.setEmail(email);
				c.setBirthday(date);
				c.setPhone(phone);
				c.setHome_addr(addressR);
				c.setIdCard(idCard);
				if(reg.saveNewUser(c))
				{
					response.sendRedirect("/xueZhang/page/registerSuccess.jsp");
				}
				else{
					response.sendRedirect("/xueZhang/page/registerFail.jsp");
				}
		}else{
			response.sendRedirect("/xueZhang/page/registerFail.jsp");
		}
		}
		}
		else
		{
			request.getSession().setAttribute("flagIdentityR", flagIdentityR);
			response.sendRedirect("/xueZhang/page/register.jsp");
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
