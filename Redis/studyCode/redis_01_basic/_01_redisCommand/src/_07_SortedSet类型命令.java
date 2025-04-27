//  SortedSet类型命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)SortedSet类型介绍
//  Redis的SortedSet是一个【可排序的set集合】，底层的实现是一个跳表(SkipList)加hash表。
//  SortedSet中的每一个元素都带有一个score分数属性，可以【基于score分数对元素排序】。
//  SortedSet具备下列特性：
//      ·可排序
//      ·元素不重复
//      ·查询速度快
//  因为SortedSet的可排序特性，经常被用来实现排行榜这样的功能。
//
//
//
// (2)常见的SortedSet类型命令
//  注意：以下所有的排名/排序默认都是升序，如果要降序则在命令的Z字母后面添加REV即可。
//
//  ①ZADD:添加一个或多个元素到sortedSet，如果已经存在则更新其score值
//      语法：ZADD key score member [score member ...]
//
//  ②ZREM:删除sortedSet中的一个或多个元素
//      语法：ZREM key member [member ...]
//
//  ③ZSCORE:获取sortedSet中的指定元素的score值
//      语法：ZSCORE key member
//
//  ④ZRANK:获取sortedSet中的指定元素的排名（排名从0开始，默认按照升序排名）
//      语法：ZRANK key member
//
//  ⑤ZINCRBY:使sortedSet中的指定成员的score值加上增量increment
//      语法：ZINCRBY key increment member
//
//  ⑥ZCARD:获取sortedSet中的元素个数
//      语法：ZCARD key
//
//  ⑦ZCOUNT:统计给定score范围内的元素个数
//      语法：ZCOUNT key min max
//      范围：[min, max]
//
//  ⑧ZRANGE:按照score排序后，获取指定排名范围内的元素（排名从0开始）
//      语法：ZRANGE key min max
//      范围：[min, max]
//
//  ⑨ZRANGEBYSCORE:按照score排序后，获取指定score范围内的元素
//      语法：ZRANGEBYSCORE key min max
//      范围：[min, max]
//
//  ⑩ZDIFF、ZINTER、ZUNION:求差集、交集、并集
//      语法：ZDIFF numkeys key [key ...]
//          ZINTER numkeys key [key ...]
//          ZUNION numkeys key [key ...]
//
//
//


public class _07_SortedSet类型命令 {
}
