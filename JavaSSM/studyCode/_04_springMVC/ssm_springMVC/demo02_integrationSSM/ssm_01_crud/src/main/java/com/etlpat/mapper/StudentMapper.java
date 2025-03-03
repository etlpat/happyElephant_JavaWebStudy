package com.etlpat.mapper;

import com.etlpat.pojo.Student;

import java.util.List;


public interface StudentMapper {

    int insertStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    List<Student> selectAllStudent();

}
