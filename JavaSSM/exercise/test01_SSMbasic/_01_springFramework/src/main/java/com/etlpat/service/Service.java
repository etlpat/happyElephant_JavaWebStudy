package com.etlpat.service;

import com.etlpat.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// 添加到IoC容器
@org.springframework.stereotype.Service
public class Service {
    @Autowired// DI
    Dao dao;

    public List serviceGetAll() {
        List list = dao.daoGetAll();
        System.out.println("Service包，获取学生信息~~");
        return list;
    }
}
