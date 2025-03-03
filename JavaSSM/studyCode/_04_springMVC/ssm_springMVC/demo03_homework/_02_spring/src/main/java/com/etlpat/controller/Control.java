package com.etlpat.controller;

import com.etlpat.pojo.Student;
import com.etlpat.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Control {
    @Autowired
    Service service;

    public void showAllStudents() {
        List<Student> allStudent = service.getAllStudent();
        System.out.println("Controller层，获取到Service层传来的学生信息！ -- " + allStudent.hashCode());
        System.out.println("==============学生信息如下==============");
        for (Student student : allStudent) {
            System.out.println(student);
        }
        System.out.println("==============结束==============");
    }
}
