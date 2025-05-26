package com.etlpat.controller;

import com.etlpat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 跳转到login方法
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/test01")
    @ResponseBody
    public String test01() {
        return "hello spring security";
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "spring security home";
    }

}
