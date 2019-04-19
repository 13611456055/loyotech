package com.loyotech.dao;

import com.loyotech.pojo.Post;
import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {

    void insert(Post post);

	List<Post> selectPostByTopic(String topic);

	String selectPostIdByTitleAndUserId(Post post);

	Post selectPostByPostId(Integer postId);

	List<Post> selectAllPost();

	void updateStatus1(Integer postId);

	void updateStatus0(Integer postId);

	List<Reply> selectReplyByPostId(@Param("postId") Integer postId);

	void comment(Reply reply);

	//org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'topic' in 'class java.lang.String'
	List<Post> selectPostByKey(String key);

	List<Post> selectPostByLimit(@Param("pageAndSize") String pageAndSize);


	void updateTopic(QueryVo qv);

	List<QueryVo> selectPostAboutTopic();

    void deleteTopic(String topic);
}
