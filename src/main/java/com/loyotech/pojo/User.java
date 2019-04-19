package com.loyotech.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {
    private String userId;

    private String password;

    private String username;

    //value注解：当spring帮我们创建对象时，会自动注入value值，而当我们自己new出来的则是没有初始值
    private Date addTime = new Date();

    @Value("男")
    private String sex;

    @Value("0")
    private Integer postNum;

    @Value("0")
    private Integer replyNum;

    @Value("1")
    private Integer status;

    @Value("0")
    private Integer thumbUp;

    @Value("0")
    private Integer collectionNum;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", addTime=" + addTime +
                ", sex='" + sex + '\'' +
                ", postNum=" + postNum +
                ", replyNum=" + replyNum +
                ", status=" + status +
                ", thumbUp=" + thumbUp +
                ", collectionNum=" + collectionNum +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }
}
	