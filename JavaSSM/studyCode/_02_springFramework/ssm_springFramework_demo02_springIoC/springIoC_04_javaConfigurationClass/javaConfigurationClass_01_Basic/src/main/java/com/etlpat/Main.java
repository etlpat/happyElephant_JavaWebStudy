package com.etlpat;

import com.etlpat.config.JavaConfiguration;
import com.etlpat.javaBean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // (1)创建IoC容器
        // 注意：java配置类，对应AnnotationConfigApplicationContext容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        // (2)获取组件
        User user = context.getBean(User.class);
        System.out.println(user);

        // (3)关闭容器
        context.close();

    }
}