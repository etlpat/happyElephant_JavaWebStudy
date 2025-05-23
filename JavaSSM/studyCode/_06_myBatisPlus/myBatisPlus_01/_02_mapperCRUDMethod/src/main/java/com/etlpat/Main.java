package com.etlpat;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication// 设置为启动类（将本类设置为配置类、引入其它配置类、扫描本包内注解）
@MapperScan("com.etlpat.mapper")// 扫描mapper接口所在的包
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);// 创建ioc容器，启动tomcat服务器
    }


    // 导入分页插件（添加第三方类组件）
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();// 创建myBatis-plus插件集合
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));// 在插件集合中，添加分页插件
        return interceptor;
    }
}