package com.loyotech.pojo;

import org.springframework.stereotype.Component;


@Component
public class QueryVo {

    private String topic;
    private Integer topicNum;
    private String oldTopic;
    private String newTopic;
    private String userId;
    private Integer status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOldTopic() {
        return oldTopic;
    }

    public void setOldTopic(String oldTopic) {
        this.oldTopic = oldTopic;
    }

    public String getNewTopic() {
        return newTopic;
    }

    public void setNewTopic(String newTopic) {
        this.newTopic = newTopic;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "topic='" + topic + '\'' +
                ", topicNum=" + topicNum +
                ", oldTopic='" + oldTopic + '\'' +
                ", newTopic='" + newTopic + '\'' +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }
}
