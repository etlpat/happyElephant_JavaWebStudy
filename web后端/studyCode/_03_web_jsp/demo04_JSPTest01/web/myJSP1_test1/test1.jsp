<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>

<%--
    案例1：jsp向客户端打印99乘法表
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--打印99乘法表--%>
<%--由于JSP中的html部分会默认被输出好响应体中，因此我们可以在java脚本中续上只有一半的html代码--%>
<table align="center" border="1px" style="background-color: aqua">
    <%
        for (int i = 1; i <= 9; i++) {
            out.print("<tr>");
            for (int j = 1; j <= i; j++) {
                out.print("<td>" + j + "*" + i + "=" + i * j + "</td>");
            }
            out.print("</tr>");
        }

    %>
</table>
</body>
</html>
