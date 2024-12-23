package com.etlpat.service;

import com.etlpat.dao.StudentDao;
import com.etlpat.javaBean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 装入ioc容器
@Service
public class StudentService {
    // DI，自动装配组件
    @Autowired
    StudentDao studentDao;

    public List<Student> getAllStudent() {
        List<Student> allStudent = studentDao.getAllStudent();
        System.out.println("Service层，获取到Dao层传来的学生信息！ -- " + allStudent.hashCode());
        return allStudent;
    }
}
