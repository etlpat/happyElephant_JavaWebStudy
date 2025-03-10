package com.etlpat;

import com.etlpat.config.JavaConfig;
import com.etlpat.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建IoC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        // 获取控制层组件
        Controller bean = context.getBean(Controller.class);
        // 使用bean组件，从controller->service->dao逐层获取数据库信息
        bean.controllerGetAll();

        // 关闭容器
        context.close();
    }
}