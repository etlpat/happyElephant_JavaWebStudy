<%--
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
<form method="post" action="./myInsertServlet">
    <table align="center" border="1">
        <thead>
        <tr>
            <td colspan="2">
                <h2 align="center">添加用户信息</h2>
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="提交"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
