package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/requestForwardServlet2")

public class requestForwardServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestForwardServlet2执行了");

        // 请求转发到静态资源htmlTest1
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("./htmlTest1.html");// 测试跳转到静态资源htmlTest1（非保护路径）【跳转成功】
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/htmlTest2.html");// 测试跳转到静态资源htmlTest2（保护路径）【跳转成功】
        requestDispatcher.forward(req, resp);


//        req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);// 请求响应不能跳转到外部资源【跳转失败】
    }
}
