package com.seu.xueZhang.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.xueZhang.dao.ICommentDao;
import com.seu.xueZhang.dao.impl.ICommentDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Comments;
import com.seu.xueZhang.entity.Customer;

public class AddCommentSev extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCommentSev() {
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

		response.setContentType("text/html");

		ICommentDao comm = new ICommentDaoImpl();
		Comments com = new Comments();

		Customer user =   (Customer) request.getSession().getAttribute("user");
		Book book = (Book) request.getSession().getAttribute("book");
		
		String compoint = request.getParameter("comment");
		
		int mark;
		if (compoint == null || compoint.trim().equals(""))
            compoint = compoint + "";
        mark = Integer.parseInt(compoint);
        
		String comment = request.getParameter("commentarea");
		
		String commentR = new String(comment.getBytes("ISO-8859-1"),"UTF-8");
		
		//com.setBook(book);
		//com.setUser(user);
		com.setComments(commentR);
		com.setMark(mark);
		System.out.println("fuck THe WOrld!!!!!!!!!!!!!!"+book.getBook_id()+user.getUser_name());
		comm.addComments(book.getBook_id(), com, user.getUser_id());
		response.sendRedirect("/xueZhang/page/commentSuccess.jsp");
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
