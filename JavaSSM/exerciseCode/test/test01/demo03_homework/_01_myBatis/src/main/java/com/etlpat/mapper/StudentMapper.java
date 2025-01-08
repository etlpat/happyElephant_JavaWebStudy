package com.etlpat.mapper;

import com.etlpat.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentMapper {

    int insertStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    List<Student> selectAllStudent();

    List<Student> selectStudentLikeName(String name);

    List<Student> selectStudentByNameAndAddress(@Param("name") String name,
                                                @Param("address") String address);

}
