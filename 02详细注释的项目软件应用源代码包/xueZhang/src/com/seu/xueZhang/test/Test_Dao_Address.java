package com.seu.xueZhang.test;

import java.util.List;

import com.seu.xueZhang.dao.IAddressDao;
import com.seu.xueZhang.dao.impl.IaddressDaoImpl;
import com.seu.xueZhang.entity.Rec_Addr;

public class Test_Dao_Address {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IAddressDao test = new IaddressDaoImpl();
		Rec_Addr recAddr = new Rec_Addr("SEUCOSE", "ssadf", "34234", "123124");
		//添加地址
		/*
		 * test.addAddress((long) 13, recAddr);
		 */
		//查询地址
		/*List<Rec_Addr> l = test.queryAddress((long) 13);
			System.out.println(l.get(0).toString());
			System.out.println(l.get(1).toString());
		*/
		
		// TODO Auto-generated method stub

	}

}
