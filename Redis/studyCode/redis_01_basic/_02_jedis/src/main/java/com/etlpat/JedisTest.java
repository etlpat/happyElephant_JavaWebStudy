package com.etlpat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;


// Jedis
//
//
// (1)Jedis介绍
//  Jedis是一个流行的Java Redis客户端，用于Java与Redis数据库进行交互。
//  它提供了简单易用的API，让Java开发者能够方便地在应用程序中使用Redis。
//  <1>主要特性：
//      ①完整的Redis命令支持：支持几乎所有Redis命令
//      ②连接池支持：内置连接池管理
//      ③同步操作：提供同步通信模式
//      ④事务支持：支持Redis事务和管道操作
//      ⑤集群支持：支持Redis集群模式
//  <2>注意事项：
//      ①Jedis不是线程安全的，每个线程应该使用自己的Jedis实例
//      ②生产环境推荐使用连接池
//      ③使用完毕后需要关闭连接或归还连接到连接池
//      ④对于高并发场景，可以考虑使用Lettuce作为替代方案
//
//
//
// (2)Jedis使用步骤
//      <0>引入依赖
//      <1>建立连接，获取jedis对象
//      <2>使用jedis对象，对Redis数据库进行CRUD操作
//          注意：jedis对象操作数据库的方法名，与Redis命令的名称相同
//      <3>关闭jedis对象，释放资源
//
//
//
// (3)Jedis连接池
//  Jedis连接池代码，见：com.etlpat.JedisConnectionFactory
//
//


public class JedisTest {
    private static Jedis jedis;


    // <1>建立连接，获取jedis对象
    @BeforeEach
    public void init() {
        // 从jedis连接池中，获取jedis对象
        jedis = JedisConnectionFactory.getJedis();
    }


    // <2>使用jedis对象，对Redis数据库进行CRUD操作
    @Test
    public void jedisTest() {
        // (1)测试String类型操作
        // 存入String类型数据，并设置过期时间
        String str = jedis.setex("username", 600L, "jimmy");
        System.out.println(str);
        // 获取String类型数据
        String username = jedis.get("username");
        System.out.println(username);
        System.out.println("==============================");

        // (2)测试Hash类型操作
        HashMap<String, String> user = new HashMap<>();
        user.put("username", "jimmy");
        user.put("password", "123456");
        // 存入Hash类型数据
        String str1 = jedis.hmset("user", user);
        jedis.expire("user", 600);// 设置过期时间
        System.out.println(str1);
        // 获取Hash类型数据
        Map<String, String> user1 = jedis.hgetAll("user");
        System.out.println(user1);
    }


    // <3>关闭jedis对象，释放资源
    @AfterEach
    public void destroy() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
