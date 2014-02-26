/** 
* 2013-8-30 
* Pur_Items.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;

public class Pur_Items implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5896052393698030553L;

	private Long item_id;
	private Book book;
	private int quantity;
	private Customer user;
	
	public Pur_Items(Book book, int quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}
	public Pur_Items() {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
}
