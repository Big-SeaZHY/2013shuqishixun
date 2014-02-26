package com.seu.xueZhang.android;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Customer;

public class AndroidRegisterSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidRegisterSev() {
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

		request.setCharacterEncoding("UTF-8");  
        String name = request.getParameter("name");   
        String password  = request.getParameter("password");
        System.out.println("zhangyuchuanlaile" + name + password + "heheh");
        ICustomerManagerDao icd = new ICustomerManagerDaoImpl();
        Customer c = new Customer();
        if(!(icd.checkUserexist(name)))
        {
        	OutputStream out = response.getOutputStream();  
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

	        writer.write("the name is exist");  
	        writer.flush(); 
	        writer.close(); 
        }else{

        String phone = request.getParameter("phone");
        String email = request.getParameter("Email");
        String adr = request.getParameter("postalAddress");
        

        
        c.setUser_name(name);
        c.setPassword(password);
        c.setPhone(phone);
        c.setEmail(email);
        c.setHome_addr(adr);
       try{
        	if(icd.saveNewUser(c))
        	{
        		OutputStream out = response.getOutputStream();  
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	        System.out.println("qishichenggongle");
	        writer.write("success");  
	        writer.flush(); 
	        writer.close(); 
	        }
        	else
        	{
        		 OutputStream out = response.getOutputStream();  
     	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
     	        writer.write("fail");  
     	        writer.flush(); 
     	        writer.close(); 
        	}
        }catch(Exception e){
        	 OutputStream out = response.getOutputStream();  
 	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
 	        writer.write("fail");  
 	        writer.flush(); 
 	        writer.close(); 
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
