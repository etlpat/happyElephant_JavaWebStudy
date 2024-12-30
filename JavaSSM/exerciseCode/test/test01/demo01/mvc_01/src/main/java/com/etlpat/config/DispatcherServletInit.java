package com.etlpat.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// DispatcherServletInit类
//  会自动被web项目加载，用于：①创建ioc容器  ②创建DispatcherServlet对象（并设置访问路径）
//  P.S. WebApplicationInitializer父接口，会在web项目启动时，自动加载。
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 设置service/mapper(dao)层的ioc容器的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置springMVC/controller层ioc容器的配置文件（java配置类）
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 设置springMVC框架中，servlet的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};// “/”表示servlet允许访问全部路径
    }
}
