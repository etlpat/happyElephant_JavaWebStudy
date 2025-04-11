package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .select(User::getUsername, User::getPassword)
                .orderByAsc(User::getUsername);
        return userMapper.selectList(userLambdaQueryWrapper);
    }
}
