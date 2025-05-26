package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.etlpat.mapper.StudentsMapper;
import com.etlpat.pojo.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SpringBootTest
public class StudentsService {
    @Autowired
    StudentsMapper studentsMapper;

    @Test
    public void selectAll() {
        List<Students> students = studentsMapper.selectList(null);
        System.out.println(students);
    }

    @Test
    public void insert() {
        Students student = new Students(null, "JIMMY", 88, "男", "5678107", "山西", 1);
        studentsMapper.insert(student);
    }

    @Test
    public void select1() {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .like("name", "三")
                .between("age", 10, 30)
                .isNotNull("address");
        List<Students> students = studentsMapper.selectList(wrapper);
        System.out.println(students);
    }

    @Test
    public void select2() {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .orderByDesc("age")
                .orderByAsc("id");
        List<Students> students = studentsMapper.selectList(wrapper);
        System.out.println(students);
    }

    @Test
    public void delete1() {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("status", 3);
        studentsMapper.delete(wrapper);
    }

    @Test
    public void update1() {
        UpdateWrapper<Students> wrapper = new UpdateWrapper<Students>()
                .eq("name", "JIMMY")
                .set("number", "88889999");
        studentsMapper.update(null, wrapper);
    }

    @Test
    public void select3() {
        LambdaQueryWrapper<Students> wrapper = new LambdaQueryWrapper<Students>()
                .eq(Students::getGender, "女")
                .or()
                .like(Students::getName, "JIM");
        List<Students> students = studentsMapper.selectList(wrapper);
        System.out.println(students);
    }

    @Test
    public void update2() {
        LambdaUpdateWrapper<Students> wrapper = new LambdaUpdateWrapper<Students>()
                .eq(Students::getName, "三明治")
                .set(Students::getStatus, 5);
        studentsMapper.update(null, wrapper);
    }
}
