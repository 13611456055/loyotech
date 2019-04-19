package com.loyotech.service;

import com.loyotech.dao.PostMapper;
import com.loyotech.dao.UserMapper;
import com.loyotech.pojo.Post;
import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private UserMapper userMapper;
	
	public void publish(Post post) {
		postMapper.insert(post);
		userMapper.updatePostNum(post.getUserId());
	}

	@Override
	public List<Post> selectPostByTopic(String topic) {
		List<Post> posts = postMapper.selectPostByTopic(topic);
		return posts;
	}

	@Override
	public String selectPostIdByTitleAndUserId(Post post) {
		String postId = postMapper.selectPostIdByTitleAndUserId(post);
		return postId;
	}

	@Override
	public Post selectPostByPostId(Integer postId) {
		Post post = postMapper.selectPostByPostId(postId);
		return post;
	}

	@Override
	public List<Post> selectAllPost() {
		List<Post> posts = postMapper.selectAllPost();
		return posts;
	}

	@Override
	public void updateStatus(Integer postId, String audit) {
		if(audit.equals("pass")){
			postMapper.updateStatus1(postId);
		}else{
			postMapper.updateStatus0(postId);
		}
	}

	@Override
	public List<Reply> selectReplyByPostId(Integer postId) {
		List<Reply> replys = postMapper.selectReplyByPostId(postId);
		return replys;
	}

	@Override
	public void comment(Reply reply) {
		postMapper.comment(reply);
		userMapper.updateReplyNum(reply.getUserId());
	}

	@Override
	public List<Post> selectPostByKey(String key) {
		List<Post> posts = postMapper.selectPostByKey(key);
		return posts;
	}

	@Override
	public List<Post> selectPostByLimit(Integer page, Integer size) {
		--page ;
		page *= size ;
		String pageAndSize = page + "," +size;
		List<Post> posts = postMapper.selectPostByLimit(pageAndSize);
		return posts;
	}

	@Override
	public void updateTopic(QueryVo qv) {
		postMapper.updateTopic(qv);
	}

	@Override
	public List<QueryVo> selectPostAboutTopic() {
		List<QueryVo> qvs = postMapper.selectPostAboutTopic();
		return qvs;
	}

	@Override
	public void deleteTopic(String topic) {
		postMapper.deleteTopic(topic);
	}

}
