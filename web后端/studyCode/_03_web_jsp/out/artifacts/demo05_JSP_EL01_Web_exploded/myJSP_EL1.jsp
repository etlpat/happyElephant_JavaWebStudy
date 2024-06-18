<%@ page import="com.java.Person" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/06/16
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>


<%--
    EL表达式


    (1)基本概念
        ①EL介绍
            EL -- Expression Language（表达式语言）
            EL的作用：替代jsp中的<%= xxx %>，进行数据的输出。
            EL表达式的核心使用方法，就是利用EL内置的11大隐式对象，配合"."和"[]"运算符，寻找指定的对象。
        ②EL语法
            语法：${表达式}
            功能：自动向客户端输出表达式的值。
        ③EL对null的处理
            EL表达式若遇到null，转化为空字符串""输出。
            jsp的out/printWriter输出流，遇到null会直接输出"null"，用户可读性低。



    (2)EL表达式的通用语法
        【①】"."：用于表示层级关系，可以用来表示成员或键对应的值
            表达式.成员 == 该成员
            表达式.键 == 键对应的值
            注意：表达式.成员，只能获取到当前可以访问到的成员。
                 若当前成员为private且没有get方法，那么EL表达式也无法获取。
                 （假如private成员，有get方法，EL表达式会自动调用get方法）

        【②】[index]：用于表示数组的元素
            表达式[2] == 下标为2的数组元素
            补充：[]也可以用于输出map中含义特殊字符的key对应的值
            如：（map["a.+b<"]，可以输出key“a.+b<”对应的值）

        ③算数运算符
            +、 -、 *、 /(或div)、 %(或mod)
            功能：用于算数运算，结果是数字。
            注意：+ 不能用于字符串拼接
                 / 的结果为浮点数，不会取整（如：${1/1}==1.0）

        ④比较运算符
            ==(或eq)、 !=(或ne)、
            <(或lt)、  >(或gt)、
            <=(或le)、 >=(或ge)
            功能：用于比较运算，结果是true或false
            注意：若用字母表示运算符，规则如下
                ${1lt 2}    字母和后边的数字间必须有空格
                ${2lt(1+1)} 若后边有()等，可以不写空格

        ⑤逻辑运算符
            &&(and)、 ||(or)、 !(not)
            功能：用于逻辑运算（操作数必须是boolean类型），返回boolean值

        ⑥empty运算符
            语法：${empty exp}
            功能：判断表达式是否为 null 或 "" 或 长度为0的数组，是则返回true

        ⑦条件(三目)运算符
            语法：bool ? exp1 : exp2
            功能：与java相同

        ⑧运算符优先级：
            “.”和"[]" >单目 > 算数 > 比较 > 逻辑 > 三目
            和java相同



    (3)EL表达式的11个隐含对象
        注意：①EL的隐含对象，都是EL自己定义、创建的对象，不是Servlet中有的对象。
             ②EL只能在JSP文件中使用，但是EL中不能使用JSP的9大内置隐式对象。EL把JSP的9大对象进行处理，形成了自己的11个隐含对象。

        EL的11个隐式对象如下：（通过EL的11个隐式对象，我们可以看出EL主要用于处理域对象、以及客户端提交的请求参数）
                变量                  类型                      作用
            1.  pageContext         PageContextImpl         获取jsp的9大内置对象

            2.  pageScope           Map<String,Object>      获取PageContext域中的属性
            3.  requestScope        Map<String,Object>      获取Request域中的属性
            4.  sessionScope        Map<String,Object>      获取HttpSession域中的属性
            5.  applicationScope    Map<String,Object>      获取ServletContext域中的属性

            6.  param               Map<String,String>      获取请求参数的一个值
            7.  paramValues         Map<String,String[]>    获取请求参数的多个值
            8.  initParam           Map<String,String>      获取<context-param>全局初始化参数的值

            9.  header              Map<String,String>      获取请求头的一个值
            10. headerValues        Map<String,String[]>    获取请求头的多个值

            11. cookie              Map<String,Cookie>      获取当前请求的Cookie信息



    (4)EL处理域对象
        ①语法1：寻找指定域中的域对象
            获取PageContext域属性：   ${pageScope} == {key=value,...}
                                    ${pageScope.key} == value
            获取Request域属性：       ${requestScope} == {key=value,...}
                                    ${requestScope.key} == value
            获取HttpSession域属性：   ${sessionScope} == {key=value,...}
                                    ${sessionScope.key} == value
            获取ServletContext域属性：${applicationScope} == {key=value,...}
                                    ${applicationScope.key} == value

        ②语法2：寻找存在的首个域对象（小域->大域）
            语法：${key} == value
            功能：从小域到大域，依次寻找域对象key，输出首个找到的域对象的value
                （类似与pageContext.findAttribute(String name)）



    (5)EL处理请求参数
        语法：${param.key} == value
             ${paramValues.key} == {value1, value2,...}


    (6)EL中获取JSP九大对象
        例如：
            ${pageContext.request.scheme}
            ${pageContext.request.serverName}
            ${pageContext.request.serverPort}
            ${pageContext.request.method}
            ${pageContext.session.id}
        注意：
            EL表达式中不能调用get方法，EL表达式中直接写对象的成员属性的层级关系即可。
            Tomcat会自动把EL表达式的层级关系，转化为get方法调用。
            e.g. ① ${pageContext.request.method}
                    等价于 <%= request.getMethod() %>
                 ② ${pageContext.session.id}
                    等价于 <%= session.getId() %>
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--测试运算符--%>
<h3>测试运算符：</h3>
${1+1}<br/>
${1/2}<br/>
${1/1}<br/>
${1==2}<br/>
${1<=2}<br/>
${1lt 2}<br/>
${2lt(1+1)}<br/>
${true || false}<br/>
${!true}<br/>
${empty null}<br/>
${empty ""}<br/>
${true ? 1 : 2}<br/>
${1*(2+3)}<br/>


