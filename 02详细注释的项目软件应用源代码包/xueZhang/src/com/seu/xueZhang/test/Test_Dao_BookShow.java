package com.seu.xueZhang.test;

import java.util.List;

import com.seu.xueZhang.dao.IBookShowDao;
import com.seu.xueZhang.dao.impl.IBookShowDaoImpl;
import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Det_img;
import com.seu.xueZhang.entity.Thu_img;

public class Test_Dao_BookShow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IBookShowDao test = new IBookShowDaoImpl();
		//首页展示书目
		/*
		 * List<Book> l = test.bookShowInHomePage();
		System.out.println(l.get(0).toString());
		*/
		//分类展示书目
		/*List<Book> l = test.bookShowByClassify((long) 9);
			System.out.println(l.get(0).toString());
			System.out.println(l.get(1).toString());
		*/
		//关键词查询
		/*List<Book> l = test.bookQueryByKey(3, "S");
		System.out.println(l.get(0).toString());
		System.out.println(l.get(1).toString());
		*/
		//查询书目
		/*Book b = test.bookDetails((long) 12);
		System.out.println(b.toString());
		*/
		//查看图片，缩略图和详图
			/*Det_img di = test.findDetImgByBookID((long) 1);
			Thu_img ti = test.findThuImgByBookID((long) 1);
			System.out.println(di.toString()+ti.toString());
			*/
//		List<Det_img> l = test.findDetImgByBookID((long) 1);
//		System.out.println("1: " + l.get(0).getDet_path());
//		System.out.println("2: " + l.get(1).getDet_path());

		// TODO Auto-generated method stub

	}

}
