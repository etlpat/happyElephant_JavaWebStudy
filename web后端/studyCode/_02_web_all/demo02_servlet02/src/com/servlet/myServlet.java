package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//  注解（@WebServlet("xxx")）
//
// (1)注解介绍
//  使用注解，为该Servlet类设置映射路径
//  注解和xml两种设置映射路径的方式等价，任选其一即可
//
// (2)注解的属性
//  WebServlet注解中，常用的属性如下：
//      ①name：可为当前Servlet类起别名
//      ②urlPatterns：即当前Servlet类的映射路径
//      ③value：等价于urlPatterns属性
//  （value为该注解的默认属性，因此不需要[键="值"]的形式，也可以直接为value(urlPatterns)赋值）
//
// (3)语法
//      语法1：@WebServlet(name="myServlet",urlPatterns="/myServlet")// 通过键值对的形式为注解赋值
//      语法2：@WebServlet(name="myServlet",value="/myServlet")
//      语法3：@WebServlet("/myServlet")// 不写键，默认为value属性，即urlPatterns


// 使用注解为该Servlet类设置映射路径
@WebServlet("/myServlet")

public class myServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求报文信息
        String username = req.getParameter("username");
        String passwoed = req.getParameter("password");

        // 根据业务要求处理数据
        String tmp = "zhangsan".equals(username) && "123456".equals(passwoed) ? "<h1>yes</h1>" : "<h1>no</h1>";

        // 将处理后的数据传输给响应报文
        resp.setContentType("text/html");
        resp.getWriter().write(tmp);
    }
}
