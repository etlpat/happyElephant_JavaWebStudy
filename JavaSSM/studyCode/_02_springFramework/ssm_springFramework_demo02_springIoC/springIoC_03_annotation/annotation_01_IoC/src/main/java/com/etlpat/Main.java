package com.etlpat;

import com.etlpat.javaBean.MyController;
import com.etlpat.javaBean.MyDao;
import com.etlpat.javaBean.MyService;
import com.etlpat.javaBean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //(1) 创建IoC容器，并配置xml文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_01.xml");

        //(2)通过容器获取组件
        User user = context.getBean(User.class);
        System.out.println(user);

        MyController myController = context.getBean("myController", MyController.class);
        System.out.println(myController);

        MyService myService = context.getBean(MyService.class);
        System.out.println(myService);

        MyDao myDao = (MyDao) context.getBean("myDao");
        System.out.println(myDao);

        //(3)关闭容器
        context.close();
    }
}