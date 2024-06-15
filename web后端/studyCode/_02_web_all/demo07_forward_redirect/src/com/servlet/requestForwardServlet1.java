package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 请求转发
//
// (0)请求转发和响应重定向概述
//  请求转发和响应重定向是web应用中间接访问项目资源的两种手段。
//  二者是Servlet控制页面跳转的两种重要手段。
//  请求转发通过HttpServletRequest实现，响应重定向通过HttpServletResponse实现。
//  现实生活举例：
//      请求转发：张三找李四借钱，李四没有，李四找王五借，王五把钱传输给了张三（张三不知道是王五借的）
//      响应重定向：张三找李四借钱，李四没有，李四让张三去找王五，张三自己再去找王五借钱。
//
//
//
// (1)请求转发语法
//  ①获取请求转发器（参数为要跳转的资源路径）
//      RequestDispatcher rd = req.getRequestDispatcher("目标资源的路径（绝对/相对）");
//  ②使请求转发器做出跳转动作（把req、resp传递给目标资源）
//      rd.forward(req, resp);
//
//
// (2)请求转发的特点【重点】
//  1.请求转发是通过HttpServletRequest对象实现的。
//  2.请求转发是服务器内部行为，对客户端是屏蔽的。（浏览器地址栏不变）
//  3.客户端只发送了一次请求，Tomcat只产生了一次响应对象。
//    这对请求、响应对象从跳转前的资源发送给了跳转后的资源。
//  4.由于全程只有一对请求、响应对象，因此请求参数和请求域中的数据可以传递到目标资源。
//  5.请求转发可以跳转到其它Servlet动态资源，也可以跳转到静态资源，从而实现页面跳转。
//  6.由于请求转发是服务器内部的行为，因此可以跳转到WEB-INF下受保护的资源。
//    （注意：WEB-INF下的资源受保护，是指在浏览器中无法直接访问该目录下的资源。但是请求转发是在服务器中实现跳转，因此可以访问）
//  7.请求转发不能跳转到本项目以外的外部资源。
//    （原因：请求转发器会把其参数的路径作为文件内部路径检索。若为其传入外部资源，检索不到，则返回404状态码）
//
//
//
// (3)绝对和相对路径
//  ①绝对路径和相对路径介绍
//      web开发中，参数的路径通常可以是绝对/相对路径。
//      注意：无论是绝对路径还是相对路径，都是【URL下的路径】。
//  ②【绝对路径】
//      语法：以“/”开头，如：“/demo7/myServlet1”
//      功能：“/”表示“http://localhost:8080/”，绝对路径是端口号后的路径。
//      注意：绝对路径通常要加上下文路径，即“/demo7/...”（可以通过servletContext.getContextPath()获取上下文路径“/demo7”）
//  ③【相对路径】
//      语法：以“./”或“../”开头，“./”可省略不写，如“./myServlet1”
//      功能：找到URL中以当前目录为开始的相对路径。
//  ④注意事项
//      【请求转发的绝对路径比较特殊】，“/”自带上下文路径。
//      e.g.请求转发中，“/”表示“http://localhost:8080/demo7/”
//      注意：请求转发中的相对路径是正常的，因此通常使用相对路径。


@WebServlet("/requestForwardServlet1")

public class requestForwardServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestForwardServlet1执行了");

        // 请求转发到requestForwardServlet2
        // ①获取请求转发器（参数为要跳转的路径）
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("./requestForwardServlet2");// 这里是目标资源的相对路径
        // ②使请求转发器做出跳转动作（把req、resp作为参数传递给要跳转的资源）
        requestDispatcher.forward(req, resp);

    }
}
