package com.loyotech.controller;

import com.loyotech.common.Result;
import com.loyotech.pojo.Post;
import com.loyotech.pojo.QueryVo;
import com.loyotech.pojo.Reply;
import com.loyotech.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private Post post;
    @Autowired
    private Result result;
    @Autowired
    private Reply reply;
    @Autowired
    private QueryVo qv;

    /*
     * 发表帖子
     */
    @RequestMapping("/publishPost")
    @ResponseBody
    public Result publish(String userId, String title, String content, String topic) {
        post.setUserId(userId);
        post.setTitle(title);
        post.setContent(content);
        post.setTopic(topic);
        postService.publish(post);
        return result;
    }

    /*
     * 获取帖子列表（用户页面） 发送：topic    title、topic、userName、回复数、更新时间
     */
    @RequestMapping("/getPostByTopic")
    @ResponseBody
    public Result getTopic(String topic) {
        result.setMsg(postService.selectPostByTopic(topic));
        return result;
    }

    /*
     * 先获取帖子id 发送：title、userId返回：postId
     * 发送：postId返回：相应帖子的title、topic、postUserName、发帖时间postTime、内容content
     */
    @RequestMapping("/selectPostIdByTitleAndUserId")
    @ResponseBody
    public Result selectPostByTitleAndUserId(String title, String userId) {
        post.setTitle(title);
        post.setUserId(userId);
        result.setMsg(postService.selectPostIdByTitleAndUserId(post));
        return result;
    }

    @RequestMapping("/selectPostByPostId")
    @ResponseBody
    public Result selectPostByPostId(Integer postId) {
        result.setMsg(postService.selectPostByPostId(postId));
        return result;
    }

    @RequestMapping("/selectAllPost")
    @ResponseBody
    public Result selectAllPost() {
        result.setMsg(postService.selectAllPost());
        return result;
    }

    /*
     * 状态吗0 不通过，1通过，2待审核
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Result audit(Integer postId, String audit) {
        postService.updateStatus(postId, audit);
        return result;
    }

    /*
     * 发送：postId  评论内容 replyContent userName
     */
    @RequestMapping("/selectReplyByPostId")
    @ResponseBody
    public Result selectReplyByPostId(Integer postId) {
        result.setMsg(postService.selectReplyByPostId(postId));
        return result;
    }

    /*
     * 评论 发送：postId、userId、评论内容replyContent
     * 对应userId中replyNum+1
     */
    @RequestMapping("/comment")
    @ResponseBody
    public Result comment(Integer postId, String userId, String content) {
        reply.setPostId(postId);
        reply.setUserId(userId);
        reply.setContent(content);
        postService.comment(reply);
        return result;
    }

    /*
     * key  模糊查询
     */
    @RequestMapping("/selectPostByKey")
    @ResponseBody
    public Result selectPostByKey(String key) {
        result.setMsg(postService.selectPostByKey(key));
        return result;
    }

    /*
     *  分页查询
     */
    @RequestMapping("/selectPostByLimit")
    @ResponseBody
    public Result selectPostByLimit(Integer page, Integer size) {
        result.setMsg(postService.selectPostByLimit(page, size));
        return result;
    }


    /**
     *  话题topic、该topic的帖子数量
     */
    @RequestMapping("/selectPostAboutTopic")
    @ResponseBody
    public Result selectPostAboutTopic(){
        result.setMsg(postService.selectPostAboutTopic());
        return result;
    }

    /**
     * 更改话题名称
     * 发送：topic以及新更改的话题名newTopic
     * 后台：把topic改成newTopic
     */
    @RequestMapping("/updateTopic")
    @ResponseBody
    public Result updateTopic(String oldTopic, String newTopic) {    //updateTopic?oldTopic=qqqq&newTopic=1111111
        qv.setOldTopic(oldTopic);
        qv.setNewTopic(newTopic);
        postService.updateTopic(qv);
        return result;
    }

    /**
     * 删除话题
     * 发送：删除的话题名topic
     * 后台：删除该topic并删除改topic下的所有帖子
     */
    @RequestMapping("/deleteTopic")
    @ResponseBody
    public Result deleteTopic(String topic){
        postService.deleteTopic(topic);
        return result;
    }


}
