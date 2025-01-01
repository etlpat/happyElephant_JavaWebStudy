package com.etlpat.controller;

import com.etlpat.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 响应(返回)json数据
//
// 1.对比@RequestBody和@ResponseBody
//  ①@RequestBody：请求体注解，表示接收json数据（用于形参列表）
//  ②@ResponseBody：响应体注解，表示返回json数据（用于类/方法上）
//
//
// 2.@ResponseBody详解
//  使用@ResponseBody注解后：
//      Ⅰ返回的实体对象，会由handlerAdapter转换为json字符串。
//      Ⅱ【不会查找视图解析器】，直接将json字符串放到响应体中返回。
//
@Controller
@RequestMapping("/json")
public class _03_jsonController {


    // TODO: 返回json数据
    // 返回json数据步骤：
    //  ①添加@ResponseBody注解，表示返回json数据
    //  ②return实体对象，会被自动转换为json数据返回
    //
    @RequestMapping("data1")
    @ResponseBody// 声明返回jsons数据
    public Person data1() {
        Person person = new Person("keke", 19810, "woman");
        return person;// return实体对象，会被自动转换为json数据返回
    }

}
