package com.etlpat.controller;

import com.etlpat.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    // 注意：由于在pom文件中导入了jdbc和druid相关的启动器，并在application.yml中配置了连接池信息，
    //      因此springBoot会在内部自动创建JdbcTemplate，并将对应的druid连接池配置给它。
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll() {
        // 获取user表中全用户
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

}
