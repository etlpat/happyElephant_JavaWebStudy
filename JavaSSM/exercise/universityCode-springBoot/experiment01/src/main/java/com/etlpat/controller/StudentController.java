package com.etlpat.controller;

import com.etlpat.pojo.Student;
import com.etlpat.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping("/getStudent")
    @ResponseBody
    public String getStudent() throws JsonProcessingException {
        Student student = studentService.getStudent();
        String json = objectMapper.writeValueAsString(student);
        System.out.println(json);
        return json;
    }

}
