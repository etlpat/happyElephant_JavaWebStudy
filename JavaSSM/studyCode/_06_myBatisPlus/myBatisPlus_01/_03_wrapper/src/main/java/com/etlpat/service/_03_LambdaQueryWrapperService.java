package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;


// 基于LambdaQueryWrapper组装条件
//
//  LambdaQueryWrapper：在QueryWrapper的基础上，支持了lambda表达式。
//  案例如下：
//      不使用lambda表达式：like("username", "jim")
//      使用lambda表达式：like(User::getUsername, "jim")
//
//  lambda表达式语法：
//      类名::get方法名 <====> "字段名"
//
//  lambda表达式功能：
//      ①使用lambda表达式代替列名字符串，有提示，不易出错
//      ②使代码更简洁、更易读
//


@SpringBootTest
@Service
public class _03_LambdaQueryWrapperService {
    @Autowired
    UserMapper userMapper;


    @Test
    public void test01() {
        // SELECT * FROM USER WHERE username LIKE '%jim%' AND PASSWORD IS NOT NULL;

        // (1)不使用lambda表达式，语法如下：
        //  new QueryWrapper<User>()
        //      .like("username", "jim")
        //      .isNotNull("password");

        // (2)使用lambda表达式，语法如下：
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .like(User::getUsername, "jim")
                .isNotNull(User::getPassword);

        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
