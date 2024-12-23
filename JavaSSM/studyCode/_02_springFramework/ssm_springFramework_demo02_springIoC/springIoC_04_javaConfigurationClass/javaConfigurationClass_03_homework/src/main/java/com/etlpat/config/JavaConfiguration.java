package com.etlpat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan("com.etlpat.bean")// 设置注解的扫描范围
@PropertySource("classpath:jdbc.properties")// 引入properties文件
public class JavaConfiguration {
    // 创建第三方类的组件对象
    @Bean
    public DruidDataSource druidDataSource(@Value("${etlpat.url}") String url,// 注意：@Value也可以为形参赋值
                                           @Value("${etlpat.driver}") String driver,
                                           @Value("${etlpat.username}") String username,
                                           @Value("${etlpat.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired @Qualifier("druidDataSource") DruidDataSource druidDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }
}
