package com.seu.xueZhang.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class ICustomerManagerDaoImpl implements ICustomerManagerDao {

	
	public ICustomerManagerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer checkUserByUserNameAndPassword(String userName,
			String userPassword) {
		try{
		Session s = HibernateSessionFactory.getSession();
		String hql="from Customer u where user_name = ? and password = ?";

		Query q = s.createQuery(hql);
		q.setString(0, userName);
		q.setString(1, userPassword);
		
		List<Customer> users = q.list();
		
		s.close();
		return users.get(0);
		}catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}


	public boolean checkUserexist(String userName) {
		Session s = HibernateSessionFactory.getSession();
		String hql="from Customer u where u.user_name = ?";

		Query q = s.createQuery(hql);
		q.setString(0, userName);
		
		List<Customer> users = q.list();
		s.close();
		//System.out.println(users.get(0).getUser_name());
		if(users.isEmpty())
			return true;//���Ϊ�գ���û������û����˻����Ϊ����ע��
		else
			return false;
	}


	public boolean saveNewUser(Customer user) {
		final int initialPoint = 0;
		final double initialBalance = 1000;
		user.setBalance(initialBalance);
		user.setPoint(initialPoint);
		Session s = HibernateSessionFactory.getSession();
		try{

			String hql="from CustomerLevel ul where ul.stand_point = ?";

			Transaction t=s.beginTransaction(); 

			Query q = s.createQuery(hql);
			q.setInteger(0, 99);
			
			List<CustomerLevel> uls = q.list();
			CustomerLevel level = uls.get(0);
			user.setLevel(level);
			s.save(user);
			t.commit();
			s.close();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}


	public Customer queryUserInfoByUserID(Long userID) {
		Session s = HibernateSessionFactory.getSession();
		//String hql="from Customer u where u.user_id = ?";
		Customer ur = (Customer) s.get(Customer.class, userID);
		//Query q = s.createQuery(hql);
		//q.setLong(0, userID);
		
		//List<Customer> users = q.list();
		
		s.close();
		return ur;
	}


	public boolean updateUserInfo(Customer user) {
		Session s = HibernateSessionFactory.getSession();
		try{
			Transaction t=s.beginTransaction();
			s.update(user);		
			t.commit();
			s.close();
		}catch(Exception e){
			return false;
		}
		return true;

		
	}


	public String findPwdByuserIDandPhone(String userName,String phone) {
		try{
		Session s = HibernateSessionFactory.getSession();
		String hql="from Customer u where u.user_name = ? and u.phone = ?";

		Query q = s.createQuery(hql);
		q.setString(0, userName);
		q.setString(1, phone);		
		
		List<Customer> users = q.list();
		s.close();
		return 	users.get(0).getPassword();
		}catch(Exception e){
			return null;
		}
		

	}

}
