package com.servlet;

import com.javaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();

        // 获取请求中的用户信息
        User user = new User(req.getParameter("username"), req.getParameter("password"));

        // 遍历查看用户是否注册过
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals(user.getUsername())) {
                if (cookie.getName().substring(0, "username".length()).equals("username")) {
                    // 用户注册重复，重新注册
                    req.getRequestDispatcher("./registerFail.jsp").forward(req, resp);
                }
            }
        }

        // 获取用户名/密码的Cookie尾号（尾号表示已存储的用户信息个数）
        Integer registerTail = (Integer) session.getAttribute("registerTail");
        if (registerTail == null) {
            registerTail = 0;
        }
        registerTail = registerTail + 1;
        session.setAttribute("registerTail", registerTail);

        // 将本次的用户存入Cookie放入浏览器中
        resp.addCookie(new Cookie("username" + registerTail, req.getParameter("username")));
        resp.addCookie(new Cookie("password" + registerTail, req.getParameter("password")));

        // 跳转到登录界面
        resp.sendRedirect("./registerSuccess.jsp");
    }
}
