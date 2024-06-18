<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--1.pageContext对象可以作为域对象操作域属性--%>
<%
    pageContext.setAttribute("username", "zhangsan");
    pageContext.setAttribute("password", "123456");
    out.print("username:" + pageContext.getAttribute("username"));
    out.print("password:" + pageContext.getAttribute("password"));
    pageContext.removeAttribute("username");
    pageContext.removeAttribute("password");
%>

<%--2.pageContext对象可以用于获取其它8个隐式对象--%>
<%
    ServletRequest request1 = pageContext.getRequest();
    ServletResponse response1 = pageContext.getResponse();
    ServletConfig servletConfig = pageContext.getServletConfig();
    ServletContext servletContext = pageContext.getServletContext();
    HttpSession session1 = pageContext.getSession();
    JspWriter out1 = pageContext.getOut();
    Object page1 = pageContext.getPage();
    Exception exception = pageContext.getException();
%>


</body>
</html>
