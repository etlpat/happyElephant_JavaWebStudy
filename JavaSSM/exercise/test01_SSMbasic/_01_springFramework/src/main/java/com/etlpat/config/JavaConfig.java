package com.etlpat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;


// java配置类
@Configuration
@ComponentScan("com.etlpat")// 配置扫描范围
@PropertySource("classpath:jdbc.properties")// 引入properties文件
public class JavaConfig {

    // 创建第三方组件，添加到IoC容器
    @Bean
    public DruidDataSource druidDataSource(@Value("${etlpat.url}") String url,// 对形参列表进行DI操作
                                           @Value("${etlpat.driver}") String driverClassName,
                                           @Value("${etlpat.username}") String username,
                                           @Value("${etlpat.password}") String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    // 创建第三方组件，添加到IoC容器
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }
}
