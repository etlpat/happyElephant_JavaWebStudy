<%@ page import="com.javaBean.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>


<%--
    JavaBean的JSP语法

    (1)使用JavaBean
        语法：<jsp:useBean id="本页面中javaBean的名称" class="javaBean的类名"></jsp:useBean>

    (2)为JavaBean设置值
        ①自定义JavaBean的值
            语法：<jsp:setProperty name="本页面中javaBean的名称" property="键（成员变量名）" value="值"></jsp:setProperty>
            功能：将指定name的JavaBean的键设置值

        ②获取请求参数中的JavaBean对应的值
            语法：<jsp:setProperty name="本页面中javaBean的名称" property="*"></jsp:setProperty>
            功能：将该JavaBean的值设置为请求参数的值

    (3)输出JavaBean的键对应值
        语法：<jsp:getProperty name="本页面中javaBean的名称" property="键"></jsp:getProperty>
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--1.使用javaBean--%>
<jsp:useBean id="stu" class="com.javaBean.Student"></jsp:useBean>


<%--
    2.为javaBean设置参数值（自定义参数值）
    (默认调用set方法)
--%>
<jsp:setProperty name="stu" property="name" value="李四"></jsp:setProperty>
<jsp:setProperty name="stu" property="age" value="16"></jsp:setProperty>
<jsp:setProperty name="stu" property="sex" value="女"></jsp:setProperty>


<%--
    3.获取javaBean参数值
    (默认调用get方法)
--%>
学生姓名：
<jsp:getProperty name="stu" property="name"></jsp:getProperty>
<br/>
学生年龄：
<jsp:getProperty name="stu" property="age"></jsp:getProperty>
<br/>
学生性别：
<jsp:getProperty name="stu" property="sex"></jsp:getProperty>
<br/>
<br/>


</body>
</html>
