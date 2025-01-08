package com.etlpat.service;

import com.etlpat.dao.Dao;
import com.etlpat.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Dao dao;

    public List<Student> getAllStudent() {
        List<Student> allStudent = dao.getAllStudent();
        System.out.println("Service层，获取到Dao层传来的学生信息！ -- " + allStudent.hashCode());
        return allStudent;
    }
}
