package com.servlet;

import com.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/myDeleteServlet")

public class MyDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();

        DAO dao = new DAO();
        boolean flag = dao.delete((int) session.getAttribute("userId"));

        if (flag) {
            req.getRequestDispatcher("./deleteSuccess.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("./index.jsp").forward(req, resp);
        }
    }
}
