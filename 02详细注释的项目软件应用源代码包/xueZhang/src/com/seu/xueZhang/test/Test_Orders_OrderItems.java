/** 
* 2013-9-4 
* Test_Orders_OrderItems.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.OrderItems;
import com.seu.xueZhang.entity.Orders;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Orders_OrderItems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -142609272531144599L;
	public static void main(String[] args) {
		Session s = HibernateSessionFactory.getSession();
		Orders order1 = new Orders("A", "Lylu", "15677899765",
				"640221199209092114", "211189", 10, new Date(2013, 6, 5));
		
		Book book1 = new Book("JAVA", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		Book book2 = new Book("JAVA", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");

		OrderItems item1 = new OrderItems(1, 20, book1);
		OrderItems item2 = new OrderItems(1,22,book2);
		Set<OrderItems> items = new HashSet<OrderItems>();
		items.add(item1);
		items.add(item2);
		order1.setOrder_items(items);
		
		s.beginTransaction();
		
		s.save(order1);
		s.getTransaction().commit();
		
		s.close();
	}
}
