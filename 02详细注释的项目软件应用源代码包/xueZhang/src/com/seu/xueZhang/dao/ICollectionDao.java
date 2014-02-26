package com.seu.xueZhang.dao;

import java.util.List;

import com.seu.xueZhang.entity.Book;

public interface ICollectionDao {
	public List<Book> queryCollectionByUserID(Long userID);
	
	public void deleteCollection(Long userID,Long bookID);
	public void addCollection(Long userID,Long bookID);
	public void clearCollection(Long userID);
	
}
