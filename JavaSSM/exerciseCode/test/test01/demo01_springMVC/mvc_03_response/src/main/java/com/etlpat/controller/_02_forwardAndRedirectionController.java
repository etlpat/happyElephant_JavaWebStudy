package com.etlpat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// 【请求转发】与【响应重定向】
//
// 页面跳转分为：请求转发、响应重定向
//  ①请求转发：return "forward:/url路径"
//  ②响应重定向：return "redirect:/url路径"
//
// 注意：Ⅰ二者均需要返回url路径，而非jsp文件名！
//      Ⅱ请求转发只能发生在项目内；响应重定向即可以在项目内也可以在项目外！
//
@Controller
@RequestMapping("/farc")
public class _02_forwardAndRedirectionController {

    // TODO: 请求转发
    // 语法：return "forward:/url路径"
    // 功能：将页面转发跳转到指定url
    @RequestMapping("/forward")
    public String forward() {
        return "forward:/jsp/index";
    }


    // TODO: 响应重定向
    // 语法：return "redirect:/url路径"
    // 功能：将页面重定向跳转到指定url
    @RequestMapping("/redirect")
    public String redirect() {
//        return "redirect:/jsp/index";
        return "redirect:https://www.baidu.com/";
    }

}
