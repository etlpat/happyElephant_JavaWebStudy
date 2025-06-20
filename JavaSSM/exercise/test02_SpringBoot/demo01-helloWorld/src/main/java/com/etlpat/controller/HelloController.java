package com.etlpat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")// 通过该路径，访问本方法
    @ResponseBody// 表示返回json形式数据
    public String helloWorld() {
        return "Hello World！！！";
    }
}
