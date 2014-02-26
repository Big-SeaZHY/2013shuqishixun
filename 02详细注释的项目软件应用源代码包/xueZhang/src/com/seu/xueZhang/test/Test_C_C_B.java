/** 
* 2013-9-4 
* Test_C_C_B.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.CollectionItems;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_C_C_B implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -114947549252144957L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Customer user = new Customer("When", "123", "male", 22, 10.00);
		Book book1 = new Book("JAVA", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		
		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		
		CollectionItems cItems = new CollectionItems(book1,user);
		
		cItems.setBook(book1);
		
		Set<CollectionItems> cit = new HashSet<CollectionItems>();
		cit.add(cItems);
		user.setCitems(cit);
		
		s.beginTransaction();
		
		s.save(book1);
		s.save(cItems);
		s.save(user);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}

}
