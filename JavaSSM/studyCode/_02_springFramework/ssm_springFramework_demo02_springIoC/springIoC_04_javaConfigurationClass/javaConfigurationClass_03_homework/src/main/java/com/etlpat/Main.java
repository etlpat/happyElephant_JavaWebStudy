package com.etlpat;

import com.etlpat.bean.controller.StudentController;
import com.etlpat.config.JavaConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        StudentController bean = context.getBean(StudentController.class);
        bean.showAllStudents();

        context.close();
    }
}