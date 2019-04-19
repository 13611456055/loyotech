package com.loyotech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author heiMaPG
 * @create 2019-04-17 15:56
 */
@Controller
public class helloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hah(){
        System.out.println("hello~~~");
        return "hello~";
    }
}
