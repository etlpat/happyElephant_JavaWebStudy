<%@ page import="com.jdbc.StuDAO" %>
<%@ page import="com.JavaBean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/18
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
    StuDAO dao = new StuDAO();
    ArrayList<Student> students = dao.getAll();
%>
<h2 align="center">学生信息表</h2>
<table align="center" width="250px" border="1px">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
    </tr>
    <%
        for (Student stu : students) {
            out.print("<tr>");
            out.print("<td>" + stu.getId() + "</td>");
            out.print("<td>" + stu.getName() + "</td>");
            out.print("<td>" + stu.getEmail() + "</td>");
            out.print("</tr>");
        }
    %>
</table>
<div align="center">
    <a href="addStu.jsp"><h3>增加学生信息</h3></a>
</div>
</body>
</html>
