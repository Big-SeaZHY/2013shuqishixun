package com.seu.xueZhang.test;

import com.seu.xueZhang.dao.impl.IAccountManagerDaoImpl;
import com.seu.xueZhang.entity.CustomerLevel;

public class Test_Dao_Account {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IAccountManagerDaoImpl test = new IAccountManagerDaoImpl();
		try {
			//鏌ヨ浣欓
			/*
			 * System.out.println(test.getBalanceByUserID((long) 13));
			 */
			//鏌ヨ绉垎
			/*
			 * System.out.println(test.getPointByUserID((long) 13));
			 */
			//查询用户等级
		
			  CustomerLevel l = test.queryUserLevelByUserID((long) 1);
				System.out.println(l.toString());
			
			//鍏呭�
			/*
			 * if(test.recharge((long) 13, 1000))
				System.out.println("youqianle");
			*/
			
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
//			System.out.println("椹粠绁炵粡鐥�);
		}

		// TODO Auto-generated method stub

	}

}
