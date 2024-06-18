<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>


<%--
    JSP指令

    (1)基础介绍
        JSP中，指令格式为：<%@ 指令名 xxx %>
        之前我们已经学过page指令，除此之外，其它指令统一在这里讲解。
        注意：静态包含和动态包含，建议使用静态包含。


    (2)静态包含指令
        语法：<%@ include file="绝对/相对路径" %>
        功能：向该条指令所在的位置添加(包含)对应路径的jsp页面内容。
        本质：当该jsp转化为java文件后，静态include这条指令，会被Tomcat替换为被包含的jsp文件的body标签中的代码。
            （静态包含就是把被包含的jsp页面代码拷贝到包含的位置进行输出）
            （只产生一个Servlet对象）
        注意事项：和请求转发一样，静态包含填写的绝对路径，也自带上下文路径。


    (3)动态包含指令
        语法：<jsp:include page="绝对/相对路径"></jsp:include>
        功能：与静态包含相似，都是向包含指令位置添加被包含的jsp页面内容。
        本质：1.包含和被包含的页面均产生servlet对象。（产生多个Servlet）
             2.把被包含的页面，通过Tomcat的方法动态的传送到包含位置。
        注意事项：和请求转发一样，动态包含填写的绝对路径，也自带上下文路径。


    (4)请求转发指令
        语法：<jsp:forward page="绝对/相对路径"></jsp:forward>
        等价于：<%
                request.getRequestDispatcher("绝对/相对路径").forward(request, response);
            %>
        注意：请求转发的绝对路径，自带上下文路径
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
