package com.loyotech.controller;

import com.loyotech.common.Result;
import com.loyotech.pojo.User;
import com.loyotech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private User user;
    @Autowired
    private Result result;

    //注册
    @RequestMapping("/register")
    @ResponseBody
    public Result register(String userId, String password) { // userId,password,username,addTime,sex,postNum,replyNum,status
        user.setUserId(userId);
        user.setPassword(password);
        user = userService.selectUserById(userId);
        if(user != null){                                      //用户名已存在
            result.setMsg("userId already exists");
        }else{
            userService.register(user);
        }
        return result;
    }

    //登陆
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String userId, String password) {
        user = userService.selectUserById(userId);
        if (user == null) {
            result.setMsg("username does not exit");
        }
        if (user.getPassword().equals(password)) {
            result.setMsg(user.getUsername());                      //登陆成功，返回用户名
        } else {
            result.setMsg("password is not correct");
        }
        return result;
    }

    /**
     * 	获取用户列表(f返回user全部数据)
     */
    @RequestMapping("selectUser")
    @ResponseBody
    public Result selectUser(){
        result.setMsg(userService.selectUser());
        return result;
    }

    /**
     * 获取用户信息
     * 发送：userId
     * 返回：userName、sex、帖子数量、回帖数量、注册时间add Time、school、status（0代表封禁，1代表正常）、被赞数、点赞数（不要）、收藏数
     */
    @RequestMapping("selectUserById")
    @ResponseBody
    public Result selectUserByUserId(String userId){
        result.setMsg(userService.selectUserById(userId));
        return result;
    }
    /**
     * 改变账号状态（封号和解封）
     * 发送：userId、状态选择userStatus（启用：start，封禁：ban）、描述describe（描述为何被封禁，可先不管）
     * 后台：根据选择改变账号状态
     */
    @RequestMapping("/updateUserStatus")
    @ResponseBody
    public Result updateUserStatus(String userId,Integer status){
        userService.updateUserStatus(userId,status);
        return result;
    }
}
