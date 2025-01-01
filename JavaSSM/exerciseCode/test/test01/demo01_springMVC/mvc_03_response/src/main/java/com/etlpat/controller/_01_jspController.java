package com.etlpat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// TODO: handler方法返回jsp页面
//
// 补充：handler方法分析
//  ①理解handler方法的作用和组成：
//      一个controller的方法是控制层的一个处理器,我们称为handler方法
//      handler需要使用@RequestMapping/@GetMapping系列,声明路径,在HandlerMapping中注册,供DS查找!
//  ②handler作用总结:
//      1.接收请求参数(param,json,pathVariable,共享域等)
//      2.调用业务逻辑
//      3.响应前端数据(页面（不讲解模版页面跳转）,json,转发和重定向等)
//  ③handler如何处理呢:
//      1.接收参数: handler(形参列表: 主要的作用就是用来接收参数)
//      2.调用业务: { 方法体  可以向后调用业务方法 service.xx() }
//      3.响应数据: return 返回结果,可以快速响应前端数据
//  ④总结
//      请求数据接收，我们都是通过handler的形参列表
//      前端数据响应，我们都是通过handler的return关键字快速处理！
//      springmvc简化了参数接收和响应！
//


@Controller
@RequestMapping("/jsp")
public class _01_jspController {

    // TODO: handler方法返回jsp页面
    // 问：handler方法如何返回jsp页面？
    //
    // 步骤：①方法返回值为String类型
    //     ②不能添加@ResponseBody注解
    //     （@ResponseBody注解的功能是：不找视图，不走视图解析器，直接将字符串返回给浏览器）
    //     ③返回值，直接写jsp文件名即可（视图解析器会自动添加前后缀）
    //     （注意：若未设置视图解析器，需要返回jsp文件在webapp下的全限定符）
    //
    // 总结：返回普通String，默认就是返回jsp页面！
    //
    @RequestMapping("/index")
    public String index() {
        return "index1";
    }
}
