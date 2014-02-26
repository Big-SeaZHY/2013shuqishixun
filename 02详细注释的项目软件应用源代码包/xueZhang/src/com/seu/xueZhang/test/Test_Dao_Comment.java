package com.seu.xueZhang.test;

import java.util.List;

import com.seu.xueZhang.dao.ICommentDao;
import com.seu.xueZhang.dao.impl.ICommentDaoImpl;
import com.seu.xueZhang.entity.Comments;

public class Test_Dao_Comment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICommentDao test = new ICommentDaoImpl();
		//查询评论
		
		List<Comments> l = test.lookComments((long) 9);
		System.out.println(l.get(1).getUser().getName());
		
		//添加评论
		/*
		Comments com = new Comments();
		com.setComments("刚开服，你说你不开心吗？");
		test.addComments((long)1, com,(long) 1);
		*/
		
		
		// TODO Auto-generated method stub

	}

}
