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
<%--动态包含页眉jsp页面（相对路径）--%>
<jsp:include page="./pageHeader.jsp"></jsp:include>

<div style="background-color: rgba(174,123,230,0.68); height: 400px; width: 600px; color: rgb(26,36,198)">
    <h1 align="center">这是主体内容！</h1>
</div>

<%--动态包含页脚jsp页面（绝对路径）--%>
<jsp:include page="/myJSP3_%20dynamicInclude/pageFooter.jsp"></jsp:include>
</body>
</html>
