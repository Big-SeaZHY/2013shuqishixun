/** 
* 2013-8-30 
* OrderItems.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;

public class OrderItems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 501619624581571678L;

	private Long item_id;
	private int quntity;
	private double price;
	private Book book;
	private Orders orders;
	
	public OrderItems( int quntity, double price, Book book) {
		super();
		this.quntity = quntity;
		this.price = price;
		this.book = book;
	}
	public OrderItems() {
		super();
	}
	
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderItems [item_id=" + item_id + ", quntity=" + quntity
				+ ", book=" + book + "]";
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
