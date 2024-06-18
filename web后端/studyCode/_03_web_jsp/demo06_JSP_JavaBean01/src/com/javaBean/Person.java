package com.javaBean;

// JavaBean
//
// (1)基础概述
//  JavaBean，即java普通对象。
//  JavaBean把前端html传来的请求参数封装成了一个对象。
//  JavaBean的本质是用于解耦，促进前后端分离
//
//
// (2)JavaBean语法规则
//  1.JavaBean就是普通的Java对象。
//  2.JavaBean的属性必须都是private的。
//  3.JavaBean必须存在一个无参构造器。（可以在此基础上重载有参构造器）
//  4.需要为属性设置public的get、set方法。


public class Person {
    private String username;
    private String password;

    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
