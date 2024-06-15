package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;


// Filter
//
// (1)过滤器概述
//  Filter过滤器，是用于对目标资源的请求进行过滤的一套技术规范。
//  Filter接口定义了过滤器的开发规范，所有过滤器都要实现该接口。
//  Filter的工作位置是该项目的目标资源之前。Tomcat在创建请求、响应对象后，会先调用Filter的doFilter方法。
//  Filter不仅可以对请求对象做出过滤，还能在Servlet调用结束后对响应对象做出处理。
//
//
// (2)实现Filter流程
//  ①实现Filter接口
//  ②重新doFilter过滤方法
//  ③配置过滤器的映射路径（注解/xml）
//
//
// (3)Filter的生命周期
//  构造(构造器) -> 初始化(init) -> 过滤(doFilter) ->销毁(destroy)
//  ①构造和初始化：在Tomcat启动是进行
//  ②过滤：每次调用Filter对应映射路径的资源时进行
//  ③销毁：Tomcat关闭时进行
//  注意：Filter和Servlet的生命周期类似，区别在于Servlet的构造和初始化默认在首次请求时完成。
//
//
// (4)Filter接口的方法
//  ①init()
//  ②doFilter(ServletRequest request, response servletResponse, FilterChain filterChain)
//  ③destroy()
//  Filter接口与Servlet接口非常相似，我们只需要重写Filter的doFilter方法即可（对应Servlet的service方法）
//
//
// (5)@WebFilter(...)注解的参数
//  ①value/urlPatterns：是WebFilter的默认参数，表示Filter要拦截的映射路径
//  ②filterName：过滤器的名称
//  ③dispatcherType：过滤器的拦截模式
//   dispatcherType属性的值如下：（以下四个属性都是枚举类型DispatcherType中的值）
//      REQUEST：是该属性的默认值，拦截浏览器中的请求路径（无法拦截请求转发这种服务器内部的跳转，可以拦截响应重定向这种浏览器地址改变的跳转）
//      FORWARD：只拦截请求转发
//      INCLUDE：只拦截include包含转发
//      ERROR：只拦截异常声明


@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
// 配置过滤器映射路径：该过滤器拦截本应用下全部路径的资源

public class myFilter1 implements Filter {
    /*
     doFilter方法（用于过滤请求）
         1.请求到达目标资源之前，会先经过该方法
         2.该方法有能力控制请求是否继续向后到达目标资源
           （可以在该方法中把请求拦截下来，直接返回给客户端，不经过Servlet）
         3.请求经过达目标资源后，响应之前，还会经过该方法
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // (1)处理拦截下来的请求对象
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("<h3>Filter before myFilter1 处理请求</h3>");

        // (2)放行代码
        // 参数的filterChain，即“过滤器链对象”，该对象是由Tomcat提供的下一个filter对象，或者servlet对象
        filterChain.doFilter(servletRequest, servletResponse);

        // (3)处理返回的响应对象
        writer.write("<h3>Filter after myFilter1 处理响应</h3>");
    }
}
