package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/myServlet2")

public class myServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();


        // (1)接收浏览器发送来的Cookie（通过请求对象接收Cookie）
        // 注意：请求头中的多个cookie会进入该数组（若请求中无cookie，则该数组为null）
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                writer.write("<h2>" + cookies[i].getName() + ":" + cookies[i].getValue() + "</h2>");
            }
        }

    }
}
