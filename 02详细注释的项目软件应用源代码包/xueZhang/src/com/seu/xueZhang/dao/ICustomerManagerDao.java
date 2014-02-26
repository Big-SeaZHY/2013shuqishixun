package com.seu.xueZhang.dao;

import com.seu.xueZhang.entity.Customer;

public interface ICustomerManagerDao {

	public Customer checkUserByUserNameAndPassword(String userName,String userPassword);	//used in login
	public boolean checkUserexist(String userName);//used in register
	public boolean saveNewUser(Customer user);//used in register
	public Customer queryUserInfoByUserID(Long userID);//used in query customer info
	public boolean updateUserInfo(Customer user);//used in update user info
	public String findPwdByuserIDandPhone(String userName,String phone);//used in findback pwd

}
