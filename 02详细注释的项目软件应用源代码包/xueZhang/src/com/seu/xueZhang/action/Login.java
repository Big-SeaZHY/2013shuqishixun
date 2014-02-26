package com.seu.xueZhang.action;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Customer;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		response.setContentType("text/html; charset=UTF-8");
		
		
		String flag = "false";
		flag = request.getParameter("flag");
		HttpSession session = request.getSession();

		System.out.println("flag"+flag);
		if (flag == "1") {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			ICustomerManagerDao icmd = new ICustomerManagerDaoImpl();
			Customer cus = icmd.checkUserByUserNameAndPassword(name, password);
			try {
				if (cus.equals(null)) {
					OutputStream out = response.getOutputStream();
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(out));
					writer.write("false");
					writer.flush();
					writer.close();
				} else {
					OutputStream out = response.getOutputStream();
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(out));
					writer.write("success");
					writer.flush();
					writer.close();
				}
			} catch (Exception e) {
				OutputStream out = response.getOutputStream();
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(out));
				writer.write("false");
				writer.flush();
				writer.close();
				// TODO: handle exception
			}
		} else {// 1为安卓端
			int flagLogin=0;
			int flagIdentity=0;
			String name = request.getParameter("user");
			String nameR = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			String pwd = request.getParameter("password");
			String Idt = request.getParameter("identity").toUpperCase();
			String Identity=(String)request.getSession().getAttribute("randomString");
//			System.out.println(Identity);
//			System.out.println(Idt);
			ICustomerManagerDao icmd = new ICustomerManagerDaoImpl();
			Customer cus = icmd.checkUserByUserNameAndPassword(nameR, pwd);
			try {
				if(Idt.equals(Identity)){
					if (cus.equals(null)) {
						request.getSession().setAttribute("flagLogin", flagLogin);
						response.sendRedirect("/xueZhang/page/login.jsp");
					} else {
						request.getSession().setAttribute("user", cus);
						session.removeAttribute("flagLogin");
						session.removeAttribute("flagIdentity");
						response.sendRedirect("/xueZhang/home/home.jsp");
					}					
				}
				else{
					request.getSession().setAttribute("flagIdentity", flagIdentity);
					response.sendRedirect("/xueZhang/page/login.jsp");
				}

			} catch (Exception e) {
				request.getSession().setAttribute("flagLogin", flagLogin);
				response.sendRedirect("/xueZhang/page/login.jsp");
				// TODO: handle exception
			}
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
