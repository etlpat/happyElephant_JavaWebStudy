package com.etlpat.service;

import com.etlpat.dao.StudentRepository;
import com.etlpat.pojo.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;


@SpringBootTest
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    // (1)基础增删改查方法=================================================================================================
    // 测试查询全部学生
    @Test
    public void testQuery() {
        // 查询全部学生（Repository自带的方法）
        List<Students> students = studentRepository.findAll();
        for (Students student : students) {
            System.out.println(student);
        }
    }

    // 测试添加学生
    @Test
    public void testAdd() {
        Students student = new Students(null, "JIM", 77, "女", "23333333", "山西", 1);
        Students save = studentRepository.save(student);
        System.out.println(save);// 主键会回显
    }

    // 测试删除学生
    @Test
    public void testDelete() {
        studentRepository.deleteById(10);
    }


    // (2)自定义方法名查询=================================================================================================
    // 测试自定义的方法
    @Test
    public void testQuery2() {
        List<Students> students = studentRepository.findAllByName("JIMMY");
        for (Students student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQuery3() {
        List<Students> students = studentRepository.findAllByGenderAndAddress("男", "山西");
        for (Students student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQuery4() {
        List<Students> students = studentRepository.findAllByNameLike("%JIM%");
        for (Students student : students) {
            System.out.println(student);
        }
    }


    // (3)JPQL==========================================================================================================
    @Test
    public void testQuery5() {
        List<Students> allStudents = studentRepository.findAllStudents();
        for (Students student : allStudents) {
            System.out.println(student);
        }
    }

    @Test
    public void testQuery6() {
        List<Integer> list = studentRepository.findAllStudentsId();
        for (Integer id : list) {
            System.out.println(id);
        }
    }

    @Test
    public void testQuery7() {
        List<Students> students = studentRepository.findStudentsByName("JIM");
        for (Students student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testQuery8() {
        Integer num = studentRepository.findNumOfStudentsStatus(1);
        System.out.println(num);
    }

    @Test
    public void testUpdate1() {
        Integer i = studentRepository.updateStatusByName("三明治", 4);
        System.out.println(i);
    }
}
