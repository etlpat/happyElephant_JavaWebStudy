package com.etlpat;

import com.etlpat.javaBean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // TODO: 1.测试组件的生命周期

        // 创建ioc容器，并为其添加xml配置信息
        // TODO: 当组件被添加到ioc容器中时（调用refresh方法时），调用组件的init()方法。
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml_04.xml");
        System.out.println("=======================");

        // 获取Bean对象
        System.out.println(context.getBean("user1", User.class));
        System.out.println("=======================");

        // 释放ioc容器
        // TODO: 当ioc容器被正常销毁时，调用组件的destroy()方法。
        context.close();
        System.out.println("\n\n========================");
        System.out.println("========================\n\n");


        // TODO: 2.测试组件的作用域
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("xml_04.xml");
        System.out.println("=======================");

        // 测试scope为单例的组件
        User user2_1 = context1.getBean("user2", User.class);
        User user2_2 = context1.getBean("user2", User.class);
        System.out.println(user2_1 == user2_2);// true
        System.out.println("=======================");

        // 测试scope为多例的组件
        User user3_1 = context1.getBean("user3", User.class);
        User user3_2 = context1.getBean("user3", User.class);
        System.out.println(user3_1 == user3_2);// false
        System.out.println("=======================");

        context1.close();
    }
}