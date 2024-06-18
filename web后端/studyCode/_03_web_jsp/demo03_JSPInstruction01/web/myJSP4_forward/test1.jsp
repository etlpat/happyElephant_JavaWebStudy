<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是test1.jsp</h1>
<%--请求转发指令--%>
<jsp:forward page="./test2.jsp"></jsp:forward>
<%
    // 等价于如下指令：
//    request.getRequestDispatcher("./test2.jsp").forward(request, response);
%>

</body>
</html>
