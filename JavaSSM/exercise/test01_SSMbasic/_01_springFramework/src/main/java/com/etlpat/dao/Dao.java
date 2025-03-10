package com.etlpat.dao;

import com.etlpat.javaBean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository// 添加到IoC容器
public class Dao {
    @Autowired// DI
    JdbcTemplate jdbcTemplate;

    public List daoGetAll() {
        // 使用JdbcTemplate的API获取学生列表
        String sql = "select id,name,gender,age,class as classes from students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        System.out.println("DAO包，获取学生信息~~");
        return students;
    }


}
