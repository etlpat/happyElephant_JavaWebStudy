package com.etlpat.dao;

import com.etlpat.javaBean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// 装入ioc容器
@Repository
public class StudentDao {
    // 使用DI，注入组件
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudent() {
        // sql语句
        String sql = "select id,name,gender,age,class as classes from students";

        // 使用jdbcTemplate操纵数据库，获取全部学生信息
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        System.out.println("DAO层，从数据库获取到全部学生信息！ -- " + students.hashCode());
        return students;
    }
}
