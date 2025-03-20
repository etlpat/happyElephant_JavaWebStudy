package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


// 基于LambdaUpdateWrapper组装条件
//
//  LambdaUpdateWrapper：在UpdateWrapper的基础上，支持了lambda表达式。
//  lambda表达式的使用方式，与lambdaQueryWrapper完全相同。
//


@SpringBootTest
@Service
public class _04_LambdaUpdateWrapperService {
    @Autowired
    UserMapper userMapper;


    @Test
    public void test01() {
        // UPDATE USER SET PASSWORD = '8888' WHERE username = '张三';

        // (1)不使用lambda表达式，语法如下：
        //  new UpdateWrapper<User>()
        //      .set("password", "8888")
        //      .eq("username", "张三");

        // (2)使用lambda表达式，语法如下：
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<User>()
                .set(User::getPassword, "8888")
                .eq(User::getUsername, "张三");

        int num = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println(num);
    }
}
