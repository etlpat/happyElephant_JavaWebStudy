package com.etlpat;

import com.etlpat.factoryBean.UserFactoryBean;
import com.etlpat.javaBean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml_05.xml");


        // 获取标准化工厂创建的User对象
        User user1 = context.getBean("user1", User.class);
        System.out.println(user1);

        // 获取标准化工厂UserFactoryBean本身的对象
        UserFactoryBean userFactoryBean = context.getBean("&user1", UserFactoryBean.class);
        System.out.println(userFactoryBean);


        context.close();
    }
}