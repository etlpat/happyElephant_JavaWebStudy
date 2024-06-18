<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>


<%--
    JSP基础知识

    (1)JSP介绍
        ①基础介绍
            JSP -- Java Server Page（Java服务器页面）
            jsp的主要作用是代替Servlet程序回传html页面数据。
        ②jsp文件的创建
            .jsp文件一般存放在WEB-INF保护路径下的jsp文件夹中。
            （就像存放Servlet的src目录在项目构建后也会被转移到WEB-INF目录中一样）


    (2)JSP的本质
        jsp文件本质上是一个Servlet程序。
        jsp文件的转化流程：
            ①当Tomcat首次访问jsp文件时，会把该文件翻译为一个.java形式的Servlet源文件。
            ②同时，Tomcat将该.java文件编译为.class字节码文件。
            ③同时，Tomcat会根据该class文件生成一个Servlet对象，开始Servlet对象的生命周期。
        jsp文件特点：一次翻译，多次执行。
            （解释：首次访问会把jsp翻译成Servlet源文件，产生Servlet对象；之后可多次执行service方法处理请求）



    (3)jsp的page指令
        page指令，用于设置该jsp页面的一些属性
        语法：<%@ page 属性1 = "值1" 属性2 = "值2" ... %>
        page设置的常见属性：
            ①language="java"
                功能：表示该jsp会翻译为java源文件，暂时只支持java。
            ②contentType="text/html;charset=utf-8"
                功能：设置jsp文件返回响应体的数据的MIME类型，以及响应体的字符集。
                注意：等价于Servlet中的resp.setContentType(...)
            ③pageEncoding="UTF-8"
                功能：设置当前jsp页面字符集为utf-8。
            ④import="java.util.*"
                功能：用于导包。
            ⑤session="true"
                功能：设置是否为该jsp创建Session对象，默认为true。
            ⑥isErrorPage="false"
                功能：指定当前页面是否为错误处理页面，默认为false。
                注意：若为true，则该jsp会内置一个Exception对象exception，可以直接使用。
            ⑦errorPage="xxx.jsp"
                功能：指定若当前页面出异常后，跳转到的错误处理页面。
                注意：错误处理页面，isErrorPage为true，内置的exception对象为未捕获的异常。



    (3)jsp脚本
        ①声明脚本
            语法：<%! java声明脚本 %>
            功能：声明Servlet类的成员属性/成员方法/内部类/代码块。
            【本质】：jsp的声明脚本，转化为.java文件后，位置在Servlet类的成员声明位置(最外层)。
                    由于声明脚本直接位于Servlet类中，因此只能用来定义成员，不能用于调用成员。

        ②代码脚本
            语法：<% java代码脚本 %>
            功能：编写Servlet的service()方法中的语句。
            【本质】：jsp的代码脚本，转化为.java文件后，位置在service()方法中。
                    代码脚本和表达式脚本都位于service()方法中，其先后顺序取决于jsp脚本中的先后顺序。

        ③表达式脚本
            语法：<%= java表达式脚本 %>
            功能：向jsp网页页面输出整型/浮点型/字符串/对象。
            注意：表达式脚本，末尾不加分号。（原因：out.print(xxx)，参数不能有分号）
            【本质】：①“<%=xxx%>”等价于在jsp中调用“out.print(xxx)”。
                    ②jsp的表达式脚本，转化为.java文件后，位置在service()方法中。



    (4)jsp注释
        ①html注释
            语法：<!-- html注释 -->
            功能：在jsp的html部分使用的注释，在java脚本中不能使用。
            注意：①html注释会被翻译到java源代码中。（但是不会输出到客户端）
                 ②html注释注不掉java脚本代码，可以以此实现动态注释。

        ②java注释
            语法：// 单行java注释
                 /* 多行java注释 */
            功能：在jsp的java脚本部分使用的注释，在html中不能使用。
            注意：java注释也会被翻译到java源代码中。

        ③jsp注释
            语法：<%- jsp注释 -%>
            功能：在jsp的html部分使用的注释，在java脚本中不能使用。
                 jsp注释可以注掉jsp界面中的所有代码，是jsp中真正的注释。
            注意：jsp注释不会被翻译到java源代码中。
                 【三种注释，只有jsp注释不会被翻译到java源代码中】

--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%@ page isErrorPage="false" %>

<html>
<head>
    <title>Title</title>
</head>

<body>

<%--1.声明脚本--%>
<%!
    int a = 5;

    public int add(int a, int b) {
        return a + b;
    }
%>

<%--2.代码脚本--%>
<%
    System.out.println("service方法调用");
    out.println("service方法调用");
%>

<%--3.表达式脚本--%>
<%= 123 %>
<%= 123.456 %>
<%= "123456" %>
<%= add(1, 2) %>
<%= new Object() %>


<!-- html注释 -->
<%
    // java注释（单行）
    /* java注释（多行） */
%>
<%-- jsp注释 --%>

<!--
    动态注释
    时间为：<%=new Date()%>
 -->

</body>
</html>
