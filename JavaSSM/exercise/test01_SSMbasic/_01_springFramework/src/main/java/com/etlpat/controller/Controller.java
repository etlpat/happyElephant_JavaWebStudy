package com.etlpat.controller;


import com.etlpat.javaBean.Student;
import com.etlpat.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// 添加到IoC容器
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired// DI
    Service service;

    public void controllerGetAll() {
        List list = service.serviceGetAll();
        System.out.println("Controller包，获取学生信息~~");
        for (Object o : list) {
            System.out.println((Student) o);
        }
    }

}
