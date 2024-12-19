package com.etlpat.controller;

import com.etlpat.javaBean.Student;
import com.etlpat.service.StudentService;

import java.util.List;

public class StudentController {
    // Controller层中，包含Service层对象
    StudentService studentService;

    // 创建set方法，用于ioc容器的依赖注入
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void showAllStudents() {
        List<Student> allStudent = studentService.getAllStudent();
        System.out.println("Controller层，获取到Service层传来的学生信息！ -- " + allStudent.hashCode());
        System.out.println("==============学生信息如下==============");
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
}
