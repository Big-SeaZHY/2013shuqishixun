package com.seu.xueZhang.dao;

import java.util.List;

import com.seu.xueZhang.entity.Rec_Addr;

public interface IAddressDao {
	public List<Rec_Addr> queryAddress(Long userID);
	public void addAddress(Long userID,Rec_Addr recAddr);
}
