package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;


@SpringBootTest
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    @Test
    public void showAll() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .orderByAsc(User::getUsername)// 按照名称升序排列
                .select(User::getUsername, User::getPassword);// 查询指定列(姓名,密码)
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);

        System.out.println("#####################################");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("#####################################");
    }
}
