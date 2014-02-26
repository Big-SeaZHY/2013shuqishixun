/** 
* 2013-8-30 
* Book.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;
import java.util.Set;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long book_id;
	private String book_name;
	private double price;
	private String author;
	private String publisher;
	private String version;
	private BookType bookType;
	private int stock_count;//
	private int sale_count;//销售量
	private int collect_count;//收藏量
	private Set<Thu_img> thu_img;//缩略图
	private Set<Det_img> det_img;//详细图
	private String outline;//图书梗概
	private Set<Comments> comments;//评论
	private Set<Pur_Items> pItems;//购买项
	private Set<CollectionItems> cItems;//收藏项
	
	public Book() {
		super();
	}

	public Book(String book_name, 
			double price, 
			String author,
			String publisher,
			String version,
			int stock_count, 
			int sale_count, 
			int collect_count,
			String outline) {
		super();
		this.book_name = book_name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.version = version;
		this.stock_count = stock_count;
		this.sale_count = sale_count;
		this.collect_count = collect_count;
		this.outline = outline;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name
				+ ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getStock_count() {
		return stock_count;
	}

	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public int getCollect_count() {
		return collect_count;
	}

	public void setCollect_count(int collect_count) {
		this.collect_count = collect_count;
	}


	public Set<Thu_img> getThu_img() {
		return thu_img;
	}

	public void setThu_img(Set<Thu_img> thu_img) {
		this.thu_img = thu_img;
	}

	public Set<Det_img> getDet_img() {
		return det_img;
	}

	public void setDet_img(Set<Det_img> det_img) {
		this.det_img = det_img;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}
	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Set<CollectionItems> getcItems() {
		return cItems;
	}

	public void setcItems(Set<CollectionItems> cItems) {
		this.cItems = cItems;
	}

	public Set<Pur_Items> getpItems() {
		return pItems;
	}

	public void setpItems(Set<Pur_Items> pItems) {
		this.pItems = pItems;
	}
}
