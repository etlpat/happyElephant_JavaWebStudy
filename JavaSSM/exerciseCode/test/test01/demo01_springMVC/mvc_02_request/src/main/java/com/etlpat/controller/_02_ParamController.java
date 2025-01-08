package com.etlpat.controller;

import com.etlpat.pojo.User;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


// TODO: param和json参数比较
// 在 HTTP 请求中，我们可以选择不同的参数类型，如 param 类型和 JSON 类型。下面对这两种参数类型进行区别和对比：
//  param格式："keyword=java & page=2"
//  json格式："{name:John, age:30}"
//
//  1. 参数编码：
//      param 类型的参数会被编码为 ASCII 码。例如，假设 `name=john doe`，则会被编码为 `name=john%20doe`。而 JSON 类型的参数会被编码为 UTF-8。
//  2. 参数顺序：
//      param 类型的参数没有顺序限制。但是，JSON 类型的参数是有序的。JSON 采用键值对的形式进行传递，其中键值对是有序排列的。
//  3. 数据类型：
//      param 类型的参数仅支持字符串类型、数值类型和布尔类型等简单数据类型。而 JSON 类型的参数则支持更复杂的数据类型，如数组、对象等。
//  4. 嵌套性：
//      param 类型的参数不支持嵌套。但是，JSON 类型的参数支持嵌套，可以传递更为复杂的数据结构。
//  5. 可读性：
//      param 类型的参数格式比 JSON 类型的参数更加简单、易读。但是，JSON 格式在传递嵌套数据结构时更加清晰易懂。
//
// 总的来说，param 类型的参数适用于单一的数据传递，而 JSON 类型的参数则更适用于更复杂的数据结构传递。根据具体的业务需求，需要选择合适的参数类型。
// 在实际开发中，常见的做法是：在 GET 请求中采用 param 类型的参数，而在 POST 请求中采用 JSON 类型的参数传递。


@Controller
@RequestMapping("/param")
public class _02_ParamController {
    // TODO: 如何接收前端的param参数？
    // TODO: (1)直接接收
    // 直接接收：（方法形参名 = 请求参数名），即可接收。
    // 注意：若未传递，也不报错。
    // e.g. 网址输入：/param/data1?name=root&age=18
    @RequestMapping("/data1")
    @ResponseBody
    public String data1(String name, int age) {
        String string = "接收到：name:" + name + ", age:" + age;
        System.out.println(string);
        return string;
    }


    // TODO: (2)注解指定
    // 语法：
    //      @RequestParam(value="请求参数名", required=是否必须传递, defaultValue="默认值")
    // 功能：
    //     （@RequestParam注解放在形参前，用于指定形参对应的请求参数）
    //      ①可以指定任意参数名
    //      ②可以要求必须传递（默认） / 要求不必传递，并给默认值
    // e.g. 网址输入：/param/data2?name=jimmy&age=114514
    @RequestMapping("/data2")
    @ResponseBody
    public String data2(@RequestParam(value = "name", required = true) String n,
                        @RequestParam(value = "age", required = false, defaultValue = "18") int a) {
        String string = "接收到：name:" + n + ", age:" + a;
        System.out.println(string);
        return string;
    }


    // TODO: (3)特殊情况
    // TODO: (3.1)一名多值，集合接值
    // e.g. /param/data3?hobby=吃饭1&hobby=睡觉2&hobby=打豆豆3
    // 解决方案：形参使用List集合接值。
    // 注意：使用集合接值，集合前必须添加@RequestParam注解【规定】
    @RequestMapping("/data3")
    @ResponseBody
    public String data3(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return hobby.toString();
    }


    // TODO: (3.2)使用实体类接值【重点】
    // e.g. /param/data4?name=jack&age=66
    // 解决方案：直接使用实体类User接值
    // 注意：①请求参数名必须和实体类User的属性名相对应
    //      ②形参的User对象，不需要添加@RequestParam注解（因为这种方式太常用，因此被简化了）
    @RequestMapping("/data4")
    @ResponseBody
    public String data4(User user) {
        System.out.println(user);
        return user.toString();
    }
}