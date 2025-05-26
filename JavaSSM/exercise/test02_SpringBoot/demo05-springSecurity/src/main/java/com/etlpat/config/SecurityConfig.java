package com.etlpat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// Security的配置类
@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    // 认证方式2：使用配置文件的方式，设置springSecurity的用户名、密码
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
//        users.createUser(User.withUsername("etlpat")
//                .password("{noop}123456")// {noop}表示明文，无加密方式
//                .roles("ADMIN")
//                .build());
//        return users;
//    }


    // 关键：配置 NoOpPasswordEncoder（明文密码）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // 禁用密码加密
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth// 定义哪些方法需要认证，哪些不需要
                        .requestMatchers("/user/login", "/user/register", "/static/**").permitAll() // 这些路径不需要认证
                        .anyRequest().authenticated()// 其余方法全认证
                )
                .formLogin(form -> form// 自定义登录页
                        .loginPage("/user/login")// 登录页面URL
                        .loginProcessingUrl("/user/login")// 登录表单提交地址（与页面form action一致）
                        .defaultSuccessUrl("/user/home")// 登录成功后跳转
                        .failureUrl("/user/login?error")// 登录失败跳转
                );
        return http.build();
    }

}
