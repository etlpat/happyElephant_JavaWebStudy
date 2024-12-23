package com.etlpat;

import com.etlpat.config.JavaConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        context.close();
    }
}