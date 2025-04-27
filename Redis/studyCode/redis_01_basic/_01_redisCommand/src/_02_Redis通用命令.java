//  Redis通用命令
//  （官方文档：https://redis.com.cn/commands.html）
//
//
//
// (1)常见的通用命令
//  注意：通过help命令可以查看一个命令的具体用法（help [command]）
//
//  ①KEYS:查找所有符合给定模式的key
//      语法：KEYS pattern
//      通配符：*表示多个任意字符，?表示一个任意字符
//      e.g. 查询全部key：KEYS *
//
//  ②DEL:删除指定的key
//      语法：DEL key [key ...]
//
//  ③EXISTS:判断key是否存在
//      语法：EXISTS key [key ...]
//
//  ④EXPIRE:为给定key设置过期时间，过期的key会被自动删除
//      语法：EXPIRE key seconds [NX|XX|GT|LT]
//
//  ⑤TTL:以秒为单位，返回给定key的剩余生存时间
//      语法：TTL key
//      注意：若返回-1，表示永不过期；若返回-2，表示已经过期/不存在
//


public class _02_Redis通用命令 {
}
