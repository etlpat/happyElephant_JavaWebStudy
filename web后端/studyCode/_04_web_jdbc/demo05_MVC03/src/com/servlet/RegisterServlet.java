package com.servlet;

import com.javaBean.User;
import com.jdbc.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;



@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DAO dao = new DAO();

        // 获取请求中的用户信息
        User user = new User(req.getParameter("username"), req.getParameter("password"));

        // 将用户信息添加到注册表
        boolean flag = dao.insert(user);

        // 根据添加结果跳转界面
        if (flag) {
            resp.sendRedirect("registerSuccess.jsp");
        } else {
            resp.sendRedirect("registerFail.jsp");
        }
    }
}
