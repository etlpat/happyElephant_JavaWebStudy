本模块用于实现：《判断用户输入账号密码是否正确》

要求：
    1.实现登录界面，并将请求传递给Servlet。
    2.在Servlet中判断是否登录成功，
      若客户端输入的username="zhangsan"且password="123456"，即成功，否则失败。
    3.Servlet判断完毕后，跳转到前端界面ret.jsp，
      该界面用于输出是否登录成功，并且提供超链接返回登录界面。

JavaBean技术的应用：
    通过JavaBean（Person类）封装请求参数信息，减少耦合性。