package com.etlpat.controller;

import com.etlpat.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/json")
@ResponseBody
public class _03_JsonController {

    // TODO: json参数接收
    // e.g. 当方法收到post请求体传来的json数据：{"name":"张三","age":18,"gender":"男"}
    //
    // 问题1：java原生API不支持json参数！
    // 解决步骤：①导入json处理依赖 （jar包：jackson-databind）
    //         ②在handlerAdapter配置json转换器 （在java配置类，添加@EnableWebMvc注解）
    //
    // 问题2：如何在参数列表接收json数据？
    // 解决步骤：①在参数列表设置与json数据对应的Person实体类！ （json是有层级的对象格式，因此拿实体类对象接收）
    //         ②在实体类参数前，添加@RequestBody注解！ （若不加注解，实体对象默认接收param参数；json数据通过请求体传输，因此注解为@RequestBody）
    //
    @RequestMapping(value = "/data1", method = RequestMethod.POST)
    public String data1(@RequestBody Person person) {
        System.out.println(person);
        return person.toString();
    }

}
