<%@ page import="com.test.Student" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (request.getAttribute("students") == null) {
        request.getRequestDispatcher("./M.jsp").forward(request, response);
    }

%>

<h1 align="center">学生信息表</h1>
<table align="center" border="1px" style="background-color: rgba(0,255,255,0.4)" width="300px">
    <thead style="background-color: deeppink">
    <tr>
        <td>id号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    </thead>
    <tbody>
    <%
        Student[] students = (Student[]) request.getAttribute("students");
        for (int i = 0; i < students.length; i++) {
            if (request.getParameter("lastname") != null &&
                    request.getParameter("lastname").charAt(0) != students[i].getName().charAt(0)) {
                // 若姓名和用户输入的不符，则直接介绍本次循环
                continue;
            }
            out.print("<tr>");
            out.print("<td>");
            out.print(students[i].getId());
            out.print("</td>");
            out.print("<td>");
            out.print(students[i].getName());
            out.print("</td>");
            out.print("<td>");
            out.print(students[i].getAge());
            out.print("</td>");
            out.print("<td>");
            out.print(students[i].getSex());
            out.print("</td>");
            out.print("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
