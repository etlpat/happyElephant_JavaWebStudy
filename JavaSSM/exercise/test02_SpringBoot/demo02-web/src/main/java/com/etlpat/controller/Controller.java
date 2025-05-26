package com.etlpat.controller;

import com.etlpat.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    // (1)Thymeleaf的基本使用 -- th:text
    @RequestMapping("/test01")
    public String test01(Model model) {
        // 把需要给页面共享的数据，放到Model中
        String name = "张三1";
        model.addAttribute("name", name);

        // 返回模板的逻辑视图名
        // 物理视图 = 前缀 + 逻辑视图名 + 后缀
        //  -前缀默认为："classpath:/templates/"
        //  -后缀默认为：".html"
        return "test01";
    }


    // (2)th:属性 -- 设置属性 / th:attr -- 批量设置属性
    @RequestMapping("/test02")
    public String test02(Model model) {
        String url = "2.jpg";
        String style = "width: 100px";
        model.addAttribute("url", url);
        model.addAttribute("style", style);
        return "test02";
    }


    // (3)th:if -- 若为true则显示标签，若为false则不显示标签
    @RequestMapping("/test03")
    public String test03(Model model) {
        Boolean flag = true;
        model.addAttribute("flag", flag);
        return "test03";
    }


    // (4)${}表达式/字符串拼接
    @RequestMapping("/test04")
    public String test04(Model model) {
        int num = 5;
        String name = "李四";
        model.addAttribute("num", num);
        model.addAttribute("name", name);
        return "test04";
    }


    // (5)th:each遍历集合
    @RequestMapping("/test05")
    public String test05(Model model) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1L, "张三", 15, "zs@qq.com", "pm"));
        users.add(new User(2L, "李四", 16, "ls@qq.com", "pm"));
        users.add(new User(3L, "王五", 17, "ww@qq.com", "pm"));
        users.add(new User(4L, "赵六", 18, "zl@qq.com", "admin"));
        users.add(new User(5L, "孙七", 19, "sq@qq.com", "hr"));
        model.addAttribute("users", users);
        return "test05";
    }
}
