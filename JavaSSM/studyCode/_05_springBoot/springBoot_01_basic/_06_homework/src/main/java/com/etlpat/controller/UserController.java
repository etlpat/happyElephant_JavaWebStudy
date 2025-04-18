package com.etlpat.controller;

import com.etlpat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/getAllUser")
    @ResponseBody
    public String getAllUser() {
        return userService.getAllUser().toString();
    }

}
