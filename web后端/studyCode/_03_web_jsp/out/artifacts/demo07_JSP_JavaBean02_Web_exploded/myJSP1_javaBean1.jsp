<%@ page import="com.javaBean.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 13:19
  To change this template use File | Settings | File Templates.
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
