package com.etlpat.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// 创建DispatcherServletInit类：用于在web项目加载时，创建ioc和servlet容器
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
