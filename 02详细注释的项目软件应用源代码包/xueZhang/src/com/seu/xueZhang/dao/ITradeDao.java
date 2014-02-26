package com.seu.xueZhang.dao;

import com.seu.xueZhang.entity.Rec_Addr;

public interface ITradeDao {
	public boolean trade(Double total,Long userID,Long bookID,int bookNumber,Rec_Addr address,String postCode);

}
