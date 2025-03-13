package com.etlpat.mapper;

import com.etlpat.pojo.User;
import java.util.List;


// mapper接口，用于声明数据库操纵方法
public interface UserMapper {

    List<User> selectAllUser();

}
