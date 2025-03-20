package com.etlpat.service;

import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}
