package com.etlpat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan("com.etlpat")
@EnableWebMvc// ①向ioc容器添加handlerMapping组件  ②向ioc容器添加handlerAdapter组件  ③给handlerAdapter配置json转换器

// WebMvcConfigurer接口，会提供构建springMVC所需组件的方法。
// java配置类实现WebMvcConfigurer接口，只需重写对应方法，就能快速配置组件。
// （省去了使用(@Bean+getter方法)配置第三方组件的步骤）
public class MvcConfig implements WebMvcConfigurer {

    // （重写WebMvcConfigurer提供的方法）
    // 创建视图解析器组件
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 设置jsp文件的前后缀（前缀：webapp包下的路径； 后缀：.jsp）
        //  之后对jsp文件进行访问时，视图解析器会自动为其添加前后缀，我们只需写清jsp文件名即可!
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
