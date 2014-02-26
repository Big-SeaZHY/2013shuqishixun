/** 
* 2013-9-4 
* Test_Book_img.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Det_img;
import com.seu.xueZhang.entity.Thu_img;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Book_img implements Serializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Book book1 = new Book("JAVA002", 10, "Jone", "SEUPUB", "1.0",  100, 10, 20,  "abckdeeeedd");
		Thu_img thu_img = new Thu_img("aa", 10, "I:/Photos", ".img");
		Det_img det_img = new Det_img(10, "aa", "I:/Photos", ".img");
		
		Set<Thu_img> thu_imgs = new HashSet<Thu_img>();
		thu_imgs.add(thu_img);
		Set<Det_img> det_imgs = new HashSet<Det_img>();
		det_imgs.add(det_img);
		
		book1.setThu_img(thu_imgs);
		book1.setDet_img(det_imgs);
		
		
		s.beginTransaction();
		s.save(book1);
		s.save(det_img);
		s.save(thu_img);
		//4.提交事务
		s.getTransaction().commit();
		
		//5.释放资源
		s.close();
	}

}
