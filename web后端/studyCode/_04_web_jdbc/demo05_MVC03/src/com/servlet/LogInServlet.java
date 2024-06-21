package com.servlet;

import com.javaBean.User;
import com.jdbc.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LogInServlet")

public class LogInServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        DAO dao = new DAO();

        // 获取请求中的用户信息
        User user = new User(req.getParameter("username"), req.getParameter("password"));
        session.setAttribute("lastLogInUser", user);

        // 获取用户登录对象，并判断是否已经登录过
        ArrayList<User> logInUsers = (ArrayList<User>) session.getAttribute("logInUsers");
        if (logInUsers == null) {
            // 若登录对象不存在，创建登录对象
            logInUsers = new ArrayList<>();
            session.setAttribute("logInUsers", logInUsers);
        } else {
            // 若登录对象存在，判断改用户是否已经登录
            for (User u : logInUsers) {
                if (u.getUsername().equals(user.getUsername())
                        && u.getPassword().equals(user.getPassword())) {
                    // 若已经登录，跳转到登录成功界面
                    session.setAttribute("logInInfo", "<h2>用户已登录</h2>" +
                            "<a href='./logOutServlet'><h3>退出登录</h3></a>");
                    resp.sendRedirect("./logInSuccess.jsp");
                    return;
                }
            }
        }


        // 若未登录过，登录并验证登录信息是否正确
        ArrayList<User> users = dao.getAll();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())
            && u.getPassword().equals(user.getPassword())) {
                // 用户名与密码都和登录信息匹配，将该用户添加到登录表中
                logInUsers.add(user);
                // 跳转到成功界面
                session.setAttribute("logInInfo", "<h2>用户首次登录</h2>" +
                        "<a href='./logOutServlet'><h3>退出登录</h3></a>");
                resp.sendRedirect("./logInSuccess.jsp");
                return;
            }
        }

        // 登录失败，重新登录
        resp.sendRedirect("./logInFail.jsp");
    }
}