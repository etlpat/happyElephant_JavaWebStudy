package com.etlpat;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


// Jedis连接池
//  --Jedis本身是线程不安全的，并且频繁的创建和销毁连接会有性能损耗，
//  --因此推荐使用Jedis连接池代替Jedis的直连方式。

public class JedisConnectionFactory {
    // 设置静态的jedis连接池属性
    private static final JedisPool jedisPool;

    static {
        // 创建连接池的配置信息对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);// 最大连接数
        poolConfig.setMaxIdle(8);// 最大空闲连接数
        poolConfig.setMinIdle(1);// 最小空闲连接数
        poolConfig.setMaxWaitMillis(200);// 最长等待时间(ms)

        // 创建Jedis连接池
        jedisPool = new JedisPool(poolConfig, "192.168.238.130"// Linux虚拟机的ip
                , 6379, 1000, "JMGMKSZ1919810");
    }


    // 获取Jedis对象
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
