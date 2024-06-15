package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


// 使用WebServlet注解定义Servlet初始化参数
@WebServlet(
        name = "myServlet2",// 定义Servlet的别名
        urlPatterns = "/myServlet2",// 定义Servlet的映射路径
        initParams = {@WebInitParam(name = "key2D", value = "value2D"),// 定义初始化参数
                @WebInitParam(name = "key2E", value = "value2E"),
                @WebInitParam(name = "key2F", value = "value2F")
        }
)


public class myServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 输出该Servlet对象中的所有初始化参数
        ServletConfig servletConfig = getServletConfig();// 通过servletConfig可访问到servlet的初始化参数
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();// 获取所有初始化参数名
        String paraName, paraValue;
        while (initParameterNames.hasMoreElements()) {
            paraName = initParameterNames.nextElement();// 利用迭代器获取参数名
            paraValue = servletConfig.getInitParameter(paraName);// 获取参数名对应的参数值
            resp.getWriter().write("<h1>" + paraName + ":" + paraValue + "</h1><br/>");
        }

        resp.setContentType("text/html");
    }
}
