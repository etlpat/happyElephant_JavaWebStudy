package com.etlpat.controller;

import com.etlpat.pojo.Student;
import com.etlpat.service.StudentService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private StudentService studentService;


    // （1）展示学生列表（首页）
    @RequestMapping("/show")
    public String showAllStudent(){
        List<Student> students = studentService.selectAllStudent();
        servletContext.setAttribute("students", students);
        return "showAllStudent";
    }

// （2.1）跳转到添加页面
    @RequestMapping("/gotoInsert")
    public String gotoInsert(){
        return "insertStudent";
    }

    // （2.2）添加学生，并返回首页
    @RequestMapping("/insert")
    public String insertStudent(Student student){
        studentService.insertStudent(student);
        return showAllStudent();
    }

    // （3）删除学生，并返回首页
    @RequestMapping("/delete")
    public String deleteStudent(int id){
        studentService.deleteStudent(id);
        return showAllStudent();
    }

    // （4.1）跳转到更新页面
    @RequestMapping("/gotoUpdate")
    public String gotoUpdate(int id){
        servletContext.setAttribute("updateId", id);
        return "updateStudent";
    }

    // （4.2）更新，并返回首页
    @RequestMapping("update")
    public String update(Student student){
        student.setId((int)servletContext.getAttribute("updateId"));
        studentService.updateStudent(student);
        return showAllStudent();
    }

}