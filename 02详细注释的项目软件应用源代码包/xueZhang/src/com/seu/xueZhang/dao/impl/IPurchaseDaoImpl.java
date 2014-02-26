package com.seu.xueZhang.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

import com.seu.xueZhang.dao.IPurchaseDao;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.Orders;
import com.seu.xueZhang.entity.Pur_Items;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class IPurchaseDaoImpl implements IPurchaseDao {

	public IPurchaseDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Set<Pur_Items> queryPurchaseInfoByUserId(long user_Id) {
		Session s = HibernateSessionFactory.getSession();
		Transaction tran = s.beginTransaction();
		String hql = "from Pur_Items where user_id = ?";
		Query q = s.createQuery(hql);
		q.setLong(0, user_Id);
		List<Pur_Items> l = q.list();
	//	Customer user = (Customer)s.get(Customer.class,user_Id);
	//	Book bk = new Book();
		Pur_Items temp = new Pur_Items();

		Set<Pur_Items> items= new HashSet<Pur_Items>();
		Iterator<Pur_Items> i = l.iterator();
		while(i.hasNext()){	
			temp = i.next();
//			bk = (Book)s.get(Book.class,temp.getItem_id());
//			temp.setBook(bk);
			items.add(temp);
		}

		tran.commit();
		s.close();
		return items;
	}


	public boolean addPurchase(Pur_Items item) {
		try{
			Session s = HibernateSessionFactory.getSession();	
			Transaction tran = s.beginTransaction();
			Book bk = new Book();
			bk = item.getBook();
			bk.setStock_count(bk.getStock_count() - item.getQuantity());
			s.update(bk);
			s.save(item);

			tran.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public boolean deletePurchase(long item_id) {
		try{		
			Session s = HibernateSessionFactory.getSession();	
			Transaction tran = s.beginTransaction();
			String hql="delete Pur_Items as u where u.item_id = ?";
			
			Query q = s.createQuery(hql);
			q.setLong(0, item_id);
			q.executeUpdate();
			tran.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}

		return true;
	}


	public boolean clearPurchaseByUserId(long user_Id,boolean ifbuy) {	
		try{
			Session s = HibernateSessionFactory.getSession();
			Transaction tran = s.beginTransaction();
			String hql = "from Pur_Items where user_id = ?";
			Query q = s.createQuery(hql);
			
			if(!ifbuy){		
				q.setLong(0, user_Id);			
				List<Pur_Items> items = q.list();				
				Pur_Items temp = new Pur_Items();
				Iterator<Pur_Items> i = items.iterator();
				while(i.hasNext()){	
					temp = i.next();
					Book bk = temp.getBook();
					bk.setStock_count(bk.getStock_count() + temp.getQuantity());
					
					s.update(bk);
				}
			}
		
			hql="delete Pur_Items where user_id = :id";
			
			q = s.createQuery(hql);
			q.setLong("id", user_Id);
			q.executeUpdate();
			tran.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public boolean updatePurchase(Set<Pur_Items> items) {
		try{
			Session s = HibernateSessionFactory.getSession();
			Transaction tran = s.beginTransaction();
			for (Pur_Items item:items){
				s.update(item);	
			}
			tran.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean updateBook(Book bk) {
		try{
			Session s = HibernateSessionFactory.getSession();
			Transaction tran = s.beginTransaction();
			Book book = new Book();
			book = bk;
			s.update(book);
			tran.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

}
