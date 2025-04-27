//  String类型命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)String类型介绍
//  String类型，是Redis中最简单的存储类型。其value是字符串，根据格式不同，又可以分为3类：
//      ①string:普通字符串
//      ②int:整数类型，可以做自增、自减操作
//      ③float:浮点类型，可以做自增、自减操作
//  不管是哪种格式，底层都是字节数组形式存储，只不过是编码方式不同。字符串类型的最大空间不能超过512m。
//
//
//
// (2)常见的String类型命令
//  ①SET:添加或者修改已经存在的一个String类型的键值对
//      语法：SET key value [NX|XX]
//
//  ②GET:根据key获取String类型的value
//      语法：GET key
//
//  ③MSET:批量添加多个String类型的键值对
//      语法：MSET key value [key value ...]
//      e.g. MSET k1 v1 k2 v2 k3 v3
//
//  ④MGET:根据多个key获取多个String类型的value
//      语法：MGET key [key ...]
//
//  ⑤INCR:让一个整型的key自增1
//      语法：INCR key
//
//  ⑥INCRBY:将key所储存的值加上给定的增量值
//      语法：INCRBY key increment
//      注意：increment可以为负
//
//  ⑦INCRBYFLOAT:将key所储存的值加上给定的浮点增量值
//      语法：INCRBYFLOAT key increment
//      注意：increment可以为负
//
//  ⑧SETNX:只有在key不存在时设置key的值
//      语法：SETNX key value
//
//  ⑨SETEX:设置key的值为value同时，将过期时间设为seconds
//      语法：SETEX key seconds value
//
//
//
// (3)key的层级格式
//  Redis的key允许有多个单词形成层级结构，多个单词之间用':'隔开。（与yml文件中的键类似）
//  【key格式 = 项目名:业务名:类型:id】
//  这个格式并非固定，也可以根据自己的需求来删除或添加词条。
//
//  例如我们的项目名称叫etlpat，有user和product两种不同类型的数据，我们可以这样定义key：
//      ①user相关的key：     etlpat:user:1
//      ②product相关的key：  etlpat:product:1
//  如果Value是一个Java对象，例如一个User对象，则可以将对象序列化为JSON字符串后存储：
//      ①KEY=etlpat:user:1      VALUE='{"id":1, "name":"Jack", "age":21}'
//      ②KEY=etlpat:product:1   VALUE='{"id":1, "name":"小米11", "price":4999}'
//
//


public class _03_String类型命令 {
}
