<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%--该属性设为true，则该页面会生成exception对象，用于捕获错误信息--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--用于处理异常的页面--%>
<h1 align="center">错误处理页面</h1>
<%--注意：只有isErrorPage="true"的页面才会有exception对象--%>
<h1 align="center">错误为：
    <%=exception%>
</h1>
<a> </a>
</body>
</html>
