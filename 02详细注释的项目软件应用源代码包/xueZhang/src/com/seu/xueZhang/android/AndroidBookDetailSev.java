package com.seu.xueZhang.android;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

public class AndroidBookDetailSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidBookDetailSev() {
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
		doPost(request, response);
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


		String id = request.getParameter("commodity_detail");
		long bid = Long.parseLong(id);
		System.out.println("zhangyu chuanali de id +" + id);
		//response.setCharacterEncoding("UTF-8");

		//OutputStream out = response.getOutputStream();
		
		IBookShowDao ibsd = new IBookShowDaoImpl();
		

		Book b = ibsd.bookDetails(bid);
		//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		JSONArray array = new JSONArray();
		// if(!(b.equals(null)))
		// {
		JSONObject obj = new JSONObject();

		try {
			obj.put("content", b.getOutline());
			System.out.println("outline:" + b.getOutline());
			obj.put("imageUrl", b.getThu_img().iterator().next().getThu_path());
			System.out.println("imageUrl:"
					+ b.getThu_img().iterator().next().getThu_path());
		} catch (Exception e) {
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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
