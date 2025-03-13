package com.etlpat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication// 设置为启动类（将本类设为配置类、引入其它配置类、扫描包内注解）
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);// 创建ioc容器、启动tomcat
    }
}