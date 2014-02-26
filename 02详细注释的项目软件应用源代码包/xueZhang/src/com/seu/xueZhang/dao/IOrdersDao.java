package com.seu.xueZhang.dao;

import java.util.Set;

import com.seu.xueZhang.entity.Orders;
import com.seu.xueZhang.entity.Rec_Addr;

public interface IOrdersDao {
	public Set<Orders> queryOrdersByUserId(long user_Id);
	public boolean checkIn(long user_Id,double totalCount,Rec_Addr address,String postCode);
}
