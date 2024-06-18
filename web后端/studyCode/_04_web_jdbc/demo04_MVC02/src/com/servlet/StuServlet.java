package com.servlet;

import com.JavaBean.Student;
import com.jdbc.StuDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stuServlet")

public class StuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 封装请求参数
        Student stu = new Student(0, req.getParameter("name"),
                req.getParameter("email"));

        // 向数据库添加元组
        StuDAO stuDAO = new StuDAO();
        boolean flag = stuDAO.insert(stu);

        // 根据flag页面跳转
        if (flag) {
            // 若成功，跳转到成功页面
            resp.sendRedirect("addSuccess.jsp");
        } else {
            // 若失败，再次回到addStu页面
            resp.sendRedirect("addStu.jsp");
        }
    }
}
