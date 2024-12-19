package com.etlpat.javaBean;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }


    // TODO:定义初始化方法
    // 注意：Bean组件的初始化方法，必须是：public、void、无参的方法（不过方法名随意）
    public void init() {
        System.out.println("User被初始化！");
    }


    // TODO:定义销毁方法
    // 注意：Bean组件的销毁方法，必须是：public、void、无参的方法（不过方法名随意）
    public void destroy() {
        System.out.println("User被销毁！");
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
