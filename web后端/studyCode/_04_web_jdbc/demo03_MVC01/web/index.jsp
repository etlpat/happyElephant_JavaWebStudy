<%@ page import="com.dao.DAO" %>
<%@ page import="com.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    DAO dao = new DAO();
    // 获取数据库中全部行
    ArrayList<User> all = dao.getAll();
%>

<h2 align="center">用户信息表</h2>
<table border="1" align="center" width="500px">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>密码</td>
        <td>最后登录时间</td>
    </tr>
    <%
        // 打印数据库中表格
        for (User user : all) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getLastlogintime() + "</td>");
            out.println("</tr>");
        }
    %>
</table>

<div align="center">
    <a href="insertUser.jsp"><h3>添加用户</h3></a>
</div>

</body>
</html>
