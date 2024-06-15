package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myServlet2")

public class myServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问myServlet2");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");

        // 获取当前会话的Session对象
        HttpSession session = req.getSession();

        writer.println(session.getId() + "<br/>");
        writer.println(session.isNew() + "<br/>");
        writer.println(session.getAttribute("username") + "<br/>");
        writer.println(session.getAttribute("password") + "<br/>");

    }
}
