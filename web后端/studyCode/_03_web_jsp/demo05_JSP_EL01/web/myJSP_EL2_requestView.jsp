<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">用户登录表</h1>
<form action="./myJSP_EL1.jsp" method="get">
    <table align="center" border="1px">
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="1">唱<br/>
                <input type="checkbox" name="hobby" value="2">跳<br/>
                <input type="checkbox" name="hobby" value="3">rap<br/>
                <input type="checkbox" name="hobby" value="4">篮球<br/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
