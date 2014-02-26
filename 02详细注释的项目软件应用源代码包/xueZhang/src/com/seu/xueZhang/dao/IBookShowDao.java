package com.seu.xueZhang.dao;



import java.util.List;

import com.seu.xueZhang.entity.Book;
import com.seu.xueZhang.entity.Det_img;
import com.seu.xueZhang.entity.Thu_img;

public interface IBookShowDao {
	public List<Book> bookShowInHomePage();
	/**
	 * bookQueryByKey()关键词搜索，type值对应的种类
	 * type = 1,按照书名
	 * type = 2,按照作者
	 * type = 3,按照出版社
	 **/
	public List<Book> bookQueryByKey(int type, String key);

	public List<Book> bookShowByClassify(Long typeID);
	public Book bookDetails(Long bookID);

	public List<Det_img> findDetImgByBookID(Long bookID);
	public Thu_img findThuImgByBookID(Long bookID);
	
}
