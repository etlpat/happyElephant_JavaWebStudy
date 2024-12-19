package com.etlpat.factory;

import com.etlpat.javaBean.User;

// 非静态工厂 -- 工厂方法不是static方法的工厂类
public class NonstaticUserFactory {
    private static User user = new User();

    // 此处工厂方法始终返回同一个对象
    public User createUser() {
        return user;
    }
}
