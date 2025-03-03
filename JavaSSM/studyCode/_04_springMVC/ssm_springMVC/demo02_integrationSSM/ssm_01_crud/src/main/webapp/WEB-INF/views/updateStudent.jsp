<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2025/01/01
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生</title>
</head>
<body>
<h2 align="center">更新学生信息</h2>
<form action="${pageContext.request.contextPath}/student/update" method="get">
    <table align="center" border="1px">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="gender"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="number"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input type="text" name="status"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
