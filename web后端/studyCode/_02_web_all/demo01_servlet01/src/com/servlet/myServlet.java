package com.servlet;

/*
* Servlet开发流程：
*   1.创建javaWeb项目，同时将tomcat添加为当前项目的依赖
*   2.继承HttpServlet类，重写service方法
*   3.在service方法中，定义业务处理代码
*     （接收请求、处理信息、返回响应）
*   4.在web.xml中配置Servlet对应的请求映射路径
* */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// 继承HttpServlet类，重写service方法
// （从而实现处理请求报文HttpServletRequest，并根据业务逻辑返回对应的响应报文HttpServletResponse）
public class myServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.从HttpServletRequest对象中获取请求报文的信息
        // 2.处理业务的代码
        // 3.将要响应的数据放入HttpServletResponse对象，形成响应报文

        String username = req.getParameter("username");// getParameter方法的功能是获取键对应的值（无论键值对在url后还是请求体中都可以）

        String tmp = "zhangsan".equals(username) ? "<h1>yes</h1>" : "<h1>no</h1>";

        resp.setHeader("Content-Type","text/html");// 将响应头中的Content-Type头字段设置为text/html，表示响应体中的数据是html数据（可以不写这句话，该头字段的值默认是text/html类型）
        PrintWriter writer = resp.getWriter();// 获取响应对象的响应流（该对象向响应体中打印字符）
        writer.write(tmp);// 将tmp字符串放入响应体
    }
}
