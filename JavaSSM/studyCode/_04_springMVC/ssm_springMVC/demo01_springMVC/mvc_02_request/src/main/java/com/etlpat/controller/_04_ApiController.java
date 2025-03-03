package com.etlpat.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
@ResponseBody
public class _04_ApiController {

    // TODO: 使用DI的自动装配，获取ServletContext对象
    // [ServletContext：①最大的配置文件 ②全局最大共享域 ③可以调用许多核心方法]
    @Autowired
    private ServletContext servletContext;


    // TODO: 在handler方法中，获取Servlet原生的api
    // 获取方式：通过形参列表直接获取即可！
    @RequestMapping("/data1")
    public void data1(HttpServletRequest request,
                      HttpServletResponse response,
                      HttpSession httpSession) throws Exception {
        // 使用Servlet原生对象...
    }

}
