/** 
* 2013-8-30 
* Orders.java 
* author:Leon,Ma
* �û�����
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1244557333368457582L;
	
	private Long order_id;
	private String rec_addr;
	private String rec_name;
	private String rec_phone;
	private String rec_idCard;
	private String postCode;
	private double price;
	private Date createDate;
	private Set<OrderItems> order_items;
	private Customer user;

	public Orders(String rec_addr,
			String rec_name, 
			String rec_phone,
			String rec_idCard, 
			String postCode, 
			double price, 
			Date createDate) {
		super();
		this.rec_addr = rec_addr;
		this.rec_name = rec_name;
		this.rec_phone = rec_phone;
		this.rec_idCard = rec_idCard;
		this.postCode = postCode;
		this.price = price;
		this.createDate = createDate;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", rec_name=" + rec_name
				+ ", postCode=" + postCode + ", price=" + price
				+ ", createDate=" + createDate + "]";
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getRec_addr() {
		return rec_addr;
	}
	public void setRec_addr(String rec_addr) {
		this.rec_addr = rec_addr;
	}
	public String getRec_name() {
		return rec_name;
	}
	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	public String getRec_phone() {
		return rec_phone;
	}
	public void setRec_phone(String rec_phone) {
		this.rec_phone = rec_phone;
	}
	public String getRec_idCard() {
		return rec_idCard;
	}
	public void setRec_idCard(String rec_idCard) {
		this.rec_idCard = rec_idCard;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Set<OrderItems> getOrder_items() {
		return order_items;
	}
	public void setOrder_items(Set<OrderItems> order_items) {
		this.order_items = order_items;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
}
