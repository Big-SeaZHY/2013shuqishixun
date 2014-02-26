package com.seu.xueZhang.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
/** 
* 2013-8-30 
* Book.java 
* author:Leon,Ma
* 用户信息
*/ 
public class Customer implements Serializable {

	private static final long serialVersionUID = 2175055773152489687L;
	//***********************必需信息*************************************
	private Long user_id;
	private String user_name;
	private int point;
	private CustomerLevel  level;
	private String password;
	private double balance;
	//***********************非必需信息*************************************
	private String name;//用户真实姓名
	private String sex;
	private Date birthday;
	private int age;
	private String phone;
	private String email;
	private String home_addr;//用户的家庭住址
	private String idCard;
	private Set<Rec_Addr> rec_Addrs;
	private Set<Comments> comments;
	private Set<Orders> orders;
	private Set<CollectionItems> citems;
	private Set<Pur_Items> pitems;
	
	
	public Customer() {
		super();
	}

	public Customer(String user_name, String password, String sex, int age,
			double balance) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", user_name=" + user_name
				+ ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result
				+ ((user_name == null) ? 0 : user_name.hashCode());
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
		Customer other = (Customer) obj;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public CustomerLevel getLevel() {
		return level;
	}

	public void setLevel(CustomerLevel level) {
		this.level = level;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome_addr() {
		return home_addr;
	}

	public void setHome_addr(String home_addr) {
		this.home_addr = home_addr;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<Rec_Addr> getRec_Addrs() {
		return rec_Addrs;
	}

	public void setRec_Addrs(Set<Rec_Addr> rec_Addrs) {
		this.rec_Addrs = rec_Addrs;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<CollectionItems> getCitems() {
		return citems;
	}

	public void setCitems(Set<CollectionItems> citems) {
		this.citems = citems;
	}

	public Set<Pur_Items> getPitems() {
		return pitems;
	}

	public void setPitems(Set<Pur_Items> pitems) {
		this.pitems = pitems;
	}

}
