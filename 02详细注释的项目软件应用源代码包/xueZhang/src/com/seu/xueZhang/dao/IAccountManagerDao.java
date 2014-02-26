package com.seu.xueZhang.dao;

import com.seu.xueZhang.entity.CustomerLevel;

public interface IAccountManagerDao {
	public double getBalanceByUserID(Long userID);
	public boolean recharge(Long userID,double money);
	public CustomerLevel queryUserLevelByUserID(Long userID);
	public int getPointByUserID(Long userID);
}
