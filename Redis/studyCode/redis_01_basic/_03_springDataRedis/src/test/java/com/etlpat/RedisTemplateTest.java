package com.etlpat;

import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


// 测试：使用RedisTemplate对Redis数据库进行CRUD操作
@SpringBootTest// 注意：使用该注解，会在测试代码运行前，先加载spring容器！
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    // 使用RedisTemplate对Redis数据库进行CRUD操作
    @Test
    public void testRedisTemplate() {
        // (1)向Redis中存取String类型数据
        // 存入string类型数据，并设置过期时间
        redisTemplate.opsForValue().set("username:1", "虎哥", 600, TimeUnit.SECONDS);
        // 获取string类型数据
        String username = (String) redisTemplate.opsForValue().get("username:1");
        System.out.println(username);

        // (2)向Redis中存取对象
        User user = new User("刀哥", "fwDog");
        // 存对象：由于value的序列化方式为json，因此对象会先被序列化为json字符串，之后再存入Redis中。
        redisTemplate.opsForValue().set("user:1", user, 600, TimeUnit.SECONDS);
        // 取对象：RedisTemplate有自动反序列化的功能，因此java会先从Redis中取出json字符串，再将其反序列化为对象。
        User user1 = (User) redisTemplate.opsForValue().get("user:1");
        System.out.println(user1);
    }

}
