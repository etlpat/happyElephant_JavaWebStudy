package com.etlpat.service;

import com.etlpat.dao.StudentDao;
import com.etlpat.javaBean.Student;

import java.util.List;

public class StudentService {
    // Service层中，包含Dao层对象
    StudentDao studentDao;

    // 创建set方法，用于spring依赖注入
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    // 用于获取全部学生信息
    public List<Student> getAllStudent() {
        List<Student> allStudent = studentDao.getAllStudent();
        System.out.println("Service层，获取到Dao层传来的学生信息！ -- " + allStudent.hashCode());
        return allStudent;
    }
}
