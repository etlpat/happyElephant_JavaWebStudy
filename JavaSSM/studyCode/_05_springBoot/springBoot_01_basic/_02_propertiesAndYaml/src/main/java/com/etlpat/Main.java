package com.etlpat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication// 设置为springBoot的启动类
// @SpringBootApplication注解功能：
//  ①将本类设置为java配置类 -- @SpringBootConfiguration
//  ②自动加载其他的java配置类 -- @EnableAutoConfiguration
//  ③扫描当前类所在的包/子包的注解 -- @ComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);// 自动创建ioc容器，启动tomcat服务器
    }
}