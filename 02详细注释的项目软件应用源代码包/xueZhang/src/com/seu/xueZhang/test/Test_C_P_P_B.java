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
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.Pur_Items;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_C_P_P_B implements Serializable {

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
		Customer user = new Customer("When001", "123", "male", 22, 10.00);
		Book book1 = new Book("JAVA001", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		
		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		
		Pur_Items pItems = new Pur_Items(book1,5);
		
		pItems.setBook(book1);
		
		Set<Pur_Items> pit = new HashSet<Pur_Items>();
		pit.add(pItems);
		user.setPitems(pit);
		
		s.beginTransaction();
		
		s.save(user);
		s.save(book1);
		s.save(pItems);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}

}
