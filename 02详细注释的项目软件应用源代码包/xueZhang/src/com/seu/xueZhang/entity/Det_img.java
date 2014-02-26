/** 
* 2013-8-30 
* Det_img.java 
* author:Leon,Ma
* ÏêÏ¸Í¼
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;

public class Det_img implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4961819920698790496L;
	private double det_size;
	private Long det_id;
	private String det_name;
	private String det_path;
	private String det_type;
	private Book book;
	
	public Det_img(double det_size, 
			String det_name,
			String det_path, 
			String det_type) {
		super();
		this.det_size = det_size;
		this.det_name = det_name;
		this.det_path = det_path;
		this.det_type = det_type;
	}

	public Det_img() {
		super();
	}

	@Override
	public String toString() {
		return "Det_img [det_id=" + det_id + ", det_name=" + det_name
				+ ", det_type=" + det_type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((det_path == null) ? 0 : det_path.hashCode());
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
		Det_img other = (Det_img) obj;
		if (det_path == null) {
			if (other.det_path != null)
				return false;
		} else if (!det_path.equals(other.det_path))
			return false;
		return true;
	}

	public double getDet_size() {
		return det_size;
	}

	public void setDet_size(double det_size) {
		this.det_size = det_size;
	}

	public Long getDet_id() {
		return det_id;
	}

	public void setDet_id(Long det_id) {
		this.det_id = det_id;
	}

	public String getDet_name() {
		return det_name;
	}

	public void setDet_name(String det_name) {
		this.det_name = det_name;
	}

	public String getDet_path() {
		return det_path;
	}

	public void setDet_path(String det_path) {
		this.det_path = det_path;
	}

	public String getDet_type() {
		return det_type;
	}

	public void setDet_type(String det_type) {
		this.det_type = det_type;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
