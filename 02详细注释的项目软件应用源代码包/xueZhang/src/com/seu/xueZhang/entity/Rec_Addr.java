package com.seu.xueZhang.entity;

import java.io.Serializable;
/** 
* 2013-8-30 
* Book.java 
* author:Leon,Ma
* 收货地址
*/ 
public class Rec_Addr implements Serializable {

	private static final long serialVersionUID = -1912678294568186665L;

	private Long addr_id;
	private String rec_addr;
	private String rec_name;
	private String rec_phone;
	private String rec_idCard;
	private Customer user;
	public Rec_Addr(){
		super();
	}
	

	public Rec_Addr(
			String rec_addr, 
			String rec_name,
			String rec_phone, 
			String rec_idCard) {
		super();
		this.rec_addr = rec_addr;
		this.rec_name = rec_name;
		this.rec_phone = rec_phone;
		this.rec_idCard = rec_idCard;
	}
	@Override
	public String toString() {
		return "Rec_Addr [addr_id=" + addr_id + ", rec_addr=" + rec_addr
				+ ", rec_name=" + rec_name + ", rec_phone=" + rec_phone
				+ ", rec_idCard=" + rec_idCard + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr_id == null) ? 0 : addr_id.hashCode());
		result = prime * result
				+ ((rec_name == null) ? 0 : rec_name.hashCode());
		return result^1;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rec_Addr other = (Rec_Addr) obj;
		if (addr_id == null) {
			if (other.addr_id != null)
				return false;
		} else if (!addr_id.equals(other.addr_id))
			return false;
		if (rec_name == null) {
			if (other.rec_name != null)
				return false;
		} else if (!rec_name.equals(other.rec_name))
			return false;
		return true;
	}
	
	
	public Long getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(Long addr_id) {
		this.addr_id = addr_id;
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
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
}
