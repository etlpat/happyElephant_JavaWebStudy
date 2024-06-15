package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/responseRedirectServlet2")

public class responseRedirectServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("responseRedirectServlet2执行了");

        resp.sendRedirect("./htmlTest1.html");// 测试跳转到静态资源htmlTest1（非保护路径）【跳转成功】
//        resp.sendRedirect("./WEB-INF/htmlTest2.html");// 测试跳转到静态资源htmlTest2（保护路径）【跳转失败】


//        resp.sendRedirect("http://www.baidu.com");// 响应重定向可以跳转到外部资源【跳转成功】
    }
}
