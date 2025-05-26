package com.etlpat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @ConfigurationProperties：将该类的属性与yml文件中定义的值相绑定
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "user")// 将该类的属性与yml文件中定义的值相绑定
public class User {
    private String username;
    private Integer age;
    private String password;
    private Map<String, String> map;
    private List<String> list;
}
