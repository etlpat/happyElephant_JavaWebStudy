<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--静态包含页眉jsp页面（相对路径）--%>
<%@ include file="./pageHeader.jsp" %>

<div style="background-color: green; height: 400px; width: 600px; color: deeppink">
    <h1 align="center">这是主体内容！</h1>
</div>

<%--静态包含页脚jsp页面（绝对路径）--%>
<%@ include file="/myJSP2_staticInclude/pageFooter.jsp" %>
</body>
</html>
