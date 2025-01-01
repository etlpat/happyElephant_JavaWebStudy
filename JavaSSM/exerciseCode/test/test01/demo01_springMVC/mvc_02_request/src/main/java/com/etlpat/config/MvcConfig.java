package com.etlpat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan("com.etlpat")
@EnableWebMvc// 给handlerAdapter配置了json转换器（并且向ioc容器添加handlerMapping、handlerAdapter对象）
public class MvcConfig {

//    //以下对象均被@EnableWebMvc注解添加
//    @Bean
//    public RequestMappingHandlerMapping handlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter handlerAdapter() {
//        return new RequestMappingHandlerAdapter();
//    }
}
