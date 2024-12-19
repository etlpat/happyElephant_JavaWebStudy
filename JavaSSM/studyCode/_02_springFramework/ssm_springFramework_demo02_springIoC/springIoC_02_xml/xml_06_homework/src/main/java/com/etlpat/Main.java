package com.etlpat;

import com.etlpat.controller.StudentController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // (1)创建ioc容器，并添加xml配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml_06.xml");

        // (2)从容器中获取控制层的controller对象
        StudentController studentController = context.getBean(StudentController.class);

        // (3)调用控制层对象的showAllStudents，展示学生信息
        studentController.showAllStudents();

        // (4)关闭ioc容器
        context.close();
    }
}