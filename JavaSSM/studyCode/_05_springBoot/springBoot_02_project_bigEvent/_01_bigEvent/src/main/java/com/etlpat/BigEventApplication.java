package com.etlpat;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.etlpat.mapper")
public class BigEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigEventApplication.class, args);
    }


    // 导入MybatisPlus的分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();// 创建myBatis-plus插件集合
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));// 在插件集合中，添加分页插件
        return interceptor;
    }
}
