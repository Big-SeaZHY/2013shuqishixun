/** 
* 2013-8-30 
* Comments.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;
import java.sql.Date;

public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5088770122746218202L;
	private Long comment_id;
	private Book book;
	private Customer user;
	private int mark;
	private String comments;
	private Date comment_date;
	public Comments() {
		super();
	}
	
	public Long getComment_id() {
		return comment_id;
	}
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
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
