package com.etlpat;

import com.etlpat.config.JavaConfiguration;
import com.etlpat.service.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // (1)创建IoC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);


        // (2)从容器获取组件
        //  注意：使用AOP后，IoC容器中真正存储的是代理对象，而非目标对象。
        Calculator calculator = context.getBean(Calculator.class);
        System.out.println(calculator);


        // (3)测试AOP是否切入增强类
        System.out.println("===========================");
        System.out.println(calculator.add(1, 1));

        System.out.println("===========================");
        try {
            calculator.div(1, 0);// 除零异常
        } catch (Exception e) {
        }
        System.out.println("===========================");


        // (4)关闭容器
        context.close();
    }
}