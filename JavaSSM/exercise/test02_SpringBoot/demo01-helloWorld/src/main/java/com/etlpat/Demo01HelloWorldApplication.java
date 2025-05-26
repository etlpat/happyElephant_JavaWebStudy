package com.etlpat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// 标注springBoot的主程序
public class Demo01HelloWorldApplication {

    public static void main(String[] args) {
        // 启动springBoot应用
        SpringApplication.run(Demo01HelloWorldApplication.class, args);
    }

}
