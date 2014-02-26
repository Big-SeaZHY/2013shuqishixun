/** 
* 2013-8-30 
* BookType.java 
* author:Leon,Ma
*  ÈºÆ¿‡–Õ
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;
import java.util.Set;

public class BookType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 124185432382778801L;
	
	private Long type_id;
	private String type_name;
	private Set<Book> books;
	
	public BookType(String type_name) {
		super();
		this.type_name = type_name;
	}
	public BookType() {
		super();
	}
	
	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	

}
