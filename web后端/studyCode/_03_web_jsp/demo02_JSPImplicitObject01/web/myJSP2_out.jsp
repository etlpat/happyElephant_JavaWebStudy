<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 测试out和PrintWriter对象输出的区别
    PrintWriter printWriter = response.getWriter();

    out.print("out输出1" + "<br/>");
    printWriter.print("printWriter输出1" + "<br/>");
    out.print("out输出2" + "<br/>");
    printWriter.print("printWriter输出2" + "<br/>");
    out.print("out输出3" + "<br/>");
    printWriter.print("printWriter输出3" + "<br/>");
    out.print("out输出4" + "<br/>");
    out.print("out输出5" + "<br/>");
    out.print("out输出6" + "<br/>");
    printWriter.print("printWriter输出4" + "<br/>");
    printWriter.print("printWriter输出5" + "<br/>");
    printWriter.print("printWriter输出6" + "<br/>");
    /*
    输出结果为：
        printWriter输出1
        printWriter输出2
        printWriter输出3
        printWriter输出4
        printWriter输出5
        printWriter输出6
        out输出1
        out输出2
        out输出3
        out输出4
        out输出5
        out输出6

    原因：
        缓冲区顺序：[out缓冲区] -> [response缓冲区] -> [客户端]
        out对象吧数据输入到out缓冲区，printWriter吧数据输出到response缓冲区。
        代码执行结束后，将out缓冲区全部数据追加到response缓冲区，再输出到客户端。
        因此，先输出response缓冲区中全部内容，再输出out缓冲区中全部内容。
    */
%>
</body>
</html>
