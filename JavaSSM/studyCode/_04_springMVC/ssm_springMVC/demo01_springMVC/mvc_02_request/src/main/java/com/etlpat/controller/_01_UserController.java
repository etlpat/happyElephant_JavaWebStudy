package com.etlpat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")// 指定类的访问路径
public class _01_UserController {

    // TODO: 1.@RequestMapping(value="访问地址")
    // @RequestMapping注解：用于指定访问地址
    //
    // (1)value属性，指定访问路径
    //  ①地址格式：
    //      "/xx/xx" 或 "xx/xx" 均可
    //  ②value格式
    //      value="xxx" 或 value={"xx","xx"}
    //  ③模糊地址
    //      模糊一层：*
    //      模糊n层：**
    //  ④类和方法的@RequestMapping注解
    //      -类上添加：指定类的访问路径
    //      -方法上添加：指定方法的访问路径（必须添加）
    //      最终，访问方法的路径为：“类路径+方法路径”
    //
    // (2)method属性，指定访问方式
    //  method = GET/POST/...
    //  注意：不写默认可以使用全部方式。
    //
    @RequestMapping(value = "/login", method = RequestMethod.GET)// 指定方法的访问路径/访问方式
    public String login() {
        System.out.println("用户登录");
        return null;
    }

    @RequestMapping("/register")
    public String register() {
        System.out.println("用户注册");
        return null;
    }

}
