package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


// ServletContext
//
// (1)介绍servletContext对象
//  一个web应用中只有唯一一个servletContext对象。
//  无论多少个servlet对象访问servletContext，访问的都是同一个对象。
//  servletContext是web应用程序的上下文对象，它封装了web应用的全局数据和信息，在整个应用程序中共享。
//
//
//
// (2)servletContext对象的获取
//  【servletContext对象是包含在servletConfig对象中的对象】，因此需要通过servletConfig来获取。
//  语法： ①servletConfig.getServletContext()
//        ②getServletContext()
//        ③req.getServletContext()
//  注意：以上三种获取ServletContext对象的语法，本质上都是第①种，从servletConfig中获取ServletContext。
//
//
//
// (3)ServletContext对象的功能（方法）
//  <1>获取web应用的全局初始化参数
//  全局初始化参数：
//      由Tomcat创建，被所有servlet对象所共享的初始化参数。
//      ServletContext获取初始化参数的语法和servletConfig获取servlet对象初始化参数的语法相同。
//  语法：
//      ①Enumeration getInitParameterNames();    获取包含所有全局初始化参数名的集合
//      ②String getInitParameter(String name);   获取参数名对应的参数值
//
//
//  <2>应用域属性的CRUT
//  域对象：
//      域对象是用于存储和传输数据的对象，根据传递范围不同，分为不同的域。
//      webapp中存在3大域对象，范围从大到小分别是--应用域、会话域、请求域。
//      servletContext提供的域对象是【应用域对象】，【可以在整个web应用内实现数据的共享和传递】。
//      （应用域对象的范围是整个web应用内，也就是【可以被所有servlet对象所共享】）
//  语法：
//      ①void setAttribute(String name, Object obj)
//          功能：用于创建/修改应用域属性
//          注意：若属性名不存在，则创建新属性并为其赋值；若属性名已存在，则会修改其对应的属性值
//      ②void removeAttribute(String name)
//          功能：删除应用域属性
//      ③Object getAttribute(String name)
//          功能：返回应用域属性名对应的属性值
//          注意：返回值是object类型，有时需要对其进行强制类型转换
//      ④Enumeration getAttributeNames()
//          功能：返回包含所有应用域属性名的集合
//          注意：Tomcat中会自带很多应用域属性，因此不能通过遍历该集合的方式获取自定义的域属性
//
//
//  <3>获取web应用中的文件路径
//  语法：
//      ①getRealPath("文件名/文件夹名")
//          功能：获取应用部署后，项目中指定文件/文件夹在磁盘中的真实路径（绝对路径）
//          注意：该路径是项目部署后的路径，即在out/webapps中的路径，而非源文件src中的路径
//          e.g. D:\JavaWeb\web??\studyCode\_02_web_all\out\artifacts\demo04_servletContext01_Web_exploded\WEB-INF
//      ②getContextPath()
//          功能：获取该项目的上下文路径
//          注意：上下文路径，即该项目的url中端口号后紧接着的文件路径，即在应用在webapps中部署的路径
//          e.g./demo04_servletContext01_Web_exploded
//
//
//
// (4)对比“全局初始化参数”和“应用域属性”
//  ①全局初始化参数（initParameter）：
//      在xml中配置，用于存放全局的配置信息。
//      全局初始化参数是只读的，web程序一旦启动就无法修改。
//  ②应用域属性（attribute）：
//      应用域属性是在整个应用范围中共享的属性，用于在各个servlet中传递信息。
//      应用域属性可在各个servlet中进行CRUT操作，便于数据的传递。


@WebServlet("/myServlet1")

public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>myServlet1</h1><br/>");

        // (0)获取servletContext对象
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();


        // (1)获取全局初始化参数
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();// 获取所有全局初始化参数名
        String paraName, paraValue;
        while (initParameterNames.hasMoreElements()) {// 遍历输出所有全局初始化参数
            paraName = initParameterNames.nextElement();
            paraValue = servletContext.getInitParameter(paraName);// 获取参数名对应的参数值
            resp.getWriter().write("<h2>" + paraName + ":" + paraValue + "</h2>");
        }
        resp.getWriter().write("<br/>");


        // (2)应用域属性的CRUT
        // ①创建应用域属性
        servletContext.setAttribute("attributeKey1", "attributeValue1");
        servletContext.setAttribute("attributeKey2", "attributeValue2");
        servletContext.setAttribute("attributeKey3", "attributeValue3");

        // ②查看全部应用域属性名
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println("应用域属性名：" + attributeNames.nextElement());
        }
        // 注意：
        //  除了我们自定义的域属性以外，还有很多系统自带的域属性。
        //  （全局初始化参数全部都是我们自定义的，而应用域属性有很多是系统自带的）
        //  因此，不能通过while循环的方式获取自定义的域属性值，这样会将很多系统自带属性也获取到。
        //  获取域属性，只能手动填写属性名。
        //
        // 结果如下：
        //  应用域属性名：javax.servlet.context.tempdir
        //  应用域属性名：org.apache.catalina.resources
        //  应用域属性名：org.apache.catalina.webappVersion
        //  应用域属性名：org.apache.tomcat.InstanceManager
        //  应用域属性名：org.apache.tomcat.util.threads.ScheduledThreadPoolExecutor
        //  应用域属性名：org.apache.catalina.jsp_classpath
        //  应用域属性名：attributeKet2
        //  应用域属性名：attributeKet3
        //  应用域属性名：org.apache.jasper.compiler.TldCache
        //  应用域属性名：org.apache.tomcat.JarScanner
        //  应用域属性名：attributeKet1
        //  应用域属性名：javax.websocket.server.ServerContainer

        // ③获取域属性的值
        String arrValue1 = (String) servletContext.getAttribute("attributeKey1");// 通过域属性名获取域属性值
        String arrValue2 = (String) servletContext.getAttribute("attributeKey2");
        String arrValue3 = (String) servletContext.getAttribute("attributeKey3");
        resp.getWriter().write("<h2>attributeKey1:" + arrValue1 + "<h2>");
        resp.getWriter().write("<h2>attributeKey2:" + arrValue2 + "<h2>");
        resp.getWriter().write("<h2>attributeKey3:" + arrValue3 + "<h2><br/>");


        // (3)获取web应用中的文件路径
        String realPath = servletContext.getRealPath("/WEB-INF");// 获取指定文件在磁盘中的真实路径
        String contextPath = servletContext.getContextPath();// 获取该应用的上下文路径
        resp.getWriter().write("<h2>" + realPath + "</h2>");
        resp.getWriter().write("<h2>" + contextPath + "</h2>");
    }
}
