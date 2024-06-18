package com.servlet;

import com.javaBean.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/myServlet1")

public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将请求参数封装到JavaBean对象中
        Person person = new Person(req.getParameter("username"), req.getParameter("password"));

        // 判断设否登录成功，以此返回不同的登录信息
        if ("zhangsan".equals(person.getUsername()) &&
                "123456".equals(person.getPassword())) {
            req.setAttribute("ret", "登录成功");
        } else {
            req.setAttribute("ret", "登录失败");
        }

        // 使用请求转发跳转到输出返回信息的JSP前端页面
        req.getRequestDispatcher("./WEB-INF/jsp/ret.jsp").forward(req, resp);
    }
}
