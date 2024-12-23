package com.etlpat.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
    public Config2() {
        System.out.println("配置类Config2被引入");
    }
}
