<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>


<%--
    JSP九大内置对象


    (1)基础介绍
        当jsp文件转化为java文件后，Tomcat会自动在该Servlet的service方法中创建9个对象，即9大内置对象。
        jsp的九大内置对象：
            ①request        HttpServletRequest对象
            ②response       HttpServletResponse对象
            ③config         ServletConfig对象
            ④application    ServletContext对象
            ⑤session        HttpSession对象
            ⑥out            jspWriter对象【新】，jsp的输出流对象
            ⑦page           Object对象【新】，指向当前页面转化后的Servlet实例的对象
            ⑧pageContext    PageContext对象【新】，jsp的上下文对象
            ⑨exception      Throwable对象【新】，异常对象

        注意：
            九大隐式对象，可以在代码脚本<%...%>中直接使用。
            九大内置对象的前5个，都是Servlet中的基础对象，我们只需考虑后4个即可。



    (2)jsp的四大域对象
        域对象如下：（域的范围从小到大）
            ①pageContext     页面域对象（本jsp页面有效）
            ②request         请求域对象（一次请求中有效）
            ③session         会话域对象（整个会话中有效）
            ④application     应用域对象（整个应用中有效）

        域对象的通用方法：
            setAttribute(String name, Object value);
            getAttribute(String name);
            removeAttribute(String name);

        注意事项：
            ①四个域对象是不同的对象，是独立的。
              四个域对象中可以有同名属性，其值不同。
            ②request域和pageContext域的区别：假如从A页面请求转发到B页面，
                整个请求转发算一次request，因此B可以访问到A的请求域。
                但是请求转发页面发送了跳转，因此B不能访问到A的页面域。
            ③域的使用优先级：从小->大



    (3)out对象
        1.out缓冲区和response缓冲区
            缓冲区顺序：[out缓冲区] -> [response缓冲区] -> [客户端]
            ①out对象：输出内容到out缓冲区。
            ②printWriter对象：输出内容到response缓冲区。

        2.【Tomcat将缓冲区内容输出到客户端方式】
            当jsp中所有代码执行完毕后，会执行以下两步操作：
            ①执行out.flush()，将out缓冲区中数据追加写入response缓冲区的末尾。
            ②执行response.flush()，将response缓冲区中全部输出输出到客户端。
            因此，客户端上会先显示printWriter对象输出的全部内容，之后再显示out对象输出的全部内容。

        3.out对象语法
            语法1：out.write(String str);
                功能：将字符串输出到out缓冲区中，最终输出给客户端。
            语法2：out.print(Object obj);
                功能：先将参数转化为字符串，再调用write输出
                等价于：<%= xxx %>
            注意：write()只能输出字符串，print()方法可以输出任意类型
                 因此建议使用print()方法

        4.输出建议
            问：用out输出还是用printWriter输出？
            答：由于底层代码全用out进行输出，因此我们建议统一用out输出。



    (4)pageContext对象
        1.pageContext对象可以获取其它8个隐式对象：
            pageContext.getRequest()
            pageContext.getResponse()
            pageContext.getServletConfig()
            pageContext.getServletContext()
            pageContext.getSession()
            pageContext.getOut()
            pageContext.getPage()
            pageContext.getException()

        2.pageContext是页面域对象，可以通过attribute相关的方法配置域属性：
            setAttribute(String name, Object value);
            getAttribute(String name);
            removeAttribute(String name);
            特殊：
                语法：findAttribute(String name);
                功能：从小到大，取第一个存在该属性的域中的属性值，都没有则返回null。



    (5)exception对象
        只有isErrorPage="true"的界面中才会生成exceprion对象。（exception对象可以用于存储错误信息）
        isErrorPage="true"的页面一般是被用于处理错误信息的页面。
        exception对象，是用于存放异常的对象，可以接收其它界面传来的异常。
        当某页面发送异常，会跳转到错误处理页面，并将异常传递给exception对象。
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">测试四大域对象</h1>
<%
    // 为域对象中添加属性
    pageContext.setAttribute("username", "张三");
    request.setAttribute("username", "李四");
    session.setAttribute("username", "王五");
    application.setAttribute("username", "赵六");
%>

<h2 align="center">以下为四大域对象中的属性：</h2>
<table border="1px" align="center">
    <tr>
        <td>pageContext域对象：</td>
        <td>username=<%=pageContext.getAttribute("username")%>
        </td>
    </tr>
    <tr>
        <td>request域对象：</td>
        <td>username=<%=request.getAttribute("username")%>
        </td>
    </tr>
    <tr>
        <td>session域对象：</td>
        <td>username=<%=session.getAttribute("username")%>
        </td>
    </tr>

    <tr>
        <td>application域对象：</td>
        <td>username=<%=application.getAttribute("username")%>
        </td>
    </tr>
    <tr>
        <td>最小域中的键值对：</td>
        <td>username=<%=pageContext.findAttribute("username")%>
        </td>
    </tr>
</table>

</body>
</html>

