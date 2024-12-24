package com.etlpat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


// java配置类
@Configuration
@ComponentScan("com.etlpat")

// 注解：@EnableAspectJAutoProxy
// 功能：开启AspectJ注解的支持
// 等同于xml中：<aop:aspectj-autoproxy />
@EnableAspectJAutoProxy

public class JavaConfiguration {
}
