package com.loyotech.service;

import com.loyotech.pojo.Post;
import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.Reply;

import java.util.List;

public interface PostService {

	void publish(Post post);

	List<Post> selectPostByTopic(String topic);

	String selectPostIdByTitleAndUserId(Post post);

	Post selectPostByPostId(Integer postId);

	List<Post> selectAllPost();

	void updateStatus(Integer postId, String audit);

	List<Reply> selectReplyByPostId(Integer postId);

	void comment(Reply reply);

	List<Post> selectPostByKey(String key);

	List<Post> selectPostByLimit(Integer page, Integer size);

	void updateTopic(QueryVo qv);

    List<QueryVo> selectPostAboutTopic();

    void deleteTopic(String topic);
}
