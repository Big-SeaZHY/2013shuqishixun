package com.seu.xueZhang.android;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.seu.xueZhang.dao.IBookShowDao;
import com.seu.xueZhang.dao.impl.IBookShowDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Thu_img;

public class AndroidBroSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidBroSev() {
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

	  //	request.setCharacterEncoding("UTF-8");  
        String name = request.getParameter("search_value");  
		String nameR = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("POST");  
        System.out.println("search_value="+nameR);  
       // response.setCharacterEncoding("UTF-8"); 

    
        IBookShowDao ibsd = new IBookShowDaoImpl();
        List<Book> book = ibsd.bookQueryByKey(1, name);
     
        System.out.println(book.get(0).toString());
	
		JSONArray array=new JSONArray();
		if(!(book.isEmpty()))
		{
		for(Book b:book)
		{
			JSONObject obj=new JSONObject();		

			try{
				obj.put("id",""+b.getBook_id());
				System.out.println("wo chuan de shi " + b.getBook_id());
				obj.put("name",b.getBook_name());
				obj.put("author", b.getAuthor());
				obj.put("price",b.getPrice());
				obj.put("imageUrl",b.getThu_img().iterator().next().getThu_path());
			}catch(Exception e){
				e.printStackTrace();
			}
			array.put(obj);
		}
		}
		else
		{
			JSONObject obj = new JSONObject();
			try{
				obj.put("id","null");
				obj.put("name","null");
				obj.put("author", "null");
				obj.put("price","null");
				obj.put("imageUrl","null");

			}catch(Exception e){
				e.printStackTrace();

			}
			array.put(obj);
		}
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
