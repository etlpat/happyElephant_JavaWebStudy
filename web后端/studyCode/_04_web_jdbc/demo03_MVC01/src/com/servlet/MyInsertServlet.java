package com.servlet;

import com.bean.RequestParamUser;
import com.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/myInsertServlet")

public class MyInsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求报文、响应报文的字符集为UTF-8，防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // ①处理请求
        // 将请求参数封装为RequestParamUser对象
        RequestParamUser requestParamUser = new RequestParamUser(req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password"));

        // ②实现业务逻辑
        // 插入学生信息表
        DAO dao = new DAO();
        boolean isInsert = dao.insert(requestParamUser);

        // ③跳转页面
        if (isInsert) {
            // 若成功，跳转到成功界面
            req.getRequestDispatcher("./insertSuccess.jsp").forward(req, resp);
        } else {
            // 若失败，重新---回到输入界面
            req.getRequestDispatcher("./insertUser.jsp").forward(req, resp);
        }

    }
}
