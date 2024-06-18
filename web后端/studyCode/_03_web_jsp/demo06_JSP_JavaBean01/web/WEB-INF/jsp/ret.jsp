<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/17
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<dir align="center">
    <%--用EL表达式获取请求域属性"ret"键对应的值--%>
    <h2>${requestScope.ret}</h2>
    <%--
        注意：该页面是请求转发跳转来的，网址是myServlet1的网址，
             因此相对路径应该是相对于myServlet1的相对路径
    --%>
    <a href="./index.jsp" target="_self">返回登录界面</a>
</dir>
</body>
</html>
