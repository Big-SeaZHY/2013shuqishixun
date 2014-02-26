package com.seu.xueZhang.dao.impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.seu.xueZhang.dao.IBookShowDao;
import com.seu.xueZhang.entity.Book;

import com.seu.xueZhang.entity.Det_img;
import com.seu.xueZhang.entity.Thu_img;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class IBookShowDaoImpl implements IBookShowDao{

	private final Long ID1 = (long) 9;
	private final Long ID2 = (long) 1;
	private final Long ID3 = (long) 2;
	private final Long ID4 = (long) 3;
	private final Long ID5 = (long) 4;
	private final Long ID6 = (long) 5;
	private final Long ID7 = (long) 6;
	private final Long ID8 = (long) 7;
	private final Long ID9 = (long) 8;

	
	public List<Book> bookShowInHomePage() {
		Session s = HibernateSessionFactory.getSession();
		List<Book> bo = new ArrayList<Book>();
		bo.add((Book) s.get(Book.class, ID1));
		bo.add((Book) s.get(Book.class, ID2));
		bo.add((Book) s.get(Book.class, ID3));
		bo.add((Book) s.get(Book.class, ID4));
		bo.add((Book) s.get(Book.class, ID5));
		bo.add((Book) s.get(Book.class, ID6));
		bo.add((Book) s.get(Book.class, ID7));
		bo.add((Book) s.get(Book.class, ID8));
		bo.add((Book) s.get(Book.class, ID9));
		
		s.close();
		
		// TODO Auto-generated method stub
		return bo;
	}


	public List<Book> bookQueryByKey(int type, String key) {
		try{
		String hql; 
		switch (type){
		case 1:
			hql = "from Book b where b.book_name like ?";
			break;
		case 2:
			hql = "from Book b where b.author like ?";
			break;
		case 3:
			hql = "from Book b where b.publisher like ?";
			break;
		default:
			hql = "from Book b where b.book_name like ?";
			break;				
		}
		Session s = HibernateSessionFactory.getSession();
		Query q = s.createQuery(hql);
		
		q.setString(0, "%" +key+"%");
		List<Book> bo = q.list();
		s.close();
		// TODO Auto-generated method stub
		return bo;
		}catch(Exception e ){
			return null;
		}
	}


	public List<Book> bookShowByClassify(Long typeID) {
		Session s = HibernateSessionFactory.getSession();
		String hql = "from Book where type_id = ?";
		Query q = s.createQuery(hql);
		q.setLong(0,typeID);
		List<Book> bo = q.list();
		s.close();
		// TODO Auto-generated method stub
		return bo;
	}


	public Book bookDetails(Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		Book b = (Book) s.get(Book.class, bookID);
		s.close();
		// TODO Auto-generated method stub
		return b;
	}


	public List<Det_img> findDetImgByBookID(Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		Book b = (Book) s.get(Book.class, bookID);
		Iterator<?> i = b.getDet_img().iterator();
		List<Det_img> di = new ArrayList<Det_img>();
		while(i.hasNext())
		{
			di.add((Det_img) i.next());
			System.out.println("----------");
		}
		
		//Det_img di = b.getDet_img().iterator().next();
		// TODO Auto-generated method stub
		return di;
	}


	public Thu_img findThuImgByBookID(Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		Book b = (Book) s.get(Book.class, bookID);
		Thu_img ti = b.getThu_img().iterator().next();

		return ti;

	}

}
