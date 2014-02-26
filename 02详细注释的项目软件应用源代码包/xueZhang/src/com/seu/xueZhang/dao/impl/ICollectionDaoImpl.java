package com.seu.xueZhang.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.ICollectionDao;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.CollectionItems;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.Pur_Items;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class ICollectionDaoImpl implements ICollectionDao {


	public List<Book> queryCollectionByUserID(Long userID) {
		List<Book> bo = new ArrayList<Book>();
		try{		

		Session s = HibernateSessionFactory.getSession();
		Transaction t = s.beginTransaction();
		Customer c = (Customer) s.get(Customer.class,userID);
		Set<CollectionItems> ci = c.getCitems();

		Iterator<CollectionItems> it =ci.iterator();
		while(it.hasNext())
		{
			bo.add(it.next().getBook());	
		}
		t.commit();
		s.close();
		return bo;
		}
		catch(Exception e){
			return null;
		}
		// TODO Auto-generated method stub

	}


	public void deleteCollection(Long userID, Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		Transaction t=s.beginTransaction();
		String hql = "from CollectionItems where user_id = ? and book_id = ?";
		Query q = s.createQuery(hql);
		q.setLong(0, userID);
		q.setLong(1, bookID);
		List<CollectionItems> ct = q.list();
		CollectionItems cl = ct.get(0);
		s.delete(cl);
		Book b = (Book) s.get(Book.class, bookID);
		b.setCollect_count(b.getCollect_count()-1);
		s.update(b);
		t.commit();
		s.close();
		// TODO Auto-generated method stub

	}


	public void addCollection(Long userID, Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		Transaction t = s.beginTransaction();
		CollectionItems ct = new CollectionItems();
	
		try{			
			String hql = "from CollectionItems  where user_id = ? and book_id = ?";
		
			Query q = s.createQuery(hql);
			q.setLong(0,userID);
			q.setLong(1,bookID);			
			List<CollectionItems> i = q.list();

			if(i.get(0).equals(null))
			{
				ct.setUser((Customer) s.get(Customer.class,userID));
				ct.setBook((Book) s.get(Book.class, bookID));
			
				s.save(ct);
				Book b = (Book) s.get(Book.class, bookID);
				b.setCollect_count(b.getCollect_count()+1);
				s.update(b);
			
				t.commit();
				s.close();
			}
			else{
				t.commit();
				s.close();
				}
			
		}
		catch(Exception e){
			ct.setUser((Customer) s.get(Customer.class,userID));
			ct.setBook((Book) s.get(Book.class, bookID));
		
			s.save(ct);
			Book b = (Book) s.get(Book.class, bookID);
			b.setCollect_count(b.getCollect_count()+1);
			s.update(b);
		
			t.commit();
			s.close();
			
		}
		
		// TODO Auto-generated method stub

	}
	
	public void clearCollection(Long userID) {
		Session s = HibernateSessionFactory.getSession();
		Transaction tran = s.beginTransaction();
		
		String hql = "from CollectionItems where user_id = ?";
		Query q = s.createQuery(hql);
		
		q.setLong(0, userID);			
		List<CollectionItems> items = q.list();				
		CollectionItems temp = new CollectionItems();
		Iterator<CollectionItems> i = items.iterator();
		while(i.hasNext()){	
			temp = i.next();
			Book bk = temp.getBook();
			bk.setCollect_count(bk.getCollect_count() - 1);
			s.update(bk);
		}
		
		hql="delete CollectionItems where user_id = :id";
		
		q = s.createQuery(hql);
		q.setLong("id", userID);
		q.executeUpdate();
		tran.commit();
		s.close();			
	}

}
