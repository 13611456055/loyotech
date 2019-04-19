package com.loyotech.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Post {
	private Integer postId;
	
	private String userId;
	
	private String title;

	private String content;
	
	private String topic;

	private Date postTime;
	
	private Integer status;

	public Post() {
		super();
	}

	public Post(String userId, String title, String content, String topic) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.topic = topic;
	}

	public Post(Integer postId, String userId, String title, String content,
			String topic,Date  postTime, Integer status) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.topic = topic;
		this.postTime = postTime;
		this.status = status;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", title="
				+ title + ", content=" + content + ", topic=" + topic
				+ ", postTime=" + postTime + ", status=" + status + "]";
	}

}
