package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


// Filter链
//
// (1)Filter链中过滤器的执行顺序
//  若用【注解】的形式配置Filter对象的映射路径，
//  那么，Filter链中过滤器的执行顺序，由【Filter对象名的大小顺序】决定。
//  即：由Filter对象名这一字符串的大小的顺序决定。
//  原因：
//      filter链的执行顺序，本质上是由xml文件中配置映射路径的定义先后次序决定。
//      若用注解配置，注解转化为xml的次序=注解调用的次序=.java文件执行的次序=filter对象名的大小次序
//      因此，注解形式配置filter，过滤器链的执行次序就是filter对象名的大小次序。
//
//
// (2)FilterChain介绍
//  FilterChain，即过滤器链。
//  filterChain对象，用于存放过滤器链中，当前过滤器要传递给的下一个过滤器。
//  （若当前过滤器是链中最后一个过滤器，那么此时filterChain对象是所过滤的资源对象，即Servlet）
//  doFilter参数中的FilterChain对象由Tomcat服务器自动传参，我们无需操心。
//  补充：
//      doFilter中放行代码的操作，就是调用下一个过滤器的doFilter方法。
//      （filterChain.doFilter(servletRequest, servletResponse);）


@WebFilter("/*")

public class myFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 拦截请求
        System.out.println("----------------------------------");
        System.out.println("Filter before myFilter1 处理请求");

        // 放行代码
        filterChain.doFilter(servletRequest, servletResponse);

        // 处理响应
        System.out.println("Filter after myFilter1 处理响应");
        System.out.println("----------------------------------");
    }
}
