/** 
 * 2013-9-5 
 * ModifySelfInfoSev.java 
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

public class ModifySelfInfoSev extends HttpServlet {
	private static final long serialVersionUID = -1108760691082356547L;


	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		ICustomerManagerDao modif = new ICustomerManagerDaoImpl();
		Customer c = (Customer) request.getSession().getAttribute("user");

		String username = request.getParameter("username");
		String usernameR = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		
		System.out.println("djkkkk"+usernameR);
		String Idt = request.getParameter("identity").toUpperCase();
		String Identity = (String) request.getSession().getAttribute(
				"randomString");
		int flagIdentity = 0;

		if (Idt.equals(Identity)) {
			if (modif.checkUserexist(usernameR)) {

				String password = request.getParameter("password");
				String password2 = request.getParameter("password2");

				if (password.equals(password2)) {

					String realName = request.getParameter("name");
					String realNameR = new String(
							realName.getBytes("ISO-8859-1"), "UTF-8");
					String email = request.getParameter("email");

					String y = request.getParameter("year");
					int year = Integer.parseInt(y) - 1900;
					String m = request.getParameter("month");
					int month = Integer.parseInt(m);
					String d = request.getParameter("day");
					int day = Integer.parseInt(d);

					Date date = new Date(year, month, day);

					String phone = request.getParameter("phone");

					String idCard = request.getParameter("idcard");

					c.setUser_name(usernameR);
					c.setPassword(password);
					c.setName(realNameR);

					c.setEmail(email);
					c.setBirthday(date);
					c.setPhone(phone);

					c.setIdCard(idCard);

					if (modif.updateUserInfo(c)) {
						request.getSession().setAttribute("user", c);
						response.sendRedirect("/xueZhang/page/infomanager.jsp");
					}
					else{
						response.sendRedirect("/xueZhang/page/updateinfo.jsp");
					}

				} else {
					response.sendRedirect("/xueZhang/page/updateinfo.jsp");
				}
			} else {
				response.sendRedirect("/xueZhang/page/updateinfo.jsp");
			}
		}
		else
		{
			request.getSession().setAttribute("flagIdentity", flagIdentity);
			response.sendRedirect("/xueZhang/page/updateinfo.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
