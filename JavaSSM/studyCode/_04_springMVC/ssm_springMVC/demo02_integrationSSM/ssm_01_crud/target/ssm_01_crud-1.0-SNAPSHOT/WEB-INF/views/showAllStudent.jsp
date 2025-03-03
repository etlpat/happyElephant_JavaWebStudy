<%@ page import="com.etlpat.pojo.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2025/01/01
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示全部学生</title>
</head>
<body>
<h2 align="center">学生信息表</h2>
<table align="center" border="1px">
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电话</th>
        <th>地址</th>
        <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (List<Student>) application.getAttribute("students");
        for (Student stu : students) {
            out.print("<tr>");
            out.print("<td>" + stu.getId() + "</td>");
            out.print("<td>" + stu.getName() + "</td>");
            out.print("<td>" + stu.getAge() + "</td>");
            out.print("<td>" + stu.getGender() + "</td>");
            out.print("<td>" + stu.getNumber() + "</td>");
            out.print("<td>" + stu.getAddress() + "</td>");
            out.print("<td>" + stu.getStatus() + "</td>");
            out.print("<td><a href=\""+ request.getContextPath() +"/student/gotoUpdate?id="+stu.getId()+"\">修改</a>|" +
                    "<a href=\""+ request.getContextPath() +"/student/delete?id="+stu.getId()+"\">删除</a></td>");
            out.print("</tr>");
        }
    %>
    </tbody>
</table>
<div align="center">
    <a href="${pageContext.request.contextPath}/student/gotoInsert"><h3>增加学生信息</h3></a>
</div>
</body>
</html>
