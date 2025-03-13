package com.etlpat.service;

import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    // 进行完myBatis的配置后，springBoot会自动将mapper接口的代理对象添加到ioc容器中
    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.selectAllUser();
    }
}
