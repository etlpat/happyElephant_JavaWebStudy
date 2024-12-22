package com.etlpat;

import com.etlpat.javaBean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_03.xml");

        User user = context.getBean(User.class);
        System.out.println(user);

        context.close();
    }
}