<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/19
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="./LogInServlet">
    <table align="center" border="1px">
        <thead>
        <tr>
            <td colspan="2">
                <h3 align="center">登录用户信息</h3>
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
            <td>
                <input type="submit" name="提交">
                <input type="reset" name="重置">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
