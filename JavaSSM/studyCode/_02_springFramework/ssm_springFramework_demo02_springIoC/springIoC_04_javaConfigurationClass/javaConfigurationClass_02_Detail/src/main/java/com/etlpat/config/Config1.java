package com.etlpat.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
    public Config1() {
        System.out.println("配置类Config1被引入");
    }
}
