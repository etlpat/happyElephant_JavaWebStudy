package com.etlpat.controller;

import com.etlpat.pojo.User;
import com.etlpat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() {
        List<User> users = userService.findAll();
        return users.toString();
    }
}
