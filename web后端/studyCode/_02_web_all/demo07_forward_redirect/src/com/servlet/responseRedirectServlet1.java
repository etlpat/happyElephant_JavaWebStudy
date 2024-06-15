package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 响应重定向
//
// (1)响应重定向语法
//  语法：resp.sendRedirect("目标资源的路径（绝对/相对）");
//
//  功能：①设置状态码为302
//       ②设置头字段location="目标资源路径";
//       （重定向：返回浏览器的响应状态码是302，浏览器会自动跳转到头字段location对应的地址）
//  注意：
//      语法：resp.sendRedirect("目标资源的路径");
//      等价于：①resp.setStatus(302);
//             ②resp.setHeader("location", "目标资源的路径");
//
//
// (2)响应重定向的特点【重点】
//  1.响应重定向是通过HttpServletResponse对象实现的。
//  2.响应重定向是在服务端提示下的，客户端的行为。（浏览器地址栏会改变）
//  3.客户端发送了多次请求，Tomcat产生了多次响应对象。
//    每重定向到一个网址，服务器都要产生一对新的请求、响应对象。
//  4.由于每个重定向的网址会产生一对新的请求、响应对象，因此请求对象中的参数不能自动传递。
//  5.响应重定向可以跳转到其它Servlet动态资源，也可以跳转到静态资源。
//  6.由于响应重定向是客户端(浏览器)的行为，因此不能跳转到WEB-INF下受保护的资源。
//  7.响应重定向可以跳转到本项目以外的外部资源。
//
//
// (3)注意事项
//  当请求转发和响应重定向都可以完成某[页面跳转]的业务逻辑时，优先使用：响应重定向


@WebServlet("/responseRedirectServlet1")

public class responseRedirectServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("responseRedirectServlet1执行了");

        // 响应重定向
        // （功能：设置状态码为302，并设置头字段location="目标资源的路径"）
        resp.sendRedirect("./responseRedirectServlet2");

    }
}
