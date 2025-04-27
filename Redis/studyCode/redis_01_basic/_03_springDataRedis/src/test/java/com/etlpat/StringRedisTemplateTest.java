package com.etlpat;

import com.etlpat.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;


// 测试：使用StringRedisTemplate对Redis数据库进行CRUD操作
@SpringBootTest// 注意：使用该注解，会在测试代码运行前，先加载spring容器！
public class StringRedisTemplateTest {

    // 注意：由于StringRedisTemplate的key和value的序列化方式均为String，
    //      因此不需要在java配置类中手动配置其序列化方式！
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // Json处理工具
    private ObjectMapper objectMapper = new ObjectMapper();


    // (1)使用StringRedisTemplate，向Redis中存取value为String类型的数据
    @Test
    public void testString() throws JsonProcessingException {
        User user = new User("篮子哥", "daiLanZi");
        // 将user手动序列化为json字符串
        String json = objectMapper.writeValueAsString(user);

        // 【注意】：由于StringRedisTemplate的序列化方式为String，因此存取方法的value参数的类型只能为String！
        // 存入String类型数据，并设置过期时间
        stringRedisTemplate.opsForValue().set("user:2", json, 600, TimeUnit.SECONDS);
        // 获取String类型数据
        String json1 = stringRedisTemplate.opsForValue().get("user:2");

        // 将json字符串反序列化为User对象
        User user1 = objectMapper.readValue(json1, User.class);
        System.out.println(json1);
        System.out.println(user1);
    }


    // (2)使用StringRedisTemplate，向Redis中存取value为Hash类型的数据
    @Test
    public void testHash() {
        // 存入Hash类型的field-value
        stringRedisTemplate.opsForHash().put("user:3", "username", "小亮");
        stringRedisTemplate.opsForHash().put("user:3", "id", "22");
        stringRedisTemplate.opsForHash().put("user:3", "password", "caoZouHuLue");

        // 设置Hash表的过期时间
        stringRedisTemplate.expire("user:3", 600, TimeUnit.SECONDS);

        // 获取Hash表中的全部数据
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println(map);
    }

}
