package com.etlpat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etlpat.pojo.User;


// 创建mapper接口，使其继承myBatis-plus提供的BaseMapper接口
public interface UserMapper extends BaseMapper<User> {
}
