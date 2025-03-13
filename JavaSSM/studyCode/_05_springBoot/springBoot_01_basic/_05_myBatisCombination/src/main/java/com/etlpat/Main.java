package com.etlpat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication// 设置为启动类（将本类设置为配置类、引入其它配置类、扫描本包内注解）
@MapperScan("com.etlpat.mapper")// 扫描mapper接口所在包
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);// 创建ioc容器、开启tomcat
    }
}