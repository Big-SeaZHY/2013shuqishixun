/** 
* 2013-8-30 
* CustomerLever.java 
* author:Leon,Ma
* 用户等级
*/ 
package com.seu.xueZhang.entity;

import java.io.Serializable;
import java.util.Set;

public class CustomerLevel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124280131729993588L;
	private Long level_id;
	private String level_name;
	private double counts;
	private int stand_point;
	private Set<Customer> user;
	
	
	public CustomerLevel(String level_name, 
			double counts, 
			int stand_point) {
		super();
		this.level_name = level_name;
		this.counts = counts;
		this.stand_point = stand_point;
	}

	public CustomerLevel() {
		super();
	}

	public Long getLevel_id() {
		return level_id;
	}

	public void setLevel_id(Long level_id) {
		this.level_id = level_id;
	}

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public double getCounts() {
		return counts;
	}

	public void setCounts(double counts) {
		this.counts = counts;
	}

	public int getStand_point() {
		return stand_point;
	}

	public void setStand_point(int stand_point) {
		this.stand_point = stand_point;
	}

	public Set<Customer> getUser() {
		return user;
	}

	public void setUser(Set<Customer> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CustomerLevel [level_id=" + level_id + ", level_name="
				+ level_name + ", counts=" + counts + "]";
	}
	
}
