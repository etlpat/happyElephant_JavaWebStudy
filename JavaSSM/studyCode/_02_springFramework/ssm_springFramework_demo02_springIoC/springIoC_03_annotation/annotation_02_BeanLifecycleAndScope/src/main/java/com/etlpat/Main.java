package com.etlpat;

import com.etlpat.javaBean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // (1)创建IoC容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_02.xml");
        System.out.println("=======================");

        // (2)从IoC容器中获取并使用组件对象
        User user1 = context.getBean(User.class);
        System.out.println(user1);
        User user2 = context.getBean(User.class);
        System.out.println(user2);
        System.out.println("=======================");

        System.out.println(user1 == user2);
        System.out.println("=======================");

        // (3)关闭IoC容器
        context.close();
    }
}