package com.etlpat.controller;

import com.etlpat.javaBean.Student;
import com.etlpat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

// 装入ioc容器
@Controller
public class StudentController {
    // 自动装配组件
    @Autowired
    StudentService studentService;

    public void showAllStudents() {
        List<Student> allStudent = studentService.getAllStudent();
        System.out.println("Controller层，获取到Service层传来的学生信息！ -- " + allStudent.hashCode());
        System.out.println("==============学生信息如下==============");
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
}
