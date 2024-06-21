package com.servlet;

import com.bean.RequestParamUser;
import com.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/myUpdateServlet")

public class MyUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();

        RequestParamUser requestParamUser = new RequestParamUser(req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password"));

        DAO dao = new DAO();
        boolean flag = dao.update((int) session.getAttribute("userId"), requestParamUser);

        if (flag) {
            req.getRequestDispatcher("./updateSuccess.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("./updateUser.jsp").forward(req, resp);
        }
    }
}
