package com.etlpat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


// java配置类
@Configuration
@ComponentScan("com.etlpat")
@EnableAspectJAutoProxy// 开启AspectJ注解许可
public class MyConfiguration {
}
