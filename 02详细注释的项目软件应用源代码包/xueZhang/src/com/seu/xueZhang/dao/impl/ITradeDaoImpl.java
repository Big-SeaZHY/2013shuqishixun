package com.seu.xueZhang.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.ITradeDao;
import com.seu.xueZhang.entity.OrderItems;
import com.seu.xueZhang.entity.Rec_Addr;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Orders;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.entity.CustomerLevel;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class ITradeDaoImpl implements ITradeDao {


	public boolean trade(Double total, Long userID, Long bookID,
			int bookNumber,Rec_Addr address,String postCode) {
		Session s = HibernateSessionFactory.getSession();
		Transaction t=s.beginTransaction();
		//String hql="from Customer u where u.user_id = ?";
		Customer ur = (Customer) s.get(Customer.class,userID);
		Book bk = (Book) s.get(Book.class, bookID);

		//Query q = s.createQuery(hql);
		//q.setLong(0,userID);

		//List<Customer> users = q.list();
		
		double b = ur.getBalance();
		if(((b - total >= 0) && (bookNumber < bk.getStock_count())))
		{
			ur.setBalance(b - total);
			ur.setPoint((int) (ur.getPoint() + (total)/10));
			while(ur.getLevel().getStand_point() < ur.getPoint())
			{
				Long level_id = ur.getLevel().getLevel_id();
				ur.setLevel((CustomerLevel) s.get(CustomerLevel.class, level_id + 1));
			}
			
			bk.setSale_count(bk.getSale_count()+bookNumber);
			bk.setStock_count(bk.getStock_count()-bookNumber);
			s.update(ur);
			
			//生成订单
			
			Set<OrderItems> order_items = new HashSet<OrderItems>();
			
			Orders order = new Orders();
			order.setOrder_items(order_items);
			order.setPostCode(postCode);
			order.setPrice(total);
			order.setRec_addr(address.getRec_addr());
			order.setRec_idCard(address.getRec_idCard());
			order.setRec_name(address.getRec_name());
			order.setRec_phone(address.getRec_phone());
			order.setUser(ur);
			java.util.Date d = new java.util.Date();
			java.sql.Date ds = new java.sql.Date(d.getTime());
			order.setCreateDate(ds);
			s.save(order);
			
			OrderItems item = new OrderItems();
			item.setBook(bk);
			item.setPrice(bk.getPrice());
			item.setQuntity(1);
			item.setOrders(order);
			order_items.add(item);
			
			order.setOrder_items(order_items);
			s.update(order);
			
			t.commit();
			s.close();
			return true;
		}
		else
		{
			s.close();
			return false;
		}

		// TODO Auto-generated method stub

	}

}