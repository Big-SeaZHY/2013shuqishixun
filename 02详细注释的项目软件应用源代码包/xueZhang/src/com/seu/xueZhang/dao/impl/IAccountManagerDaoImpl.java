package com.seu.xueZhang.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.IAccountManagerDao;
import com.seu.xueZhang.entity.CollectionItems;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class IAccountManagerDaoImpl implements IAccountManagerDao {

	public IAccountManagerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getBalanceByUserID(Long userID) {
		Session s = HibernateSessionFactory.getSession();
		Customer c = (Customer) s.get(Customer.class, userID);
		s.close();

		return c.getBalance();
	}

	public boolean recharge(Long userID, double money) {
		try{
		Session s = HibernateSessionFactory.getSession();
		Transaction t=s.beginTransaction();

		Customer c = (Customer) s.get(Customer.class, userID);
		double b = c.getBalance();
		b = b +money;
		c.setBalance(b);
		
		s.update(c);
		t.commit();
		s.close();
		return true;
		}catch(Exception e){
		return false;
		}
	}

	public CustomerLevel queryUserLevelByUserID(Long userID) {
		Session s = HibernateSessionFactory.getSession();
		Customer c = (Customer) s.get(Customer.class, userID);
		int p = c.getPoint();
		String hql = "from CustomerLevel where stand_point > ?";
		Query q = s.createQuery(hql);
		q.setInteger(0, p);
		List<CustomerLevel> cl = q.list();
		s.close();
		// TODO Auto-generated method stub
		return 	cl.get(0);
	}

	public int getPointByUserID(Long userID) {
		Session s = HibernateSessionFactory.getSession();

		Customer c = (Customer) s.get(Customer.class, userID);

		s.close();
		// TODO Auto-generated method stub
		return c.getPoint();
	}


}
