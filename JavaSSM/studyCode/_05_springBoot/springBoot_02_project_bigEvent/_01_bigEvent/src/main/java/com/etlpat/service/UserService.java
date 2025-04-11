package com.etlpat.service;

import com.etlpat.pojo.User;

public interface UserService {
    // 根据用户名查询用户
    User findUserByUsername(String username);

    // 注册用户信息
    void register(String username, String password);

    // 更新用户信息
    void update(User user);

    // 更新用户头像
    void updateAvatarById(Integer id, String avatarUrl);

    // 更新用户密码
    void updatePasswordById(Integer id, String password);
}
