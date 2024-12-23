package com.etlpat.bean.dao;

import com.etlpat.bean.javaBean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudent() {
        String sql = "select id,name,gender,age,class as classes from students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("DAO层，从数据库获取到全部学生信息！ -- " + students.hashCode());
        return students;
    }
}
