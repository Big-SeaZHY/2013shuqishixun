/** 
* 2013-9-3 
* CollectionItems.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;

public class CollectionItems implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 500149671419001690L;
	private Long item_id;
	private Book book;
	private Customer user;
	
	public CollectionItems(Book book,Customer user) {
		super();
		this.book = book;
		this.user = user;
	}
	public CollectionItems() {
		super();
	}
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	
}
