package com.etlpat;

import com.etlpat.controller.StudentController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_04.xml");

        StudentController controller = context.getBean(StudentController.class);
        controller.showAllStudents();

        context.close();
    }
}