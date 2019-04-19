package com.loyotech.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Reply {

    private Integer postId;
    private Integer replyId;
    private String content;
    private String userId;
    private Date replyTime;

    @Override
    public String toString() {
        return "Reply{" +
                "postId=" + postId +
                ", replyId=" + replyId +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
