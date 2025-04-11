package com.etlpat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


// springBoot的【自动装配】原理
//  ①在主启动类上添加了SpringBootApplication注解，这个注解组合了EnableAutoConfiguration注解，用于自动装配。
//  ②EnableAutoConfiguration注解中又组合了import注解，导入了AutoConfigurationImportSelector类。
//  ③实现selectImports方法，这个方法经过层层调用，最终会读取META-INF目录下的后缀名为imports的文件，其中存放要装配的类名。
//  ④读取到全类名之后，会将满足@Conditional条件注解的组件，自动注入到IOC容器中。
//

@SpringBootApplication
@MapperScan("com.etlpat.mapper")
public class Application {

    public static void main(String[] args) {
        // run方法返回ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        DispatcherServlet dispatcherServlet = context.getBean(DispatcherServlet.class);
        System.out.println(dispatcherServlet);
    }

}
