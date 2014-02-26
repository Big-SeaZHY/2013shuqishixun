/** 
* 2013-9-4 
* Test_Customer_Book_Common.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Comments;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Customer_Book_Common implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7864556131261425853L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Customer user = new Customer("When", "123", "male", 22, 10.00);
		Book book1 = new Book("JAVA002", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		Comments comment = new Comments();
		
		Set<Comments> comments = new HashSet<Comments>();
		comments.add(comment);
		
		user.setComments(comments);
		book1.setComments(comments);
		
		s.beginTransaction();
		s.save(user);
		s.save(book1);
		s.save(comment);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}

}
