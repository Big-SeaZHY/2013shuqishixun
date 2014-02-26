package com.seu.xueZhang.dao.impl;


import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seu.xueZhang.dao.ICommentDao;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Comments;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class ICommentDaoImpl implements ICommentDao {

	public List<Comments> lookComments(Long bookID) {
		Session s = HibernateSessionFactory.getSession();
		String hql = "from Comments where book_id = ?";
		Query q = s.createQuery(hql);
		q.setLong(0, bookID);
		List<Comments> l = q.list();
		s.close();
		// TODO Auto-generated method stub
		return l;
	}


	public void addComments(Long bookID, Comments comment, Long userID) {
		Session s = HibernateSessionFactory.getSession();
		Transaction tr = s.beginTransaction();
		comment.setBook((Book) s.get(Book.class, bookID));
		comment.setUser((Customer) s.get(Customer.class, userID));
		java.util.Date d = new java.util.Date();
		java.sql.Date ds = new java.sql.Date(d.getTime());
		
		comment.setComment_date(ds);
		s.save(comment);
		tr.commit();
		s.close();
		// TODO Auto-generated method stub

	}

}
