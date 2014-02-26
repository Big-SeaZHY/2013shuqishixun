package com.seu.xueZhang.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.IAddressDao;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.Rec_Addr;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class IaddressDaoImpl implements IAddressDao {



	public List<Rec_Addr> queryAddress(Long userID) {
		Session s = HibernateSessionFactory.getSession();
		Customer c = (Customer) s.get(Customer.class, userID);
		List<Rec_Addr> l = new ArrayList<Rec_Addr>();
		Iterator<Rec_Addr> it = c.getRec_Addrs().iterator();
		while(it.hasNext())
		{
			l.add(it.next());
		}
		s.close();
		// TODO Auto-generated method stub
		return l;
	}

	public void addAddress(Long userID, Rec_Addr recAddr) {
		Session s = HibernateSessionFactory.getSession();
		Transaction tr = s.beginTransaction();
		Customer c = (Customer) s.get(Customer.class, userID);
		recAddr.setUser(c);
		s.save(recAddr);
		tr.commit();
		s.close();
		
		// TODO Auto-generated method stub
		
	}

}
