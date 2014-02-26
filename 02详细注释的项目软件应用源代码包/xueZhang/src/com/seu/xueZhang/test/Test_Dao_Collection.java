package com.seu.xueZhang.test;

import java.util.List;

import com.seu.xueZhang.dao.ICollectionDao;
import com.seu.xueZhang.dao.impl.ICollectionDaoImpl;
import com.seu.xueZhang.entity.Book;

public class Test_Dao_Collection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICollectionDao test = new ICollectionDaoImpl();
		//添加商品到收藏夹
	
		/*
		 * test.addCollection((long)1, (long)1);
		 */
	
		//查询收藏夹中的物品
//		List<Book> l = test.queryCollectionByUserID((long) 1);
//		System.out.println(l.get(0).toString());
		
		//删除收藏夹中的物品
	
		/*
		 *   test.deleteCollection((long)1, (long) 1);
		 */
		
		// TODO Auto-generated method stub

	}

}
