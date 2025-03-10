package com.etlpat.mapper;

import com.etlpat.javaBean.User;

import java.util.List;

// 定义mapper接口，存放对数据库CRUD的抽象方法
public interface UserMapper {
    int insert(User user);

    int delete(int id);

    int update(User user);

    User selectById(int id);

    List<User> selectAll();
}
