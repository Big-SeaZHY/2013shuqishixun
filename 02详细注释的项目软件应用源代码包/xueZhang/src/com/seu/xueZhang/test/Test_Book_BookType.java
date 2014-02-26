/** 
* 2013-9-4 
* Test_Book_BookType.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.BookType;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Book_BookType implements Serializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Book book1 = new Book("JAVA002", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		
		BookType bt = new BookType();
		bt.setBooks(books);
		s.beginTransaction();
		s.save(bt);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}

}
