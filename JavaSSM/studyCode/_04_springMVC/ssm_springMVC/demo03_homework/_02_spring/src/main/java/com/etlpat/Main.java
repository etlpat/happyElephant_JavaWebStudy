package com.etlpat;

import com.etlpat.config.Config;
import com.etlpat.controller.Control;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Control bean = context.getBean(Control.class);
        bean.showAllStudents();

        context.close();
    }
}