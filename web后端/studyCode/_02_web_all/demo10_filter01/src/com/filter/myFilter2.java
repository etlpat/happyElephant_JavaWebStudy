package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")

public class myFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // (1)拦截请求
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("<h3>Filter before myFilter2 处理请求</h3>");

        // (2)放行
        filterChain.doFilter(servletRequest, servletResponse);

        // (3)处理响应
        writer.write("<h3>Filter after myFilter2 处理响应</h3>");
    }
}
