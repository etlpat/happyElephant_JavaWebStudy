<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">查询学生姓名（张/李/王）</h2>
<form method="get" action="./C.jsp">
    <table align="center">
        <tr>
            <td>
                请输入要搜索的姓：
            </td>
            <td>
                <input type="text" name="lastname">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
