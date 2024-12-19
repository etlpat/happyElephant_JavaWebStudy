package com.etlpat.dao;

import com.etlpat.javaBean.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDao {
    // dao层包含jdbcTemplate，用于操纵数据库
    JdbcTemplate jdbcTemplate;

    // 提供setter方法，用于spring注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // 从数据库获取全部学生信息
    public List<Student> getAllStudent() {
        // sql语句
        String sql = "select id,name,gender,age,class as classes from students";

        // 使用jdbcTemplate操纵数据库，获取全部学生信息
        List<Student> students = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<Student>(Student.class));

        System.out.println("DAO层，从数据库获取到全部学生信息！ -- " + students.hashCode());
        return students;
    }
}
