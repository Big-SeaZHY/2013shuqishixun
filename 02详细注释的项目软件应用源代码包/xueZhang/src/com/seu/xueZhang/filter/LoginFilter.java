/** 
* 2013-9-8 
* LoginFilter.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.filter;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
		HttpSession session = request2.getSession(true);
		
		ICustomerManagerDao temp = new ICustomerManagerDaoImpl();
		Customer tempCustomer = temp.queryUserInfoByUserID(new Long(0));
		
		StringBuffer url = request2.getRequestURL();
		String urlString = url.toString();
		String[] a = urlString.split("/");//用分隔符将url中的String取出来，以便判断
		//System.out.println("request........");
		if(a[5].equals("register.jsp")){
			session.setAttribute("user", tempCustomer);
		}
			
		else if(a[5].equals("findback.jsp")){
			session.setAttribute("user", tempCustomer);
		}
		
		Customer user = (Customer) session.getAttribute("user");
	
		if(user == null)
			request.getRequestDispatcher("../page/login.jsp").forward(request, response);
		else
			chain.doFilter(request, response);
		//System.out.println("........response");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
