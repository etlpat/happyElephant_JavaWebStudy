package com.etlpat.service;

import com.etlpat.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    Student student;

    public Student getStudent() {
        return student;
    }

}
