package com.etlpat.mapper;

import com.etlpat.pojo.User;

import java.util.List;


// mapper接口，用于声明操纵数据库的方法
public interface UserMapper {

    int insertUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User selectUserById(int id);

    List<User> selectAllUser();
}
