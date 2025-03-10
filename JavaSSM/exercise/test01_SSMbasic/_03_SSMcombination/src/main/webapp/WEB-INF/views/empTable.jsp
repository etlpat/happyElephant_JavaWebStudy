<%@ page import="com.etlpat.pojo.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工表</title>
</head>
<body>
<h2 align="center">员工表</h2>
<table align="center" border="1px" width="600">
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>薪水</th>
        <th>改/删</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employees = (List<Employee>) application.getAttribute("employees");
        for (Employee emp : employees) {
            out.print("<tr>");
            out.print("<td>" + emp.getEmpId() + "</td>");
            out.print("<td>" + emp.getEmpName() + "</td>");
            out.print("<td>" + emp.getEmpSalary() + "</td>");
            out.print("<td><a href=\"" + request.getContextPath() + "/emp/update?id=" + emp.getEmpId() + "\">修改</a>|" +
                    "<a href=\"" + request.getContextPath() + "/emp/delete?id=" + emp.getEmpId() + "\">删除</a></td>");
            out.print("</tr>");
        }
    %>
    </tbody>
</table>
<div align="center">
    <a href="${pageContext.request.contextPath}/emp/insert"><h3>增加员工信息</h3></a>
</div>
</body>
</html>
