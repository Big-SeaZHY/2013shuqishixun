/** 
* 2013-9-4 
* Test_Customer_Order.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.entity.Orders;
import com.seu.xueZhang.util.HibernateSessionFactory;
public class Test_Customer_Order {
	public static void main(String[] args) {
		Session s = HibernateSessionFactory.getSession();
		Customer user = new Customer("When", "123", "male", 22, 10.00);
		
		CustomerLevel level = new CustomerLevel("小学生",1.0, 500);
		Set<Customer> users = new HashSet<Customer>();
		users.add(user);
		user.setLevel(level);
		level.setUser(users);
		
		Orders order1 = new Orders("A", "Lylu", "15677899765",
				"640221199209092114", "211189", 10, new Date(2013, 6, 5));
		Orders order2 = new Orders("A", "Lylu", "15677899765",
				"640221199209092114", "211189", 10, new Date(2013, 6, 5));
		
		Set<Orders> orders = new HashSet<Orders>();
		orders.add(order1);
		orders.add(order2);
		
		user.setOrders(orders);
		s.beginTransaction();
		
		s.save(level);
		s.save(user);
		s.save(order1);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}
}
