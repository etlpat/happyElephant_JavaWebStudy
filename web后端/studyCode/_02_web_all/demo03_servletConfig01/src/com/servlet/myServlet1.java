package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


//  ServletConfig
//
// (1)ServletConfig介绍
//  ServletConfig对象存放servlet的配置信息。
//  每个servlet对象都拥有自己的ServletConfig对象。
//  servlet对象可调用getServletConfig()方法来获取自己的getServletConfig()对象。
//
//
// (2)ServletConfig接口的方法
//  ①语法：String getServletName();                功能：获取Servlet的名字
//  ②语法：Enumeration getInitParameterNames()     功能：获取包含Servlet所有初始化参数名的集合
//  ③语法：String getInitParameter(String name)    功能：获取参数名对应的参数值
//  ④语法：ServletContext getServletContext()      功能：获取ServletContext对象


public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String paraName, paraValue, servletName;


        // (1)获取servletConfig对象
        ServletConfig servletConfig = getServletConfig();// 该方法由Servlet接口定义，GenericServlet类实现，所以此处可以直接使用


        // (2)获取初始化参数名对应的参数值
        paraValue = servletConfig.getInitParameter("key1A");
        resp.getWriter().write("<h1>" + paraValue + "</h1><br/><br/>");


        // (3)获取全部初始化参数
        //  Enumeration对象的方法：
        //  ①bool hasMoreElements(); 判断有没有下一个元素，有则返回true，否则返回false
        //  ②String nextElement(); 返回当前元素，并使迭代器指向下一个元素
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            paraName = initParameterNames.nextElement();
            resp.getWriter().write("<h1>" + paraName + ":" + servletConfig.getInitParameter(paraName) + "</h1><br/>");
        }


        // (4)获取Servlet的名（别名）
        servletName = servletConfig.getServletName();
        resp.getWriter().write("<br/><h1>" + servletName + "</h1><br/>");


        // (5)获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
    }
}
