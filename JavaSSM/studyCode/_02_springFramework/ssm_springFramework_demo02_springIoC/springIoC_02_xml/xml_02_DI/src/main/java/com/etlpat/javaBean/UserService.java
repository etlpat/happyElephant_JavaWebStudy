package com.etlpat.javaBean;

public class UserService {
    private int age;
    private String name;
    private UserDao userDao;


    public UserService(int age, String name, UserDao userDao) {
        this.age = age;
        this.name = name;
        this.userDao = userDao;
    }

    public UserService() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
