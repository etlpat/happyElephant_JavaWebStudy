package com.etlpat.service;

import org.springframework.stereotype.Service;


// MyService组件，用于描述业务逻辑
@Service
public class MyService {

    public void func1() {
        System.out.println("func1()开始运行");
    }

    public void func2() {
        System.out.println("func2()开始运行");
        throw new RuntimeException();
    }
}
