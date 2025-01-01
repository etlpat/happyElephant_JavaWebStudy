package com.etlpat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {


    @RequestMapping("mvc/hello")// 将该handler方法加入RequestMapping中，并设置外部访问地址
    @ResponseBody// 表示不找视图，直接返回给前端
    public String helloWorld() {
        String str = "Hello World!";
        System.out.println(str);
        return str;// 返回值会被return给前端
    }


}
