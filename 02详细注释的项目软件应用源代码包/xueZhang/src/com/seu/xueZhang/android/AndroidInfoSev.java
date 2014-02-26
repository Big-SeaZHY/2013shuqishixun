package com.seu.xueZhang.android;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.seu.xueZhang.dao.IAccountManagerDao;
import com.seu.xueZhang.dao.IBookShowDao;
import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.IAccountManagerDaoImpl;
import com.seu.xueZhang.dao.impl.IBookShowDaoImpl;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;

public class AndroidInfoSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidInfoSev() {
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
        System.out.println("zhangyu chuanlaile +++++++++" + name);
		//String nameR = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
        System.out.println("POST");  
      //  System.out.println("search_value="+nameR);  
        response.setCharacterEncoding("UTF-8"); 
        
        ICustomerManagerDao icmd = new ICustomerManagerDaoImpl();
        Customer cus = icmd.checkUserByUserNameAndPassword(name,password);
        IAccountManagerDao iad = new IAccountManagerDaoImpl();
        CustomerLevel lev = iad.queryUserLevelByUserID(cus.getUser_id());
        
        double b = cus.getBalance();
        DecimalFormat df = new DecimalFormat( "0.00");  
        String balance = df.format(b);

		JSONArray array=new JSONArray();

	
		JSONObject obj=new JSONObject();		

		try{
			obj.put("id",""+cus.getUser_id());
			obj.put("sex",""+cus.getSex());
			obj.put("IDcard",""+cus.getIdCard());
			obj.put("realname",""+cus.getName());
			obj.put("birthday", ""+cus.getBirthday());

			obj.put("phone",""+cus.getPhone());
			obj.put("point",""+cus.getPoint());
			obj.put("balance",balance);
			obj.put("level", ""+lev.getLevel_name());
			obj.put("count", ""+lev.getCounts());
			obj.put("home", ""+cus.getHome_addr());
			}catch(Exception e){
				e.printStackTrace();
			}			
			array.put(obj);
		
			response.setCharacterEncoding("GBK");
		PrintWriter writer = response.getWriter();
		writer.write(array.toString());
		writer.flush();
		writer.close();
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
