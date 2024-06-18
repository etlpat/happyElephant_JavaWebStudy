package com.test;

import com.javaBean.Student;
import com.jdbc.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        DAO dao = new DAO();
        Student student1 = new Student(114, "李田所", "男", 24, "114514@qq.com");
        Student student2 = new Student(114, "田所浩二", "男", 24, "1919810@qq.com");

        // 增
        System.out.println(dao.insert(student1));

        // 删
//        System.out.println(dao.delete(114));

        // 查
        System.out.println("--------------------------------------------------------");
        System.out.println(dao.find(114));
        System.out.println("--------------------------------------------------------");

        // 改
        System.out.println(dao.update(student2));

        // 输出全部行
        dao.printAll();
    }
}