<%--测试域对象--%>
<%
    // 创建4个域对象
    pageContext.setAttribute("username", "张三");
    request.setAttribute("username", "李四");
    session.setAttribute("username", "王五");
    application.setAttribute("username", "赵六");
%>
<h3>输出指定域中的域对象：</h3>
<%--页面域：${pageScope}<br/>--%>
页面域：${pageScope.username}<br/>
<%--请求域：${requestScope}<br/>--%>
请求域：${requestScope.username}<br/>
<%--会话域：${sessionScope}<br/>--%>
会话域：${sessionScope.username}<br/>
<%--应用域：${applicationScope}<br/>--%>
应用域：${applicationScope.username}<br/>
<h3>输出首个域中的域对象：</h3>
username:${username}<br/>
password:${password}<br/>


<%--测试“.”和“[]”的使用--%>
<%
    // 创建java对象
    Person person = new Person(114, "刘明", 18, "男", "1919810");
    Person[] persons = new Person[3];
    persons[0] = new Person(101, "张三", 21, "男", "abc");
    persons[1] = new Person(102, "李四", 17, "女", "def");
    persons[2] = new Person(103, "王五", 74, "女", "ghi");
    pageContext.setAttribute("person", person);
    pageContext.setAttribute("persons", persons);
%>
<h3>测试“.”和“[]”的使用</h3>
${pageScope.person.id}<br/>
${pageScope.person.name}<br/>
${pageScope.person.sex}<br/>
${pageScope.person.address}<br/>
${pageScope.persons[0].id}<br/>
${pageScope.persons[1].name}<br/>
${pageScope.persons[2].address}<br/>


<%--EL处理请求参数--%>
<h3>EL处理请求参数</h3>
username=${param.username}<br/>
password=${param.password}<br/>
hobby=${paramValues.hobby}<br/>
hobby1=${paramValues.hobby[0]}<br/>
hobby2=${paramValues.hobby[1]}<br/>
hobby3=${paramValues.hobby[2]}<br/>
hobby4=${paramValues.hobby[3]}<br/>


<%--测试pageContext的使用--%>
<h3>测试pageContext的使用</h3>
${pageContext.request.scheme}<br/>
${pageContext.request.serverName}<br/>
${pageContext.request.serverPort}<br/>
${pageContext.request.method}<br/>
<%= request.getMethod() %><br/>
${pageContext.session.id}<br/>
<%= session.getId() %><br/>

</body>
</html>
