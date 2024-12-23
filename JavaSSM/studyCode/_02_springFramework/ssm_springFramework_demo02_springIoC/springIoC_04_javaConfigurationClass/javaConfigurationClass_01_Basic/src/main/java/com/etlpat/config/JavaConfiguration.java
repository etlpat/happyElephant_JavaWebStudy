package com.etlpat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


// Java配置类
//
// 1.java配置类概念
//  (1)基本概念
//      java配置类，是使用java文件和注解，来【替代原本的XML配置文件】。
//      相对于XML配置，java配置类具有更强的类型安全性和更好的可读性，以及更高的效率。
//
//  (2)xml文件到java配置类的转化
//      （旧）xml文件：
//          ①使用<bean>标签进行第三方类的ioc/di的配置
//          ②使用<context:component-scan>标签配置注解的扫描范围
//          ③使用<context:property-placeholder>标签引入properties文件
//
//      （新）java配置类：(@Configuration)
//          ①@Bean注解来标注方法，用来引入第三方类组件
//          ②@ComponentScan注解，用于配置注解的扫描范围
//          ③@PropertySource注解，用来引入properties文件
//
//  (3)AnnotationConfigApplicationContext容器
//      注意：若使用java配置类作为配置信息，则对应AnnotationConfigApplicationContext容器
//      容器创建语法：new AnnotationConfigApplicationContext(Java配置类名.class, ...);
//
//
//
// 2.java配置类的语法
//  (1)为类添加@Configuration注解 -- 代表该类为配置类
//      语法：@Configuration
//
//  (2)为类添加@ComponentScan注解 -- 设置注解的扫描范围
//      语法：
//          扫描1个包：@ComponentScan(value="包名")
//          扫描多个包：@ComponentScan(value={"包1","包2",...})
//
//  (3)为类添加@PropertySource注解 -- 引入properties文件
//      语法：
//          引入一个文件：@PropertySource(value="文件名")
//          引入多个文件：@PropertySource(value={"文件1","文件2",...})
//
//  (4)为方法添加@Bean注解 -- 配置第三方类的bean组件
//      语法：@Bean
//      细节：
//          一个<bean>标签，对应一个被@Bean修饰的【Getter方法】
//          <bean>的id属性，对应方法名。
//          <bean>的class属性，对应方法的返回类型。
//      注意：
//          只有添加了@Bean标签，组件才会被添加到IoC容器中。
//
//


// (1)@Configuration注解：声明该类为配置类
@Configuration

// (2)@ComponentScan注解：设置注解的扫描范围
@ComponentScan(value = "com.etlpat.javaBean")// 扫描1个包
//@ComponentScan(value = {"包1", "包2",...})// 扫描多个包

// (3)@PropertySource注解：引入properties文件
@PropertySource(value = "classpath:jdbc.properties")// 引入一个文件
//@PropertySource(value = {"文件1", "文件2",...})// 引入多个文件

public class JavaConfiguration {
    @Value("${etlpat.url}")
    private String url;
    @Value("${etlpat.deiver}")
    private String driver;
    @Value("${etlpat.username}")
    private String username;
    @Value("${etlpat.password}")
    private String password;


    // (4)@Bean注解：配置第三方类的bean组件
    // 细节：
    //  一个<bean>标签，对应一个被@Bean修饰的【Getter方法】
    //  <bean>的id属性，对应方法名。
    //  <bean>的class属性，对应方法的返回类型。
    // 注意：
    //  只有添加了@Bean标签，组件才会被添加到IoC容器中。
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
