//  List类型命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)List类型介绍
//  Redis中的List类型与Java中的【LinkedList】类似，可以看做是一个【双向链表】结构。
//  List既支持正向检索也支持反向检索，常被用来模拟栈和队列。
//  List类型的特征也与LinkedList类似：
//      ·有序
//      ·元素可以重复
//      ·插入和删除快
//      ·查询速度一般
//
//
//
// (2)常见的List类型命令
//  ①LPUSH:向列表左侧插入一个或多个元素
//      语法：LPUSH key element [element ...]
//
//  ②LPOP:移除并返回列表左侧的第一个元素，没有则返回nil
//      语法：LPOP key [count]
//
//  ③RPUSH:向列表右侧插入一个或多个元素
//      语法：RPUSH key element [element ...]
//
//  ④RPOP:移除并返回列表右侧的第一个元素，没有则返回nil
//      语法：RPOP key [count]
//
//  ⑤LRANGE:返回一段下标范围内的所有元素
//      语法：LRANGE key start stop
//      注意：start和stop都表示从0开始的下标
//      案例：LRANGE list 0 3， 表示从左到右获取list中下标范围[0,3]的元素
//
//  ⑥BLPOP和BRPOP:与LPOP和RPOP类似，只不过在没有元素时等待指定时间，而不是直接返回nil
//      语法：BLPOP key [key ...] timeout
//           BRPOP key [key ...] timeout
//
//
//


public class _05_List类型命令 {
}
