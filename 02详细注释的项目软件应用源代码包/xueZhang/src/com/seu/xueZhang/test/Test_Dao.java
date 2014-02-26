/** 
* 2013-9-2 
* Test_Dao.java 
* author:Leon,Ma
*/ 
package com.seu.xueZhang.test;





import java.sql.Date;

import org.hibernate.Session;

import com.seu.xueZhang.dao.ICustomerManagerDao;
import com.seu.xueZhang.dao.impl.ICustomerManagerDaoImpl;
import com.seu.xueZhang.entity.BookType;
import com.seu.xueZhang.entity.Customer;
import com.seu.xueZhang.util.HibernateSessionFactory;

public class Test_Dao {
	public static void main(String args[]){
		//Session s = HibernateSessionFactory.getSession();
		//BookType bt = (BookType) s.get(BookType.class, (long)1);
		//System.out.println(bt.getType_name());
		//s.close();


		ICustomerManagerDao test = new ICustomerManagerDaoImpl();
		try {
			//登陆
		
			 // Customer l = test.checkUserByUserNameAndPassword("suchen", "sdfsdf");
			//System.out.println(l.toString());
			  //if(l.)
			//	System.out.println("Nice");
			//else {
			//	System.out.println("HEHE");
			//}
			
			//注册
			//(1).检测用户名是否存在
			
			 //if(test.checkUserexist("such"))
				//System.out.println("存在");
			//else
			//	System.out.println("不存在");
				
			//(2).添加新用户	
			
			Customer c = new Customer();
			c.setUser_name("Suchhot");
			c.setPassword("su");
			c.setAge(13);
			Date birthday = new Date((new java.util.Date()).getTime());
			c.setBirthday(birthday );
		
			if(test.saveNewUser(c))
				System.out.println("好了");
			else
				System.out.println("不好");
				
			//查询个人信息		
			/*
			 * Customer c2 = test.queryUserInfoByUserID((long) 13);
			System.out.println(c2.Password);
			*/
			//找回密码
			/*
			 * System.out.print(test.findPwdByuserIDandPhone("When", "110"));
			 */
			//c2.setUser_name("SUCHHOT");
			//c2.setAge(17);
			//System.out.println(test.findPwdByuserIDandPhone("SUCHHOT", "110"));
			//修改个人信息
			/*
			 * Customer c3 = test.queryUserInfoByUserID((long) 13);
			c3.setAge(40);
			if(test.updateUserInfo(c3))
				System.out.println("sdfh");
				*/
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("马黎神经病");
		}

		
	}

}
