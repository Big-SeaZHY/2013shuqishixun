/** 
* 2013-9-5 
* Test_Encoding.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import org.hibernate.Session;

import com.seu.xueZhang.entity.BookType;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Encoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		
		BookType bType =(BookType) session.get(BookType.class, (long)1);
		
		System.out.print(bType.getType_name());
	}

}
