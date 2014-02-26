/** 
 * 2013-8-30 
 * Thu_img.java 
 * author:Leon,Ma
 * Àı¬‘Õº
 */
package com.seu.xueZhang.entity;

import java.io.Serializable;

public class Thu_img implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1282366654898626936L;
	private Long thu_id;
	private String thu_name;
	private double thu_size;
	private String thu_path;
	private String thu_type;
	private Book book;

	public Thu_img( String thu_name, double thu_size,
			String thu_path, String thu_type) {
		super();
		this.thu_name = thu_name;
		this.thu_size = thu_size;
		this.thu_path = thu_path;
		this.thu_type = thu_type;
	}

	public Thu_img() {
		super();
	}

	@Override
	public String toString() {
		return "Thu_img [thu_id=" + thu_id + ", thu_name=" + thu_name
				+ ", thu_path=" + thu_path + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((thu_id == null) ? 0 : thu_id.hashCode());
		result = prime * result
				+ ((thu_path == null) ? 0 : thu_path.hashCode());
		return result ^ 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thu_img other = (Thu_img) obj;
		if (thu_id == null) {
			if (other.thu_id != null)
				return false;
		} else if (!thu_id.equals(other.thu_id))
			return false;
		if (thu_path == null) {
			if (other.thu_path != null)
				return false;
		} else if (!thu_path.equals(other.thu_path))
			return false;
		return true;
	}

	public Long getThu_id() {
		return thu_id;
	}

	public void setThu_id(Long thu_id) {
		this.thu_id = thu_id;
	}

	public String getThu_name() {
		return thu_name;
	}

	public void setThu_name(String thu_name) {
		this.thu_name = thu_name;
	}

	public double getThu_size() {
		return thu_size;
	}

	public void setThu_size(double thu_size) {
		this.thu_size = thu_size;
	}

	public String getThu_path() {
		return thu_path;
	}

	public void setThu_path(String thu_path) {
		this.thu_path = thu_path;
	}

	public String getThu_type() {
		return thu_type;
	}

	public void setThu_type(String thu_type) {
		this.thu_type = thu_type;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
