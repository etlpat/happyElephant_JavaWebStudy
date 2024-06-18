<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./myServlet1" method="post">
    <table align="center" border="1px">
        <thead>
        <tr>
            <td colspan="2">
                <h3 align="center">用户登录页面</h3>
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
