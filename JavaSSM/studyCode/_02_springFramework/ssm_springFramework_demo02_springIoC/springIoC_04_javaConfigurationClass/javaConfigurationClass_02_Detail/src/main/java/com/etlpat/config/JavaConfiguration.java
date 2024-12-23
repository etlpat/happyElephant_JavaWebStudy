package com.etlpat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.etlpat")

// (3)@Import注解：用于在本配置类中引入（整合）其它配置类
//  语法：@Import(value={配置类1.class,配置类2.class,...})
//  功能：把其它配置类引入本配置类中（把多个配置类整合成一个，最后只需加载这一个配置类即可，方便使用）
@Import(value = {Config1.class, Config2.class})


@PropertySource("classpath:jdbc.properties")
public class JavaConfiguration {
    @Value("${etlpat.url}")
    private String url;
    @Value("${etlpat.deiver}")
    private String driver;
    @Value("${etlpat.username}")
    private String username;
    @Value("${etlpat.password}")
    private String password;


    // (1)java配置类中，bean组件的生命周期/作用域
    //  ①@Bean注解的value属性 -> 用于用于手动设置bean的id
    //  ②Bean注解的initMethod属性 -> 用于设置初始化方法
    //  ③Bean注解的destroyMethod属性 -> 用于设置销毁方法
    //  ④方法上添加@Scope注解 -> 用于设置bean的作用域
    //
    @Bean(value = "druidDataSource"// 属性value：用于手动设置bean的id（id默认为方法名）
            , initMethod = ""// 属性initMethod，用于设置初始化方法
            , destroyMethod = ""// 属性destroyMethod，用于设置销毁方法
    )
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)// @Scope注解，用于给bean设置作用域
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


    // (2)java配置类中，bean组件的Getter方法，【形参自带@Autowired注解】
    //  注意：bean组件的Getter方法的形参，ioc容器会自动对其使用@Autowired操作。
    //       也就是说，即使我们不为形参设置@Autowired注解，形参也会自动配置对应的组件。
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {// 形参自带@Autowired注解
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }
}
