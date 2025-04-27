//  Hash类型命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)Hash类型介绍
//  Hash类型，也叫散列，其value是一个无序字典，类似于Java中的【HashMap】结构。
//  每个Hash类型的value，可以存放【多个键值对】。
//  Hash类型优势：
//      String结构是将对象序列化为JSON字符串后存储，当需要修改对象某个字段时很不方便。
//      Hash结构可以将对象中的每个字段独立存储，可以针对单个字段做CRUD。
//
//
//
// (2)常见的Hash类型命令
//  ①HSET:设置hash类型key的多个field-value键值对
//      语法：HSET key field value [field value ...]
//      案例：HSET user name bob age 17 sex man
//
//  ②HGET:获取一个hash类型key的field的值
//      语法：HGET key field
//
//  ③HMGET:批量获取多个hash类型key的field的值
//      语法：HMGET key field [field ...]
//
//  ④HDEL:删除hash类型key的多个field-value键值对
//      语法：HDEL key field [field ...]
//
//  ⑤HGETALL:获取一个hash类型的key中的所有的field和value
//      语法：HGETALL key
//
//  ⑥HKEYS:获取一个hash类型的key中的所有的field
//      语法：HKEYS key
//
//  ⑦HVALS:获取一个hash类型的key中的所有的value
//      语法：HVALS key
//
//  ⑧HINCRBY:为存储在key中的哈希表指定field做整数增量运算
//      语法：HINCRBY key field increment
//
//
//


public class _04_Hash类型命令 {
}
