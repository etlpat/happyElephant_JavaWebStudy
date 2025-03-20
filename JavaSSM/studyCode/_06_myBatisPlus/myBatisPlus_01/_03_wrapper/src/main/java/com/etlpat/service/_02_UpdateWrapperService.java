package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.etlpat.mapper.UserMapper;
import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


// 基于UpdateWrapper组装条件
//
//  UpdateWrapper：对update语句的where+set条件进行封装。
//  UpdateWrapper是在QueryWrapper的基础上，支持了对update的set语句进行拼接。
//  语法：wrapper.set(列名,值) --等价于--> "SET 列名 = 值"
//


@SpringBootTest
@Service
public class _02_UpdateWrapperService {
    @Autowired
    UserMapper userMapper;


    @Test
    public void test01() {
        // UPDATE USER SET PASSWORD = '666666' WHERE username = '张三';
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>()
                .set("password", "666666")
                .eq("username", "张三");

        // 注意：若使用UpdateWrapper进行set操作，实体对象填null即可。
        int num = userMapper.update(null, updateWrapper);
        System.out.println(num);
    }

}
