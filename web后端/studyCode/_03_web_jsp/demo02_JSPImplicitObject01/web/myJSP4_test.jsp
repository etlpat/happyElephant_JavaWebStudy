<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="./myJSP4_exception_errorPage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int a = 1, b = 0;
    int c = a / b;
    // 制造错误
    // 该页面遇到错误后，跳转到errorPage中指定的页面
%>
</body>
</html>
