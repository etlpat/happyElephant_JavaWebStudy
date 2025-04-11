package com.etlpat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import com.etlpat.service.UserService;
import com.etlpat.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.getMD5String(password));// 将原密码用MD5加密后再插入表中
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<User>()
                .set(User::getNickname, user.getNickname())
                .set(User::getEmail, user.getEmail())
                .set(User::getUpdateTime, LocalDateTime.now())
                .eq(User::getId, user.getId());
        userMapper.update(null, wrapper);
    }

    @Override
    public void updateAvatarById(Integer id, String avatarUrl) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<User>()
                .set(User::getUserPic, avatarUrl)
                .set(User::getUpdateTime, LocalDateTime.now())
                .eq(User::getId, id);
        userMapper.update(null, wrapper);
    }

    @Override
    public void updatePasswordById(Integer id, String password) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<User>()
                .set(User::getPassword, MD5Util.getMD5String(password))
                .set(User::getUpdateTime, LocalDateTime.now())
                .eq(User::getId, id);
        userMapper.update(null, wrapper);
    }
}
