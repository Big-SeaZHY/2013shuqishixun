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
import com.seu.xueZhang.dao.ICollectionDao;
import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.IBookShowDaoImpl;
import com.seu.xueZhang.dao.impl.ICollectionDaoImpl;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Customer;

public class AndroidCollectionSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AndroidCollectionSev() {
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

		//request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("User_name");
		String password = request.getParameter("User_password");
		System.out.println("what the fuck !!!!!!!!!!!!!!!" + name +password);
		ICustomerManagerDao icmd = new ICustomerManagerDaoImpl();
		Customer cus = icmd.checkUserByUserNameAndPassword(name, password);
		ICollectionDao icd = new ICollectionDaoImpl();
		List<Book> book = icd.queryCollectionByUserID(cus.getUser_id());


		JSONArray array = new JSONArray();

		for (Book b : book) {
			JSONObject obj = new JSONObject();

			try {
				obj.put("id", b.getBook_id());
				obj.put("name", b.getBook_name());
				System.out.println("Bookname" + b.getBook_name());
				obj.put("author", b.getAuthor());
				obj.put("price", b.getPrice());
				obj.put("imageUrl", b.getThu_img().iterator().next()
						.getThu_path());
			} catch (Exception e) {
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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
