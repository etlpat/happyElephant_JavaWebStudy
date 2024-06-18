<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 避免中文乱码
    request.setCharacterEncoding("utf-8");
%>


<%--1.使用javaBean--%>
<jsp:useBean id="book" class="com.javaBean.Book"></jsp:useBean>


<%--2.为javaBean设置参数（获取页面传来的参数）--%>
<jsp:setProperty name="book" property="*"></jsp:setProperty>


<%--3.输出javaBean参数--%>
书名：
<jsp:getProperty name="book" property="name"/>
<br/>
作者：
<jsp:getProperty name="book" property="author"/>
<br/>
价格：
<jsp:getProperty name="book" property="price"/>
<br/>


</body>
</html>
