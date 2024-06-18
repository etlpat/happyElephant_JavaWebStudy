<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./myJSP2_javaBean2.jsp" method="post">
    <table align="center" border="1px">
        <thead>
        <tr>
            <td colspan="2">
                <h3 align="center">添加图书信息</h3>
            </td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>书名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="text" name="price"></td>
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
