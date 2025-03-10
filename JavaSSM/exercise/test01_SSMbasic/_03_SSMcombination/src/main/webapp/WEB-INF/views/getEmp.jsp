<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取员工信息</title>
</head>
<body>
<h2 align="center">获取员工信息</h2>
<form action="${pageContext.request.contextPath}/emp/getEmp" method="get">
    <table align="center" border="1px">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="empName"></td>
        </tr>
        <tr>
            <td>薪水</td>
            <td><input type="text" name="empSalary"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
