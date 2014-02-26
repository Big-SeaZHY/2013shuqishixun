/** 
* 2013-9-2 
* Test_Hibernate.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.seu.xueZhang.entity.*;
import com.seu.xueZhang.util.*;

public class Test_Customer_Addr_Lever {

	public static void main(String[] args) {
		//2.�����Ự
		Session s=HibernateSessionFactory.getSession();
		
		//
		CustomerLevel level = new CustomerLevel("小学生ds",1.0, 500);
		
		Customer user2=new Customer("Whensdf", "123", "male", 22,10.00);
//		Customer user1=new Customer("marcy", "123", "male", 22,10.00);
		
//		user1.setLevel(level);
		user2.setLevel(level);
//		Set<Customer> users = new HashSet<Customer>();
//		users.add(user2);
//		users.add(user1);		
//		level.setUser(users);
		
		
//		Rec_Addr addr1=new Rec_Addr("SEU", "Marcy1","15999999999", "21011111333332222");
//		Rec_Addr addr2=new Rec_Addr("SEU", "Lucy1","15999999999", "21011111333332222");
//		
//		Rec_Addr addr3=new Rec_Addr("SEU", "Marcy2","15999999999", "21011111333332222");
//		Rec_Addr addr4=new Rec_Addr("SEU", "Lucy2","15999999999", "21011111333332222");
//		
//		Set<Rec_Addr> addrs1=new HashSet<Rec_Addr>();
//		Set<Rec_Addr> addrs2=new HashSet<Rec_Addr>();
//		addrs1.add(addr1);
//		addrs1.add(addr2);
//		
//		addrs2.add(addr3);
//		addrs2.add(addr4);
		
//		addr1.setUser(user1);
//		addr2.setUser(user1);
//		addr3.setUser(user2);
//		addr4.setUser(user2);
		
		
//		user1.setRec_Addrs(addrs1);
//		user2.setRec_Addrs(addrs2);

		//3.��ݳ־û�
		//3.1-��������
		s.beginTransaction();
		
		//3.2-�������
		s.save(level);
//		s.save(user1);
		s.save(user2);
		
		
		//4.�ύ����
		s.getTransaction().commit();
		
		//5.�ͷ���Դ
		s.close();
	}

}
