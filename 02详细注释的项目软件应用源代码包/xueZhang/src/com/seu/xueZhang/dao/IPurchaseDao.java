package com.seu.xueZhang.dao;

import java.util.Set;
import java.util.List;

import com.seu.xueZhang.entity.Pur_Items;
import com.seu.xueZhang.entity.Book;

public interface IPurchaseDao {
	public Set<Pur_Items> queryPurchaseInfoByUserId(long user_Id);
	public boolean addPurchase(Pur_Items item);
	public boolean deletePurchase(long item_id);
	public boolean clearPurchaseByUserId(long user_Id,boolean ifbuy);
	public boolean updatePurchase(Set<Pur_Items> items);
	public boolean updateBook(Book bk);
}
