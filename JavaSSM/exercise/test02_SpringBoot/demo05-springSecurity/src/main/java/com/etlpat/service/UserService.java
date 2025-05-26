package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;


    // 认证方式3：自定义UserDetailsService方式，从数据库中获取并检查springSecurity的用户名、密码
    //      重写loadUserByUsername方法，用于检查前端的用户名、密码
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取数据库中用户名、密码
        User user = findByUsername(username);
        if (user == null) {// 认证失败
            throw new UsernameNotFoundException(username);
        }

        // 创建UserDetails用户信息
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
        return userDetails;
    }


    // （默认用户名不重复）
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        return userMapper.selectOne(wrapper);
    }
}
