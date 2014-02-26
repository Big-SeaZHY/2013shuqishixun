package com.seu.xueZhang.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.IOrdersDao;
import com.seu.xueZhang.entity.*;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class IOrdersDaoImpl implements IOrdersDao {
	
	public IOrdersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Set<Orders> queryOrdersByUserId(long user_Id){
		Session s = HibernateSessionFactory.getSession();
		Transaction tran = s.beginTransaction();
		Customer user = (Customer)s.get(Customer.class,user_Id);		
		
		String hql = "from Orders u where user_id = ?";
		Query q = s.createQuery(hql);
		q.setParameter(0,user.getUser_id());
		Set<Orders> orders = new HashSet<Orders>();
		List<Orders> tempOrders = q.list();
		
		String hql2 = "from OrderItems u where order_id = ?";
		q = s.createQuery(hql2);
		
		String hql3 = "from Book u where book_id = ?";
		
		for(Orders temp:tempOrders){
			q = s.createQuery(hql2);
			q.setParameter(0, temp.getOrder_id());
			List<OrderItems> orderitem = new ArrayList<OrderItems>();
			orderitem = q.list();
			Set<OrderItems> orderitem2 = new HashSet<OrderItems>();
			orderitem2.addAll(orderitem);
			q = s.createQuery(hql3);
			for(OrderItems item:orderitem2){
				Book bk = new Book();
				bk = item.getBook();
				q.setParameter(0, bk.getBook_id());
				item.setBook((Book)(q.list().get(0)));
			}
			temp.setOrder_items(orderitem2);
		}
		
		tran.commit();
		s.close();
		orders.addAll(tempOrders);
		return orders;
	}
	
	public boolean checkIn(long user_Id,double totalCount,Rec_Addr address,String postCode){
		try{
			Session s = HibernateSessionFactory.getSession();
			Transaction tran = s.beginTransaction();
			
			Customer user = (Customer)s.get(Customer.class,user_Id);
			
			Set<OrderItems> order_items = new HashSet<OrderItems>();
			
			double newBalance = user.getBalance() - totalCount;
			if(newBalance >= 0){
				user.setBalance(newBalance);
				user.setPoint((int) (user.getPoint() + (totalCount)/10));
				while(user.getLevel().getStand_point() < user.getPoint())
				{
					long level_id = user.getLevel().getLevel_id();
					user.setLevel((CustomerLevel) s.get(CustomerLevel.class, level_id + 1));
				}
				s.update(user);
				
				Book bk = new Book();
				Pur_Items pur = new Pur_Items();
				
				Set<Pur_Items> temp = user.getPitems();
				Iterator<Pur_Items> i = temp.iterator();
				
				while(i.hasNext()){
					pur = i.next();
					bk = pur.getBook();
					OrderItems item = new OrderItems();
					item.setBook(bk);
					item.setPrice(bk.getPrice());
					item.setQuntity(pur.getQuantity());
					order_items.add(item);
					bk.setSale_count(bk.getSale_count() + pur.getQuantity());
					s.update(bk);
				}
				
	
				//生成订单
				Orders order = new Orders();
				order.setUser(user);
				order.setOrder_items(order_items);
				order.setPostCode(postCode);
				order.setPrice(totalCount);
				order.setRec_addr(address.getRec_addr());
				order.setRec_idCard(address.getRec_idCard());
				order.setRec_name(address.getRec_name());
				order.setRec_phone(address.getRec_phone());
				java.util.Date d = new java.util.Date();
				java.sql.Date ds = new java.sql.Date(d.getTime());
				order.setCreateDate(ds);
				s.save(order);
				
				for(OrderItems o_item:order_items){
					o_item.setOrders(order);
					s.update(o_item);
				}
				
				tran.commit();	
				s.close();
				return true;
			}
			else return false;
		}
		catch(Exception e){
			return false;
		}
	}

}