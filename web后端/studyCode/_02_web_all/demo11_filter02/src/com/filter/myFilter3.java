package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")

public class myFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 拦截请求
        System.out.println("Filter before myFilter3 处理请求");

        // 放行代码
        filterChain.doFilter(servletRequest, servletResponse);

        // 处理响应
        System.out.println("Filter after myFilter3 处理响应");
    }
}
