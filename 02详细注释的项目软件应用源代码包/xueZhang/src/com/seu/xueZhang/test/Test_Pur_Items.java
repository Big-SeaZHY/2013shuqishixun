package com.seu.xueZhang.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.seu.xueZhang.dao.impl.*;
import com.seu.xueZhang.entity.*;

public class Test_Pur_Items {
	public static void main(String args[]){
		/*ITradeDaoImpl impl = new ITradeDaoImpl();
		IaddressDaoImpl addr = new IaddressDaoImpl();
		ICustomerManagerDaoImpl cus = new ICustomerManagerDaoImpl();
		IOrdersDaoImpl ord = new IOrdersDaoImpl();*/
		
		
		//Rec_Addr rec = addr.queryAddress((long)1).get(0);
		//impl.trade((double)44, (long)1, (long)1, 3, rec, "123456");
		//System.out.println(ord.queryOrdersByUserId((long)1).iterator().next().getPrice());
		/*IPurchaseDaoImpl impl = new IPurchaseDaoImpl();
		IBookShowDaoImpl dd = new IBookShowDaoImpl();
		Book bk = dd.bookDetails((long)1);
		bk.setStock_count(bk.getStock_count()+1);
		impl.updateBook(bk);*/
		IPurchaseDaoImpl impl = new IPurchaseDaoImpl();
		//System.out.println(impl.queryPurchaseInfoByUserId((long)1).iterator().next().getQuantity());
		impl.clearPurchaseByUserId((long)1, false);
		
	}
}