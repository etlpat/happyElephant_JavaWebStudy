package com.servlet;

import com.javaBean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/logOutServlet")

public class LogOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ArrayList<User> logInUsers = (ArrayList<User>) session.getAttribute("logInUsers");
        logInUsers.remove((User) session.getAttribute("lastLogInUser"));

        resp.sendRedirect("logOutSuccess.jsp");
    }
}
