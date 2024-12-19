package com.etlpat.factory;

import com.etlpat.javaBean.User;

// 静态工厂 -- 工厂方法为static的工厂类
public class StaticUserFactory {
    private static User user = new User();

    // 此处工厂方法始终返回同一个对象
    public static User createUser() {
        return user;
    }
}
