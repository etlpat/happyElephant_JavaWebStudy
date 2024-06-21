package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet(urlPatterns = "/myServlet2",
        initParams = {@WebInitParam(name = "configKey1", value = "configValue1"),
                @WebInitParam(name = "configKey2", value = "configValue2")})

public class myServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>myServlet2</h1><br/>");
        resp.setContentType("text/html");
        ServletContext servletContext = getServletConfig().getServletContext();


        // (1)在myServlet2中获取全局初始化参数
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        String paraName, paraValue;
        while (initParameterNames.hasMoreElements()) {
            paraName = initParameterNames.nextElement();
            paraValue = servletContext.getInitParameter(paraName);
            resp.getWriter().write("<h2>" + paraName + ":" + paraValue + "</h2>");
        }
        resp.getWriter().write("</br>");


        // (2)在myServlet2中获取myServlet1中定义的应用域属性
        String attName1 = "attributeKey1", attName2 = "attributeKey2", attName3 = "attributeKey3";
        Object attValue1 = servletContext.getAttribute(attName1);
        Object attValue2 = servletContext.getAttribute(attName2);
        Object attValue3 = servletContext.getAttribute(attName3);
        resp.getWriter().write("<h2>" + attName1 + ":" + attValue1 + "</h2>");
        resp.getWriter().write("<h2>" + attName2 + ":" + attValue2 + "</h2>");
        resp.getWriter().write("<h2>" + attName3 + ":" + attValue3 + "</h2><br/>");


        // (3)删除应用域属性
        servletContext.removeAttribute(attName1);
        servletContext.removeAttribute(attName2);
        servletContext.removeAttribute(attName3);

    }
}
