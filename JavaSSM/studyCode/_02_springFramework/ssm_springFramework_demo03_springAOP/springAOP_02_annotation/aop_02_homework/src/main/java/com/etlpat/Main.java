package com.etlpat;

import com.etlpat.config.MyConfiguration;
import com.etlpat.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // 获取组件对象
        MyService service = context.getBean(MyService.class);

        // 测试组件方法
        System.out.println("======================================");
        service.func1();
        System.out.println("======================================");
        try {
            service.func2();
        } catch (Exception e) {
        }
        System.out.println("======================================");

        // 关闭容器
        context.close();

    }
}