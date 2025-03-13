package com.etlpat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@ResponseBody
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!!";
    }


    // 测试properties文件定义的参数
    @RequestMapping("/testProperties")
    public String testProperties(@Value("${etlpat.pname}") String name,
                                 @Value("${etlpat.page}") Integer age) {
        return "name: " + name + ", age: " + age;
    }


    // 测试yml文件定义的参数
    @RequestMapping("/testYml")
    public String testYml(@Value("${etlpat.info.yname}") String name,// yml配置文件，DI的方式和properties文件相同
                          @Value("${etlpat.info.yage}") int age,
                          @Value("${etlpat.root.username}") String username,
                          @Value("${etlpat.root.password}") String password) {
        return "name: " + name + ", age: " + age + ", username: " + username + ", password: " + password;
    }


    // 测试激活其它的yml文件
    @RequestMapping("/testOtherYml")
    public String testOtherYml(@Value("${tmp1}") int tmp1,
                               @Value("${tmp2}") int tmp2) {
        return "tmp1: " + tmp1 + ", tmp2: " + tmp2;
    }
}
