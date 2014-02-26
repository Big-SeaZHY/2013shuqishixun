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

import org.json.JSONArray;
import org.json.JSONObject;

import com.seu.xueZhang.dao.IAccountManagerDao;
import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.ITradeDao;
import com.seu.xueZhang.dao.impl.IAccountManagerDaoImpl;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.dao.impl.ITradeDaoImpl;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.entity.Rec_Addr;

public class AndroidTradeSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidTradeSev() {
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

        String name = request.getParameter("name");  
		String password = request.getParameter("password");
		String totals = request.getParameter("total");
		String numbers = request.getParameter("number");
		String bookids = request.getParameter("bookid");
		String address = request.getParameter("address");
		String post = request.getParameter("post");
		String attention = request.getParameter("attention");
		String phone = request.getParameter("phone");
		String idcard = request.getParameter("idcard");
		
		Double total = Double.parseDouble(totals);
		long bookid = Long.parseLong(bookids);
		int number = Integer.parseInt(numbers);	
		Rec_Addr rec = new Rec_Addr(address,attention,phone,idcard);
		
        ICustomerManagerDao icmd = new ICustomerManagerDaoImpl();
        Customer cus = icmd.checkUserByUserNameAndPassword(name,password);
        ITradeDao itd = new ITradeDaoImpl();
        
        try{
        if(itd.trade(total, cus.getUser_id(), bookid, number, rec, post))
        {
        	 OutputStream out = response.getOutputStream();  
 	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
 	        writer.write("success");  
 	        writer.flush(); 
 	        writer.close(); 
        }else{
        	 OutputStream out = response.getOutputStream();  
 	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
 	        writer.write("fail");  
 	        writer.flush(); 
 	        writer.close(); 
        }
        }catch(Exception e )
        {
        	 OutputStream out = response.getOutputStream();  
 	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
 	        writer.write("fail");  
 	        writer.flush(); 
 	        writer.close(); 
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
