<%@ page import="com.test.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student[] students = new Student[10];
    students[0] = new Student("20240001", "张三", 18, "男");
    students[1] = new Student("20240002", "李四", 19, "女");
    students[2] = new Student("20240003", "王五", 20, "男");
    students[3] = new Student("20240004", "张六", 21, "女");
    students[4] = new Student("20240005", "李七", 22, "男");
    students[5] = new Student("20240006", "王明", 23, "女");
    students[6] = new Student("20240007", "张花", 24, "男");
    students[7] = new Student("20240008", "李哥", 25, "女");
    students[8] = new Student("20240009", "王刚", 26, "男");
    students[9] = new Student("20240010", "张黄", 27, "女");

    // 将学生数组添加到请求域对象，传送到请求响应跳转到的网址
    request.setAttribute("students", students);
    request.getRequestDispatcher("./C.jsp").forward(request, response);
%>
</body>
</html>
