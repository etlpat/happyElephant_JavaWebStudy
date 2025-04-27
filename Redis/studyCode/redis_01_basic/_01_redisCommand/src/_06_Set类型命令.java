//  Set类型命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)Set类型介绍
//  Redis的Set结构与Java中的【HashSet】类似。
//  因为也是一个hash表，因此具备与HashSet类似的特征：
//      ·无序
//      ·元素不可重复
//      ·查找快
//      ·支持交集、并集、差集等功能
//
//
//
// (2)常见的Set类型命令
//  ①SADD:向set中添加一个或多个成员
//      语法：SADD key member [member ...]
//
//  ②SREM:移除set中一个或多个成员
//      语法：SREM key member [member ...]
//
//  ③SCARD:返回set中成员的个数
//      语法：SCARD key
//
//  ④SISMEMBER:判断一个成员是否存在于set中
//      语法：SISMEMBER key member
//
//  ⑤SMEMBERS:获取set中的所有成员
//      语法：SMEMBERS key
//
//  ⑥SINTER:求key1与key2的交集
//      语法：SINTER key [key ...]
//
//  ⑦SDIFF:求key1与key2的差集
//      语法：SDIFF key [key ...]
//
//  ⑧SUNION:求key1和key2的并集
//      语法：SUNION key [key ...]
//
//
//


public class _06_Set类型命令 {
}
