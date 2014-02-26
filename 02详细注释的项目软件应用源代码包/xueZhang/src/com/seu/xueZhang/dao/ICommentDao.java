package com.seu.xueZhang.dao;

import java.util.List;

import com.seu.xueZhang.entity.Comments;

public interface ICommentDao {
	public List<Comments> lookComments(Long bookID);
	public void addComments(Long bookID,Comments comment,Long userID);

}
