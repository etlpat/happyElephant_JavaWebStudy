package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


// HttpServletRequest
//
// (1)HttpServletRequest介绍
//  HttpServletRequest是一个接口，其父接口是ServletRequest。
//  Tomcat会将浏览器发送来的请求报文封装成HttpServletRequest对象。
//  HttpServletRequest对象代表客户端发来的请求报文，请求中的所有信息都可以通过该对象获得。
//
//
//
// (2)HttpServletRequest中的方法
//  <1>请求行相关的方法
//      getMethod()         获取请求方式[GET/POST]
//      getScheme()         获取请求的协议[http]
//      getProtocol()       获取请求的协议和版本号[HTTP/1.1]
//      getRequestURI()     获取请求的uri[项目内的资源路径](如：/demo05/myServlet1)
//      getRequestURL()     获取请求的url[完整的资源路径](如：http://localhost:8080/demo05/myServlet1)
//
//  <2>端口号相关的方法
//      getLocalPort()      获取本应用容器的端口号[8080]
//      getServerPort()     获取客户端发送请求时的端口号[8080]
//      getRemotePort()     获取客户端浏览器的端口号[如：50405]
//
//  <3>请求头相关的方法
//      getHeaderNames()    获取由全部请求头名称构成的集合
//      getHeader(String name)  获取请求头名称对应的值
//
//  <4>【获取用户提交的参数的方法】
//  注意：以下方法，无论是请求行(GET)中的键值对参数还是请求体(POST)中的键值对参数，都可以处理
//      getParameterNames()             获取包含所有参数名的集合
//      getParameter(String name)       获取参数名对应的一个参数值
//      getParameterValues(String name) 获取参数名对应的多个参数值，返回字符串数组
//      getParameterMap()               返回包含所有参数的map集合
//
//  <5>其它相关方法
//      getServletContext() 获取ServletContext对象
//      getCookies()        获取请求中的所有Cookie
//      getSession()        获取Session对象
//
//
//
// (3)uri和url
//  ①URI：统一资源标识符
//      uri显示应用软件内的路径，即从webapps中应用资源为开始的路径
//      e.g. /demo05/myServlet1
//  ②URL：统一资源定位器
//      url是以网址的形式显示完整的文件路径
//      e.g.http://localhost:8080/demo05/myServlet1


@WebServlet("/myServlet1")

public class myServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        // (1)请求行相关的方法（HttpServletRequest）
        System.out.println(httpServletRequest.getMethod());// GET
        System.out.println(httpServletRequest.getScheme());// http
        System.out.println(httpServletRequest.getProtocol());// HTTP/1.1
        System.out.println(httpServletRequest.getRequestURI());// /demo05_httpServletRequest01_Web_exploded/myServlet1
        System.out.println(httpServletRequest.getRequestURL());// http://localhost:8080/demo05_httpServletRequest01_Web_exploded/myServlet1


        // (2)端口号相关的方法（HttpServletRequest）
        System.out.println(httpServletRequest.getLocalPort());// 8080
        System.out.println(httpServletRequest.getServerPort());// 8080
        System.out.println(httpServletRequest.getRemotePort());// 50405


        // (3)请求头相关的方法（HttpServletRequest）
        String accept = httpServletRequest.getHeader("accept");// 获取请求头名称对应的值
        System.out.println("accept:" + accept);

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();// 获取全部请求头名称
        String headerName;
        while (headerNames.hasMoreElements()) {
            headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + httpServletRequest.getHeader(headerName));
        }


        // (4)获取用户提交参数的方法（HttpServletRequest）
        // ①返回参数名对应的1个参数值
        System.out.println("------------------------------------");
        System.out.println("username=" + httpServletRequest.getParameter("username"));
        System.out.println("password=" + httpServletRequest.getParameter("password"));
        System.out.println("sex=" + httpServletRequest.getParameter("sex"));
        System.out.println("nativeplace=" + httpServletRequest.getParameter("nativeplace"));

        // ②返回参数名对应的多个参数值
        System.out.println("------------------------------------");
        String[] hobbies = httpServletRequest.getParameterValues("hobby");
        String tmp = "{";
        for (int i = 0; i < hobbies.length - 1; i++) {
            tmp += hobbies[i] + ", ";
        }
        tmp += hobbies[hobbies.length - 1] + "}";
        System.out.println("hobby=" + tmp);

        // ③获取全部参数名（从而获取全部参数）
        System.out.println("------------------------------------");
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        String paraName, sarr[];
        while (parameterNames.hasMoreElements()) {
            paraName = parameterNames.nextElement();
            sarr = httpServletRequest.getParameterValues(paraName);// 获取参数名对应的多个参数值
            if (sarr.length == 1) {// 若参数名对应一个值
                tmp = sarr[0];
            } else {// 若参数名对应多个值
                tmp = "{";
                for (int i = 0; i < sarr.length - 1; i++) {
                    tmp += sarr[i] + ", ";
                }
                tmp += sarr[sarr.length - 1] + "}";
            }
            System.out.println(paraName + "=" + tmp);
        }
    }
}
