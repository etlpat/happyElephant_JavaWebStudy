package com.etlpat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etlpat.pojo.User;


// 创建mapper接口，继承myBatisPlus提供的BaseMapper接口
// 注意：BaseMapper<xxx>接口的泛型，用于定义要操纵的table表对应的pojo实体类。
public interface UserMapper extends BaseMapper<User> {
}
