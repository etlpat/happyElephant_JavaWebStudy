package com.etlpat.service;

import com.etlpat.pojo.Student;

import java.util.List;

public interface StudentService {
    int insertStudent(Student student);
    int deleteStudent(int id);
    int updateStudent(Student student);
    List<Student> selectAllStudent();
}
